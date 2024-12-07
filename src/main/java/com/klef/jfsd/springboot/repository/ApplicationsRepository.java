package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.models.Applications;

public interface ApplicationsRepository extends JpaRepository<Applications, Integer>
{
	public List<Applications> findByRid(int rid);
	
	@Query("select a from Applications a where a.sid = ?1")
	public List<Applications> getApplications(int id);
	
	@Query("select a from Applications a where a.rid = ?1 and a.status = 'Accepted'")
	public List<Applications> getCandidates(int id);

	
	
	
	@Query("update Applications a set a.status=?1 where a.id=?2 ")
	@Modifying
	@Transactional
	public int updateapplicationstatus(String s , int id);
	
	@Query("select a from Applications a where a.sid=?1 and a.jid=?2")
	public Applications checkapplication(int sid, int jid);
	
	
	
}
