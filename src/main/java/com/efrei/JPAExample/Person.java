package com.efrei.JPAExample;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
	
	private long id;
	private String name;
	private List<Rent> rents = new ArrayList<Rent>();

	public Person() {
		super();
	}

	public Person(String name) {
		super();
		this.name = name;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="person", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Rent> getRents() { return rents; }
	public void setRents(List<Rent> rents) { this.rents = rents; }

	@Override
	public String toString() {
		return "Person{" +
				"id=" + id +
				", name='" + name + '\'' +
				", rents=" + rents +
				'}';
	}
}
