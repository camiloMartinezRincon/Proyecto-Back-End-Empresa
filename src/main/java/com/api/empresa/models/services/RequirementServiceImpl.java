package com.api.empresa.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.empresa.models.dao.IRequirementDao;
import com.api.empresa.models.entity.Requirement;

@Service
public class RequirementServiceImpl implements IRequirementService{

	@Autowired
	private IRequirementDao requirementDao;
	
	@Override
	@Transactional
	public List<Requirement> findAll() {
		return (List<Requirement>) requirementDao.findAll();
	}

	@Override
	@Transactional
	public Requirement findById(Long requirementId) {
		return requirementDao.findById(requirementId).orElse(null);
	}

	@Override
	@Transactional
	public Requirement save(Requirement requirement) {
		return requirementDao.save(requirement);
	}

	@Override
	@Transactional
	public void delete(Long requirementId) {
		requirementDao.deleteById(requirementId);
	}

}
