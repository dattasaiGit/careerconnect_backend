package com.klef.jfsd.springboot.models;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Resume {
	
	@Id
	private int sid;
	private Blob resume;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public Blob getResume() {
		return resume;
	}
	public void setResume(Blob resume) {
		this.resume = resume;
	}
	
	

}
