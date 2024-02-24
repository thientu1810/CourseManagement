/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAL;
import java.sql.Date;
/**
 *
 * @author vapuhi
 */
public class Department {
    int departmentID;
    String departmentName;
    int budget;
    String startDate;
    String adminStrator;

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAdminStrator() {
        return adminStrator;
    }

    public void setAdminStrator(String adminStrator) {
        this.adminStrator = adminStrator;
    }

    public Department(int departmentID, String departmentName, int budget, String startDate, String adminStrator) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.budget = budget;
        this.startDate = startDate;
        this.adminStrator = adminStrator;
    }
}
