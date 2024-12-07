package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.models.Recruiter;
import java.util.List;


@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Integer>
{
	@Query("select r from Recruiter r where r.email=?1 and r.password=?2")
	public Recruiter recruiterlogin(String email,String password);
  
  @Query("update Recruiter r set r.status=?1 where r.id=?2")
	@Modifying //DML
	@Transactional // To Enable Auto Commit
	public int updaterecruiterstatus(String status,int rid);
  
  @Query("Select r from Recruiter r where r.status='Accepted'")
  public List<Recruiter> findAccepted();
  
  public List<Recruiter> findByStatus(String status);
}