/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

/**
 *
 * @author USER
 */
public class Course {
    int courseId, departmentId;
    String title, credits;
    public Course(){
        
    }
    public Course(int departmentId, String title, String credits){
        this.departmentId = departmentId;
        this.title = title;
        this.credits = credits;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getTitle() {
        return title;
    }

    public String getCredits() {
        return credits;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }
    
}
