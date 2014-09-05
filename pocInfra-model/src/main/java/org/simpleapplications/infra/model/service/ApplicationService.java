package org.simpleapplications.infra.model.service;

import org.simpleapplications.infra.model.entity.Application;

public interface ApplicationService {

	Application findApplication(String string);

	void save(Application application);

	void delete(Application application);

	void populateLabels(Application application);

}
