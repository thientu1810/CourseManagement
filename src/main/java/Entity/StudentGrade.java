/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class StudentGrade {
    int enrollmentID;
    int courseID;
     int studentID;
     float grade;
    String title;
    String firstName;
    String lastName;
    Date enrollmentDate;

    public StudentGrade() {
    }
    public StudentGrade(int enrollmentID, int courseID,int studentID, float grade){
        this.enrollmentID=enrollmentID;
        this.courseID=courseID;
        this.studentID=studentID;
        this.grade=grade;
    }
    public StudentGrade(int enrollmentID, int courseID,int studentID, float grade,Date enrollmentDate){
        this.enrollmentID=enrollmentID;
        this.courseID=courseID;
        this.studentID=studentID;
        this.grade=grade;
        this.enrollmentDate=enrollmentDate;
    }
    public Date getEnrollmentDate(){
        return enrollmentDate;
    }
    public void setEnrollmentDate(Date enrollmentDate){
        this.enrollmentDate=enrollmentDate;
    }
    public int getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(int enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    
    
}
