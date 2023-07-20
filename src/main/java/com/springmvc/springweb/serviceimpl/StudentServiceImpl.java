package com.springmvc.springweb.serviceimpl;

import com.springmvc.springweb.model.Student;
import com.springmvc.springweb.repository.StudentRepository;
import com.springmvc.springweb.serviceimpl.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    @Override
    public List<Student> GetStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> studentFromDb = studentRepository.findById(id);
        if(studentFromDb.isPresent()) {
            return studentFromDb.get();
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public Student UpdateStudent(long id, Student student) {
        Optional<Student> studentFromDb = studentRepository.findById(id);
        if(studentFromDb.isPresent()) {
            studentFromDb.get().setFirstName(student.getFirstName());
            studentFromDb.get().setLastName(student.getLastName());
            studentFromDb.get().setEmail(student.getEmail());

            return studentRepository.save(studentFromDb.get());
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public String DeleteStudent(long id) {
        Optional<Student> studentFromDb = studentRepository.findById(id);
        if(studentFromDb.isPresent()) {
            studentRepository.delete(studentFromDb.get());
            return "";
        }else {
            throw new RuntimeException();
        }
    }

    @Override
    public Student SaveStudent(Student student) {
        return studentRepository.save(student);
    }
}
