package com.example.restservice;

public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String title;

    // Default constructor
    public Employee() {}

    // Parameterized constructor
    public Employee(String id, String firstName, String lastName, String email, String title) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title=title;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }



    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName +
                ", lastName=" + lastName + ", email=" + email + "title="+title+"]";
    }
}
