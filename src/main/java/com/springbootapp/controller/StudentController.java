package com.springbootapp.controller;

import com.springbootapp.Dto.StudentDto;
import com.springbootapp.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;


@Api(tags = "students")
@RestController
@RequestMapping(value = "/v1/students")
@Slf4j
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ApiOperation(value = "create student information")
    @PostMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE, consumes = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public StudentDto create(@RequestBody StudentDto studentDto) {
        log.info("new create request for student={}", studentDto);
        StudentDto studentDtoRsp = studentService.create(studentDto);
        return studentDtoRsp;
    }

    @ApiOperation(value = "delete student information using id")
    @DeleteMapping(produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    public StudentDto delete(Long id) {
        log.info("delete request for student id={}", id);
        StudentDto studentDtoRsp = studentService.delete(id);
        return studentDtoRsp;
    }
}
