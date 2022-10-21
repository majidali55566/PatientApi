package com.majid.ApiDevolopment.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.majid.ApiDevolopment.entity.Patient;
import com.majid.ApiDevolopment.error.PatientNotFoundException;
import com.majid.ApiDevolopment.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService {
	 
	
	private PatientRepository patientRepository;
	

	public PatientServiceImp(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}


	@Override
	public Patient addPatient(Patient patient) {
		return patientRepository.save(patient);
	}


	@Override
	public List<Patient> allpatients() {
		return patientRepository.findAll();
	}


	@Override
	public String deletePatient(Long id) throws PatientNotFoundException {
		 findPatientById(id);
		 patientRepository.deleteById(id);
		 return "Deleted successfully";
	}


	@Override
	public Patient updatePatient(Long id, Patient patient) throws PatientNotFoundException {
		Patient newPatient=findPatientById(id); 
		
		if(Objects.nonNull(patient.getPatientName()) &&
			!"".equalsIgnoreCase(patient.getPatientName())) {
			
			newPatient.setPatientName(patient.getPatientName());
		}
		
		if(Objects.nonNull(patient.getDisease()) &&
				!"".equalsIgnoreCase(patient.getDisease())) {
				
				newPatient.setDisease(patient.getDisease());
			}
		
		return patientRepository.save(newPatient);
		
	}


	@Override
	public Patient findPatientById(Long id) throws PatientNotFoundException {
		Optional<Patient> optional=patientRepository.findById(id);
		
		if(!optional.isPresent()) {
			throw new PatientNotFoundException("Patient not found!");
		}
		return optional.get();
	}

}
