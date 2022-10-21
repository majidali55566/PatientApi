package com.majid.ApiDevolopment.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.majid.ApiDevolopment.entity.Patient;
import com.majid.ApiDevolopment.service.PatientService;

@WebMvcTest(PatientRestController.class)
class PatientRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private PatientService patientService;
	private Patient actual;

	@BeforeEach
	void setUp() {
		actual=new Patient((long)1,"Majid","Distractions");
	}

	@Test
	void test() {
		Patient underTest=new Patient((long)1,"Majid","Distractions");
		
		Mockito.when(patientService.addPatient(underTest)).thenReturn(actual);
		
		
	}

}
