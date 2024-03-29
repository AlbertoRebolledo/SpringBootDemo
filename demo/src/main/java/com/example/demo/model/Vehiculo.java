package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class Vehiculo {
    private final UUID id;
	
	@NotBlank
	private final String name; // No puede estar vacío
	
	public Vehiculo(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
		this.id = id;
		this.name = name;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public String getName() {
		return name;
	}
}
