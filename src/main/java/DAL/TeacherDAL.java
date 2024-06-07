/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ankho
 */
public class TeacherDAL extends MyDatabaseManager {
    public TeacherDAL() {
        TeacherDAL.connectDB();
    }
     public ArrayList<Teacher> readTeacher() throws SQLException {
        String query = "Select * From person Where HireDate > 0";
        ResultSet rs = TeacherDAL.doReadQuery(query);
        ArrayList list = new ArrayList();
        if(rs != null) {
            while(rs.next()) {
                Teacher t = new Teacher();
                t.setPersonId(rs.getInt("PersonID"));
                t.setFirstName(rs.getString("FirstName"));
                t.setLastName(rs.getString("LastName"));
                t.setHireDate(rs.getDate("HireDate"));
                list.add(t);
            }
        }
        return list;
    }
     
      public Teacher getTeacher(int personId) throws SQLException {
        String query = "Select * From person Where PersonID = ? And HireDate > 0";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
         p.setInt(1, personId);
        ResultSet rs = p.executeQuery();
        Teacher t  = new Teacher();
        if(rs != null) {
            while(rs.next()) {
                t.setPersonId(rs.getInt("PersonID"));
                t.setFirstName(rs.getString("FirstName"));
                t.setLastName(rs.getString("LastName"));
                t.setHireDate(rs.getDate("HireDate"));
            }
        }
        return t;
    }
      
       public int insertTeacher (Teacher tc) throws SQLException {
         String query = "Insert person(FirstName, LastName, HireDate) Values (?,?,?)";
         PreparedStatement  p = TeacherDAL.getConnection().prepareStatement(query);
         p.setString(1, tc.getFirstName());
         p.setString(2, tc.getLastName());
         p.setString(3, tc.getHireDate().toString());
         int result = p.executeUpdate();
         return result;
     }
       public int updateTeacher(Teacher t ) throws SQLException {
          String query = "Update person SET FirstName = ? , LastName = ? "
                    + " WHERE PersonID = ?";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, t.getFirstName());
            p.setString(2, t.getLastName());
            p.setInt(3, t.getPersonId());
            int result = p.executeUpdate();
        return result;
     }
       public int deleteTeacher(int personID) throws SQLException {
         String query = "DELETE FROM person WHERE PersonID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        return result;
    }
        public ArrayList<Teacher> findTeachers(String fullName) throws SQLException {
        String query = "SELECT * FROM Person WHERE HireDate > 0 AND concat(FirstName, ' ', LastName)  LIKE ?";
        PreparedStatement p = TeacherDAL.getConnection().prepareStatement(query);
        p.setString(1, "%" + fullName + "%");
        ResultSet rs = p.executeQuery();
        ArrayList<Teacher> list = new ArrayList();

        if (rs != null) {
            while (rs.next()) {
                Teacher tc = new Teacher();
                tc.setPersonId(rs.getInt("PersonID"));
                tc.setFirstName(rs.getString("FirstName"));
                tc.setLastName(rs.getString("LastName"));
                list.add(tc);
            }
        }
        return list;
    }
}
