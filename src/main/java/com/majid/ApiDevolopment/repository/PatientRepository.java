package com.majid.ApiDevolopment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.majid.ApiDevolopment.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}
