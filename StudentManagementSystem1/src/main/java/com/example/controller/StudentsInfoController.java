package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.service.StudentService;

@Controller
public class StudentsInfoController {

    private final StudentService studentService;

    public StudentsInfoController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/studentsinfo")
    public String showStudentInfo(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "studentsinfo";
    }
}
