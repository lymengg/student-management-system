package com.springmvc.springweb.serviceimpl.service;

import com.springmvc.springweb.model.Student;
import com.springmvc.springweb.repository.StudentRepository;

import java.util.List;

public interface StudentService {
    List<Student> GetStudentList();
    Student getStudentById(long id);
    Student UpdateStudent(long id, Student student);
    String DeleteStudent(long id);
    Student SaveStudent(Student student);
}
