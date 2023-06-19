package com.example.api_students;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ApiController {
    private final StudentService studentService;

    public ApiController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Метод для получения списка всех студентов
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        try {
            List<Student> students =  studentService.getStudents();
            return ResponseEntity.ok(students);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    // Метод для добавления студента
    @PostMapping("/students")
    public ResponseEntity<String> addStudent(final Student student) {
        try {
            studentService.addStudent(student);
            return ResponseEntity.ok("Student added successfully.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Метод для получение оценок конкретного студента
    @GetMapping("grades/{studentId}")
    public ResponseEntity<?> getGrades(@PathVariable("studentId") final Integer id) {
        try {
            Integer grade = studentService.getGrade(id);
            return ResponseEntity.ok(grade);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // метод выставления оценки студенту
    @PostMapping("grades")
    public ResponseEntity<?> postGrade(Integer id, Integer grade) {
        try {
            studentService.addGrade(id, grade);
            return ResponseEntity.ok("Grade was added\n");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}