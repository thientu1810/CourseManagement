/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.Person;
import DAL.PersonDAL;
import java.awt.List;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ankho
 */
public class PersonBLL {
    PersonDAL psDal;
    public PersonBLL() {
        psDal = new PersonDAL();
    }
    public ArrayList LoadPerson() throws SQLException {
        ArrayList list = psDal.readPerson();
        return list;
    }
    
    public ArrayList LoadStudent() throws SQLException {
        ArrayList list = psDal.readStudent();
        return list;
    }
    
    public ArrayList LoadTeacher() throws SQLException {
        ArrayList list = psDal.readTeacher();
        return list;
    }
    
    public int addPerson(Person p) throws SQLException {
        int result = psDal.insertPerson(p);
        return result;
    }
}
