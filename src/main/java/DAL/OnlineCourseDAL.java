
package DAL;

import Entity.OnlineCourse;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OnlineCourseDAL extends MyDatabaseManager {

    public OnlineCourseDAL() {
        OnlineCourseDAL.connectDB();
    }

    public ArrayList<OnlineCourse> readOnlineCourses() throws SQLException  {
        
        ArrayList list = new ArrayList();
            String query = "select *\n"
                    + "from course c join onlinecourse oc\n"
                    + "on c.CourseID = oc.CourseID join department d\n"
                    + "on c.DepartmentID = d.DepartmentID;";
            ResultSet rs = doReadQuery(query);

            if (rs != null) {
                while (rs.next()) {
                    OnlineCourse oc = new OnlineCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setTitle(rs.getString("Title"));
                    oc.setCredits(rs.getInt("Credits"));
                    oc.setUrl(rs.getString("url"));
                    oc.setDepartmentID(rs.getInt("DepartmentID"));
                    list.add(oc);
                }
            }
        return list;
    }

    public OnlineCourse getOnlineCourse(int courseID) throws SQLException{
        OnlineCourse oc = new OnlineCourse();
            String query = "select *\n"
                    + "from course c join onlinecourse oc\n"
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
                    oc.setUrl(rs.getString("url"));
                    oc.setDepartmentID(rs.getInt("DepartmentID"));
                }
            }
        return oc;

    }

    public int updateOnlineCourse(OnlineCourse oc)  throws SQLException {
            String query = "update course c, onlineCourse oc, department d\n"
                    + "set c.Title = ?,\n"
                    + "	c.Credits = ?,\n"
                    + "    c.DepartmentID = ?,\n"
                    + "    oc.url = ?\n"
                    + "where c.CourseID = oc.CourseID\n"
                    + "	and c.DepartmentID = d.DepartmentID\n"
                    + "    and oc.CourseID = ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, oc.getTitle());
            p.setInt(2, oc.getCredits());
            p.setInt(3, oc.getDepartmentID());
            p.setString(4, oc.getUrl());
            p.setInt(5, oc.getCourseID());
            int result = p.executeUpdate();
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

    public int insertOnlineCourse(OnlineCourse oc) {
        int result = 0;

        try {
            String query1 = "INSERT INTO course (CourseID, Title, Credits, DepartmentID) VALUES(?, ?, ?,?);";
            PreparedStatement p1 = getConnection().prepareStatement(query1);
            p1.setInt(1, oc.getCourseID());
            p1.setString(2, oc.getTitle());
            p1.setInt(3, oc.getCredits());
            p1.setInt(4, oc.getDepartmentID());
            result = p1.executeUpdate();
            
            String query2 = "INSERT INTO onlineCourse (CourseID, url) VALUES(?,?);";
            PreparedStatement p2 = getConnection().prepareStatement(query2);
            p2.setInt(1, oc.getCourseID());
            p2.setString(2, oc.getUrl());
            result = p2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<OnlineCourse> findOnlineCourse(String title) {
        ArrayList list = new ArrayList();

        try {
            String query = "select *\n"
                    + "from course c join onlinecourse oc\n"
                    + "on c.CourseID = oc.CourseID join department d\n"
                    + "on c.DepartmentID = d.DepartmentID\n"
                    + "where c.title like ?;";
            PreparedStatement p = getConnection().prepareStatement(query);
            p.setString(1, "%" + title + "%");
            ResultSet rs = p.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    OnlineCourse oc = new OnlineCourse();
                    oc.setCourseID(rs.getInt("CourseID"));
                    oc.setTitle(rs.getString("Title"));
                    oc.setCredits(rs.getInt("Credits"));
                    oc.setUrl(rs.getString("url"));
                    oc.setDepartmentID(rs.getInt("DepartmentID"));
                    list.add(oc);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return list;
    }

    public int deleteOnlineCourse(int courseID) throws SQLException {
        int result = 0;
            String query1 = "delete from onlinecourse where CourseID = ?;";
            PreparedStatement p1 = getConnection().prepareStatement(query1);
            p1.setInt(1, courseID);
            result = p1.executeUpdate();
            
            String query2 = "delete from course where CourseID = ?;";
            PreparedStatement p2 = getConnection().prepareStatement(query2);
            p2.setInt(1, courseID);
            result = p2.executeUpdate();
        return result;
    }

    public int countRecordOnlineCourse() {
        int result = 0;

        try {
            String query = "select count(*) as count from OnlineCourse;";
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
