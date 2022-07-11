package com.axyya.example.dto;


public class ServerDto {
	
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

	@Override
	public String toString() {
		return "ServerDao [id=" + id + ", name=" + name + ", language=" + language + ", framework=" + framework + "]";
	}

	
	
	

}
