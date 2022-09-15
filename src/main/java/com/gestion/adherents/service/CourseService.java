package com.gestion.adherents.service;

import com.gestion.adherents.model.Course;
import com.gestion.adherents.model.Student;
import com.gestion.adherents.mapper.CourseMapper;
import com.gestion.adherents.mapper.StudentMapper;
import com.gestion.adherents.repository.CourseRepository;
import com.gestion.adherents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CourseService {
    
    private final CourseRepository courseRepository;
    
    private StudentRepository studentRepository;

    public List<Course> findAllCourse() {

      return courseRepository.findAll();

    }

    public List<Course> addCourse(CourseMapper course) {
        Course newCourse = new Course();
        newCourse.setName(course.getName());
        newCourse.setTeacher(course.getTeacher());
        courseRepository.save(newCourse);

        return findAllCourse();
    }
    	
    public Course findByCourseId(Long id) {
    
      return courseRepository.findById(id).get();
    
    }



}
