package com.barry.example.rest;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.barry.example.model.DoctorEntry;
import com.barry.example.service.DoctorServiceImpl;
import com.barry.example.utils.Utils;

import lombok.RequiredArgsConstructor;

/**
 * http://localhost:8080/doctors
 * 
 * @author barry.grotjahn
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctors")
public class DoctorRestController {

	private final DoctorServiceImpl service;

	@GetMapping
	public String showDoctors() {
		return Utils.returnAsJson(service.findAll());
	}

	@GetMapping(value = "/{id}")
	public DoctorEntry findById(@PathVariable UUID id) {
		return service.findById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DoctorEntry create(@RequestBody DoctorEntry resource) {
		return service.create(resource);
	}

	@PutMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public DoctorEntry update(@PathVariable UUID id, @RequestBody DoctorEntry resource) {
		return service.update(id, resource);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable UUID id) {
		service.deleteById(id);
	}
}
