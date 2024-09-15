package com.springbootapp.controller;

import com.springbootapp.Dto.StudentDto;
import com.springbootapp.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;


@Tag(name = "students")
@RestController
@RequestMapping(value = "/v1/students")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(description = "Create student information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created")
    })
    @PostMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> create(@RequestBody StudentDto studentDto) {
        log.info("new create request for student={}", studentDto);
        StudentDto studentDtoRsp = studentService.create(studentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentDtoRsp);
    }

    @Operation(description = "Delete student information")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted")
    })
    @DeleteMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public ResponseEntity<StudentDto> delete(Long id) {
        log.info("delete request for student id={}", id);
        StudentDto studentDtoRsp = studentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentDtoRsp);
    }
}
