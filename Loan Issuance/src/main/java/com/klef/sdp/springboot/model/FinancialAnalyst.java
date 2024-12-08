package com.klef.sdp.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="financial_analyst_table")
public class FinancialAnalyst {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="analyst_id")
    private int id;

    @Column(name="name", nullable = false, length=100)
    private String name;

    @Column(name="gender", nullable = false, length=10)
    private String gender;

    @Column(name="date_of_birth", nullable = false, length=20)
    private String dateofbirth;

    @Column(name="email", nullable = false, unique = true, length=100)
    private String email;

    @Column(name="password", nullable = false, length=100)
    private String password;

    @Column(name="location", nullable = false, length=100)
    private String location;

    @Column(name="contact", nullable = false, unique = true, length=20)
    private String contact;


    @Column(name="expertise_level", nullable = true, length=50)
    private String expertiseLevel;

    @Column(name="specialization_area", nullable = true, length=100)
    private String specializationArea;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getExpertiseLevel() {
		return expertiseLevel;
	}

	public void setExpertiseLevel(String expertiseLevel) {
		this.expertiseLevel = expertiseLevel;
	}


	public String getSpecializationArea() {
		return specializationArea;
	}

	public void setSpecializationArea(String specializationArea) {
		this.specializationArea = specializationArea;
	}

    
}
