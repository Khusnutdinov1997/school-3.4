package com.example.school34.conroller;

import com.example.school34.model.Student;
import com.example.school34.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infoStudent")
public class InfoStudentController {

    private final StudentService studentService;

    public InfoStudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping("/amount-all-students")
    public Long getAmountOfAllStudents() {
       return studentService.getAmountOfAllStudents();
    }

    @GetMapping("/average-age-of-all-students")
    public  Double getAverageAgeOfAllStudents() {
        return studentService.getAverageAgeOfAllStudents();
    }

    @GetMapping("/last-five-students")
    public List<Student> getLastFiveStudents() {
        return studentService.getLastFiveStudents();
    }

}
