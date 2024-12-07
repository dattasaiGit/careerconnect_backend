package com.klef.jfsd.springboot.models;

import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Photo 
{
  @Id
  private int id;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public Blob getImage() {
    return image;
  }
  public void setImage(Blob image) {
    this.image = image;
  }
  private Blob image;
  
}