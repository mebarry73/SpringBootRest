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

	public DoctorEntry update(UUID id, DoctorEntry resource) {
		DoctorEntry doctorEntry = null;
		Optional<DoctorEntry> found = repository.findById(id);
		if (!found.isEmpty()) {
			doctorEntry = found.get();
			doctorEntry.setLicense(resource.getLicense());
			doctorEntry.setName(resource.getName());
			return repository.save(doctorEntry);
		}

		return doctorEntry;
	}

	public DoctorEntry findById(UUID id) {
		DoctorEntry doctorEntry = null;
		Optional<DoctorEntry> found = repository.findById(id);
		if (!found.isEmpty()) {
			doctorEntry = found.get();
		}

		return doctorEntry;
	}

	public List<DoctorEntry> findAll() {
		return repository.findAll();
	}

	public DoctorEntry create(DoctorEntry resource) {
		return repository.save(resource);
	}
}