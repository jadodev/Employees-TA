package com.Jonathan.Prueba.Tecnica.infrastructure.controller;

import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeDto;
import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeResponseDto;
import com.Jonathan.Prueba.Tecnica.application.service.EmployeeApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeApplicationService employeeService;

    public EmployeeController(EmployeeApplicationService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        return ResponseEntity.ok(employeeService.getAlEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable("id") long id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id).orElse(null));
    }
}
