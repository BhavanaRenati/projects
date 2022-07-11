package com.axyya.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axyya.example.dto.ServerDto;
import com.axyya.example.entity.Server;
import com.axyya.example.exception.NotFoundException;
import com.axyya.example.service.ServerService;

@RestController
public class ServerController {
	
	
	@Autowired
	ServerService service;
	
	
	@PostMapping("/addDetails")
	public Server addDetails(@RequestBody Server server) {
		return service.saveDetails(server);
		
	}
	
	@GetMapping("/getDetails")
	public List<Server> getAllServerDetails(){
		
		return service.getAllServerDetails();
	}
	
	
	@GetMapping("/getDetailsById/{id}")
	public ResponseEntity<ServerDto> getServerDetailsById(@PathVariable int id) throws NotFoundException {
		return service.getServerDetailsById(id);
		}
	
	@GetMapping("/getDetailsByName/{name}")
	public ResponseEntity<ServerDto> getServerDetailsByName(@PathVariable String name) throws NotFoundException{
		return service.getServerDetailsByName(name);
		}
	
	
	@PutMapping("/updateDetails/{id}")
	 public ResponseEntity<Server> updateServerDetails(@PathVariable int id, @RequestBody Server server) {
		 return service.updateServerDetails(id,server);
	 }
	
	@DeleteMapping("delete/{id}")
	 public String deleteDetails(@PathVariable int id) {
		 service.deleteDetails(id);
			System.out.println("Deleted..!");
		return "Deleted Successfully..!";

	 }

}
