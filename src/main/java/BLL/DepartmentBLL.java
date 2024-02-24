/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Department;
import DAL.DepartmentDAL;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author vapuhi
 */
public class DepartmentBLL {

     public static boolean addDepartment(int departmentID, String departmentName, int budget, String startDate, String adminStrator) {
        // Kiểm tra điều kiện hợp lệ trước khi gọi DAL để thêm vào cơ sở dữ liệu
        if (departmentID <= 0 || departmentName.isEmpty() || budget < 0 || startDate == null || adminStrator.isEmpty()) {
            // Có thể thêm các xử lý lỗi khác tùy thuộc vào yêu cầu
            System.out.println("Thông tin bộ phận không hợp lệ");
            return false;
        }

        return DepartmentDAL.addDepartment(new Department(departmentID, departmentName, budget, startDate, adminStrator));
    }

    // Lấy danh sách tất cả các bộ phận
    public static List<Department> getAllDepartments() {
        return DepartmentDAL.getAllDepartments();
    }

    // Cập nhật thông tin của một bộ phận
    public static boolean updateDepartment(int departmentID, String departmentName, int budget, String startDate, String adminStrator) {
        // Kiểm tra điều kiện hợp lệ trước khi gọi DAL để cập nhật vào cơ sở dữ liệu
        if (departmentID <= 0 || departmentName.isEmpty() || budget < 0 || startDate == null || adminStrator.isEmpty()) {
            // Có thể thêm các xử lý lỗi khác tùy thuộc vào yêu cầu
            System.out.println("Thông tin bộ phận không hợp lệ");
            return false;
        }

        return DepartmentDAL.updateDepartment(new Department(departmentID, departmentName, budget, startDate, adminStrator));
    }

    // Xóa một bộ phận
    public static boolean deleteDepartment(int departmentID) {
        // Kiểm tra điều kiện hợp lệ trước khi gọi DAL để xóa khỏi cơ sở dữ liệu
        if (departmentID <= 0) {
            // Có thể thêm các xử lý lỗi khác tùy thuộc vào yêu cầu
            System.out.println("ID bộ phận không hợp lệ");
            return false;
        }

        return DepartmentDAL.deleteDepartment(departmentID);
    }
    
}
