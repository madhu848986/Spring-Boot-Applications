package com.example.StudentDao;
import java.util.List;
import com.example.Student.*;

public interface StudentDAO {

 int save(Student student);
 List<Student> getAll();
 Student getByRollno(int rollNo);
 int update(Student student,int rollNo);
 int deleteByrollno(int rollNo);
}
