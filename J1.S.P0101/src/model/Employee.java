/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.regex.Pattern;

/**
 *
 * @author ngoba
 */
public class Employee {
    String iD, firstName, lastName, phone, email,address, dOB;
    Sex sex;
    double salary;

    public Employee(String iD, String firstName, String lastName, String phone, String email, String address, String dOB, Sex sex, double salary) {
        this.iD = iD;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dOB = dOB;
        this.sex = sex;
        this.salary = salary;
    }
    private static final Pattern ID_PATTERN = Pattern.compile();
}
