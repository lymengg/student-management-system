package com.springmvc.springweb.repository;

import com.springmvc.springweb.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
