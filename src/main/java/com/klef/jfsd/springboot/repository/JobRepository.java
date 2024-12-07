package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.models.Job;
import java.util.List;


public interface JobRepository extends JpaRepository<Job , Integer>
{
	public List<Job> findByRid(int recruiter);
	
	@Query("delete from Job j where j.id =?1")
	@Modifying
	@Transactional
	public int deletejob(int id);
	
	
}
