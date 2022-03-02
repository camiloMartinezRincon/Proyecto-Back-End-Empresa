package com.api.empresa.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.empresa.models.entity.Requirement;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IRequirementDao extends CrudRepository<Requirement, Long>{

}
