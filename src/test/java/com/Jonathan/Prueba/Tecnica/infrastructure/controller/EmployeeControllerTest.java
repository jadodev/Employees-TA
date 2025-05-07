package com.Jonathan.Prueba.Tecnica.infrastructure.controller;

import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeDto;
import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeResponseDto;
import com.Jonathan.Prueba.Tecnica.application.service.EmployeeApplicationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeApplicationService employeeService;

    @Test
    void testGetAllEmployees() throws Exception {
        List<EmployeeDto> mockEmployees = Arrays.asList(
                new EmployeeDto(1, "John Doe", 50000, 30, "profile1.jpg"),
                new EmployeeDto(2, "Jane Smith", 60000, 40, "profile2.jpg")
        );

        when(employeeService.getAlEmployees()).thenReturn(mockEmployees);

        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1].id").value(2));
    }

    @Test
    void testGetAllEmployeesEmpty() throws Exception {
        when(employeeService.getAlEmployees()).thenReturn(Arrays.asList());

        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.size()").value(0));
    }

    @Test
    void testGetEmployeeById() throws Exception {
        EmployeeResponseDto mockEmployee = new EmployeeResponseDto(1, "John Doe", 50000, 30, "profile1.jpg", 600000);

        when(employeeService.getEmployeeById(1L)).thenReturn(Optional.of(mockEmployee));

        mockMvc.perform(get("/employees/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.employee_name").value("John Doe"))
                .andExpect(jsonPath("$.employee_salary").value(50000.0))
                .andExpect(jsonPath("$.employee_anual_salary").value(600000.0));
    }

}