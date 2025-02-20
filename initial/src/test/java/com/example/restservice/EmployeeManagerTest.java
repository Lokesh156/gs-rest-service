package com.example.restservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {
    EmployeeManager employeeManager;
    @Test
    void shouldTestAddEmployee() {
        employeeManager =  new EmployeeManager();
        Employee employee = new Employee("5", "Lokesh", "Pallikonda", "lp@kmail.com", "Gh");
       employeeManager.addEmployee(employee);

     assertEquals(employeeManager.getById("5"),employee);

    }

    @Test
    void shouldUpdateRun(){
        employeeManager = new EmployeeManager();
        Employee employee = new Employee("2","Naveena","Singam","sn@gmail.com","Lead");
      employeeManager.update("2",employee);
      var emp=employeeManager.getById("2");
      assertEquals("Naveena", emp.getFirstName());
    }

    @Test
    void shouldDelete(){
        employeeManager = new EmployeeManager();
        employeeManager.delete("1");
        assertNull(employeeManager.getById("1"));
    }

}