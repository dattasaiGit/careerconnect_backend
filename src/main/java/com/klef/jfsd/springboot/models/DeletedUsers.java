package com.klef.jfsd.springboot.models;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class DeletedUsers 
{
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name="deleted_id")
	   private int id;
	   private int uid; //user id
	   private String role;
	   private String name;
	   private Date deletedon;
	   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDeletedon() {
		return deletedon;
	}
	public void setDeletedon(Date deletedon) {
		this.deletedon = deletedon;
	}
	   
	   
}
