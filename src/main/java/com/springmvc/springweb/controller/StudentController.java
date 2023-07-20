package com.springmvc.springweb.controller;

import com.springmvc.springweb.model.Student;
import com.springmvc.springweb.serviceimpl.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
    public class StudentController {
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    private StudentService studentService;

    //List all the students in view
    @GetMapping("/students")
    public String StudentList(Model model) {
        model.addAttribute("students", studentService.GetStudentList());
        return "students";
    }

    @GetMapping("/create")
    public String CreateStudent(Model model) {
        model.addAttribute("createStudent", new Student());
        return "create";
    }

    @GetMapping("/update/{id}")
    public String UpdateStudentView(@PathVariable(value = "id") long id, Model model) {
        var student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String UpdateStudent(@PathVariable(value = "id") long id,  @ModelAttribute("student") Student student) {
        studentService.UpdateStudent(id, student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String DeleteStudentView(@PathVariable(value = "id") long id, Model model) {
        var student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String DeleteStudent(@PathVariable(value = "id") long id) {
        studentService.DeleteStudent(id);
        return "redirect:/students";
    }

    @PostMapping("/save")
    public String SaveStudent(@ModelAttribute("createStudent") Student student) {
        studentService.SaveStudent(student);
        return "redirect:/students";
    }
}
