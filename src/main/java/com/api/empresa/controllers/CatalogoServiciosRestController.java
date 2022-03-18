package com.api.empresa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.empresa.models.entity.CatalogoServicios;
import com.api.empresa.models.services.ICatalogoServiciosService;

@RestController
@RequestMapping("/api/company")
public class CatalogoServiciosRestController {
	
	@Autowired
	private ICatalogoServiciosService catalogoServiciosService;

	@GetMapping("/catalogo/servicios/info")
	public List<CatalogoServicios> allServices(){
		return catalogoServiciosService.findAll();
	}
	
	@GetMapping("/catalogo/servicios/info/{servicioId}")
	public CatalogoServicios showServiceInformation(@PathVariable Long servicioId) {
		return catalogoServiciosService.findById(servicioId);
	}
	
	@PostMapping("/new/catalogo/servicios")
	@ResponseStatus(HttpStatus.CREATED)
	public CatalogoServicios createCatalogoServicios(@RequestBody CatalogoServicios catalogoServicios) {
		return catalogoServiciosService.save(catalogoServicios);
	}

	@PostMapping("/portafolio/cotizacion")
	@ResponseStatus(HttpStatus.CREATED)
	public Boolean createPortafolioCotizacion(@RequestBody List<CatalogoServicios> catalogoServicios) {
		String response = catalogoServiciosService.portafilioCotiza(catalogoServicios);
		if(response ==null){
			return false;
		}else{
			return true;
		}
	}
}
