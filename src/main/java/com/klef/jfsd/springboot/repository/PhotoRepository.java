package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.models.Photo;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Integer> 
{
	
}