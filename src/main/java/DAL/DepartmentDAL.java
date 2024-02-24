package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAL extends MyDatabaseManager{
    public DepartmentDAL(){
        DepartmentDAL.connectDB();
    }


    // Thêm một bộ phận mới vào cơ sở dữ liệu
    public static boolean addDepartment(Department department) {
        String sql = "INSERT INTO department (DepartmentID, Name, Budget, AdminStrator, StartDate) "
                + "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = MyDatabaseManager.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, department.getDepartmentID());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setInt(3, department.getBudget());
            preparedStatement.setString(4, department.getAdminStrator());
            preparedStatement.setString(5, department.getStartDate());


            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tất cả các bộ phận từ cơ sở dữ liệu
    public static List<Department> getAllDepartments() {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM department";

        try {
            ResultSet resultSet = MyDatabaseManager.doReadQuery(sql);
            while (resultSet.next()) {
                int departmentID = resultSet.getInt("DepartmentID");
                String departmentName = resultSet.getString("Name");
                int budget = resultSet.getInt("Budget");
                String startDate = resultSet.getString("StartDate");
                String adminStrator = resultSet.getString("AdminStrator");



                Department department = new Department(departmentID, departmentName, budget, startDate, adminStrator);
                departments.add(department);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return departments;
    }

    // Cập nhật thông tin của một bộ phận trong cơ sở dữ liệu
    public static boolean updateDepartment(Department department) {
        String sql = "UPDATE department SET Name=?, Budget=?, AdminStrator=?, StartDate=? WHERE DepartmentID=?";

        try {
            PreparedStatement preparedStatement = MyDatabaseManager.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setInt(2, department.getBudget());
            preparedStatement.setString(3, department.getAdminStrator());
            preparedStatement.setString(4, department.getStartDate());
            preparedStatement.setInt(5, department.getDepartmentID());


            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Xóa một bộ phận khỏi cơ sở dữ liệu
    public static boolean deleteDepartment(int departmentID) {
        String sql = "DELETE FROM department WHERE DepartmentID=?";

        try {
            PreparedStatement preparedStatement = MyDatabaseManager.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, departmentID);

            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
