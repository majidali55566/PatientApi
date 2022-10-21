package com.majid.ApiDevolopment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.mockito.Mockito.verify;

import java.io.Closeable;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.majid.ApiDevolopment.entity.Patient;
import com.majid.ApiDevolopment.error.PatientNotFoundException;
import com.majid.ApiDevolopment.repository.PatientRepository;

@ExtendWith(MockitoExtension.class)
public class PatientServiceImpTest {
	
	@Mock
	private PatientRepository patientRepository;
	private PatientServiceImp underTest;
	
	
	
	@BeforeEach
	void setUp() {
		underTest=new PatientServiceImp(patientRepository);
		
	}
	
	
	
	@Test
	public void canGetAllPatients() {
		//when
		underTest.allpatients();
		//then
		verify(patientRepository).findAll();
	}
	@Test
	public void canAddPatient() throws PatientNotFoundException {
		Patient patient=new Patient((long)1,"Majid","Malaria");
		//when
		underTest.addPatient(patient);
		//then
		ArgumentCaptor<Patient> patientArgumentCaptor=ArgumentCaptor.forClass(Patient.class);
		
		verify(patientRepository).save(patientArgumentCaptor.capture());
		
		Patient capturedPatient=patientArgumentCaptor.getValue();
		assertThat(capturedPatient).isEqualTo(patient);
	}
	@Test()
	public void shouldThroughPatientNotFoundExceptionWhenPatientIsNotFound() {
		Patient patient=new Patient((long)1,"Majid","Distractions");
		underTest.addPatient(patient);
		assertThrows(PatientNotFoundException.class, ()->{
			underTest.findPatientById((long) 1);
		});
	}
	
	
	
	
	
	
	
	
}
