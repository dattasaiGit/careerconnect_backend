package com.klef.jfsd.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.models.PlacementOfficer;
import com.klef.jfsd.springboot.models.Student;
import java.util.List;


@Repository
public interface PlacementOfficerRepository extends JpaRepository<PlacementOfficer, Integer>
{
	@Query("select p from PlacementOfficer p where p.email=?1 and p.password=?2")
	public PlacementOfficer checkofficerlogin(String email, String password);
	
	@Query("update PlacementOfficer p set p.status=?1 where p.id=?2 ")
	@Modifying
	@Transactional
	public int updateofficerstatus(String s , int id);
	
	@Query("select p from PlacementOfficer p where p.status='Accepted'")
	public List<PlacementOfficer> findAccepted();
	
	
	public List<PlacementOfficer> findByStatus(String status);
	
}