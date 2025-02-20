package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Employees {
    private List<Employee> employeeList;

    // Get the employee list (initialize if null)
    public List<Employee> getEmployeeList() {
        if (employeeList == null) {
            employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    public Employee getEmployeeById(String id) {
        Optional<Employee> employee = employeeList.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();

        return employee.orElse(null); // Returns null if not found
    }

    void deleteById(String id){
      employeeList.removeIf(e->e.getId().equals(id));
    }

    void update(String id, Employee employee){
        Employee exsisting= getEmployeeById(id);
        if (exsisting!=null){
            int index = employeeList.indexOf(exsisting);
            employeeList.set(index,employee);
        }
        else {
            throw new IllegalArgumentException("Employee is not present in the list"+id);
        }
        //employeeList.set(getEmployeeList().indexOf(getEmployeeById(id)), employee );
    }
}
