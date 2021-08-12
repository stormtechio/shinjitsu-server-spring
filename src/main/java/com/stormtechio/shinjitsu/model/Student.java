package com.stormtechio.shinjitsu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne
	private User user;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	@Column(name = "law_responsible", nullable = true)
	private String lawResponsible;
	
	@Column(name = "street", nullable = false)
	private String street;
	
	@Column(name = "neighborhood", nullable = false)
	private String neighborhood;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "number", nullable = false)
	private int number;
	
	@Column(name = "complement", nullable = false)
	private String complement;
	
	@Column(name = "cellphone", nullable = false)
	private String cellphone;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "telephone", nullable = true)
	private String telephone;
	
	@Column(name = "has_desease", nullable = false)
	private boolean desease;
	
	@Column(name = "has_chronical_desease", nullable = false)
	private boolean chronicalDesease;
	
	@Column(name = "surgery", nullable = false)
	private boolean surgery;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getIdade() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getLawResponsible() {
		return lawResponsible;
	}
	
	public void setLawResponsible(String lawResponsible) {
		this.lawResponsible = lawResponsible;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getComplement() {
		return complement;
	}
	
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public boolean hasDesease() {
		return desease;
	}
	
	public void setDesease(boolean desease) {
		this.desease = desease;
	}
	
	public void setChronicalDesease(boolean chronicalDesease) {
		this.chronicalDesease = chronicalDesease;
	}
	
	public boolean hadSurgery() {
		return surgery;
	}
	
	public void setSurgery(boolean surgery) {
		this.surgery = surgery;
	}

	public int getAge() {
		return age;
	}

	public boolean isDesease() {
		return desease;
	}

	public boolean hasChronicalDesease() {
		return chronicalDesease;
	}

	public boolean isSurgery() {
		return surgery;
	}
	
	
	
	
	
}
