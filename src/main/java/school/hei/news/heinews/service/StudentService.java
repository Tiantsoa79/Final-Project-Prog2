package school.hei.news.heinews.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import school.hei.news.heinews.repository.StudentRepository;

@Service
@AllArgsConstructor
public class StudentService {
    private StudentRepository studentRepository;

}
