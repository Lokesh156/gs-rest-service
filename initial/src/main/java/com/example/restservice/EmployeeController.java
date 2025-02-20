package com.example.restservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

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

  @GetMapping("/{id}")
  Employee getById(@PathVariable String id){
    Optional<Employee> employee = Optional.ofNullable(employeeManager.getById(id));
if (employee.isEmpty()){
throw new ResponseStatusException(HttpStatus.NOT_FOUND);
}
    return employee.get();
  }

  @PostMapping("")
  @ResponseStatus(HttpStatus.CREATED)
  void addEmployee(@RequestBody Employee employee){
    employeeManager.addEmployee(employee);
  }


 @PutMapping("/{id}")
 @ResponseStatus(HttpStatus.NO_CONTENT)
  void updateEmployee(@PathVariable String id, @RequestBody Employee employee){
    employeeManager.update(id, employee);
 }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void deleteEmployee(@PathVariable String id){
    employeeManager.delete(id);
 }
}
