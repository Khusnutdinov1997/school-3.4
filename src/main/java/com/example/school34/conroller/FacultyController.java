package com.example.school34.conroller;

import com.example.school34.model.Faculty;
import com.example.school34.model.Student;
import com.example.school34.service.FacultyService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyInfo(@PathVariable long id) {
        Faculty faculty = facultyService.findFaculty(id);
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty, @PathVariable Long id) {
        Faculty foundFaculty = facultyService.editFaculty(id, faculty);
        if (foundFaculty == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundFaculty);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFacultuInfo(){
        return ResponseEntity.ok(facultyService.getAllFacultyInfo());
    }

    @GetMapping(params = "nameOrColor")
    public Collection<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(@RequestParam String nameOrColor){
        return facultyService.findByNameIgnoreCaseOrColorIgnoreCase(nameOrColor);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Collection<Student>> getFacultyStudents(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getFacultyStudents(id));
    }
}
