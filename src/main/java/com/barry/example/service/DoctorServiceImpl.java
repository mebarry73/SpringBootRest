package com.barry.example.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.barry.example.model.DoctorEntry;
import com.barry.example.repository.DoctorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl {

	final DoctorRepository repository;

	public void deleteById(UUID id) {
		repository.deleteById(id);
	}

	public void update(DoctorEntry resource) {
		// to be implemented
	}

	public Optional<DoctorEntry> findById(UUID id) {
		return repository.findById(id);
	}

	public List<DoctorEntry> findAll() {
		return repository.findAll();
	}

	public DoctorEntry create(DoctorEntry resource) {
		return repository.save(resource);
	}
}