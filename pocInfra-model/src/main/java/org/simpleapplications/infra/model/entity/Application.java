package org.simpleapplications.infra.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Application {

	@Id
	@Column(name = "CODE")
	String code;
	
	@Column(name = "NAME", nullable = false)
	String name;
	
	@Transient
	List<Label> labels;

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public List<Label> getLabels() {
		if(labels == null) {
			labels = new ArrayList<Label>();
		}
		return labels;
	}
	
	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}
}
