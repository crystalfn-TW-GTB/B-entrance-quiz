package com.thoughtworks.capability.gtb.entrancequiz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//TODO GTB-知识点: * 了解下DTO的概念，思考下什么场景引入DTO比较合适。
public class GroupDto {
    private String name;
    private List<StudentDto> studentDtoList;
}
