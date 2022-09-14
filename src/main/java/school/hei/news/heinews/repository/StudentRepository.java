package school.hei.news.heinews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.news.heinews.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
