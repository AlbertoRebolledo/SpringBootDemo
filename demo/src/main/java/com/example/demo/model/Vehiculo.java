package com.example.demo.model;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

public class Vehiculo {
    
    private final UUID id;

    @NotBlank
    private final String name;

    public Vehiculo(UUID id, @NotBlank String name) {
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
