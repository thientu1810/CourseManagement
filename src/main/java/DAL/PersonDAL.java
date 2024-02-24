/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ankho
 */
public class PersonDAL extends MyDatabaseManager {
    public PersonDAL() {
        PersonDAL.connectDB();
    }
    
    public ArrayList readPerson() throws SQLException {
        String query = "Select * From person Where EnrollmentDate > 0 Or HireDate > 0";
        ResultSet rs = PersonDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                Person p = new Person();
                p.setPersonId(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                p.setHireDate(rs.getDate("HireDate"));
                list.add(p);
            }
        }
        return list;
    }
    
    
    public ArrayList readStudent() throws SQLException {
         String query = "Select * From person Where EnrollmentDate > 0 And HireDate < 0";
        ResultSet rs = PersonDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                Person p = new Person();
                p.setPersonId(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                p.setHireDate(rs.getDate("HireDate"));
                list.add(p);
            }
        }
        return list;
    }
    public ArrayList readTeacher() throws SQLException {
        String query = "Select * From person Where EnrollmentDate < 0 And HireDate > 0";
        ResultSet rs = PersonDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                Person p = new Person();
                p.setPersonId(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                p.setHireDate(rs.getDate("HireDate"));
                list.add(p);
            }
        }
        return list;
    }
    
     public Person getPerson(int personId) throws SQLException {
        String query = "Select * From person Where PersonID = ? And EnrollmentDate > 0 Or HireDate > 0";
        PreparedStatement ps = PersonDAL.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Person p  = new Person();
        if(rs != null) {
            while(rs.next()) {
                p.setPersonId(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                p.setHireDate(rs.getDate("HireDate"));
            }
        }
        return p;
    }
    
     public Person getStudent(int personId) throws SQLException {
        String query = "Select * From person Where PersonID = ? And EnrollmentDate > 0 And HireDate < 0";
        PreparedStatement ps = PersonDAL.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Person p  = new Person();
        if(rs != null) {
            while(rs.next()) {
                p.setPersonId(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                p.setHireDate(rs.getDate("HireDate"));
            }
        }
        return p;
    }
     
     public Person getTeacher(int personId) throws SQLException {
        String query = "Select * From person Where PersonID = ? And EnrollmentDate < 0 And HireDate > 0";
        PreparedStatement ps = PersonDAL.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        Person p  = new Person();
        if(rs != null) {
            while(rs.next()) {
                p.setPersonId(rs.getInt("PersonID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                p.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                p.setHireDate(rs.getDate("HireDate"));
            }
        }
        return p;
    }
     
     public int insertPerson (Person p) throws SQLException {
         String query = "Insert person(FirstName, LastName, HireDate, EnrollmentDate) Values (?,?,?,?)";
         PreparedStatement  ps = PersonDAL.getConnection().prepareStatement(query);
         ps.setString(1, p.getFirstName());
         ps.setString(2, p.getLastName());
         ps.setString(3, p.getHireDate().toString());
         ps.setString(4, p.getEnrollmentDate().toString());
         int result = ps.executeUpdate();
         return result;
     }
     
     public int updatePerson(Person p ) throws SQLException {
          String query = "Update person SET FirstName = ? , LastName = ? "
                + " WHERE PersonID = ?";
          PreparedStatement ps = PersonDAL.getConnection().prepareStatement(query);
          ps.setString(1, p.getFirstName());
          ps.setString(2, p.getLastName());
          ps.setInt(3, p.getPersonId());
         int result = ps.executeUpdate();
         return result;
     }
     
}
