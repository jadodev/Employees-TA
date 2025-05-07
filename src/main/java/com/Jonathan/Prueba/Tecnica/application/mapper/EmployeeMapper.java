package com.Jonathan.Prueba.Tecnica.application.mapper;

import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeDto;
import com.Jonathan.Prueba.Tecnica.application.dto.EmployeeResponseDto;
import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;

public class EmployeeMapper {
    public static EmployeeResponseDto toResponse (Employee employee){
        return  new EmployeeResponseDto(
                employee.getId(),
                employee.getEmployee_name(),
                employee.getEmployee_salary(),
                employee.getEmployee_age(),
                employee.getProfie_image(),
                employee.employee_anual_salary()
        );
    }

    public static EmployeeDto toDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getEmployee_name(),
                employee.getEmployee_salary(),
                employee.getEmployee_age(),
                employee.getProfie_image()
        );
    }
}
