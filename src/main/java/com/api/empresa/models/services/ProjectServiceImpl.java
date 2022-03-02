package com.api.empresa.models.services;

import java.util.List;

import com.api.empresa.models.dao.IUserDao;
import com.api.empresa.models.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.empresa.models.dao.IProjectDao;
import com.api.empresa.models.entity.Project;

@Service
public class ProjectServiceImpl implements IProjectService{

	@Autowired
	private IProjectDao projectDao;

	@Autowired
	private IUserService userService;

	@Autowired
	private EmailSenderService emailService;
	
	@Override
	@Transactional
	public List<Project> findAll() {
		return (List<Project>) projectDao.findAll();
	}

	@Override
	@Transactional
	public Project findById(Long projectId) {
		return projectDao.findById(projectId).orElse(null);
	}

	@Override
	@Transactional
	public Project save(Project project) {
		/* User usertoAssociated = new User();
		User userId = userService.findByCorpUserEmail(project.getClientEmail());
		usertoAssociated.setUserId(userId.getUserId());
		project.setUser(usertoAssociated);*/
		Project created = new Project();
				created = projectDao.save(project);
		if(created.getProjectId() != null){
			this.emailService.sendProjectMail(project);
			return project;
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(Long projectId) {
		Project projectToDelete = this.findById(projectId);
		projectDao.delete(projectToDelete);
	}

}
