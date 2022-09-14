package school.hei.news.heinews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.hei.news.heinews.model.Course;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
