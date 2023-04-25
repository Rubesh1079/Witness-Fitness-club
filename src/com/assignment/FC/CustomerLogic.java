package com.assignment.FC;

public class CustomerLogic {
    private String name;
    private String email;

    public CustomerLogic(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void viewCustomer(){
        System.out.println("Username is "+ name +" and email is "+ email);
    }
}


