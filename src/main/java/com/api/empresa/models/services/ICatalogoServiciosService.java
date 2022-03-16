package com.api.empresa.models.services;

import java.util.List;

import com.api.empresa.models.entity.CatalogoServicios;

public interface ICatalogoServiciosService {
	
	public List<CatalogoServicios> findAll();
	public CatalogoServicios findById(Long servicioId);
	public CatalogoServicios save(CatalogoServicios catalogoServicios);
}
