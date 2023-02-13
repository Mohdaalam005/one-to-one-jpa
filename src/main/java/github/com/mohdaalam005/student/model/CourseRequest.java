package github.com.mohdaalam005.student.model;

import lombok.Data;

@Data
public class CourseRequest extends StudentResponse {
    private String name ;
    private Double price ;
}
