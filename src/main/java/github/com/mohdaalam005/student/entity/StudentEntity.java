package github.com.mohdaalam005.student.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "students")
@Data
public class StudentEntity {

    @Id
    @SequenceGenerator(name = "student_id" , sequenceName = "student_id",initialValue = 1000 , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "student_id")
    private Long id;

    private String name;
    private String gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private CourseEntity course;

}
