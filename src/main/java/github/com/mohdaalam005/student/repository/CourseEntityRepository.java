package github.com.mohdaalam005.student.repository;

import github.com.mohdaalam005.student.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseEntityRepository extends JpaRepository<CourseEntity, Long> {
}