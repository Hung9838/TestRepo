package com.test.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table (name = "Tickets")
public class Ticket implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne @JoinColumn(name = "DepartmentId")
	private Department department;
	private String phoneNumber;
	private String customerReviews;
	private String contents;
	private Boolean status;
	@Temporal(TemporalType.DATE)
	@Column(name = "PostTime")
	private Date postTime = new Date();
	@Temporal(TemporalType.DATE)
	@Column(name = "EndTime")
	private Date endTime= new Date();
}
