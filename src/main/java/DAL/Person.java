/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Date;

/**
 *
 * @author USER
 */
public class Person {
    int personId;
    String lastName, firstName;
    Date hireDate, enrollmentDate;
    
    public Person(){
        
    }
    public Person(String firstName, String lastName, Date hireDate, Date enrollmentDate){
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.enrollmentDate = enrollmentDate;
    }

    public int getPersonId() {
        return personId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
}

