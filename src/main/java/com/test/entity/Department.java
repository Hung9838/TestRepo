package com.test.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Departments")
public class Department implements Serializable{
	@Id
	private String id;
	private String name;
	@Temporal(TemporalType.DATE)
	private Date CreateDay = new Date();
	@JsonIgnore
	@OneToMany(mappedBy = "department")
	List<Ticket> tickets;
}

