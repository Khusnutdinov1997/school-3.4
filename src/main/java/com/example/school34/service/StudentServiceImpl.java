package com.example.school34.service;

import com.example.school34.model.Avatar;
import com.example.school34.model.Faculty;
import com.example.school34.model.Student;
import com.example.school34.repositories.FacultyRepository;
import com.example.school34.repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

import static java.nio.file.StandardOpenOption.CREATE_NEW;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    public StudentServiceImpl(StudentRepository studentRepository,
                              FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Student createStuent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student editStudent(long id, Student student) {
        Student oldStudent = findStudent(id);
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Collection<Student> getAllStudentInfo(){
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> findByAgeBetween(Long minAge, Long maxAge){
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Faculty getStudentFaculty(long id) {
        Student student = findStudent(id);
        if (student == null) {
            return null;
        }
        return student.getFaculty();
    }

}
