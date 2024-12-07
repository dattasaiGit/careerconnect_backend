package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klef.jfsd.springboot.models.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Integer>
{

}
