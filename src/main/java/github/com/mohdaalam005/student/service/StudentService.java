package github.com.mohdaalam005.student.service;

import github.com.mohdaalam005.student.entity.CourseEntity;
import github.com.mohdaalam005.student.entity.StudentEntity;
import github.com.mohdaalam005.student.mapper.StudentMapper;
import github.com.mohdaalam005.student.model.StudentRequest;
import github.com.mohdaalam005.student.model.StudentResponse;
import github.com.mohdaalam005.student.repository.CourseEntityRepository;
import github.com.mohdaalam005.student.repository.StudentEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    private final CourseEntityRepository courseEntityRepository;
    private final StudentEntityRepository studentEntityRepository;

    public StudentService(StudentMapper studentMapper, CourseEntityRepository courseEntityRepository, StudentEntityRepository studentEntityRepository) {
        this.studentMapper = studentMapper;
        this.courseEntityRepository = courseEntityRepository;
        this.studentEntityRepository = studentEntityRepository;
    }

    public StudentResponse createStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = studentMapper.modelToEntity(studentRequest);
        StudentEntity save = studentEntityRepository.save(studentEntity);
        return studentMapper.entityToResponse(save);
    }

    public List<StudentRequest> getStudents() {
        List<StudentEntity> students = studentEntityRepository.findAll();
        return studentMapper.entityToModels(students);
    }

    public StudentRequest getStudent(Long studentId) {
        StudentRequest studentRequest = null;
        Optional<StudentEntity> student = studentEntityRepository.findById(studentId);
        if (student.isPresent()) {
            studentRequest = studentMapper.entityToModel(student.get());
        }
        return studentRequest;
    }

    public StudentRequest updateStudent(Long studentId, StudentRequest studentRequest) {
        StudentRequest studentRequest1 = null;
        Optional<StudentEntity> student = studentEntityRepository.findById(studentId);
        if (student.isPresent()) {
            Optional<CourseEntity> course = courseEntityRepository.findById(student.get().getCourse().getId());

            if (course.isPresent()) {
                StudentEntity studentEntity = studentMapper.modelToEntity(studentRequest);
                CourseEntity courseEntity = studentMapper.toEntity(studentRequest.getCourse());
                courseEntity.setId(student.get().getCourse().getId());
                CourseEntity updateCourse = courseEntityRepository.save(courseEntity);
                studentEntity.setId(studentId);
                studentEntity.setCourse(updateCourse);
                StudentEntity save = studentEntityRepository.save(studentEntity);
                studentRequest1 = studentMapper.entityToModel(save);
            }

        }
        return studentRequest1;
    }

    public void deleteStudent(Long studentId){
        Optional<StudentEntity> findById = studentEntityRepository.findById(studentId);

        if(findById.isPresent()){
            studentEntityRepository.deleteById(studentId);
        }

    }


}
