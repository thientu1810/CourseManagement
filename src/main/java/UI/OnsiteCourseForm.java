/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import BLL.DepartmentBLL;
import BLL.OnsiteCourseBLL;
import BLL.OnsiteCourseBLL;
import Entity.OnsiteCourse;
import Entity.OnsiteCourse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author USER
 */
public class OnsiteCourseForm extends javax.swing.JPanel {

   OnsiteCourseBLL onsBLL = new OnsiteCourseBLL();
    public OnsiteCourseForm() {
        initComponents();
        try {
            loadOnsiteCourse(null);
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void loadOnsiteCourse(ArrayList<OnsiteCourse> l) throws SQLException {
    ArrayList<OnsiteCourse> onsiteCourseList = new ArrayList<OnsiteCourse>();
    if(l == null) {
       onsiteCourseList = (ArrayList<OnsiteCourse>) onsBLL.LoadOnsiteCourse();
    } else {
        onsiteCourseList = l;
    }
    for(int i=0; i< onsiteCourseList.size(); i++){
        System.out.print(onsiteCourseList.get(i).toString());
    }
    // jtable columns
    String[] colNames = {"COURSE ID","TITLE", "CREDITS", "LOCATION", "DAYS", "TIME", "DEPARTMENT ID"};
    
    // jtable rows
    Object[][] rows = new Object[onsiteCourseList.size()][colNames.length];
    
    for(int i = 0; i < onsiteCourseList.size(); i++) {
        rows[i][0] = onsiteCourseList.get(i).getCourseID();
        rows[i][1] = onsiteCourseList.get(i).getTitle();
        rows[i][2] = onsiteCourseList.get(i).getCredits(); 
        rows[i][3] = onsiteCourseList.get(i).getLocation();
        rows[i][4] = onsiteCourseList.get(i).getDays();
        rows[i][5] = onsiteCourseList.get(i).getTime();
        rows[i][6] = onsiteCourseList.get(i).getDepartmentID();
    }
    
    DefaultTableModel model = new DefaultTableModel(rows, colNames);
    jTable1.setModel(model);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jtxtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();

        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnSearch.setText("Search");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });

        btnRefesh.setText("Refesh");
        btnRefesh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefeshMouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnAdd.setText("Add");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(btnAdd)
                            .addGap(18, 18, 18)
                            .addComponent(btnEdit)
                            .addGap(18, 18, 18)
                            .addComponent(btnDelete)
                            .addGap(18, 18, 18)
                            .addComponent(btnRefesh)
                            .addGap(70, 70, 70))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(btnSearch)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete)
                    .addComponent(btnRefesh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        int onsiteCourseID = Integer.parseInt(model.getValueAt(row, 0).toString());
        System.out.print(onsiteCourseID);
        OnsiteCourseEditForm f = null;
       try {
           f = new OnsiteCourseEditForm(this,onsiteCourseID);
       } catch (SQLException ex) {
           Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
       }
        f.setVisible(true);
    }//GEN-LAST:event_btnEditMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
         int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();

        int onsiteCourseID = Integer.parseInt(model.getValueAt(row, 0).toString());
        System.out.print(onsiteCourseID);
        try {
            if (onsBLL.deleteOnsiteCourse(onsiteCourseID) > 0) {
                JOptionPane.showMessageDialog(this, "Complete delete OnsiteCourse", "Message", JOptionPane.INFORMATION_MESSAGE);
                loadOnsiteCourse(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error delete OnsiteCourse", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
         try {

            String fullname = jtxtSearch.getText();
            if (fullname.isBlank() == false) {
                ArrayList<OnsiteCourse> list = onsBLL.findOnsiteCourse(fullname);
                        loadOnsiteCourse(list);
            } else {
                JOptionPane.showMessageDialog(this, "fullname is empty", "Message", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        try {
            loadOnsiteCourse(null);
        } catch (SQLException ex) {
            Logger.getLogger(OnsiteCourseForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefeshMouseClicked

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
         OnsiteCourseAddForm addform = new OnsiteCourseAddForm(this);
        addform.setVisible(true);
    }//GEN-LAST:event_btnAddMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxtSearch;
    // End of variables declaration//GEN-END:variables
}
