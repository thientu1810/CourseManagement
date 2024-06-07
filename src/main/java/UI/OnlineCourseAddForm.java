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
public class OnlineCourseAddForm extends javax.swing.JFrame {

    OnlineCourseBLL onlBLL = new OnlineCourseBLL();
    OnlineCourseForm onlForm = new OnlineCourseForm();
    DepartmentBLL deBLL = new DepartmentBLL();
    ArrayList<Department> departmentList = new ArrayList<Department>();
    public OnlineCourseAddForm(OnlineCourseForm aThis){
        initComponents();
         try {
            loadDepartment(null);
        } catch (SQLException ex) {
            Logger.getLogger(OnlineCourseAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void loadDepartment(ArrayList<Department> l) throws SQLException {
        
    if(l == null) {
       departmentList = (ArrayList<Department>) deBLL.LoadDepartments();
    } else {
        departmentList = l;
    }
    for(int i = 0; i < departmentList.size(); i++) {
        jcbDepartment.addItem(String.valueOf(departmentList.get(i).getDepartmentID()));
    }
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAdd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jLbFirstName = new javax.swing.JLabel();
        jLbLastName = new javax.swing.JLabel();
        jtxtTitle = new javax.swing.JTextField();
        jtxtCredits = new javax.swing.JTextField();
        JLbHireDay = new javax.swing.JLabel();
        jLbHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtUrl = new javax.swing.JTextField();
        jcbDepartment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAdd.setText("ADD");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
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

        JLbHireDay.setText("Url: ");

        jLbHeader.setText("ADD ONLINECOURSE");

        jLabel1.setText("Department: ");

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
                            .addComponent(btnAdd)
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
                .addContainerGap(45, Short.MAX_VALUE))
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
                    .addComponent(btnAdd)
                    .addComponent(btnClose))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        OnlineCourse onl = new OnlineCourse();
        onlBLL.isBlank(jtxtTitle.getText());
        onl.setTitle(jtxtTitle.getText());
        onlBLL.isInteger(jtxtCredits.getText());
        onl.setCredits(Integer.parseInt(jtxtCredits.getText()));
        onlBLL.isBlank(jtxtUrl.getText());
        onl.setUrl(jtxtUrl.getText());
        int selectedDepartmentID = Integer.parseInt(jcbDepartment.getSelectedItem().toString());
        onl.setDepartmentID(selectedDepartmentID);
        int id = onlBLL.getAutoIncrement();
        onl.setCourseID(id);
        try {
            if (onlBLL.addOnlineCourse(onl) > 0) {
                JOptionPane.showMessageDialog(this, "Complete add OnlineCourse", "Message", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                onlForm.loadOnlineCourse(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error add OnlineCourse", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentAddForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCloseMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OnlineCourseAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OnlineCourseAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OnlineCourseAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OnlineCourseAddForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                OnlineCourseForm form = new OnlineCourseForm();
                new OnlineCourseAddForm(form).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLbHireDay;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLbFirstName;
    private javax.swing.JLabel jLbHeader;
    private javax.swing.JLabel jLbLastName;
    private javax.swing.JComboBox<String> jcbDepartment;
    private javax.swing.JTextField jtxtCredits;
    private javax.swing.JTextField jtxtTitle;
    private javax.swing.JTextField jtxtUrl;
    // End of variables declaration//GEN-END:variables

    private String StringValueOf(int departmentID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
