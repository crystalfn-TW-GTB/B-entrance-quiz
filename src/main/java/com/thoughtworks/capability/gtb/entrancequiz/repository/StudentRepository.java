package com.thoughtworks.capability.gtb.entrancequiz.repository;

import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static final String[] studentNameList = {"成吉思汗", "鲁班七号", "太乙真人", "钟无艳", "花木兰", "雅典娜", "芈月",
            "白起", "刘禅", "庄周", "马超", "刘备", "哪吒", "大乔", "蔡文姬"};

    private static int id = 1;
    private static final List<StudentDto> studentDtoList = new ArrayList<>();

    static {
        for (String name : studentNameList) {
            studentDtoList.add(new StudentDto(id, name));
            id++;
        }
    }

    public static List<StudentDto> getAllStudents() {
        return studentDtoList;
    }
}