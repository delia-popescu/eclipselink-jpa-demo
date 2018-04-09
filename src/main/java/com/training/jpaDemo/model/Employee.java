package com.training.jpaDemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="globalSequence")
	private Long id;
	
	private String name;
	
	private String surname;
	
	@ManyToOne
	private Departament departament;

	public Long getId() {
		return id;
	}

	public Employee setId(Long id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public String getSurname() {
		return surname;
	}

	public Employee setSurname(String surname) {
		this.surname = surname;
		return this;
	}
	
	public Departament getDepartament() {
		return departament;
	}

	public Employee setDepartament(Departament departament) {
		this.departament = departament;
		return this;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", departament=" + departament + "]";
	}
}
