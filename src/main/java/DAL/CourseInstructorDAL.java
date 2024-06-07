/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.CourseInstructor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class CourseInstructorDAL extends MyDatabaseManager {

    public CourseInstructorDAL() {
        CourseInstructorDAL.connectDB();
    }

   public ArrayList<CourseInstructor> readCourseIntructors() {
        ArrayList list = new ArrayList();
        try {
            String query = "select ci.CourseID, ci.PersonID, c.Title, p.FirstName, p.LastName\n"
                    + "from courseinstructor as ci join course as c\n"
                    + "on ci.CourseID = c.CourseID join person as p\n"
                    + "on ci.PersonID = p.PersonID and p.HireDate > 0;";
            ResultSet rs = doReadQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    CourseInstructor ci = new CourseInstructor();
                    ci.setCourseID(rs.getInt("CourseID"));
                    ci.setFirstName(rs.getString("FirstName"));
                    ci.setLastName(rs.getString("LastName"));
                    ci.setTeacherID(rs.getInt("PersonID"));
                    ci.setTitleCourse(rs.getString("Title"));
                    list.add(ci);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public CourseInstructor getCourseInstructor(int courseID, int personID) {
       
        CourseInstructor ci = new CourseInstructor();

        try {
            String query = "select ci.CourseID, ci.PersonID, c.Title, p.FirstName, p.LastName\n"
                    + "from CourseInstructor ci join course c\n"
                    + "on ci.CourseID = c.CourseID join person p\n"
                    + "on ci.PersonID = p.PersonID and p.HireDate > 0\n"
                    + "where ci.PersonID = ? and ci.CourseID = ?;";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, personID);
            p.setInt(2, courseID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    ci.setCourseID(rs.getInt("CourseID"));
                    ci.setFirstName(rs.getString("FirstName"));
                    ci.setLastName(rs.getString("LastName"));
                    ci.setTeacherID(rs.getInt("PersonID"));
                    ci.setTitleCourse(rs.getString("Title"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ci;

    }

    public int updateCourseInstructor(CourseInstructor newci, CourseInstructor oldci) {
        connectDB();
        int result = 0;
        try {
            String query = "update CourseInstructor set CourseID = ?, PersonID = ?\n"
                    + "where CourseID = ? and PersonID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, newci.getCourseID());
            p.setInt(2, newci.getTeacherID());
            p.setInt(3, oldci.getCourseID());
            p.setInt(4, oldci.getTeacherID());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public int insertCourseInstructor(CourseInstructor ci) {
        connectDB();
        int result = 0;

        try {
            String query = "insert CourseInstructor(CourseID, PersonID) values (?, ?);";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, ci.getCourseID());
            p.setInt(2, ci.getTeacherID());
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return result;
    }

    public ArrayList<CourseInstructor> findCourseInstructors(String title) {
        connectDB();
        ArrayList list = new ArrayList();

        try {
            String query = "select ci.CourseID, ci.PersonID, c.Title, p.FirstName, p.LastName\n"
                    + "from CourseInstructor ci join course c\n"
                    + "on ci.CourseID = c.CourseID join person p\n"
                    + "on ci.PersonID = p.PersonID and p.HireDate > 0\n"
                    + "where c.Title like ? or p.FirstName like ? or p.LastName like ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, "%" + title + "%");
            p.setString(2, "%" + title + "%");
            p.setString(3, "%" + title + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    CourseInstructor ci = new CourseInstructor();
                    ci.setCourseID(rs.getInt("CourseID"));
                    ci.setFirstName(rs.getString("FirstName"));
                    ci.setLastName(rs.getString("LastName"));
                    ci.setTeacherID(rs.getInt("PersonID"));
                    ci.setTitleCourse(rs.getString("Title"));
                    list.add(ci);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public int deleteCourseInstructor(int courseID, int personID) {
        connectDB();
        int result = 0;

        try {
            String query = "DELETE FROM CourseInstructor WHERE CourseID = ? and PersonID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, courseID);
            p.setInt(2, personID);
            result = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public int countRecordCourseInstructor() {
        connectDB();
        int result = 0;

        try {
            String query = "select count(*) as count from CourseInstructor;";
            PreparedStatement p = getConnection().prepareStatement(query);
            ResultSet rs = p.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }

        return result;
    }

    public String getTitleCourse(int courseID) throws SQLException {
        String s = null;
        String query = "select *\n"
                    + "from course \n"
                    + "where CourseID = ?;";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, courseID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    s = rs.getString("Title");
                }
            }
        return s;
    }

}
