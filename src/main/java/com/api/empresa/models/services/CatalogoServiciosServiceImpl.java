package com.api.empresa.models.services;

import java.util.List;

import javax.transaction.Transactional;

import com.api.empresa.models.entity.ProjectDelivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.empresa.models.dao.ICatalogoServiciosDao;
import com.api.empresa.models.entity.CatalogoServicios;

@Service
public class CatalogoServiciosServiceImpl implements ICatalogoServiciosService{
	
	@Autowired
	private ICatalogoServiciosDao catalogoServiciosDao;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private EmailSenderService emailService;
	
	@Override
	@Transactional
	public List<CatalogoServicios> findAll(){
		return (List<CatalogoServicios>) catalogoServiciosDao.findAll();
	}
	
	@Override
	@Transactional
	public CatalogoServicios findById(Long servicioId) {
		return catalogoServiciosDao.findById(servicioId).orElse(null);
	}
	
	@Override
	@Transactional
	public CatalogoServicios save(CatalogoServicios catalogoServicios) {
		CatalogoServicios created = new CatalogoServicios();
		created = catalogoServiciosDao.save(catalogoServicios);
		return created;
	}

	@Override
	public String portafilioCotiza(List<CatalogoServicios> catalogoServicios) {
		// Correo del cliente alojada en: getDireccionRecurso
		if(catalogoServicios.size() > 0){
			String nombreProductos = "";
			String precios = "";
			String descripcion ="";
			for(int i = 0; i< catalogoServicios.size();i++){
				nombreProductos = nombreProductos.concat(catalogoServicios.get(i).getNombreServicio())+", ";
				precios = precios.concat(catalogoServicios.get(i).getPrecioServicio())+", ";
				descripcion = descripcion.concat(catalogoServicios.get(i).getDescripcionServicio())+", ";
			}
			CatalogoServicios newCatalogo = new CatalogoServicios();
			newCatalogo.setNombreServicio(nombreProductos);
			newCatalogo.setDescripcionServicio(descripcion);
			newCatalogo.setPrecioServicio(precios);
			newCatalogo.setUser(catalogoServicios.get(0).getUser());
			this.emailService.sendPortafolioCotizationMail(newCatalogo);

		}
		return "Enviado";
	}
}
