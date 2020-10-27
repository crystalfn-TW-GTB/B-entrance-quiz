package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    public List<StudentDto> getAllStudents() {
        return StudentRepository.getAllStudents();
    }

    public void addStudent(String name) {
        StudentDto studentDto = new StudentDto(StudentRepository.getAllStudents().size() - 1, name);
        StudentRepository.addStudent(studentDto);
    }
}
