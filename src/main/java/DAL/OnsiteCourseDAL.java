/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Entity.OnsiteCourse;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 */
public class OnsiteCourseDAL extends MyDatabaseManager {

    public OnsiteCourseDAL() {
        OnsiteCourseDAL.connectDB();
    }

    public ArrayList<OnsiteCourse> readOnsiteCourses() throws SQLException {
        ArrayList list = new ArrayList();
            String query = "select *\n"
                    + "from course c join onsitecourse oc\n"
                    + "on c.CourseID = oc.CourseID join department d\n"
                    + "on c.DepartmentID = d.DepartmentID";
            ResultSet rs = doReadQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    OnsiteCourse oc = new OnsiteCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setTitle(rs.getString("Title"));
                    oc.setCredits(rs.getInt("Credits"));
                    oc.setLocation(rs.getString("Location"));
                    oc.setDays(rs.getString("Days"));
                    oc.setTime(rs.getString("Time"));
                    oc.setDepartmentID(rs.getInt("DepartmentID"));
                    list.add(oc);
                }
            }
        
        return list;
    }

    public OnsiteCourse getOnsiteCourse(int courseID) {
        OnsiteCourse oc = new OnsiteCourse();

        try {
            String query = "select *\n"
                    + "from course c join onsitecourse oc\n"
                    + "on c.CourseID = oc.CourseID join department d\n"
                    + "on c.DepartmentID = d.DepartmentID\n"
                    + "where oc.CourseID = ?;";

            PreparedStatement p = getConnection().prepareStatement(query);
            p.setInt(1, courseID);
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setTitle(rs.getString("Title"));
                    oc.setCredits(rs.getInt("Credits"));
                    oc.setLocation(rs.getString("Location"));
                    oc.setDays(rs.getString("Days"));
                    oc.setTime(rs.getString("Time"));
                    oc.setDepartmentID(rs.getInt("DepartmentID"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oc;

    }

    public int updateOnsiteCourse(OnsiteCourse oc) throws SQLException {
        String query = "UPDATE course SET Title = ?, Credits = ?, DepartmentID = ? WHERE CourseID = ?";
        PreparedStatement p1 = getConnection().prepareStatement(query);
        p1.setString(1, oc.getTitle());
        p1.setInt(2, oc.getCredits());
        p1.setInt(3, oc.getDepartmentID());
        p1.setInt(4, oc.getCourseID());
        int result = p1.executeUpdate();

        String query1 = "UPDATE onsitecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
        PreparedStatement p2 = getConnection().prepareStatement(query1);
        p2.setString(1, oc.getLocation());
        p2.setString(2, oc.getDays());
        p2.setString(3, oc.getTime());
        p2.setInt(4, oc.getCourseID());
        result = p2.executeUpdate();
        
        return result;
    }
    public int getAutoIncrement() {
    int result = -1;
    try {
        String query = "SELECT CourseID from course";
        PreparedStatement ps = getConnection().prepareStatement(query);
        ResultSet resultSet = ps.executeQuery();
        if (!resultSet.next()) {
            System.out.println("No data");
        } else {
            do {
                result = resultSet.getInt(1); 
            } while (resultSet.next());
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result + 1;
}
    public int insertOnsiteCourse(OnsiteCourse oc) {
        int result = 0;

        try {
            String query1 = "INSERT INTO course (CourseID ,Title, Credits, DepartmentID) VALUES(?, ?, ?, ?);";
            PreparedStatement p1 = getConnection().prepareStatement(query1);
            p1.setInt(1, oc.getCourseID());
            p1.setString(2, oc.getTitle());
            p1.setInt(3, oc.getCredits());
            p1.setInt(4, oc.getDepartmentID());
            result = p1.executeUpdate();

            String query2 = "INSERT INTO onsiteCourse (CourseID ,Location, Days, Time) VALUES(?,?,?,?);";
            PreparedStatement p2 = getConnection().prepareStatement(query2);
            p2.setInt(1, oc.getCourseID());
            p2.setString(2, oc.getLocation());
            p2.setString(3, oc.getDays());
            p2.setString(4, oc.getTime());
            result = p2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<OnsiteCourse> findOnsiteCourse(String title) {
        ArrayList list = new ArrayList();

        try {
            String query = "select *\n"
                    + "from course c join onsitecourse oc\n"
                    + "on c.CourseID = oc.CourseID join department d\n"
                    + "on c.DepartmentID = d.DepartmentID\n"
                    + "where c.title like ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, "%" + title + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    OnsiteCourse oc = new OnsiteCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setTitle(rs.getString("Title"));
                    oc.setCredits(rs.getInt("Credits"));
                    oc.setLocation(rs.getString("Location"));
                    oc.setDays(rs.getString("Days"));
                    oc.setTime(rs.getString("Time"));
                    oc.setDepartmentID(rs.getInt("DepartmentID"));
                    list.add(oc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public int deleteOnsiteCourse(int courseID) {
        int result = 0;

        try {
            String query1 = "delete from onsiteCourse where CourseID = ?;";
            PreparedStatement p1 = getConnection().prepareStatement(query1);
            p1.setInt(1, courseID);
            result = p1.executeUpdate();

            String query2 = "delete from course where CourseID = ?;";
            PreparedStatement p2 = getConnection().prepareStatement(query2);
            p2.setInt(1, courseID);
            result = p2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public int countRecordOnsiteCourse() {
        int result = 0;

        try {
            String query = "select count(*) as count from OnsiteCourse;";
            PreparedStatement p = getConnection().prepareStatement(query);
            ResultSet rs = p.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int getMaxIDCourse() {
        int result = 0;

        try {
            String query = "SELECT CourseID as id FROM course ORDER BY CourseID DESC LIMIT 0, 1";
            PreparedStatement p = getConnection().prepareStatement(query);
            ResultSet rs = p.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    result = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
