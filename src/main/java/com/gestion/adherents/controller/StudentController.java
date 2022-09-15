package com.gestion.adherents.controller;

import com.gestion.adherents.mapper.StudentMapper;
import com.gestion.adherents.model.Course;
import com.gestion.adherents.service.CourseService;
import com.gestion.adherents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class StudentController {

    private CourseService courseService;
    private StudentService studentService;

    @PutMapping("/courses/{id_course}/student")
    public Course postStudent(
            @PathVariable Long id_course,
            @RequestBody StudentMapper student
    ){
        return  studentService.addStudent(id_course,student);
    }

    @PutMapping("/courses/{id_course}/student/{id_student}")
    public Course postStudent(
            @PathVariable Long id_course,
            @PathVariable Long id_student,
            @RequestBody StudentMapper student
    ){
        return studentService.updateStudent(id_course, id_student, student);

    }

    @DeleteMapping("/courses/{id_course}/student/{id_student}")
    public Course postStudent(
            @PathVariable Long id_course,
            @PathVariable Long id_student
    ){
        return studentService.deleteStudent(id_course, id_student);

    }
}
