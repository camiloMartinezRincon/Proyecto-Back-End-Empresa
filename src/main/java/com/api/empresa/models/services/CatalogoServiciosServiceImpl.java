package com.api.empresa.models.services;

import java.util.List;

import javax.transaction.Transactional;

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
}
