package com.axyya.example.entity;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Server")

public class Server {
		
	@Id
	private int id;
	
	private String name;
	

	private String language;
	

	private String framework;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getFramework() {
		return framework;
	}

	public void setFramework(String framework) {
		this.framework = framework;
	}

	public Server(int id, String name, String language, String framework) {
		super();
		this.id = id;
		this.name = name;
		this.language = language;
		this.framework = framework;
	}

	
	@Override
	public String toString() {
		return "Server [id=" + id + ", name=" + name + ", language=" + language + ", framework="
				+ framework + "]";
	}

	public Server() {
		super();
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(framework, id, language, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Server other = (Server) obj;
		return Objects.equals(framework, other.framework) && id == other.id && Objects.equals(language, other.language)
				&& Objects.equals(name, other.name);
	}
	
	

}
