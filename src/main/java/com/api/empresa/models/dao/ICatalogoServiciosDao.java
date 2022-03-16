package com.api.empresa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.CatalogoServicios;

public interface ICatalogoServiciosDao extends CrudRepository<CatalogoServicios, Long> {

}
