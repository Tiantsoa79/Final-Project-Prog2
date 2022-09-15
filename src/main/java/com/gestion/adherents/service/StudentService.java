package com.gestion.adherents.service;

import com.gestion.adherents.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

}
