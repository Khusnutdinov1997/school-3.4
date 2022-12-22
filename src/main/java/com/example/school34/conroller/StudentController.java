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

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentInfo(@PathVariable Long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStuent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> editStudent(@RequestBody Student student, @PathVariable Long id) {
        Student foundStudent = studentService.editStudent(id, student);
        if (foundStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudentInfo(){
        return ResponseEntity.ok(studentService.getAllStudentInfo());
    }

    @GetMapping(params = "minAge, maxAge")
    public Collection<Student> findByAgeBetween(@RequestParam Long minAge,
                                                @RequestParam Long maxAge){
        return studentService.findByAgeBetween(minAge, maxAge);
    }

    @GetMapping("/{id}/faculty")
    public Faculty getFacultyByStudent(@PathVariable long id) {
        return studentService.getFacultyByStudent(id);
    }
}
