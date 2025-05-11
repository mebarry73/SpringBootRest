package com.barry.example.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.barry.example.model.DoctorEntry;
import com.google.gson.Gson;

/**
 * Some static helper tools.
 * 
 * @author barry.grotjahn
 */
@FunctionalInterface
interface GetAsJson {
	String format(List<DoctorEntry> values);
}

public class Utils {
	public static String returnAsJson(List<DoctorEntry> values) {
		Gson gson = new Gson();
		GetAsJson lExpression = (List<DoctorEntry> list) -> gson.toJson(list);

		return lExpression.format(values);
	}

	public static <T extends DoctorEntry> List<T> sortDoctorEntry(List<T> values) {
		values.sort((DoctorEntry d1, DoctorEntry d2) -> d1.getName().compareTo(d2.getName()));
		return values;
	}

	public static String readFromFileToString(String filePath) throws IOException {
		File resource = new ClassPathResource(filePath).getFile();
		byte[] byteArray = Files.readAllBytes(resource.toPath());
		return new String(byteArray);
	}
}