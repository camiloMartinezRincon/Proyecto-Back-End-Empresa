package com.api.empresa.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.Requirement;

public interface IRequirementDao extends CrudRepository<Requirement, Long>{

}
