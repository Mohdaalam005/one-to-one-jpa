package github.com.mohdaalam005.student.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "courses")
@Data
public class CourseEntity {
    @Id
    @SequenceGenerator(name = "course_id" , sequenceName = "course_id",initialValue = 100 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "course_id")
    private Long id ;
    private String name ;
    private Double price ;

    @OneToOne(mappedBy = "course")
    private StudentEntity student ;
}
