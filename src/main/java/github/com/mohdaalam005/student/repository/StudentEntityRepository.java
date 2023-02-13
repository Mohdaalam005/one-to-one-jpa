package github.com.mohdaalam005.student.repository;

import github.com.mohdaalam005.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentEntityRepository extends JpaRepository<StudentEntity, Long> {
}