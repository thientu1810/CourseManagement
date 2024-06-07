/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.CourseInstructorDAL;
import static DAL.MyDatabaseManager.getConnection;
import Entity.CourseInstructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class CourseInstructorBLL {

    CourseInstructorDAL courseInstructorDAL;

    public CourseInstructorBLL() {
        courseInstructorDAL = new CourseInstructorDAL();
    }

    public ArrayList<CourseInstructor> LoadCourseInstructor() {
        
        ArrayList<CourseInstructor> resultList = courseInstructorDAL.readCourseIntructors();
        return resultList;
    }

    public List findCourseInstructor(String title) {
        List list = new ArrayList();
        list = courseInstructorDAL.findCourseInstructors(title);
        return list;
    }

    public CourseInstructor getCourseInstructor(int courseID, int teacherID) {
        CourseInstructor ci = courseInstructorDAL.getCourseInstructor(courseID, teacherID);
        return ci;
    }

    public int addCourseInstructor(CourseInstructor ci) {
        int result = courseInstructorDAL.insertCourseInstructor(ci);
        return result;
    }
    
    public int updateCourseInstructor(CourseInstructor newci, CourseInstructor oldci) {
        int result = courseInstructorDAL.updateCourseInstructor(newci, oldci);
        return result;
    }
    
    public int deleteCourseInstructor(int courseID, int teacherID) {
        int result = courseInstructorDAL.deleteCourseInstructor(courseID, teacherID);
        return result;
    }
    
    public int countRecordCourseInstructor() {
        int result = courseInstructorDAL.countRecordCourseInstructor();
        return result;
    }
    public String getTitleCourse(int courseID) throws SQLException {
        return courseInstructorDAL.getTitleCourse(courseID);
    }
    public void isBlank(String input) {
        if(input == null || input.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please enter valid information","Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    public boolean isInteger(String input) {
    try {
        Integer.parseInt(input);
         if(input == null || input.isEmpty()){
           JOptionPane.showMessageDialog(null, "Please enter valid information","Message",JOptionPane.ERROR_MESSAGE);
        }
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
    }
}
