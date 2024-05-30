package com.picafe.team_3.model;

import jakarta.persistence.*;

import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "employee")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private int employeeId;

    @Column(name = "employee_name", nullable = false)
    private String employeeName;

    @Column(name = "store_id", nullable = false)
    private int storeId;

    @Column(name = "employee_phone", nullable = false)
    private String employeePhone;

    @Column(name = "employee_address", nullable = false)
    private String employeeAddress;

    @Column(name = "employee_designation", nullable = false)
    private String employeeDesignation;

    @Column(name = "employee_salary", nullable = false)
    private int employeeSalary;

    @Column(name = "joining_date", nullable = false)
    private Date joiningDate;

    @Column(name = "leaving_date", nullable = false)
    private Date leavingDate;

    @Column(name = "employee_password", nullable = false)
    private String employeePassword;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String password) {
        this.employeePassword = password;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    };

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }
}