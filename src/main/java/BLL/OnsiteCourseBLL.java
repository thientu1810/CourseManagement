/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.OnsiteCourseDAL;
import Entity.OnsiteCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class OnsiteCourseBLL {

    OnsiteCourseDAL onsiteCourseDAL;

    public OnsiteCourseBLL() {
        onsiteCourseDAL = new OnsiteCourseDAL();
    }

    public ArrayList<OnsiteCourse> LoadOnsiteCourse() throws SQLException  {
         ArrayList list = onsiteCourseDAL.readOnsiteCourses();
        return list;
    }

     public ArrayList<OnsiteCourse> findOnsiteCourse(String title) {
       ArrayList<OnsiteCourse> list = new ArrayList();
        list = onsiteCourseDAL.findOnsiteCourse(title);
        return list;
    }
     public int getAutoIncrement(){
        int result = onsiteCourseDAL.getAutoIncrement();
        return result;
    }

    public OnsiteCourse getOnsiteCourse(int courseID) {
        OnsiteCourse oc = onsiteCourseDAL.getOnsiteCourse(courseID);
        return oc;
    }

    public int addOnsiteCourse(OnsiteCourse oc) {
        int result = onsiteCourseDAL.insertOnsiteCourse(oc);
        return result;
    }
    
    public int updateOnsiteCourse(OnsiteCourse oc) throws SQLException{
        int result = onsiteCourseDAL.updateOnsiteCourse(oc);
        return result;
    }
    
    public int deleteOnsiteCourse(int onsiteCourseID) {
        int result = onsiteCourseDAL.deleteOnsiteCourse(onsiteCourseID);
        return result;
    }
    
    public int countRecordOnsiteCourse() {
        int result = onsiteCourseDAL.countRecordOnsiteCourse();
        return result;
    }
    
    public int getMaxIDCourse() {
        int result = onsiteCourseDAL.getMaxIDCourse();
        return result;
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
