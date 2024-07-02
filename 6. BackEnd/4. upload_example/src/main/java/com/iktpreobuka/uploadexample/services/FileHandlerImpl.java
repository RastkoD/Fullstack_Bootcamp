package com.iktpreobuka.uploadexample.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iktpreobuka.uploadexample.entities.UserEntity;

@Service
public class FileHandlerImpl implements FileHandler {

	//snimanje file-a u folder
	private static String UPLOADED_FOLDER = "C:\\temp\\";
	
	private List<UserEntity> allUsers = new ArrayList<>();

	@Override //razbiti na manje metode
	public String singleFileUpload(MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}
		try {
			// uzimanje i snimanje file-a
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			
			// ubaciti code oko citanja fajla i parsiranje svakog reda gde format reda ime, email
			//https://www.digitalocean.com/community/tutorials/java-read-file-line-by-line
			
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] parts = line.split(",");
		            if (parts.length == 3) {
		                String name = parts[0].trim();
		                String email = parts[1].trim();
		                String city = parts[2].trim();
		                //double expenses = Double.parseDouble(parts[3].trim());

		                double expenses = calculateCosts(city);

		                if (!isEmailAlreadyTaken(email)) {
		                    UserEntity userEntity = new UserEntity(name, email, city, expenses);
		                    allUsers.add(userEntity);

		                    System.out.println("Created User: " + userEntity);
		                } else {
		                    System.out.println("Duplicate email found, User not added: " + name + ", " + email);
		                }
		            }
		        }
		    }
			
			//redirekcija na upload status stranicu
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");
		} catch (IOException e) {
			throw e;
		}
		return "redirect:/uploadStatus";
	}

	@Override
	public List<UserEntity> saveUsers(List<UserEntity> users) {
		List<UserEntity> filterUsers = users.stream().filter( user -> !isEmailAlreadyTaken(user.getEmail())).collect(Collectors.toList());
	
		allUsers.addAll(filterUsers);
		return allUsers;
	}
	
	public List<UserEntity> getAllUsers() {
		return new ArrayList<>(allUsers);
	}
	
	private boolean isEmailAlreadyTaken(String email) {
		return allUsers.stream().anyMatch(user -> user.getEmail().equalsIgnoreCase(email));
	}
	
	private double calculateCosts(String city) {
		if("Edoras".equalsIgnoreCase(city)) {
			return 5000;
		} else if ("Minas Tirith".equalsIgnoreCase(city)) {
			return 10000;
		} else {
			return 0;
		}
	}

	 @Override
	    public byte[] readFileContent(String csvFileName) throws IOException {
	        Path filePath = Paths.get(csvFileName);
	        return Files.readAllBytes(filePath);
	    }
}
