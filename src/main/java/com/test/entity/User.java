package com.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User implements Serializable{
	@Id
	private String username;
	private String password;
	private String role;
	private String email;
}
