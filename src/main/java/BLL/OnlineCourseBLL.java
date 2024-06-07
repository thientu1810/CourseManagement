/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnlineCourseDAL;
import Entity.OnlineCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class OnlineCourseBLL {

    OnlineCourseDAL onlineCourseDAL;

    public OnlineCourseBLL() {
        onlineCourseDAL = new OnlineCourseDAL();
    }

    public ArrayList<OnlineCourse> LoadOnlineCourse() throws SQLException {
        ArrayList list = onlineCourseDAL.readOnlineCourses();
        return list;
    }

    public ArrayList<OnlineCourse> findOnlineCourse(String title) {
        ArrayList<OnlineCourse> list = new ArrayList();
        list = onlineCourseDAL.findOnlineCourse(title);
        return list;
    }

    public OnlineCourse getOnlineCourse(int courseID) throws SQLException {
        OnlineCourse oc = onlineCourseDAL.getOnlineCourse(courseID);
        return oc;
    }

    public int getAutoIncrement() {
        int result = onlineCourseDAL.getAutoIncrement();
        return result;
    }

    public int addOnlineCourse(OnlineCourse oc) {
        int result = onlineCourseDAL.insertOnlineCourse(oc);
        return result;
    }

    public int updateOnlineCourse(OnlineCourse oc) throws SQLException {
        int result = onlineCourseDAL.updateOnlineCourse(oc);
        return result;
    }

    public int deleteOnlineCourse(int onlineCourseID) throws SQLException {
        int result = onlineCourseDAL.deleteOnlineCourse(onlineCourseID);
        return result;
    }

    public int countRecordOnlineCourse() {
        int result = onlineCourseDAL.countRecordOnlineCourse();
        return result;
    }

    public int getMaxIDCourse() {
        int result = onlineCourseDAL.getMaxIDCourse();
        return result;
    }

    public void isBlank(String input) {
        if (input == null || input.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid information", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            if (input == null || input.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter valid information", "Message", JOptionPane.ERROR_MESSAGE);
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
}
