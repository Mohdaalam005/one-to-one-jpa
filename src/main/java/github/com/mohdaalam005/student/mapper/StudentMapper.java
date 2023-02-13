package github.com.mohdaalam005.student.mapper;

import github.com.mohdaalam005.student.entity.CourseEntity;
import github.com.mohdaalam005.student.entity.StudentEntity;
import github.com.mohdaalam005.student.model.CourseRequest;
import github.com.mohdaalam005.student.model.StudentRequest;
import github.com.mohdaalam005.student.model.StudentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentRequest entityToModel(StudentEntity studentEntity);
    List<StudentRequest> entityToModels(List<StudentEntity> studentEntity);

    StudentEntity modelToEntity(StudentRequest studentRequest);

    CourseRequest toModel(CourseEntity courseEntity);

    CourseEntity toEntity(CourseRequest courseRequest);


    StudentResponse entityToResponse(StudentEntity studentEntity);
}
