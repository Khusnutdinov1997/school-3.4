package com.example.school34.service;

import com.example.school34.model.Faculty;
import com.example.school34.model.Student;

import java.util.Collection;

public interface FacultyService {

    Faculty createFaculty(Faculty faculty);

    Faculty findFaculty(long id);
    Faculty editFaculty(Long id, Faculty faculty);

    void deleteFaculty(long id);

    Collection<Faculty> getAllFacultyInfo();

    Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String nameOrColor);
    Collection<Student> getStudentByFaculty(long id);
}
