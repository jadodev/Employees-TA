package com.Jonathan.Prueba.Tecnica.infrastructure.entity;

public class EmployeeById {
    private EmployeeExternalDto data;

    public EmployeeById(EmployeeExternalDto data) {
        this.data = data;
    }

    public EmployeeExternalDto getData() {
        return data;
    }

    public void setData(EmployeeExternalDto data) {
        this.data = data;
    }
}
