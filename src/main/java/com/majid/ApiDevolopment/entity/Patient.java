package com.majid.ApiDevolopment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long patientId;
	@NotBlank(message="Please Enter Patient name")
	private String patientName;
	private String disease;
	public Patient(Long patientId, String patientName, String disease) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.disease = disease;
	}
	public Patient() {
		super();
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", disease=" + disease + "]";
	}
	
	
	

}
