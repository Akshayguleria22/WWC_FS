package com.student.demo.controller;

import com.student.demo.models.student;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class studentcontroller {
    private List<student> students = new ArrayList<>();

    @GetMapping
    public List<student> getAllStudents() {
        return students;
    }

    @PostMapping("/register")
    public String addStudent(@RequestBody student newStudent) {
        if (newStudent.getName() == null || newStudent.getCourse() == null || newStudent.getName().isEmpty()
                || newStudent.getCourse().isEmpty()) {
            return "400 BAD REQUEST";
        }

        if (students.stream().anyMatch(s -> s.getId() == newStudent.getId())) {
            return "409 CONFLICT";
        }

        students.add(newStudent);
        return "200 OK Student added successfully";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable int id) {
        for (student s : students) {
            if (s.getId() == id) {
                return "200 OK Student Found: ID=" + s.getId() + ", Name=" + s.getName() + ", Course=" + s.getCourse();
            }
        }
        return "404 NOT FOUND";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        if (students.stream().noneMatch(s -> s.getId() == id)) {
            return "404 NOT FOUND";
        }
        students.removeIf(student -> student.getId() == id);
        return "200 OK Student deleted successfully";
    }
}
