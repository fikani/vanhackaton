package com.fikani.store.model;


import lombok.Data;

@Data
public class Store{

	public Store(Long id, String name, String address, Long cousineId) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.cousineId = cousineId;
	}
	
	private long id;
	private String name;
	private String address;
	private Long cousineId;
	
}