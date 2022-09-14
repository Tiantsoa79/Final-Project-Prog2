package school.hei.news.heinews.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import school.hei.news.heinews.model.Course;
import school.hei.news.heinews.model.Student;
import school.hei.news.heinews.service.CourseService;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {
    private CourseService courseService;

    @GetMapping("/courses")
    public List<String> getCourses(){
        return courseService.findAllCourse();
    }

    @PostMapping("/courses")
    public List<String> postCourse(
          @RequestBody List<Course> listCourse
    ){

        courseService.addCourse(listCourse);
        
        return courseService.findAllCourse();
    }
    
    @GetMapping("/courses/{id_course}")
    public Course getCourse(long id){
        return courseService.findByCourseId(id);
    }
    
    @PostMapping("/courses/{id_course}")
    public Course postStudent(
            @PathVariable long id,
            @RequestBody Student student
    ){
        courseService.addStudent(id,student);
        return courseService.findByCourseId(id);
    }
    
    @PutMapping("/courses/{id_course}/{id_student}")
    public Course postStudent(
            @PathVariable long id_course,
            @PathVariable long id_student,
            @RequestBody Student student
    ){
        courseService.updateStudent(id_course, id_student, student);
        return courseService.findByCourseId(id_course);
    }
     
    @PutMapping("/courses/{id_course}/{id_student}")
    public Course postStudent(
            @PathVariable long id_course,
            @PathVariable long id_student
    ){
        courseService.deleteStudent(id_course, id_student);
        return courseService.findByCourseId(id_course);
    }
}
