/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ankho
 */
public class StudentDAL extends MyDatabaseManager {
    public StudentDAL() {
        StudentDAL.connectDB();
    }
    public ArrayList<Student> readStudent() throws SQLException {
        String query = "Select * From person Where EnrollmentDate > 0";
        ResultSet rs =  StudentDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(rs.getDate("EnrollmentDate"));
                list.add(s);
            }
        }
        return list;
    }
    public Student getStudent(int studentId) throws SQLException {
        String query = "Select * From person Where PersonID = ? And EnrollmentDate > 0";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, studentId);
        ResultSet rs = p.executeQuery();
        Student s  = new Student();
        if(rs != null) {
            while(rs.next()) {
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEnrollmentDate(rs.getDate("EnrollmentDate"));
            }
        }
        return s;
    }
    
    public int insertStudent (Student s) throws SQLException {
         String query = "Insert person(FirstName, LastName, EnrollmentDate) Values (?,?,?)";
         PreparedStatement  p =  StudentDAL.getConnection().prepareStatement(query);
         p.setString(1, s.getFirstName());
         p.setString(2, s.getLastName());
         p.setString(3, s.getEnrollmentDate().toString());
         int result = p.executeUpdate();
         return result;
     }
    
    public int updateStudent(Student s ) throws SQLException {
          String query = "Update person SET FirstName = ? , LastName = ? "
                    + " WHERE PersonID = ?";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, s.getFirstName());
            p.setString(2, s.getLastName());
            p.setInt(3, s.getPersonId());
            int result = p.executeUpdate();
        return result;
     }
    public int deleteStudent(int personID) throws SQLException {
         String query = "DELETE FROM person WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        return result;
    }
    
    public ArrayList<Student> findStudents(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE EnrollmentDate > 0 AND concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        ArrayList<Student> list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Student s = new Student();
                s.setPersonId(rs.getInt("PersonID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                list.add(s);
            }
        }
        return list;
    }
}
