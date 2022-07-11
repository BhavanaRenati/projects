package com.axyya.example.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.axyya.example.dto.ServerDto;
import com.axyya.example.entity.Server;
import com.axyya.example.exception.NotFoundException;

public interface ServerService {
	
	List<Server> getAllServerDetails();
	
	ResponseEntity<ServerDto> getServerDetailsById(int id) throws NotFoundException;
	
	ResponseEntity<ServerDto> getServerDetailsByName(String name)throws NotFoundException;
	
	ResponseEntity<Server> updateServerDetails(int id,Server server);
	
	void deleteDetails(int id);
	
	Server saveDetails(Server server);
}

