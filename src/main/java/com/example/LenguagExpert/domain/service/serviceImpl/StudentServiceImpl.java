package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.StudentRepository;
import com.example.LenguagExpert.domain.service.service.StudentService;
import com.example.LenguagExpert.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Long id, Student student) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if(optionalStudent.isPresent()){
            Student studentToUpdate = optionalStudent.get();
            studentToUpdate.setFirstName(student.getFirstName());
            studentToUpdate.setLastName(student.getLastName());
            studentToUpdate.setStatus(student.getStatus());
            studentToUpdate.setAddress(student.getAddress());
            studentToUpdate.setEmail(student.getEmail());
            studentToUpdate.setEnrollmentDate(student.getEnrollmentDate());
            studentToUpdate.setPhone(student.getPhone());
            studentRepository.save(studentToUpdate);
            System.out.println("Student updated");
        }else {
            throw new Error("Student id not found: " + id);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
