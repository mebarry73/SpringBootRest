package com.barry.example.model;

import java.util.UUID;

import com.barry.example.utils.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

/**
 * Entity for the doctor.
 * 
 * @author barry.grotjahn
 */
@Builder
@Data
@Entity(name = "doctor")
@Table
public class DoctorEntry {

	public DoctorEntry() {

	}

	public DoctorEntry(UUID id, Integer license, String name) {
		this.id = id;
		this.license = license;
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column
	private Integer license;

	@Column
	private String name;

	public String toString() {
		return new StringBuffer().append(id).append(Constants.CSV_DELIMITER).append(license)
				.append(Constants.CSV_DELIMITER).append(name).toString();
	}
}
