package com.api.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.empresa.models.entity.Cotizacion;
import com.api.empresa.models.services.ICotizacionService;

@RestController
@RequestMapping("/api/company")
public class CotizacionRestController {
	
	@Autowired
	private ICotizacionService cotizacionService;
	
	@GetMapping("/cotizacion/info")
	public List<Cotizacion> todasCotizaciones() {
		return cotizacionService.findAll();
	}
	
	@GetMapping("/cotizaciones/info/{cotizacionId}")
	public Cotizacion mostrarCotizacionInfo(@PathVariable Long cotizacionId) {
		return cotizacionService.findById(cotizacionId);
	}
	
	@PostMapping("/new/cotizacion")
	@ResponseStatus(HttpStatus.CREATED)
	public Cotizacion nuevaCotizacion(@RequestBody Cotizacion cotizacion) {
		return cotizacionService.save(cotizacion);
	}
	
	@PutMapping("/cotizacion/update/info/{cotizacionId}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cotizacion actualizarCotizacion(@RequestBody Cotizacion cotizacion, @PathVariable Long cotizacionId) {
		Cotizacion cotizacionActual = cotizacionService.findById(cotizacionId);
		
		cotizacionActual.setClienteNombreApellido(cotizacion.getClienteNombreApellido());
		cotizacionActual.setCorpEmail(cotizacion.getCorpEmail());
		cotizacionActual.setCotizacionDescripcion(cotizacion.getCotizacionDescripcion());
		cotizacionActual.setFechaEntrega(cotizacion.getFechaEntrega());
		cotizacionActual.setFechaInicio(cotizacion.getFechaInicio());
		cotizacionActual.setTipoServicio(cotizacion.getTipoServicio());
		
		return cotizacionService.save(cotizacionActual);
	}
	
	@DeleteMapping("/cotizacion/delete/{cotizacionId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCotizacion(@PathVariable Long cotizacionId) {
		cotizacionService.delete(cotizacionId);
	}
}
