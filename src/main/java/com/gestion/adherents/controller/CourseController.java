package com.gestion.adherents.controller;

import com.gestion.adherents.model.Course;
import com.gestion.adherents.mapper.CourseMapper;
import com.gestion.adherents.mapper.StudentMapper;
import com.gestion.adherents.service.CourseService;
import com.gestion.adherents.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;
    private StudentService studentService;


    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.findAllCourse();
    }

    @PostMapping("/courses")
    public List<Course> postCourse(
          @RequestBody CourseMapper course
    ){

        courseService.addCourse(course);
        
        return courseService.findAllCourse();
    }
    
    @GetMapping("/courses/{id_course}")
    public Course getCourse(@PathVariable Long id_course){
        return courseService.findByCourseId(id_course);
    }
    

}
