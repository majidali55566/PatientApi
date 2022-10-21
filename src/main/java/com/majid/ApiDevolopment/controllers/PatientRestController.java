package com.majid.ApiDevolopment.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.majid.ApiDevolopment.entity.Patient;
import com.majid.ApiDevolopment.error.PatientNotFoundException;
import com.majid.ApiDevolopment.service.PatientService;

@RestController
@RequestMapping("/api")
public class PatientRestController {
		private PatientService patientService;
	public PatientRestController(PatientService patientService) {
			super();
			this.patientService = patientService;
		}




	@PostMapping("/patients")
	public Patient registerPatient(@RequestBody Patient patient) {
		return patientService.addPatient(patient);
	}
	
	
	@GetMapping("/patients")
	public List<Patient> allPatients(){
		return patientService.allpatients();
	}
	
	@DeleteMapping("/patients/{id}")
	public String deleteById(@PathVariable("id") Long id) throws PatientNotFoundException {
		return patientService.deletePatient(id);
	}
	
	@PutMapping("patients/{id}")
	public Patient update(@PathVariable("id") Long id,@RequestBody Patient patient) throws PatientNotFoundException {
		return patientService.updatePatient(id, patient);
	}
	
	@GetMapping("patients/{id}")
	public Patient findById(@PathVariable("id") Long id) throws PatientNotFoundException {
		return patientService.findPatientById(id);
	}
	
	
}
