/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DepartmentDAL;
import Entity.Department;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DepartmentBLL {

    DepartmentDAL departmentDAL;

    public DepartmentBLL() {
        departmentDAL = new DepartmentDAL();
    }

    public ArrayList<Department> LoadDepartments() {
        ArrayList list = departmentDAL.readDepartments();;
        return list;
    }
    public int deleteDepartment(int departmentID) throws SQLException{
        int result = departmentDAL.deleteDepartment(departmentID);
                return result;
    }
    public ArrayList<Department> findDepartment(String name) throws SQLException {
        ArrayList<Department> list = departmentDAL.findDepartment(name);
        return list;
    }

    public Department getDepartment(int departmentID) {
        Department d = departmentDAL.getDepartment(departmentID);
        return d;
    }
     public int addDepartment(Department de) throws SQLException {
        int result = departmentDAL.insertDepartment(de);
        return result;
    }
     public int updateDepartment(Department de) throws SQLException {
        int result = departmentDAL.updateDepartment(de);
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
