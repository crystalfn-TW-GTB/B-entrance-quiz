package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class StudentController {
    final
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    //TODO GTB-知识点: - StudentController.java:29 根据restful实践，资源名一般是复数
    //TODO GTB-知识点: - StudentController.java:30 根据restful实践，POST方法一般返回创建的内容或者Id
    //TODO GTB-知识点: - StudentController.java:31 如果不是有自定义返回的需求，ResponseEntity一般可省略
    @PostMapping("/student")
    public ResponseEntity<List<StudentDto>> addStudent(@RequestBody String productName) {
        studentService.addStudent(productName);
        return ResponseEntity.created(null).build();
    }
}
