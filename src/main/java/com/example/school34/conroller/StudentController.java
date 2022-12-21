package com.example.school34.conroller;

import com.example.school34.model.Faculty;
import com.example.school34.model.Student;
import com.example.school34.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studetnService;

    public StudentController(StudentService studetnService) {
        this.studetnService = studetnService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studetnService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studetnService.createStuent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Student foundStudent = studetnService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studetnService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudentInfo(){
        return ResponseEntity.ok(studetnService.getAllStudentInfo());
    }

    @GetMapping(params = "minAge, maxAge")
    public Collection<Student> findByAgeBetween(@RequestParam(required = false) Long minAge,
                                                @RequestParam(required = false) Long maxAge){
        return studetnService.findByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/{id}/faculty")
    public Collection<Faculty> getFacultyByStudent(@PathVariable long id) {
        return studetnService.getFacultyByStudent(id);
    }
}
