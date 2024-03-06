package com.example.LenguagExpert.domain.service.serviceImpl;

import com.example.LenguagExpert.domain.repository.SpecialActivityRepository;
import com.example.LenguagExpert.domain.repository.StudentRepository;
import com.example.LenguagExpert.domain.service.service.StudentService;
import com.example.LenguagExpert.persistence.entity.SpecialActivity;
import com.example.LenguagExpert.persistence.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final SpecialActivityRepository specialActivityRepository;

    @Autowired
    StudentServiceImpl(StudentRepository studentRepository,SpecialActivityRepository specialActivityRepository){
        this.studentRepository =studentRepository;
        this.specialActivityRepository = specialActivityRepository;
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

    @Override
    @Transactional
    public void insertSpecialActivity(Long specialActivityId, Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        SpecialActivity specialActivity = specialActivityRepository.findById(specialActivityId).orElse(null);

        if (student != null && specialActivity != null) {
            specialActivity.getStudents().add(student);
            student.getSpecialActivity().add(specialActivity);
//            specialActivityRepository.save(specialActivity);
//            studentRepository.save(student);
        }
    }


//    @Transactional
//    public void removeLibro(Long autorId, Long libroId) {
//        Autor autor = autorRepository.findById(autorId).orElse(null);
//        Libro libro = libroRepository.findById(libroId).orElse(null);
//
//        if (autor != null && libro != null) {
//            autor.getLibros().remove(libro);
//            libro.getAutores().remove(autor);
//        }
//    }

}
