package com.axyya.example.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.axyya.example.entity.Server;


public interface ServerRepository extends MongoRepository<Server, Integer> {

	Optional<Server> findByName(String name);

}
