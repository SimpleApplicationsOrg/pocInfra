package org.simpleapplications.infra.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LabelPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5999844605101283550L;

	@Column(name = "CODE", nullable = false)
	String code;
	
	@Column(name = "LANGUAGE", nullable = false)
	String language;
	
	@Column(name = "APPLICATIONCODE", nullable = false)
	String applicationCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String languague) {
		this.language = languague;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
}