package com.example.bsuir.controller;

import com.example.bsuir.service.StudentService;
import com.example.bsuir.model.StudentGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public StudentGroup getStudentGroup(@RequestParam String groupNumber) {
        List<StudentGroup> studentGroups = studentService.getStudentGroups();

        for (StudentGroup group : studentGroups) {
            if (group.getName().equals(groupNumber)) {
                return group;
            }
        }

        return null;
    }
}
