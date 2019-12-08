package com.itss.parking.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1426754412511552604L;

	@Id
	@ApiModelProperty(value = "Vehicle code")
	@SequenceGenerator(name = "vehicle_id_seq", sequenceName = "vehicle_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_id_seq")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@ApiModelProperty(value = "Client")
	@JoinColumn(name = "clientId")
	private Client client;

	@JsonIgnore
	@ApiModelProperty(value = "Parkings")
	@OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
	List<Parking> parkings;

	@ApiModelProperty(value = "Vehicle plate")
	@Column(nullable = false)
	private String plate;

	@ApiModelProperty(value = "Model")
	@Column(nullable = false)
	private String model;

	@ApiModelProperty(value = "Color")
	@Column(nullable = false)
	private Integer color;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlate() {
		return plate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Parking> getParkings() {
		return parkings;
	}

	public void setParkings(List<Parking> parkings) {
		this.parkings = parkings;
	}

	public void setPlate(String plate) {
		this.plate = plate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}
}
