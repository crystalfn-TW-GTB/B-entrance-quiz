package com.thoughtworks.capability.gtb.entrancequiz.service;

import com.thoughtworks.capability.gtb.entrancequiz.dto.GroupDto;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    //TODO GTB-工程实践: - GroupService.java:14 长方法，需要按模块抽取方法，进行重构
    public List<GroupDto> getGroups() {
        List<StudentDto> allStudents = StudentRepository.getAllStudents();
        List<StudentDto> shuffleStudents = new ArrayList<>(allStudents);
        Collections.shuffle(shuffleStudents);

        List<GroupDto> groupDtoList = new ArrayList<>();
        //TODO GTB-工程实践: - GroupService.java:20 Magic number 6
        for (int i = 0; i < 6; i++) {
            List<StudentDto> studentDtoList = new ArrayList<>();
            groupDtoList.add(new GroupDto(String.format("%d 组", i+1), studentDtoList));
        }

        for (int i = 0; i < shuffleStudents.size(); i++) {
            if (i < 6) {
                List<StudentDto> studentDtoList = groupDtoList.get(i).getStudentDtoList();
                studentDtoList.add(shuffleStudents.get(i));
                groupDtoList.get(i).setStudentDtoList(studentDtoList);
            } else {
                List<StudentDto> studentDtoList = groupDtoList.get(i % 6).getStudentDtoList();
                studentDtoList.add(shuffleStudents.get(i));
                groupDtoList.get(i % 6).setStudentDtoList(studentDtoList);
            }
        }

        return groupDtoList;
    }
}
