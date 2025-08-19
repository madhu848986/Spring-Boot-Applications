package com.example.StudentDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Student.Student;
@Repository
public class StudentDAOimp implements StudentDAO {
   @Autowired
   JdbcTemplate jdbcTemplate;
 Student student=new Student();
   @Override
   public int save(Student student) {
	// TODO Auto-generated method stub
	return   jdbcTemplate.update("INSERT INTO students(rollNo,name,phone,email,department) VALUES(?,?,?,?,?)",new Object[] {student.getRollNo(),student.getName(),student.getPhone(),student.getEmail(),student.getDepartment()});
			  
   }

   @Override
   public List<Student> getAll() {
	// TODO Auto-generated method stub
	  return jdbcTemplate.query("SELECT *FROM students", new BeanPropertyRowMapper<Student>(Student.class));
	
   }

   @Override
   public Student getByRollno(int rollNo) {
	// TODO Auto-generated method stub
	 return   jdbcTemplate.queryForObject("SELECT * FROM students WHERE rollNo=?",new BeanPropertyRowMapper<Student>(Student.class) , rollNo);
	
   }

   @Override
   public int update(Student student, int rollNo) {
	// TODO Auto-generated method stub
	  return  jdbcTemplate.update("UPDATE students SET name=?,phone=?,email=?,department=? WHERE rollNo=?",new Object[] {student.getName(),student.getPhone(),student.getEmail(),student.getDepartment(),rollNo});

   }

   @Override
   public int deleteByrollno(int rollNo) {
	// TODO Auto-generated method stub
	return   jdbcTemplate.update("DELETE FROM students WHERE rollNo=?",rollNo);
	
   }

   

}
