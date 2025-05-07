package com.Jonathan.Prueba.Tecnica.application.dto;

public class EmployeeDto {
    private long id;
    private String employee_name;
    private double employee_salary;
    private int employee_age;
    private String profie_image;

    public EmployeeDto() {
    }

    public EmployeeDto(long id, String employee_name, double employee_salary, int employee_age, String profie_image) {
        this.id = id;
        this.employee_name = employee_name;
        this.employee_salary = employee_salary;
        this.employee_age = employee_age;
        this.profie_image = profie_image;
    }

    public EmployeeDto(String employeeName, double employeeSalary, int employeeAge) {
    }

    public long getId() {
        return id;
    }


    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public int getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(int employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfie_image() {
        return profie_image;
    }

    public void setProfie_image(String profie_image) {
        this.profie_image = profie_image;
    }

}
