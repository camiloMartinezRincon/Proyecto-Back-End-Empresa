package com.api.empresa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.Project;

public interface IProjectDao extends CrudRepository<Project, Long>{

}
