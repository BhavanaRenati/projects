package com.axyya.example.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.axyya.example.dto.ServerDto;
import com.axyya.example.entity.Server;
import com.axyya.example.exception.NotFoundException;
import com.axyya.example.repository.ServerRepository;


@Service
public class ServerServiceImp implements ServerService {

	
	@Autowired
	ServerRepository repo;
	
	@Override
	public Server saveDetails(Server server) {
		return repo.save(server);
	}
	
	@Override
	public  List<Server> getAllServerDetails() {
		List<Server> server = repo.findAll();
		return server;
	}


	@Override
	public ResponseEntity<ServerDto> getServerDetailsById(int id) throws NotFoundException {
		
		Optional<Server> server = repo.findById(id);
		if (server.isPresent()) {
		ServerDto dto =  new ServerDto();
		dto.setId(id);
		dto.setName(server.get().getName());
		dto.setFramework(server.get().getFramework());
		dto.setLanguage(server.get().getLanguage());
	
		return ResponseEntity.ok().body(dto);
	}
		throw new NotFoundException("Not found ");
	}

	@Override
	public ResponseEntity<ServerDto> getServerDetailsByName(String name)throws NotFoundException {
		Optional<Server> result = repo.findByName(name);
	if (result.isPresent()) {
		ServerDto dto1 =  new ServerDto();
		dto1.setId(result.get().getId());
		dto1.setName(result.get().getName());
		dto1.setFramework(result.get().getFramework());
		dto1.setLanguage(result.get().getLanguage());
	
		return ResponseEntity.ok().body(dto1);
	}
	throw new NotFoundException("Not found - 404");
}
	@Override
	public ResponseEntity<Server> updateServerDetails(int id,Server server) {
		 
		Server result = repo.findById(id).get();
		if(Objects.nonNull(server.getName()) && !"".equalsIgnoreCase(server.getName())) {
			result.setName(server.getName());
		}
		
		if(Objects.nonNull(server.getFramework()) && !"".equalsIgnoreCase(server.getFramework())) {
			result.setFramework(server.getFramework());
		}
		if(Objects.nonNull(server.getLanguage()) && !"".equalsIgnoreCase(server.getLanguage())) {
			result.setLanguage(server.getLanguage());
		}

		 
		 return ResponseEntity.ok().body(repo.save(result));
		
	 }
	
	@Override
	 public void deleteDetails(int id) {
		 repo.deleteById(id);
	 }
}
