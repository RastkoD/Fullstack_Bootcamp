package com.iktpreobuka.uploadexample.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iktpreobuka.uploadexample.entities.UserEntity;

public interface FileHandler {
	
	public String singleFileUpload(
			MultipartFile file, RedirectAttributes
			redirectAttributes) throws IOException;
	
	List<UserEntity> saveUsers(List<UserEntity> users);

	public byte[] readFileContent(String csvFileName) throws IOException;

	public List<UserEntity> getAllUsers();
	
}
