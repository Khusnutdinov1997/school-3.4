package com.example.school34.service;

import com.example.school34.model.Faculty;
import com.example.school34.model.Student;
import java.util.Collection;
import java.util.List;

public interface StudentService {

    Student createStuent(Student student);

    Student findStudent(long id);

    Student editStudent(long id , Student student);

    void deleteStudent(long id);

    Collection<Student> getAllStudentInfo();

    Collection<Student> findByAgeBetween(Long minAge, Long maxAge);
    Faculty getStudentFaculty(long id);
    Long getAmountOfAllStudents();
    Double getAverageAgeOfAllStudents();
    List<Student> getLastFiveStudents();
}
