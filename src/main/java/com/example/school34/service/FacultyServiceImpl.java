package com.example.school34.service;

import com.example.school34.model.Faculty;
import com.example.school34.model.Student;
import com.example.school34.repositories.FacultyRepository;
import com.example.school34.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    private final StudentRepository studentRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository,
                                StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @Override
    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    @Override
    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    @Override
    public Faculty editFaculty(Long id, Faculty faculty) {
        Faculty oldFaculty = findFaculty(id);
        oldFaculty.setName(faculty.getName());
        oldFaculty.setColor(faculty.getColor());
        return facultyRepository.save(faculty);
    }

    @Override
    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public Collection<Faculty> getAllFacultyInfo(){
        return facultyRepository.findAll();
    }

    @Override
    public Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String nameOrColor){
        return facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor, nameOrColor);
    }

    @Override
    public Collection<Student> getStudentByFaculty(long id){
        return studentRepository.findAllByFaculty_id(id);
    }
}
