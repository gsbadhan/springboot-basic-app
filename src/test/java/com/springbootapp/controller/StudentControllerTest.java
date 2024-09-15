package com.springbootapp.controller;

import com.springbootapp.Dto.StudentDto;
import com.springbootapp.service.StudentService;
import com.springbootapp.start.SpringbootBasicApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(StudentController.class)
@ContextConfiguration(classes = SpringbootBasicApp.class)
class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    private StudentDto studentDto;

    @BeforeEach
    void setUp() {
        studentDto = new StudentDto();
        studentDto.setId(1L);
        studentDto.setName("John Doe");
        // Initialize other properties of studentDto if needed
    }

    @Test
    void testCreate() throws Exception {
        // Mock the service layer
        when(studentService.create(any(StudentDto.class))).thenReturn(studentDto);
        // Perform the POST request
        mockMvc.perform(post("/v1/students")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"John Doe\"}")) // Use a JSON string representation of the StudentDto
                .andExpect(status().isCreated()) // Expect a 201 Created status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"John Doe\"}")); // Expect JSON response
    }

    @Test
    void testDelete() throws Exception {
        // Mock the service layer
        when(studentService.delete(1L)).thenReturn(studentDto);
        // Perform the DELETE request
        mockMvc.perform(delete("/v1/students")
                        .param("id", "1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()) // Expect a 200 OK status
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"John Doe\"}")); // Expect JSON response
    }
}