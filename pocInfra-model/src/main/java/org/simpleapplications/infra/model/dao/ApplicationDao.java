package org.simpleapplications.infra.model.dao;

import org.simpleapplications.infra.model.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationDao extends CrudRepository<Application, String> {

}
