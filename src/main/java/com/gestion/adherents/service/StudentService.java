package com.gestion.adherents.service;

import com.gestion.adherents.mapper.StudentMapper;
import com.gestion.adherents.model.Course;
import com.gestion.adherents.model.Student;
import com.gestion.adherents.repository.CourseRepository;
import com.gestion.adherents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public Course addStudent(Long id, StudentMapper student) {

         Student newStudent = new Student();

         newStudent.setName(student.getName());
         newStudent.setReference(student.getReference());
         newStudent.setGroupProm(student.getGroupProm());

         studentRepository.save(newStudent);

         Course course =  courseRepository.findById(id).get();
         course.addAdherents(newStudent);

        return courseRepository.save(course);

    }

    public Course deleteStudent(Long id, Long id_student) {

        Course course =  courseRepository.findById(id).get();

        course.removeAdherents(studentRepository.findById(id_student).get());

        studentRepository.deleteById(id_student);

        return courseRepository.save(course);
    }
    public Course updateStudent(Long id, Long id_student, StudentMapper student) {


        this.deleteStudent(id, id_student);
        this.addStudent(id,student);

       return courseRepository.findById(id).get();
    }


}
