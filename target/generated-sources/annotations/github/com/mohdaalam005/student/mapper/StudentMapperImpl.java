package github.com.mohdaalam005.student.mapper;

import github.com.mohdaalam005.student.entity.CourseEntity;
import github.com.mohdaalam005.student.entity.StudentEntity;
import github.com.mohdaalam005.student.model.CourseRequest;
import github.com.mohdaalam005.student.model.StudentRequest;
import github.com.mohdaalam005.student.model.StudentResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-13T15:51:53+0530",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.2 (Oracle Corporation)"
)
*/
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentRequest entityToModel(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentRequest studentRequest = new StudentRequest();

        studentRequest.setId( studentEntity.getId() );
        studentRequest.setName( studentEntity.getName() );
        studentRequest.setGender( studentEntity.getGender() );
        studentRequest.setCourse( toModel( studentEntity.getCourse() ) );

        return studentRequest;
    }

    @Override
    public List<StudentRequest> entityToModels(List<StudentEntity> studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        List<StudentRequest> list = new ArrayList<StudentRequest>( studentEntity.size() );
        for ( StudentEntity studentEntity1 : studentEntity ) {
            list.add( entityToModel( studentEntity1 ) );
        }

        return list;
    }

    @Override
    public StudentEntity modelToEntity(StudentRequest studentRequest) {
        if ( studentRequest == null ) {
            return null;
        }

        StudentEntity studentEntity = new StudentEntity();

        studentEntity.setId( studentRequest.getId() );
        studentEntity.setName( studentRequest.getName() );
        studentEntity.setGender( studentRequest.getGender() );
        studentEntity.setCourse( toEntity( studentRequest.getCourse() ) );

        return studentEntity;
    }

    @Override
    public CourseRequest toModel(CourseEntity courseEntity) {
        if ( courseEntity == null ) {
            return null;
        }

        CourseRequest courseRequest = new CourseRequest();

        courseRequest.setId( courseEntity.getId() );
        courseRequest.setName( courseEntity.getName() );
        courseRequest.setPrice( courseEntity.getPrice() );

        return courseRequest;
    }

    @Override
    public CourseEntity toEntity(CourseRequest courseRequest) {
        if ( courseRequest == null ) {
            return null;
        }

        CourseEntity courseEntity = new CourseEntity();

        courseEntity.setId( courseRequest.getId() );
        courseEntity.setName( courseRequest.getName() );
        courseEntity.setPrice( courseRequest.getPrice() );

        return courseEntity;
    }

    @Override
    public StudentResponse entityToResponse(StudentEntity studentEntity) {
        if ( studentEntity == null ) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();

        studentResponse.setId( studentEntity.getId() );

        return studentResponse;
    }
}
