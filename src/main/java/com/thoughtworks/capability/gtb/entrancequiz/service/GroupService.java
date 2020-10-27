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
    public List<GroupDto> getGroups() {
        List<StudentDto> allStudents = StudentRepository.getAllStudents();
        Collections.shuffle(allStudents);

        List<GroupDto> groupDtoList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            List<StudentDto> studentDtoList = new ArrayList<>();
            groupDtoList.add(new GroupDto(String.format("%d 组", i), studentDtoList));
        }

        for (int i = 0; i < allStudents.size(); i++) {
            List<StudentDto> studentDtoList = groupDtoList.get(i).getStudentDtoList();
            if (i < 6) {
                studentDtoList.add(allStudents.get(i));
                groupDtoList.get(i).setStudentDtoList(studentDtoList);
            } else {
                studentDtoList.add(allStudents.get(i % 6));
                groupDtoList.get(i % 6).setStudentDtoList(studentDtoList);
            }
        }

        return groupDtoList;
    }
}
