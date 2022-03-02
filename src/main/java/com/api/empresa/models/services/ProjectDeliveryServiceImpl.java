package com.api.empresa.models.services;

import java.util.List;

import com.api.empresa.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.empresa.models.dao.IProjectDeliveryDao;
import com.api.empresa.models.entity.ProjectDelivery;

@Service
public class ProjectDeliveryServiceImpl implements IProjectDeliveryService {

	@Autowired
	private IProjectDeliveryDao projectDeliveryDao;

	@Autowired
	private IUserService userService;

	@Autowired
	private EmailSenderService emailService;
	
	@Override
	@Transactional
	public List<ProjectDelivery> findAll() {
		return (List<ProjectDelivery>) projectDeliveryDao.findAll();
	}

	@Override
	@Transactional
	public ProjectDelivery findById(Long projectDeliveryId) {
		return projectDeliveryDao.findById(projectDeliveryId).orElse(null);
	}

	@Override
	@Transactional
	public ProjectDelivery save(ProjectDelivery projectDelivery) {
		ProjectDelivery projectCreated = new ProjectDelivery();
		projectCreated = projectDeliveryDao.save(projectDelivery);
		if(projectCreated.getProjectDeliveryId()!= null){
			this.emailService.sendProjectDeliveryMail(projectDelivery);
			return projectCreated;
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(Long projectDeliveryId) {
		projectDeliveryDao.deleteById(projectDeliveryId);
	}

}
