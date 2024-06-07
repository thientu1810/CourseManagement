/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;
import static DAL.MyDatabaseManager.getConnection;
import Entity.StudentGrade;
import Entity.Student;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import static java.sql.Types.NULL;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class StudentGradeDAL extends MyDatabaseManager{
    public StudentGradeDAL(){
        StudentGradeDAL.connectDB();
    }
    public String showName(int StudentID) throws SQLException {
        String query = "SELECT p.FirstName, p.LastName FROM person p WHERE p.personid=?";
        PreparedStatement sg = StudentGradeDAL.getConnection().prepareStatement(query);
        sg.setInt(1, StudentID);
        ResultSet rs = sg.executeQuery();
        String fullName = null;
        if (rs.next()) {
            String ho = rs.getString("LastName");
            String ten = rs.getString("FirstName");
            fullName = ho + " " + ten;
        }
        return fullName;
    }
    
   public ArrayList<String> showComboBox(String cb1) throws SQLException {
    String query = "SELECT a.CourseID, c.Title FROM course c JOIN " + cb1 + " a ON c.CourseID = a.CourseID";
    try (PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query)) {
        ResultSet rs = p.executeQuery();
        
        ArrayList<String> list = new ArrayList<>();
        
        while (rs.next()) {
            int courseID = rs.getInt("CourseID");
            String title = rs.getString("Title");
            String concatenated = courseID + "_" + title;
            list.add(concatenated);
        }
        
        return list;
    }
}
   
   public int count5(int CourseID)throws SQLException{
       String query="SELECT COUNT(*) AS count FROM StudentGrade s Join person p On s.StudentID=p.PersonID WHERE s.Grade >=5 AND s.CourseID= ? AND p.EnrollmentDate >0";
       PreparedStatement ps = StudentGradeDAL.getConnection().prepareStatement(query);
    ps.setInt(1, CourseID);
    ResultSet rs = ps.executeQuery();
    rs.next();
    int count = rs.getInt("count");
    return count;
} 
    public int countNullGrade(int CourseID) throws SQLException {
    String query = "SELECT COUNT(*) AS count FROM StudentGrade s Join person p On s.StudentID=p.PersonID WHERE s.Grade IS NULL AND s.CourseID= ? AND p.EnrollmentDate >0";
    PreparedStatement ps = StudentGradeDAL.getConnection().prepareStatement(query);
    ps.setInt(1, CourseID);
    ResultSet rs = ps.executeQuery();
    rs.next();
    int count = rs.getInt("count");
    return count;
}
/*
    public ArrayList<StudentGrade> readstudentCourse(int StudentID) throws SQLException{
        String query="SELECT c.title,p.FirstName, p.EnrollmentDate, sg.Grade FROM studentGrade sg JOIN person p ON sg.StudentID=p.PersonID JOIN course c ON sg.CourseID=c.CourseID WHERE sg.StudentID= ?";
        PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, StudentID);
        ResultSet rs = p.executeQuery();
        ArrayList<StudentGrade> list = new ArrayList<>();

        if(rs !=null){
            while (rs.next()) {
                StudentGrade sg = new StudentGrade();
                sg.setTitle(rs.getString("Title"));
                sg.setFirstName(rs.getString("FirstName"));
                sg.setEnrollmentDate(rs.getDate("enrollmentDate"));
                sg.setGrade(rs.getFloat("Grade"));
                
                list.add(sg);
            }
        }
        return list;
    }*/
   public ArrayList<StudentGrade> courses(int CourseID)throws SQLException{
       String query="Select s.EnrollmentID,s.Grade,c.Titile,p.FirstName,p.LastName From studentgrade s Join person p On s.StudentID=p.PersonID Join course c On s.CourseID=c.CourseID Where CourseID= ? ";
       PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, CourseID);
        ResultSet rs = p.executeQuery();
        ArrayList<StudentGrade> list = new ArrayList<>();

   if(rs !=null){
        while (rs.next()) {
            StudentGrade sg = new StudentGrade();
            sg.setEnrollmentID(rs.getInt("EnrollmentID"));
            sg.setTitle(rs.getString("Title"));
            sg.setGrade(rs.getFloat("Grade"));
            
            sg.setFirstName(rs.getString("FirstName"));
            sg.setLastName(rs.getString("LastName"));
            list.add(sg);
    }
   }
       return list;
   }
    public ArrayList<StudentGrade> readstudentCourse(int StudentID) throws SQLException {
    String query = "SELECT c.title, p.FirstName, p.EnrollmentDate,  FROM studentGrade sg JOIN person p ON sg.StudentID = p.PersonID JOIN course c ON sg.CourseID = c.CourseID WHERE sg.StudentID = ?";
    try (PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query)) {
        p.setInt(1, StudentID);
        ResultSet rs = p.executeQuery();
        ArrayList<StudentGrade> list = new ArrayList<>();

        while (rs.next()) {
            StudentGrade sg = new StudentGrade();
            sg.setTitle(rs.getString("Title"));
            sg.setFirstName(rs.getString("FirstName"));
            sg.setEnrollmentDate(rs.getDate("EnrollmentDate"));
            
            // Check if the Grade value is "none check" and set it accordingly
            String grade = rs.getString("Grade");
            if (grade.equals("none check")) {
                sg.setGrade(NULL); // Set Grade to null in Java
            } else {
                sg.setGrade(Float.parseFloat(grade));
            }
            
            list.add(sg);
        }
        return list;
    }
}

    public ArrayList<StudentGrade> readStudentGrade() throws SQLException{
        String query ="SELECT sg.EnrollmentID,sg.Grade,c.Title, p.FirstName, p.LastName FROM studentgrade sg JOIN person p ON sg.StudentID = p.PersonID  JOIN course c ON sg.CourseID=c.CourseID WHERE p.EnrollmentDate > 0"; /// 
        ResultSet rs=StudentGradeDAL.doReadQuery(query);
        
        ArrayList list=new ArrayList();
        if (rs !=null){
            while(rs.next()){
                StudentGrade sg=new StudentGrade();
                sg.setEnrollmentID(rs.getInt("EnrollmentID"));
                sg.setTitle(rs.getString("Title"));
                sg.setFirstName(rs.getString("FirstName"));
                sg.setLastName(rs.getString("LastName"));
                Float grade = rs.getFloat("Grade");
            if (rs.wasNull()) {
                sg.setGrade(NULL); 
            } else {
                sg.setGrade(grade);
            }
                list.add(sg);
            }
        }
        return list;
    }
    public StudentGrade getStudentGrade (int EnrollmentID) throws SQLException{
        String query ="Select * From studentgrade Where EnrollmentID = ?";
        PreparedStatement sg= StudentGradeDAL.getConnection().prepareStatement(query);
        sg.setInt (1,EnrollmentID);
         ResultSet rs = sg.executeQuery();
        StudentGrade t  = new StudentGrade();
        if(rs != null) {
            while(rs.next()) {
                t.setEnrollmentID(rs.getInt("EnrollmentID"));
                t.setStudentID(rs.getInt("StudentID"));
                t.setCourseID(rs.getInt("CourseID"));
                t.setGrade(rs.getFloat("Grade"));
                
            }
        }
        return t;
    }
    public int insertStudentGrade (StudentGrade sg) throws SQLException{
        String query= "Insert StudentGrade(CourseID,StudentID,Grade) Values (?,?,?)";///
        PreparedStatement  p = StudentGradeDAL.getConnection().prepareStatement(query);
        p.setInt(1, sg.getCourseID());
        p.setInt(2,sg.getStudentID());
        p.setFloat(3, sg.getGrade());
         int result = p.executeUpdate();
         return result;
    }
    public int updateStudentGrade (StudentGrade sg)throws SQLException {
        String query="Update studentgrade Set Grade=? "
                +" Where EnrollmentID=?";///
        PreparedStatement p=getConnection().prepareStatement(query);
        p.setFloat(1, sg.getGrade());
        p.setInt(2,sg.getEnrollmentID());
            int result = p.executeUpdate();
        return result;
     }
      public int deleteStudentGrade(int EnrollmentID) throws SQLException {
         String query = "DELETE FROM StudentGrade WHERE EnrollmentID = ?";
        PreparedStatement p = StudentDAL.getConnection().prepareStatement(query);
        p.setInt(1, EnrollmentID);
        int result = p.executeUpdate();
        return result;
    }
       public ArrayList<StudentGrade> findStudentGrade(int CourseID) throws SQLException {
    String query = "SELECT s.EnrollmentID,s.Grade, p.FirstName, p.LastName,c.Title FROM StudentGrade s Join  Person p On s.StudentID = p.PersonID Join course c On s.CourseID=c.CourseID WHERE s.CourseID=? AND HireDate > 0";///
    PreparedStatement p = StudentGradeDAL.getConnection().prepareStatement(query);
    p.setInt(1, CourseID);
    ResultSet rs = p.executeQuery();
    ArrayList<StudentGrade> list = new ArrayList<>();

   if(rs !=null){
        while (rs.next()) {
            StudentGrade sg = new StudentGrade();
            sg.setEnrollmentID(rs.getInt("EnrollmentID"));
            sg.setTitle(rs.getString("Title"));
            sg.setGrade(rs.getFloat("Grade"));
            sg.setFirstName(rs.getString("FirstName"));
            sg.setLastName(rs.getString("LastName"));
            list.add(sg);
    }
   }
    return list;
}
       
    public StudentGrade viewStudentGrade(int EnrollmentID)throws SQLException{
        String query="Select s.*, p.FirstName, p.LastName From StudentGrade s Join Person p on s.StudentID = p.PersonID where s.EnrollmentID=?";
        PreparedStatement sg= StudentGradeDAL.getConnection().prepareStatement(query);
        sg.setInt (1,EnrollmentID);
         ResultSet rs = sg.executeQuery();
        StudentGrade t  = new StudentGrade();
        if(rs != null) {
            while(rs.next()) {
                t.setStudentID(rs.getInt("StudentID"));
                t.setCourseID(rs.getInt("CourseID"));
                t.setGrade(rs.getFloat("Grade"));
                t.setEnrollmentID(rs.getInt("EnrollmentID"));
                t.setLastName(rs.getString("LastName"));
                t.setFirstName(rs.getString("FirstName"));
             
            }
        }
        return t;
    
    }
    public boolean isStudentIDExist(int StudentID) throws SQLException{
        String query = "SELECT COUNT(*) AS count FROM StudentGrade WHERE StudentID = ?";
        PreparedStatement ps = StudentGradeDAL.getConnection().prepareStatement(query);
        ps.setInt(1, StudentID);
        ResultSet rs = ps.executeQuery();
        rs.next();
        int count = rs.getInt("count");
        return count > 0;
    }
}
 /*
    public StudentGrade viewStudentGrade(int EnrollmentID)throws SQLException{
        String query="Select s.*, p.FirstName, p.LastName From StudentGrade s Join Person p on s.StudentID = p.PersonID where s.EnrollmentID=?";
        PreparedStatement sg= StudentGradeDAL.getConnection().prepareStatement(query);
        sg.setInt (1,EnrollmentID);
         ResultSet rs = sg.executeQuery();
        StudentGrade t  = new StudentGrade();
        if(rs != null) {
            while(rs.next()) {
                t.setStudentID(rs.getInt("StudentID"));
                t.setCourseID(rs.getInt("CourseID"));
                t.setGrade(rs.getFloat("Grade"));
                t.setEnrollmentID(rs.getInt("EnrollmentID"));
                t.setLastName(rs.getString("LastName"));
                t.setFirstName(rs.getString("FirstName"));
             
            }
        }
        return t;
    
    }*/  
