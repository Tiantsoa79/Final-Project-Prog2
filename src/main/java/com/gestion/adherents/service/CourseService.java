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
    
    private CourseRepository courseRepository;
    
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
    	
    public Course findByCourseId(long id) {
    
      return courseRepository.getById(id);
    
    }

    public void addStudent(long id, StudentMapper student) {
        Student tmp = new Student();
        tmp.setName(student.getName());
        tmp.setReference(student.getReference());
        tmp.setGroupProm(student.getGroup());

        studentRepository.save(tmp);

        List<Student> newList = new ArrayList<>();

        for (Student adherent: courseRepository.getById(id).getAdherents()
        ) {
            newList.add(adherent);
        }

        newList.add(tmp);

        courseRepository.getById(id).setAdherents(newList);
    }

    public void updateStudent(long id, long id_student, StudentMapper student) {

        studentRepository.getById(id_student).setName(student.getName());

        studentRepository.getById(id_student).setReference(student.getReference());

        studentRepository.getById(id_student).setGroupProm(student.getGroup());

        List<Student> newList = new ArrayList<>();

        for (Student adherent: courseRepository.getById(id).getAdherents()
        ) {
            if(adherent.getIdStudent()!=id_student) {
                newList.add(adherent);
            }
        }

        newList.add(studentRepository.getById(id_student));

        courseRepository.getById(id).setAdherents(newList);
    }

    public void deleteStudent(long id, long id_student) {


        List<Student> newList = new ArrayList<>();

        for (Student adherent: courseRepository.getById(id).getAdherents()
        ){
            if(adherent.getIdStudent()!=id_student) {
                newList.add(adherent);
            }
        }

        courseRepository.getById(id).setAdherents(newList);

        studentRepository.deleteById(id_student);
    }

}
