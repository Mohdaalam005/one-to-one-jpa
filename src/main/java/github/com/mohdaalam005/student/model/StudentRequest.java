package github.com.mohdaalam005.student.model;


import lombok.Data;

@Data
public class StudentRequest extends StudentResponse {
    private String name ;
    private String gender ;

    private CourseRequest course ;
}
