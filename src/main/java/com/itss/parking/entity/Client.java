package com.itss.parking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 8829140989186888568L;

	@Id
	@ApiModelProperty(value = "Client code")
	@SequenceGenerator(name = "client_id_seq", sequenceName = "client_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_id_seq")
	private Long id;
	
	@ApiModelProperty(value = "Document")
	@Column(nullable = false)
	private String document;
	
	@ApiModelProperty(value = "Vehicles")
	@JsonIgnore
	@OneToMany(mappedBy = "client")
	List<Vehicle> vehicles;

	@ApiModelProperty(value = "Name")
	@Column(nullable = false)
	private String name;
	
	@ApiModelProperty(value = "Phone number")
	@Column(nullable = false)
	private String phone;

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public List<Vehicle> getVehicles() {
		return vehicles;
	}
	
	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getId() {
		return this.id;
	}

}
