/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.StudentDAL;
import Entity.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ankho
 */
public class StudentBLL {
    StudentDAL stDal;
    public StudentBLL () {
        stDal = new StudentDAL();
    }
    public ArrayList<Student> LoadStudent() throws SQLException {
        ArrayList list = stDal.readStudent();
        return list;
    }
    
    public Student GetStudent(int studentId) throws SQLException {
        return stDal.getStudent(studentId);
    }
    
     public int addStudent(Student s) throws SQLException {
        int result = stDal.insertStudent(s);
        return result;
    }
     public int updateStudent(Student s) throws SQLException {
        int result = stDal.updateStudent(s);
        return result;
    }
    
    public int deleteStudent(int studentID) throws SQLException {
        int result = stDal.deleteStudent(studentID);
        return result;
    }
    
    public ArrayList<Student> findStudent(String fullname) throws SQLException {
        ArrayList<Student> list = new ArrayList();
        list = stDal.findStudents(fullname);
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
