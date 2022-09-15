package com.gestion.adherents.controller;

import com.gestion.adherents.model.Course;
import com.gestion.adherents.mapper.CourseMapper;
import com.gestion.adherents.mapper.StudentMapper;
import com.gestion.adherents.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

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
    public Course getCourse(long id){
        return courseService.findByCourseId(id);
    }
    
    @PostMapping("/courses/{id_course}")
    public Course postStudent(
            @PathVariable long id,
            @RequestBody StudentMapper student
    ){
        courseService.addStudent(id,student);
        return courseService.findByCourseId(id);
    }
    
    @PutMapping("/courses/{id_course}/{id_student}")
    public Course postStudent(
            @PathVariable long id_course,
            @PathVariable long id_student,
            @RequestBody StudentMapper student
    ){
        courseService.updateStudent(id_course, id_student, student);
        return courseService.findByCourseId(id_course);
    }
     
    @DeleteMapping("/courses/{id_course}/{id_student}")
    public Course postStudent(
            @PathVariable long id_course,
            @PathVariable long id_student
    ){
        courseService.deleteStudent(id_course, id_student);
        return courseService.findByCourseId(id_course);
    }
}
