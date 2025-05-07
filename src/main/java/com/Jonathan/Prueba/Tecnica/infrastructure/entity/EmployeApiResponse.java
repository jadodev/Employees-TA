package com.Jonathan.Prueba.Tecnica.infrastructure.entity;

import java.util.List;

public class EmployeApiResponse {
    private List<EmployeeExternalDto> data;

    public EmployeApiResponse() {
    }

    public List<EmployeeExternalDto> getData() {
        return data;
    }

    public void setData(List<EmployeeExternalDto> data) {
        this.data = data;
    }
}
