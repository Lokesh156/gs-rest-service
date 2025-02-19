package com.example.restservice;

import org.springframework.stereotype.Repository;

@Repository
public class EmployeeManager {
    private static Employees employees = new Employees();

    static {
        // Initialize with sample employees
        employees.getEmployeeList()
                .add(new Employee("1", "Prem", "Tiwari", "prem@gmail.com", "Developer"));
        employees.getEmployeeList()
                .add(new Employee("2", "Vikash", "Kumar", "vikash@gmail.com", "Tester"));
        employees.getEmployeeList()
                .add(new Employee("3", "Ritesh", "Ojha", "ritesh@gmail.com","Lead"));
        employees.getEmployeeList().add(new Employee("4","Lokesh","Pallikonda","lp@gmail.com","Developer"));
    }

    // Retrieve all employees
    public Employees getAllEmployees() {
        return employees;
    }

    // Add an employee
    public void addEmployee(Employee employee) {
        employees.getEmployeeList().add(employee);
    }
}
