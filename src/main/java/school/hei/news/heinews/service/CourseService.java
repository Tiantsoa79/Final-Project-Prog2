package school.hei.news.heinews.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.news.heinews.model.Course;
import school.hei.news.heinews.model.Student;
import school.hei.news.heinews.repository.CourseRepository;
import school.hei.news.heinews.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseService {
    
    private CourseRepository courseRepository;
    
    private StudentRepository studentRepository;

    public List<String> findAllCourse() {
     
      List<Course> list = courseRepository.findAll();
      
      List<String> names = new ArrayList<>();
      
      for (Course course: list ) {
         names.add(course.getName());
      }
     
      return names;
    }
    
    public List<Course> addCourse(List<Course> courseList) {
   
      return courseRepository.saveAll(courseList);
    
    }
    	
    public Course findByCourseId(long id) {
    
      return courseRepository.getById(id);
    
    }

    public void addStudent(long id, Student student) {
      
      studentRepository.save(student);
    
      List<Student> newList = new ArrayList<>();
    
      for (Student adherent: courseRepository.getById(id).getAdherents()
         ) {
      newList.add(adherent);
      }
    
      newList.add(student);

        courseRepository.getById(id).setAdherents(newList);
    }
    
    public void updateStudent(long id, long id_student, Student student) {
      
      studentRepository.getById(id_student).setName(student.getName());
      
      studentRepository.getById(id_student).setReference(student.getReference());
      
      studentRepository.getById(id_student).setGroup(student.getGroup());
      
      List<Student> newList = new ArrayList<>();
      
      for (Student adherent: courseRepository.getById(id).getAdherents()
         ) {
      if(adherent.getIdStudent() != id_student){newList.add(adherent);}
      }
      
      newList.add(studentRepository.getById(id_student));

        courseRepository.getById(id).setAdherents(newList);
    }	
    
    public void deleteStudent(long id, long id_student) {
      
      List<Student> newList = new ArrayList<>();
      
      for (Student adherent: courseRepository.getById(id_student).getAdherents()
         ) {
      if(adherent.getIdStudent()!=id_student){newList.add(adherent);}
      }

        courseRepository.getById(id_student).setAdherents(newList);
    }	
   
}
