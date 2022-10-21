package com.majid.ApiDevolopment.service;

import java.util.List;

import com.majid.ApiDevolopment.entity.Patient;
import com.majid.ApiDevolopment.error.PatientNotFoundException;


public interface PatientService {
		Patient addPatient(Patient patient);
		
		public List<Patient> allpatients();
		
		String deletePatient(Long id) throws PatientNotFoundException;
		
		Patient updatePatient(Long id,Patient patient)throws PatientNotFoundException;
		
		Patient findPatientById(Long id) throws PatientNotFoundException;
			
		
}
