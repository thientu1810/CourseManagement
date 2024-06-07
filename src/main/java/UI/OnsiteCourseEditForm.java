/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import BLL.DepartmentBLL;
import BLL.OnsiteCourseBLL;
import Entity.Department;
import Entity.OnsiteCourse;
import Entity.OnsiteCourse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class OnsiteCourseEditForm extends javax.swing.JFrame {

    OnsiteCourseBLL onsBLL = new OnsiteCourseBLL();
    OnsiteCourseForm onsForm = new OnsiteCourseForm();
    OnsiteCourse obj;
    DepartmentBLL deBLL = new DepartmentBLL();
    public OnsiteCourseEditForm(OnsiteCourseForm of, int onsId) throws SQLException {
        initComponents();
        onsForm = of;
        obj = new OnsiteCourse();
        obj = onsBLL.getOnsiteCourse(onsId);
        System.out.print(obj.toString());
        LoadOnsiteCourseForEdit(obj);
        try {
            loadDepartment(null);
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void loadDepartment(ArrayList<Department> l) throws SQLException {
         ArrayList<Department> departmentList = new ArrayList<Department>();
        if(l == null) {
           departmentList = (ArrayList<Department>) deBLL.LoadDepartments();
        } else {
            departmentList = l;
        }
        for(int i = 0; i < departmentList.size(); i++) {
            jcbDepartment.addItem(String.valueOf(departmentList.get(i).getDepartmentID()));
        }
    }
    private void LoadOnsiteCourseForEdit(OnsiteCourse ons) {
        jtxtTitle.setText(ons.getTitle());
        jtxtCredits.setText(String.valueOf(ons.getCredits()));
        jtxtLocation.setText(ons.getLocation());
       // Tách chuỗi ngày
        String[] days = ons.getDays().split(" to ");
        String DayStart = days[0];
        String DayEnd = days[1];
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date startDate = sdf.parse(DayStart);
            Date endDate = sdf.parse(DayEnd);

            jDateChooser1.setDate(startDate);
            jDateChooser2.setDate(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Tách chuỗi thời gian
        String[] times = ons.getTime().split(" to ");
        String timeStart = times[0];
        String timeEnd = times[1];

        // Tách thời gian bắt đầu
        String[] startTimes = timeStart.split("h ");
        String startHour = startTimes[0];
        String startMinute = startTimes[1].replace("m", "");
        jtxtHourse.setText(startHour);
        jtxtMinutes.setText(startMinute);

        // Tách thời gian kết thúc
        String[] endTimes = timeEnd.split("h ");
        String endHour = endTimes[0];
        String endMinute = endTimes[1].replace("m", "");
        jtxtHourse1.setText(endHour);
        jtxtMinutes1.setText(endMinute);

        jcbDepartment.setSelectedItem(ons.getDepartmentID());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jtxtLocation = new javax.swing.JTextField();
        jtxtHourse1 = new javax.swing.JTextField();
        jcbDepartment = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLbHeader = new javax.swing.JLabel();
        jtxtMinutes1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtxtHourse = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtMinutes = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btnEdit = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLbFirstName = new javax.swing.JLabel();
        jLbLastName = new javax.swing.JLabel();
        jtxtTitle = new javax.swing.JTextField();
        jtxtCredits = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JLbHireDay = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Time End:");

        jLabel8.setText("h");

        jLbHeader.setText("EDIT ONSITECOURSE");

        jLabel2.setText("Days:");

        jLabel9.setText("m");

        jLabel3.setText("Time Start:");

        jLabel4.setText("h");

        jLabel5.setText("m");

        btnEdit.setText("EDIT");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });

        jLbFirstName.setText("Title: ");

        jLbLastName.setText("Credits: ");

        jLabel1.setText("Department: ");

        JLbHireDay.setText("Location:");

        jLabel6.setText("to");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLbHeader))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbHireDay)
                                    .addComponent(jLbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtxtTitle)
                                    .addComponent(jtxtCredits)
                                    .addComponent(jtxtLocation)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jtxtHourse, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtxtMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jtxtHourse1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtxtMinutes1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLbHeader)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLbHireDay))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtHourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMinutes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtxtHourse1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtMinutes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnClose))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
       OnsiteCourse ons = new OnsiteCourse();
       ons.setCourseID(obj.getCourseID());
        onsBLL.isBlank(jtxtTitle.getText());
        ons.setTitle(jtxtTitle.getText());
        onsBLL.isInteger(jtxtCredits.getText());
        ons.setCredits(Integer.parseInt(jtxtCredits.getText()));
        onsBLL.isBlank(jtxtLocation.getText());
        ons.setLocation(jtxtLocation.getText());
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date startDate = jDateChooser1.getDate();
        java.util.Date endDate = jDateChooser2.getDate();

        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(null, "Please select both start and end dates","Message",JOptionPane.ERROR_MESSAGE);
        } else {
            String DayStart = sdf.format(startDate);
            String DayEnd = sdf.format(endDate);

            if (startDate.compareTo(endDate) > 0) {
                JOptionPane.showMessageDialog(null, "Start date must be before end date","Message",JOptionPane.ERROR_MESSAGE);
            } else {
                ons.setDays(DayStart + " to " + DayEnd);
            }
        }

        String hourStart = jtxtHourse.getText();
        String minuteStart = jtxtMinutes.getText();
        String hourEnd = jtxtHourse1.getText();
        String minuteEnd = jtxtMinutes1.getText();

        if (hourStart.isEmpty() || minuteStart.isEmpty() || hourEnd.isEmpty() || minuteEnd.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter both start and end times","Message",JOptionPane.ERROR_MESSAGE);
        } else {
            int hStart = Integer.parseInt(hourStart);
            int mStart = Integer.parseInt(minuteStart);
            int hEnd = Integer.parseInt(hourEnd);
            int mEnd = Integer.parseInt(minuteEnd);

            if (hStart < 0 || hStart > 12 || hEnd < 0 || hEnd > 12 || mStart < 0 || mStart > 60 || mEnd < 0 || mEnd > 60) {
                JOptionPane.showMessageDialog(null, "Hours must be between 0 and 12, and minutes must be between 0 and 60","Message",JOptionPane.ERROR_MESSAGE);
            } else if (hStart > hEnd || (hStart == hEnd && mStart >= mEnd)) {
                JOptionPane.showMessageDialog(null, "Start time must be before end time","Message",JOptionPane.ERROR_MESSAGE);
            } else {
                String timeStart = hStart + "h " + mStart + "m";
                String timeEnd = hEnd + "h " + mEnd + "m";
                ons.setTime(timeStart + " to " + timeEnd);
            }
        }

        
        int selectedDepartmentID = Integer.parseInt(jcbDepartment.getSelectedItem().toString());
        ons.setDepartmentID(selectedDepartmentID);
        

        try {
            if (onsBLL.updateOnsiteCourse(ons) > 0) {
                JOptionPane.showMessageDialog(this, "Complete edit OnsiteCourse", "Message", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                onsForm.loadOnsiteCourse(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error edit OnsiteCourse", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseEditForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLbHireDay;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnEdit;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLbFirstName;
    private javax.swing.JLabel jLbHeader;
    private javax.swing.JLabel jLbLastName;
    private javax.swing.JComboBox<String> jcbDepartment;
    private javax.swing.JTextField jtxtCredits;
    private javax.swing.JTextField jtxtHourse;
    private javax.swing.JTextField jtxtHourse1;
    private javax.swing.JTextField jtxtLocation;
    private javax.swing.JTextField jtxtMinutes;
    private javax.swing.JTextField jtxtMinutes1;
    private javax.swing.JTextField jtxtTitle;
    // End of variables declaration//GEN-END:variables
}
