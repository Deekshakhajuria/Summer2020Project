/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.School;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.AdministrationOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.SchoolWorKRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deekshakhajuria
 */
public class RequestToManufacturerJPanel extends javax.swing.JPanel {
 private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private AdministrationOrganization administrationOrganization;
    private Enterprise enterprise;
    /**
     * Creates new form RequestToManufacturerJPanel
     */
    public RequestToManufacturerJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business,Enterprise enterprise) {
        initComponents();
        workRequestJTable.getColumnModel().getColumn(4).setPreferredWidth(270);
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.administrationOrganization = (AdministrationOrganization)organization;
        this.enterprise  = enterprise;
        populateTable();
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)workRequestJTable.getModel();
        
        model.setRowCount(0);
        ArrayList<WorkRequest> list = administrationOrganization.getWorkQueue().getWorkRequestList();
        for(int i=0; i<list.size();i++ ){
            SchoolWorKRequest request =(SchoolWorKRequest) list.get(i);
            Object[] row = new Object[6];
            row[0] = request.getRequestDate();
            row[1] = request.getSender().getEmployee().getName();
            row[2] = request.getTestResult();
            row[3] = request;
            row[4] = request.getAmount();
            row[5] = request.getMessage();
            model.addRow(row);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        refreshJButton = new javax.swing.JButton();
        raiseRequestJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1620, 900));
        jPanel1.setMinimumSize(new java.awt.Dimension(1620, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(1620, 900));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Date", "Sender", "Test Result", "Status", "Amount", "Message"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(workRequestJTable);

        refreshJButton.setBackground(new java.awt.Color(0, 102, 204));
        refreshJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshJButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshJButton.setText("Refresh");
        refreshJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshJButtonActionPerformed(evt);
            }
        });

        raiseRequestJButton.setBackground(new java.awt.Color(0, 102, 204));
        raiseRequestJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        raiseRequestJButton.setForeground(new java.awt.Color(255, 255, 255));
        raiseRequestJButton.setText("Raise New Request");
        raiseRequestJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raiseRequestJButtonActionPerformed(evt);
            }
        });

        processJButton.setBackground(new java.awt.Color(0, 102, 204));
        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("MANAGE HOSPITAL INVENTORY");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(raiseRequestJButton)
                        .addGap(279, 279, 279)
                        .addComponent(processJButton)
                        .addGap(18, 18, 18)
                        .addComponent(refreshJButton)))
                .addContainerGap(721, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(raiseRequestJButton)
                    .addComponent(processJButton)
                    .addComponent(refreshJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 560, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1620, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshJButtonActionPerformed
        populateTable();
    }//GEN-LAST:event_refreshJButtonActionPerformed

    private void raiseRequestJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raiseRequestJButtonActionPerformed
        SchoolWorkAreaJPanel hospitalWorkAreaJPanel = new SchoolWorkAreaJPanel(userProcessContainer,userAccount,administrationOrganization,business,enterprise);
        userProcessContainer.add("HospitalWorkAreaJPanel", hospitalWorkAreaJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_raiseRequestJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int selectedRow = workRequestJTable.getSelectedRow();
        if (selectedRow < 0){
            return;
        }
        SchoolWorKRequest request = (SchoolWorKRequest)workRequestJTable.getValueAt(selectedRow, 3);
        if("Completed".equalsIgnoreCase(request.getStatus())){
            JOptionPane.showMessageDialog(null, "Request is already completed");
            return;
        }
        request.setMessage("Payment Done");
        request.setStatus("Completed");
        populateTable();
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JButton raiseRequestJButton;
    private javax.swing.JButton refreshJButton;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}