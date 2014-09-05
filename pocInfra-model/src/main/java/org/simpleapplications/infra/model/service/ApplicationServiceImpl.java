package org.simpleapplications.infra.model.service;

import java.util.ArrayList;
import java.util.List;

import org.simpleapplications.infra.model.dao.ApplicationDao;
import org.simpleapplications.infra.model.dao.LabelDao;
import org.simpleapplications.infra.model.entity.Application;
import org.simpleapplications.infra.model.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Autowired
	ApplicationDao applicationDao;
	
	@Autowired
	LabelDao labelDao;
	
	@Override
	public Application findApplication(String code) {
		return applicationDao.findOne(code);
	}

	@Override
	public void save(Application application) {
		saveLabels(application);
		applicationDao.save(application);
	}

	@Override
	public void delete(Application application) {
		applicationDao.delete(application);
	}

	@Override
	public void populateLabels(Application application) {
		application.setLabels(labelDao.findAllByIdApplicationCode(application.getCode()));
	}

	private void saveLabels(Application application) {
		List<Label> removedLabels = getRemovedLabels(application.getLabels(), labelDao.findAllByIdApplicationCode(application.getCode()));
		labelDao.delete(removedLabels);
		labelDao.save(application.getLabels());
		
		
	}
	
	private List<Label> getRemovedLabels(List<Label> modifiedList, List<Label> persistedList) {
		List<Label> removedLabels = new ArrayList<Label>();
		if(!modifiedList.containsAll(persistedList)) {
			for(Label persistedLabel : persistedList) {
				if(!modifiedList.contains(persistedLabel)) {
					removedLabels.add(persistedLabel);
				}
			}
		}
		return removedLabels;
	}
	
}
