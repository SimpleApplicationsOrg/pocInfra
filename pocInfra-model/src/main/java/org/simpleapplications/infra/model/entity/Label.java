package org.simpleapplications.infra.model.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Label {

	@EmbeddedId
	LabelPK id;
	
	@Column(name = "TEXT", nullable = false)
	String text;

	public LabelPK getId() {
		return id;
	}

	public void setId(LabelPK id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
