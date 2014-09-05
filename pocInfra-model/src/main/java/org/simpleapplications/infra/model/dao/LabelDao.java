package org.simpleapplications.infra.model.dao;

import java.util.List;

import org.simpleapplications.infra.model.entity.Label;
import org.simpleapplications.infra.model.entity.LabelPK;
import org.springframework.data.repository.CrudRepository;

public interface LabelDao extends CrudRepository<Label, LabelPK> {

	List<Label> findAllByIdApplicationCode(String code);

}
