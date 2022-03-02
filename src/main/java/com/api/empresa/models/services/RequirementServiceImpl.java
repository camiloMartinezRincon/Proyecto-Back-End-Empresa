package com.api.empresa.models.services;

import java.util.ArrayList;
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

	@Autowired
	private EmailSenderService emailService;

	@Override
	@Transactional
	public List<Requirement> findAll() {
		List<Requirement> listObject= (List<Requirement>) requirementDao.findAll();
		/*List<Requirement> listRequirement = new ArrayList<>();
		for(int i=0; i<listObject.size(); i++){
			Requirement requirement = listObject.get(i);
			Sy
			if(requirement.getRequerement_usermail() == userEmail){
				listRequirement.add(requirement);
			}
		}*/
		return listObject;
	}

	@Override
	@Transactional
	public Requirement findById(Long requirementId) {
		return requirementDao.findById(requirementId).orElse(null);
	}

	@Override
	@Transactional
	public Requirement save(Requirement requirement) {

		Requirement created = requirementDao.save(requirement);
		if(created.getRequirementId() != null){
			this.emailService.sendRequirementMail(requirement);
			return requirement;
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(Long requirementId) {
		requirementDao.deleteById(requirementId);
	}

}
