/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UI;

import BLL.DepartmentBLL;
import BLL.OnlineCourseBLL;
import Entity.Department;
import Entity.OnlineCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class OnlineCourseEditForm extends javax.swing.JFrame {
    OnlineCourseBLL onlBLL = new OnlineCourseBLL();
    OnlineCourseForm onlForm = new OnlineCourseForm();
    OnlineCourse obj;
    DepartmentBLL deBLL = new DepartmentBLL();
    public OnlineCourseEditForm(OnlineCourseForm of, int onlId) throws SQLException {
        initComponents();
        onlForm = of;
        obj = new OnlineCourse();
        obj = onlBLL.getOnlineCourse(onlId);
        System.out.print(obj.toString());
        LoadOnlineCourseForEdit(obj);
        try {
            loadDepartment(null);
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseEditForm.class.getName()).log(Level.SEVERE, null, ex);
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
    private void LoadOnlineCourseForEdit(OnlineCourse onl) {
        jtxtTitle.setText(onl.getTitle());
        jtxtCredits.setText(String.valueOf(onl.getCredits()));
        jtxtUrl.setText(onl.getUrl());
        jcbDepartment.setSelectedItem(onl.getDepartmentID());

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEdit = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLbFirstName = new javax.swing.JLabel();
        jLbLastName = new javax.swing.JLabel();
        jtxtTitle = new javax.swing.JTextField();
        jtxtCredits = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        JLbHireDay = new javax.swing.JLabel();
        jtxtUrl = new javax.swing.JTextField();
        jcbDepartment = new javax.swing.JComboBox<>();
        jLbHeader = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        JLbHireDay.setText("Url: ");

        jLbHeader.setText("EDIT ONLINECOURSE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(jLbHeader))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(btnEdit)
                            .addGap(33, 33, 33)
                            .addComponent(btnClose))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLbLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JLbHireDay)
                                .addComponent(jLbFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                .addComponent(jtxtCredits)
                                .addComponent(jtxtUrl)
                                .addComponent(jcbDepartment, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(14, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLbHireDay)
                    .addComponent(jtxtUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jcbDepartment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit)
                    .addComponent(btnClose))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
                OnlineCourse onl = new OnlineCourse();
                onl.setCourseID(obj.getCourseID());
               onlBLL.isBlank(jtxtTitle.getText());
        onl.setTitle(jtxtTitle.getText());
        onlBLL.isInteger(jtxtCredits.getText());
        onl.setCredits(Integer.parseInt(jtxtCredits.getText()));
        onlBLL.isBlank(jtxtUrl.getText());
        onl.setUrl(jtxtUrl.getText());
        int selectedDepartmentID = Integer.parseInt(jcbDepartment.getSelectedItem().toString());
        onl.setDepartmentID(selectedDepartmentID);
        
                 try {
            if (onlBLL.updateOnlineCourse(onl) > 0) {
                JOptionPane.showMessageDialog(this, "Complete edit OnlineCourse", "Message", JOptionPane.INFORMATION_MESSAGE);
                   this.dispose();
                onlForm.loadOnlineCourse(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error edit OnlineCourse", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseAddForm.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbFirstName;
    private javax.swing.JLabel jLbHeader;
    private javax.swing.JLabel jLbLastName;
    private javax.swing.JComboBox<String> jcbDepartment;
    private javax.swing.JTextField jtxtCredits;
    private javax.swing.JTextField jtxtTitle;
    private javax.swing.JTextField jtxtUrl;
    // End of variables declaration//GEN-END:variables
}
