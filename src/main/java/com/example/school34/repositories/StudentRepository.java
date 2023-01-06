package com.example.school34.repositories;

import com.example.school34.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface StudentRepository extends JpaRepository <Student, Long> {
    Collection<Student> findByAgeBetween(Long minAge, Long maxAge);

   Collection<Student> findAllByFacultyId(long facultyId);

}
