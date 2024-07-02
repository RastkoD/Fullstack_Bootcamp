package com.iktpreobuka.uploadexample.controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iktpreobuka.uploadexample.entities.UserEntity;
import com.iktpreobuka.uploadexample.services.FileHandler;

@Controller
public class DownloadController {
    private static final String UPLOADED_FOLDER = "C:\\temp\\";
    
    @Autowired
    private FileHandler fileHandler;

    @GetMapping("/downloadAllUsers")
    public ResponseEntity<byte[]> downloadAllUsersCSV(@RequestParam(required = false) List<String> attributes) {
    	try {
    		List<UserEntity> allUsers = fileHandler.getAllUsers();
    		
    		if(attributes == null || attributes.isEmpty()) {
    			attributes = List.of("name", "email", "city", "expenses");
    		}
    		
    		validateAttributes(attributes);
    		
    		String csvFileName = UPLOADED_FOLDER + "allUsers.csv";
    		createCSVFile(allUsers, attributes, csvFileName);
    		
    		byte[] fileContent = fileHandler.readFileContent(csvFileName);
    		HttpHeaders headers = new HttpHeaders();
    		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
    		headers.setContentDispositionFormData("attachment", "allUsers.csv");
    		
    		return ResponseEntity.ok().headers(headers).body(fileContent);
    	} catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
    	}
    }
    
    private void validateAttributes(List<String> attributes) {
    	for (String attribute : attributes) {
    		try {
                UserEntity.class.getDeclaredField(attribute);
            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException("Invalid attribute: " + attribute);
            }
    	}
    }
    
    private void createCSVFile(List<UserEntity> users, List<String> attributes, String fileName) throws IOException {
    	try (FileWriter writer = new FileWriter(fileName)) {
    		writer.append(String.join(",", attributes)).append("\n");
    		
    		for(UserEntity user : users) {
    			StringBuilder line = new StringBuilder();
    			for(String attribute : attributes) {
    				try {
                        line.append(UserEntity.class.getMethod("get" + capitalize(attribute)).invoke(user)).append(",");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
    			}
    			writer.append(line.deleteCharAt(line.length() - 1).toString()).append("\n");
    		}
    	}
    }
    
    private String capitalize(String string) {
    	return string.substring(0, 1).toUpperCase() + string.substring(1);
    }
    
    /* 2.4 Napraviti endpoint za slanje MIME email-a sa attachment-om, gde ce
parametri email-a (to, subject, text) fajl koji je attachment biti prosledjeni
endpoint-u. */
}
