/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author joseph
 */
public class WorkersTable extends javax.swing.JFrame {
    DefaultTableModel model;
    WorkerOperations operations;
    /**
     * Creates new form WorkersTable
     */
    public WorkersTable() {
        operations = new WorkerOperations();
        initComponents();
        model = (DefaultTableModel) workersTable.getModel();
        loadTableContent();
    }
    final void loadTableContent(){
        model.setRowCount(0);
        ArrayList<Worker> workers = operations.getWorkers();
        for (Worker worker : workers) {
            model.addRow(new Object[]{worker.getId(),worker.getName(),worker.getSurname(),worker.getDepartment(),worker.getSalary()});
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        workersTable = new javax.swing.JTable();
        searchBarText = new javax.swing.JTextField();
        addWorkerButon = new javax.swing.JButton();
        nameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        surnameText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        departmentText = new javax.swing.JTextField();
        salaryText = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        idText = new javax.swing.JTextField();
        messageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        workersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "name", "surname", "department", "salary"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                workersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(workersTable);

        searchBarText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBarTextKeyReleased(evt);
            }
        });

        addWorkerButon.setText("Add Worker");
        addWorkerButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkerButonActionPerformed(evt);
            }
        });

        jLabel1.setText("Name:");

        jLabel2.setText("Surname:");

        jLabel3.setText("Department:");

        jLabel4.setText("Salary");

        deleteButton.setText("Delete Worker");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setText("Update Worker");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("ID:");

        idText.setEditable(false);

        messageLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        messageLabel.setForeground(new java.awt.Color(51, 0, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(searchBarText, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(departmentText)
                                    .addComponent(nameText, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(surnameText)
                                    .addComponent(salaryText)
                                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addWorkerButon, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(92, Short.MAX_VALUE)
                .addComponent(searchBarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(messageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(surnameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(departmentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addWorkerButon)
                    .addComponent(jLabel4)
                    .addComponent(salaryText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void dynamicSearch(String value) {
        // *** dynamic search with regex filter ***
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        workersTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(value ));
    }
    private void searchBarTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarTextKeyReleased
        String value = searchBarText.getText();
        dynamicSearch(value);
                
    }//GEN-LAST:event_searchBarTextKeyReleased

    private void addWorkerButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkerButonActionPerformed
        String name = nameText.getText();
        String surname = surnameText.getText();
        String department = departmentText.getText();
        String salary = salaryText.getText();
        
        try {
            operations.addWorker( name,surname,department,salary);
            loadTableContent();
        } catch (SQLException ex) {
            Logger.getLogger(WorkersTable.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addWorkerButonActionPerformed

    private void workersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_workersTableMouseClicked
        int row = workersTable.getSelectedRow();
        idText.setText(String.valueOf((Integer)workersTable.getValueAt(row, 0) ));
        nameText.setText((String)workersTable.getValueAt(row, 1));
        surnameText.setText((String)workersTable.getValueAt(row, 2));
        departmentText.setText((String)workersTable.getValueAt(row, 3));
        salaryText.setText((String)workersTable.getValueAt(row, 4));
        
    }//GEN-LAST:event_workersTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int row = workersTable.getSelectedRow();// id ile olmas?? gereken s??ra ayn?? olmay??nca silme i??leminde arrayOutOfBoundsException yiyiyoruz .... fix pls
        if(row == -1){
            messageLabel.setText("Please Select A Worker...");idText.setText("");            
        }
        else{
            String id = String.valueOf( workersTable.getValueAt(row, 0) );
            //workersTable.remove(row);
            operations.deleteWorker(Integer.valueOf(id));
            messageLabel.setText("Worker with ID:" + id + " has been deleted from the system...");
            loadTableContent();
            
            
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int row = workersTable.getSelectedRow();
        if(row == -1){
            messageLabel.setText("Please Select A Worker...");idText.setText("");
        }
        else{
            String id = String.valueOf( workersTable.getValueAt(row, 0) );
            String name = nameText.getText();
            String surname = surnameText.getText();
            String department = departmentText.getText();
            String salary = salaryText.getText();
            operations.updateWorker(Integer.valueOf(id),name,surname,department,salary);
            messageLabel.setText("Worker with ID:" + id + " has been updated succesfully...");
            loadTableContent();           
            
        }
    }//GEN-LAST:event_updateButtonActionPerformed

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
            java.util.logging.Logger.getLogger(WorkersTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WorkersTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WorkersTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WorkersTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WorkersTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWorkerButon;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField departmentText;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField salaryText;
    private javax.swing.JTextField searchBarText;
    private javax.swing.JTextField surnameText;
    private javax.swing.JButton updateButton;
    private javax.swing.JTable workersTable;
    // End of variables declaration//GEN-END:variables


}
