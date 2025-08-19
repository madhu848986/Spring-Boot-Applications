package com.example.StudentDetailsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Student.Student;
import com.example.StudentDao.StudentDAO;

@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private StudentDAO sDAO;

    @GetMapping("/students")
    public List<Student> getStudents() {
        return sDAO.getAll();
    }

    @GetMapping("/students/{rollNo}")
    public Student getStudentByRollNo(@PathVariable int rollNo) {
        return sDAO.getByRollno(rollNo);
    }

    @PostMapping("/students")
    public String saveStudent(@RequestBody Student student) {
        return sDAO.save(student) + " student(s) added to DB";
    }

    @PutMapping("/students/{rollNo}")
    public String updateStudent(@RequestBody Student student, @PathVariable int rollNo) {
        return sDAO.update(student, rollNo) + " student(s) updated in DB";
    }

    @DeleteMapping("/students/{rollNo}")
    public String deleteStudent(@PathVariable int rollNo) {
        return sDAO.deleteByrollno(rollNo) + " student(s) deleted from DB";
    }
}
