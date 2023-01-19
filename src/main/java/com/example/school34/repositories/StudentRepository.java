package com.example.school34.repositories;

import com.example.school34.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
    Collection<Student> findByAgeBetween(Long minAge, Long maxAge);

   Collection<Student> findAllByFacultyId(long facultyId);

   @Query(value = "SELECT COUNT (*) FROM student", nativeQuery = true)
    Long getAmountOfAllStudents();

   @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    Double getAverageAgeOfAllStudents();

   @Query(value = "SELECT * FROM student ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Student> getLastFiveStudents();
}
