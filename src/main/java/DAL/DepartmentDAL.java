/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDAL extends MyDatabaseManager {

    public DepartmentDAL() {
        StudentDAL.connectDB();
    }

    public ArrayList<Department> readDepartments() {
        ArrayList list = new ArrayList();
        try {
            String query = "select * from department";
            ResultSet rs = doReadQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    Department d = new Department();
                    d.setDepartmentID(rs.getInt("DepartmentID"));
                    d.setName(rs.getString("Name"));
                    d.setBudget(rs.getInt("Budget"));
                    d.setStartDate(rs.getDate("StartDate"));
                    d.setAdministrator(rs.getString("Administrator"));
                    list.add(d);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Department getDepartment(int departmentID) {
        Department d = new Department();

        try {
            String query = "select * from department where DepartmentID = ?";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, departmentID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    d.setDepartmentID(rs.getInt("DepartmentID"));
                    d.setName(rs.getString("Name"));
                    d.setBudget(rs.getInt("Budget"));
                    d.setStartDate(rs.getDate("StartDate"));
                    d.setAdministrator(rs.getString("Administrator"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;

    }
    public Department getDepartmentName() {
        Department d = new Department();

        try {
            String query = "select Name from department";

            PreparedStatement p = getConnection().prepareStatement(query);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    d.setName(rs.getString("Name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;

    }
    public int deleteDepartment(int departmentID) throws SQLException {
        int result = 0;
            String query1 = "delete from department where DepartmentID = ?;";
            PreparedStatement p1 = getConnection().prepareStatement(query1);
            p1.setInt(1, departmentID);
            result = p1.executeUpdate();

        return result;
    }
    public ArrayList<Department> findDepartment(String name) throws SQLException {
        Department d = new Department();
            String query = "select * from department where Name = ?";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, name);
            ResultSet rs = p.executeQuery();
            ArrayList<Department> list = new ArrayList();

            if (rs != null) {
                while (rs.next()) {
                    d.setDepartmentID(rs.getInt("DepartmentID"));
                    d.setName(rs.getString("Name"));
                    d.setBudget(rs.getInt("Budget"));
                    d.setStartDate(rs.getDate("StartDate"));
                    d.setAdministrator(rs.getString("Administrator"));
                    list.add(d);
                }
            }

        return list;
    }
      public int insertDepartment (Department de) throws SQLException {
         String query = "Insert department(Name, Budget, Administrator,StartDate) Values (?,?,?,?)";
         PreparedStatement  p = getConnection().prepareStatement(query);
         p.setString(1, de.getName());
         p.setInt(2, de.getBudget());
         p.setString(3, de.getAdministrator());
         p.setString(4, de.getStartDate().toString());
         int result = p.executeUpdate();
         return result;
     }
      public int updateDepartment(Department de)  throws SQLException {
            String query = "Update department SET Name = ? , Budget = ?, Administrator = ?, StartDate =? "
                    + " WHERE DepartmentID = ?";
            PreparedStatement p = getConnection().prepareStatement(query);
             p.setString(1, de.getName());
         p.setLong(2, de.getBudget());
         p.setString(3, de.getAdministrator());
         p.setString(4, de.getStartDate().toString());
         p.setInt(5, de.getDepartmentID());
         int result = p.executeUpdate();
        return result;
    }
}
