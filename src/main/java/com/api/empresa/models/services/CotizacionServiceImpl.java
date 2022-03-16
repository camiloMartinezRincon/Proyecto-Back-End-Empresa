package com.api.empresa.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.empresa.models.dao.ICotizacionDao;
import com.api.empresa.models.entity.Cotizacion;

@Service
public class CotizacionServiceImpl implements ICotizacionService{
	
	@Autowired
	private ICotizacionDao cotizacionDao;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private EmailSenderService emailService;
	
	@Override
	@Transactional
	public List<Cotizacion> findAll() {
		return (List<Cotizacion>) cotizacionDao.findAll();
	}

	@Override
	@Transactional
	public Cotizacion findById(Long cotizacionId) {
		return cotizacionDao.findById(cotizacionId).orElse(null);
	}

	@Override
	@Transactional
	public Cotizacion save(Cotizacion cotizacion) {
		Cotizacion created = new Cotizacion();
				   created = cotizacionDao.save(cotizacion);
		if(created.getCotizacionId() != null) {
			this.emailService.sendCotizacionMail(cotizacion);
			return cotizacion;
		}
	
		return null;
	}

	@Override
	@Transactional
	public void delete(Long cotizacionId) {
		Cotizacion cotizacionToDelete = this.findById(cotizacionId);
		cotizacionDao.delete(cotizacionToDelete);
		
	}

}
