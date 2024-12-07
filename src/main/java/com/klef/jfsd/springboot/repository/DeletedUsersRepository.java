package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.models.DeletedUsers;

public interface DeletedUsersRepository extends JpaRepository<DeletedUsers, Integer> 
{
		
}
