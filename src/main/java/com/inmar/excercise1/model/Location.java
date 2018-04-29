package com.inmar.excercise1.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Component

@Entity
@Table(name = "location")
@EntityListeners(AuditingEntityListener.class)
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@OneToMany(mappedBy = "location")
	private List<Department> departmentlist = new ArrayList<Department>();

	@JsonIgnore
	public List<Department> getDepartmentlist() {
		return departmentlist;
	}

	public void setDepartmentlist(List<Department> departmentlist) {
		this.departmentlist = departmentlist;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Location() {
		super();
	}

	public Location(Long id, String name,  String description) {
		
		this.id = id;
		this.name = name;
		this.description = description;
	}

	
}
