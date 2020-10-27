package com.thoughtworks.capability.gtb.entrancequiz.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.capability.gtb.entrancequiz.dto.StudentDto;
import com.thoughtworks.capability.gtb.entrancequiz.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void should_get_all_students() throws Exception {
        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(15)))
                .andExpect(jsonPath("$[0].name", is("成吉思汗")))
                .andExpect(jsonPath("$[0].id", is(1)));
    }

    @Test
    void should_add_student() throws Exception {
        mockMvc.perform(post("/student")
                .content("crystal")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        assertEquals(16, StudentRepository.getAllStudents().size());
        assertEquals("crystal", StudentRepository.getAllStudents().get(15).getName());
    }
}