package com.barry.example.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barry.example.model.DoctorEntry;

/**
 * the repository for the DoctorEntry
 * 
 * @author barry.grotjahn
 */
public interface DoctorRepository extends JpaRepository<DoctorEntry, UUID> {
	List<DoctorEntry> findAll();
}
