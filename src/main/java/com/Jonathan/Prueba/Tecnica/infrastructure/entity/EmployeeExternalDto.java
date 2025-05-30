package com.Jonathan.Prueba.Tecnica.infrastructure.entity;

public class EmployeeExternalDto {
    private long id;
    private String employee_name;
    private double employee_salary;
    private int employee_age;
    private String profile_image;


    public EmployeeExternalDto(long id, String employee_name, double employee_salary, int employee_age, String profile_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }

    public long getId() {
        return id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }
}
