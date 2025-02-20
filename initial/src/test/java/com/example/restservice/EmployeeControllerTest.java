package com.example.restservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    EmployeeManager employeeManager;

    @Test
    void testGetEmployeesEndpoint() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(status().isOk());
    }

    @Test
    void testGetEmployeeNotFound() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/999")).andExpect(status().isNotFound());
    }

    @Test
    void testDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/employees/1")).andExpect(status().isNoContent());
    }

    @Test
    void testGetEmployeeById() throws Exception{
        Employee employee = new Employee("1","Lokesh", "Pallikonda","lp@mail.com","Klo");
        when(employeeManager.getById("1")).thenReturn(employee);
        mockMvc.perform(MockMvcRequestBuilders.get("/employees/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Lokesh"))
                .andExpect(jsonPath("$.lastName").value("Pallikonda"));
    }
//    @Test
//    void testAddEmployee() throws Exception {
//        Employee newEmployee = new Employee("3", "Alice", "Smith", "alice.smith@example.com", "Designer");
//
//        doNothing().when(employeeManager).addEmployee(newEmployee);
//
//        mockMvc.perform(post("/employees")
//                        .contentType("application/json")
//                        .content(new ObjectMapper().writeValueAsString(newEmployee)))
//                .andExpect(status().isCreated())
//                .andExpect(jsonPath("$.firstName").value("Alice"))
//                .andExpect(jsonPath("$.email").value("alice.smith@example.com"));
//    }

//    @Test
//    void testUpdateEmployee() throws Exception{
//        Employee employee = new Employee("1","Lokesh", "Pallikonda","lp@mail.com","KloKl");
//        when(employeeManager.getById("1")).thenReturn(employee);
//        doNothing().when(employeeManager).update("1",employee);
//        mockMvc.perform(MockMvcRequestBuilders.put("/employees/1"))
//                .contentType("application/json")
//                .content(new ObjectMapper().writeValueAsString(employee))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").value("KloKl"));
//    }

}