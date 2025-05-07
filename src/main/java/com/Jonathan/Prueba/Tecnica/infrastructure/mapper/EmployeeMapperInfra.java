package com.Jonathan.Prueba.Tecnica.infrastructure.mapper;

import com.Jonathan.Prueba.Tecnica.domain.entity.Employee;
import com.Jonathan.Prueba.Tecnica.infrastructure.entity.EmployeeExternalDto;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeMapperInfra {
    public static Employee toDomain(EmployeeExternalDto dto) {
        return new Employee(
                dto.getId(),
                dto.getEmployee_name(),
                dto.getEmployee_salary(),
                dto.getEmployee_age(),
                dto.getProfile_image()
        );
    }

    public static List<Employee> toDomainList(List<EmployeeExternalDto> dtos) {
        return dtos.stream()
                .map(EmployeeMapperInfra::toDomain)
                .collect(Collectors.toList());
    }
}
