package BLL;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import DAL.StudentGradeDAL;
import Entity.StudentGrade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class StudentGradeBLL {
    StudentGradeDAL stgDal;
    public StudentGradeBLL(){
        stgDal=new StudentGradeDAL();
    }
    public ArrayList<StudentGrade> LoadStudentGrade() throws SQLException {
        ArrayList list = stgDal.readStudentGrade();
        return list;
    }
    public ArrayList<String> ShowComboBox(String cb1)throws SQLException{
        
        return stgDal.showComboBox(cb1);
    }
    public int  count5(int CourseID) throws SQLException{
        int result= stgDal.count5(CourseID);
        return result;
    }
    public int  countNull(int CourseID) throws SQLException{
        int result= stgDal.countNullGrade(CourseID);
        return result;
    }
    /*public int countStudent() throws SQLException {
        ArrayList<StudentGrade> studentGrades = LoadStudentGrade();
        return studentGrades.size();
    }*/
    public ArrayList<StudentGrade> LoadStudentGradeForView(int StudentID) throws SQLException{
        ArrayList<StudentGrade> list = new ArrayList();
        list =stgDal.readstudentCourse(StudentID);
        return list;
    }
    
    public StudentGrade GetStudentGrade(int enrollmentID) throws SQLException {
        return stgDal.getStudentGrade(enrollmentID);
    }
    
     public int addStudentGrade(StudentGrade s) throws SQLException {
        int result = stgDal.insertStudentGrade(s);
        return result;
    }
     public int updateStudentGrade(StudentGrade s) throws SQLException {
        int result = stgDal.updateStudentGrade(s);
        return result;
    }
    
    public int deleteStudentGrade(int enrollmentID) throws SQLException {
        int result = stgDal.deleteStudentGrade(enrollmentID);
        return result;
    }
    public ArrayList<StudentGrade> loadcourses(int CourseID) throws SQLException {
        ArrayList<StudentGrade> list = new ArrayList();
        list = stgDal.courses(CourseID );
        return list;

    }
     public ArrayList<StudentGrade> findStudentGrade(int CourseID) throws SQLException {
        ArrayList<StudentGrade> list = new ArrayList();
        list = stgDal.findStudentGrade(CourseID );
        return list;

    }
    
    public String showName(int studentID) throws SQLException {
    // Truy vấn cơ sở dữ liệu để lấy tên của sinh viên dựa trên ID
    return stgDal.showName(studentID);
    }
    public StudentGrade viewStudentGrade(int EnrollmentID) throws SQLException{
        return stgDal.viewStudentGrade(EnrollmentID);
    }
    public boolean isStudentIDExist(int StudentID)throws SQLException{
        return stgDal.isStudentIDExist(StudentID);
    }
    
}
