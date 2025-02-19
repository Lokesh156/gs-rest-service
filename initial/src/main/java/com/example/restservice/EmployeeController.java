package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
private final EmployeeManager employeeManager;

  public EmployeeController(EmployeeManager employeeManager){
    this.employeeManager=employeeManager;
}

  @GetMapping("")
  Employees getAllEmployee(){
      return employeeManager.getAllEmployees();
  }
  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  void addEmployee(@RequestBody Employee employee){
    employeeManager.addEmployee(employee);
  }
}
