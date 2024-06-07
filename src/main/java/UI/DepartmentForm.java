/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import BLL.DepartmentBLL;
import Entity.Department;
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
public class DepartmentForm extends javax.swing.JPanel {

    DepartmentBLL deBLL = new DepartmentBLL();
    public DepartmentForm() {
        initComponents();
     try {
            loadDepartment(null);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void loadDepartment(ArrayList<Department> l) throws SQLException {
    ArrayList<Department> departmentList = new ArrayList<Department>();
    if(l == null) {
       departmentList = (ArrayList<Department>) deBLL.LoadDepartments();
    } else {
        departmentList = l;
    }
    for(int i=0; i< departmentList.size(); i++){
        System.out.print(departmentList.get(i).toString());
    }
    // jtable columns
    String[] colNames = {"DEPARTMENT ID","NAME", "BUDGET", "ADMINISTRATOR", "STARTDATE"};
    
    // jtable rows
    Object[][] rows = new Object[departmentList.size()][colNames.length];
    
    for(int i = 0; i < departmentList.size(); i++) {
        rows[i][0] = departmentList.get(i).getDepartmentID();
        rows[i][1] = departmentList.get(i).getName();
        rows[i][2] = departmentList.get(i).getBudget();
        rows[i][3] = departmentList.get(i).getAdministrator(); 
        rows[i][4] = departmentList.get(i).getStartDate();
    }
    
    DefaultTableModel model = new DefaultTableModel(rows, colNames);
    jTable1.setModel(model);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDelete = new javax.swing.JButton();
        jtxtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnRefesh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAdd6 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

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

        btnAdd6.setText("Add");
        btnAdd6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdd6MouseClicked(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAdd6)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnDelete)
                                .addGap(18, 18, 18)
                                .addComponent(btnRefesh)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(btnSearch))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd6)
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

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();

        int departmentID = Integer.parseInt(model.getValueAt(row, 0).toString());
        System.out.print(departmentID);
        try {
            if (deBLL.deleteDepartment(departmentID) > 0) {
                JOptionPane.showMessageDialog(this, "Complete delete Department", "Message", JOptionPane.INFORMATION_MESSAGE);
                loadDepartment(null);
            } else {
                JOptionPane.showMessageDialog(this, "Error delete Department", "Message", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        try {

            String fullname = jtxtSearch.getText();
            if (fullname.isBlank() == false) {
                ArrayList<Department> list = deBLL.findDepartment(fullname);
                loadDepartment(list);
            } else {
                JOptionPane.showMessageDialog(this, "fullname is empty", "Message", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DepartmentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void btnRefeshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefeshMouseClicked
        try {
            loadDepartment(null);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRefeshMouseClicked

    private void btnAdd6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdd6MouseClicked

        DepartmentAddForm addform = new DepartmentAddForm(this);
        addform.setVisible(true);
    }//GEN-LAST:event_btnAdd6MouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int row = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        int departmentID = Integer.parseInt(model.getValueAt(row, 0).toString());
        System.out.print(departmentID);
        DepartmentEditForm f = new DepartmentEditForm(this,departmentID);
        f.setVisible(true);
    }//GEN-LAST:event_btnEditMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAdd1;
    private javax.swing.JButton btnAdd2;
    private javax.swing.JButton btnAdd3;
    private javax.swing.JButton btnAdd4;
    private javax.swing.JButton btnAdd5;
    private javax.swing.JButton btnAdd6;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefesh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtxtSearch;
    // End of variables declaration//GEN-END:variables
}
