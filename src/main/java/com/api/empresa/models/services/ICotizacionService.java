package com.api.empresa.models.services;

import java.util.List;


import com.api.empresa.models.entity.Cotizacion;

public interface ICotizacionService {
	
	public List<Cotizacion> findAll();
	public Cotizacion findById(Long cotizacionId);
	public Cotizacion save(Cotizacion cotizacion);
	public void delete(Long cotizacionId);
}
