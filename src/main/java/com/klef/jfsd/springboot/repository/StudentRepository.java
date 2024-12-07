package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klef.jfsd.springboot.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{	
	@Query("select s from Student s where s.email=?1 and s.password=?2")
	public Student checkstudentlogin(String email, String password);
	
	@Query("update Student s set s.status=?1 where s.id=?2 ")
	@Modifying
	@Transactional
	public int updatestudentstatus(String s , int id);
	
	@Query("update Student s set s.password=?1 where s.id=?2 ")
	@Modifying
	@Transactional
	public int updatepassword(String s , int id);
	
	
	@Query("select s from Student s where s.status IS NULL or s.status = 'Accepted'")
	public List<Student> findAccepted();
	
	

}
