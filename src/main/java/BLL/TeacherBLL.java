/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.TeacherDAL;
import Entity.Student;
import Entity.Teacher;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ankho
 */
public class TeacherBLL {
    TeacherDAL tcDal;
    public TeacherBLL () {
        tcDal = new TeacherDAL();
    }
    public ArrayList<Teacher> LoadTeacher() throws SQLException {
        ArrayList list = tcDal.readTeacher();
        return list;
    }
    
    public Teacher GetTeacher(int teacherId) throws SQLException {
        return tcDal.getTeacher(teacherId);
    }
    
     public int addTeacher(Teacher tc) throws SQLException {
        int result = tcDal.insertTeacher(tc);
        return result;
    }
     public int updateTeacher(Teacher tc) throws SQLException {
        int result = tcDal.updateTeacher(tc);
        return result;
    }
    
    public int deleteTeacher(int teacherId) throws SQLException {
        int result = tcDal.deleteTeacher(teacherId);
        return result;
    }
    
    public ArrayList<Teacher> findTeacher(String fullname) throws SQLException {
        ArrayList<Teacher> list = new ArrayList();
        list = tcDal.findTeachers(fullname);
        return list;
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
