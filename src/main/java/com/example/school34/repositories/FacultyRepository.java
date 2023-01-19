package com.example.school34.repositories;

import com.example.school34.model.Faculty;
import com.example.school34.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository <Faculty, Long> {

    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String name, String color);

}
