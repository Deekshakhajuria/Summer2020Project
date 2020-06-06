/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SalesRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.AdministrationOrganization;
import Business.Organization.Organization;
import Business.Organization.OrphanageOrganization;
import Business.Organization.SalesOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ManufacturingWorkRequest;
import Business.WorkQueue.OrphanagePackage;
import Business.WorkQueue.OrphanageWorkRequest;
import Business.WorkQueue.SalesWorkRequest;
import Business.WorkQueue.SchoolPackage;
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
public class SalesManWorkAreaJPanel extends javax.swing.JPanel {
JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private SalesOrganization salesOrganization;
    private SalesWorkRequest request;
    ArrayList<WorkRequest> result = new ArrayList<>();
    /**
     * Creates new form SalesManWorkArea
     */
    public SalesManWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, SalesWorkRequest request) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        this.request = request;
        this.salesOrganization = (SalesOrganization) organization;
        result = business.getWorkQueue().getWorkRequestList();
        populateTable();
    }
    
    public void populateTable() {

        String packageType = request.getPackageType();
        jLabel2.setText(packageType);
        for (int i = 0; i < result.size(); i++) {
            ManufacturingWorkRequest manufacturingworkrequest = (ManufacturingWorkRequest) result.get(i);
            if ("Orphanage Package".equalsIgnoreCase(packageType)) {

                DefaultTableModel defaultTableModel = (DefaultTableModel) packageJTable.getModel();
                defaultTableModel.setRowCount(0);
                OrphanagePackage orphanagePackage = manufacturingworkrequest.getOrphanagePackage();
                if (orphanagePackage != null) {
                    for (int j = 0; j < 5; j++) {
                        Object row[] = new Object[2];
                        if (j == 0) {
                            row[0] = "Number Of beds";
                            row[1] = String.valueOf(orphanagePackage.getNumberOfBeds()) == null ? 0 : orphanagePackage.getNumberOfBeds();
                        } else if (j == 1) {
                            row[0] = "Number Of blankets";
                            row[1] = String.valueOf(orphanagePackage.getNumberOfBlankets()) == null ? 0 : orphanagePackage.getNumberOfBlankets();
                        } else if (j == 2) {
                            row[0] = "Number Of Notebooks";
                            row[1] = String.valueOf(orphanagePackage.getNumberOfNotebooks()) == null ? 0 : orphanagePackage.getNumberOfNotebooks();
                        } else if (j == 3) {
                            row[0] = "Number Of ArtSupplies";
                            row[1] = String.valueOf(orphanagePackage.getNumberOfArtSupplies()) == null ? 0 : orphanagePackage.getNumberOfArtSupplies();;
                        } else if (j == 4) {
                            row[0] = "Number Of Masks";
                            row[1] = String.valueOf(orphanagePackage.getNumberOfMasks()) == null ? 0 : orphanagePackage.getNumberOfMasks();;
                        }
                        defaultTableModel.addRow(row);
                    }
                }
            } else if ("School Package".equalsIgnoreCase(packageType)) {
                DefaultTableModel model = (DefaultTableModel) packageJTable.getModel();
                model.setRowCount(0);
                SchoolPackage schoolPackage = manufacturingworkrequest.getSchoolPackage();
                if (schoolPackage != null) {
                    for (int j = 0; j < 5; j++) {
                        Object row[] = new Object[2];
                        if (j == 0) {
                            row[0] = "Number Of Boards";
                            row[1] = (String.valueOf(schoolPackage.getNumberOfBoards())) == null ? 0 : schoolPackage.getNumberOfBoards();
                        } else if (j == 1) {
                            row[0] = "Number Of Tables";
                            row[1] = (String.valueOf(schoolPackage.getNumberOfTables())) == null ? 0 : schoolPackage.getNumberOfTables();
                        } else if (j == 2) {
                            row[0] = "Number Of Notebooks";
                            row[1] = (String.valueOf(schoolPackage.getNumberOfNotebooks())) == null ? 0 : schoolPackage.getNumberOfNotebooks();
                        } else if (j == 3) {
                            row[0] = "Number Of Masks";
                            row[1] = (String.valueOf(schoolPackage.getNumberOfMasks())) == null ? 0 : schoolPackage.getNumberOfMasks();
                        }
                        model.addRow(row);
                    }
                }
            }
        }
        
        if ("School Package".equalsIgnoreCase(packageType)) {
            jLabel5.setText("Number Of Boards");
            jLabel6.setText("Number Of Tables");
            jLabel7.setText("Number Of Notebooks");
            jLabel8.setText("Number Of Masks");
            jLabel9.setVisible(false);
            JText5.setVisible(false);

            JText1.setText(String.valueOf(request.getSchoolPackage().getNumberOfBoards()));
            JText2.setText(String.valueOf(request.getSchoolPackage().getNumberOfTables()));
            JText3.setText(String.valueOf(request.getSchoolPackage().getNumberOfNotebooks()));
            JText4.setText(String.valueOf(request.getSchoolPackage().getNumberOfMasks()));
        } else  if ("Orphanage Package".equalsIgnoreCase(packageType)) {
            jLabel5.setText("Number Of Beds");
            jLabel6.setText("Number Of Blankets");
            jLabel7.setText("Number Of Notebooks");
            jLabel8.setText("Number Of ArtSupplies");
            jLabel9.setVisible(true);
            jLabel9.setText("Number Of Masks");

            JText1.setText(String.valueOf(request.getOrphanagePackage().getNumberOfBeds()));
            JText2.setText(String.valueOf(request.getOrphanagePackage().getNumberOfBlankets()));
            JText3.setText(String.valueOf(request.getOrphanagePackage().getNumberOfNotebooks()));
            JText4.setText(String.valueOf(request.getOrphanagePackage().getNumberOfArtSupplies()));
            JText5.setVisible(true);
            JText5.setText(String.valueOf(request.getOrphanagePackage().getNumberOfMasks()));
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
        jScrollPane2 = new javax.swing.JScrollPane();
        packageJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        JText1 = new javax.swing.JTextField();
        JText2 = new javax.swing.JTextField();
        JText3 = new javax.swing.JTextField();
        JText4 = new javax.swing.JTextField();
        processJButton = new javax.swing.JButton();
        JText5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1620, 900));
        jPanel1.setMinimumSize(new java.awt.Dimension(1620, 900));
        jPanel1.setPreferredSize(new java.awt.Dimension(1620, 900));

        packageJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Package Type", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(packageJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Requested Quantity : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("jLabel1");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("jLabel2");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("jLabel3");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("jLabel4");

        JText1.setEnabled(false);
        JText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText1ActionPerformed(evt);
            }
        });

        JText2.setEnabled(false);
        JText2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText2ActionPerformed(evt);
            }
        });

        JText3.setEnabled(false);

        JText4.setEnabled(false);
        JText4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText4ActionPerformed(evt);
            }
        });

        processJButton.setBackground(new java.awt.Color(0, 102, 204));
        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process Request");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        JText5.setEnabled(false);
        JText5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JText5ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("jLabel5");

        backJButton.setBackground(new java.awt.Color(0, 102, 204));
        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setForeground(new java.awt.Color(255, 255, 255));
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(240, 240, 240));
        jLabel17.setText(" x");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel17))
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("MANAGE SALES REQUESTS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backJButton)
                .addGap(128, 128, 128)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JText1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JText2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JText3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JText4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(JText5, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 861, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(processJButton))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(backJButton))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(JText2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JText3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(processJButton))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(JText5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(JText4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 199, Short.MAX_VALUE))))
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

    private void JText4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText4ActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        int count = packageJTable.getRowCount();
        if (count == 0) {
            if (jLabel2.getText().equals("School Package")) {
                Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof AdministrationOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }
                SchoolWorKRequest schoolWorKRequest = new SchoolWorKRequest();
                schoolWorKRequest.setSender(userAccount);
                schoolWorKRequest.setStatus("Sent");
                schoolWorKRequest.setTestResult("Request cannot be processed as there are no items.");
                schoolWorKRequest.setAmount(0.0);
                schoolWorKRequest.setMessage("Request cannot be processed as there are no items.");
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(schoolWorKRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(schoolWorKRequest);
                }
            }  if (jLabel2.getText().equals("Orphanage Package")) {
                Organization org = null;
                for (Network network : business.getNetworkList()) {
                    for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            if (organization instanceof OrphanageOrganization) {
                                org = organization;
                                break;
                            }
                        }
                    }
                }
                OrphanageWorkRequest orphanageworkrequest = new OrphanageWorkRequest();
                orphanageworkrequest.setSender(userAccount);
                orphanageworkrequest.setStatus("Sent");
                orphanageworkrequest.setTestResult("Request cannot be processed as there are no items.");
                orphanageworkrequest.setAmount(0.0);
                orphanageworkrequest.setMessage("Request cannot be processed as there are no items.");
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(orphanageworkrequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(orphanageworkrequest);
                }
            }
            request.setStatus("completed");
            JOptionPane.showMessageDialog(null, "Request cannot be processed as there are no items");
            return;
        }
        if (jLabel2.getText().equals("School Package")) {
            int boards = (int) packageJTable.getValueAt(0, 1);
            int tables = (int) packageJTable.getValueAt(1, 1);
            int notebooks = (int) packageJTable.getValueAt(2, 1);
            int masks = (int) packageJTable.getValueAt(3, 1);

            int approvedBoards = Integer.parseInt(JText1.getText());
            int approvedTables = Integer.parseInt(JText2.getText());
            int approvedNotebooks = Integer.parseInt(JText3.getText());
            int approvedMasks = Integer.parseInt(JText4.getText());

            SchoolWorKRequest schoolWorKRequest = new SchoolWorKRequest();
            schoolWorKRequest.setSender(userAccount);
            schoolWorKRequest.setStatus("Sent");
            String testResult = "";
            int lesserBoards = 0;
            int lesserTables = 0;
            int lesserNotebooks = 0;
            int lesserMasks = 0;

            Organization org = null;
            for (Network network : business.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof AdministrationOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
            double amount = 0.0;
            if (approvedBoards <= boards && approvedTables <= tables && approvedNotebooks <= notebooks && approvedMasks <= masks) {
                JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to School for Payment Details");
                schoolWorKRequest.setTestResult("Completed");

                amount = (boards * 5) + (tables * 2) + (notebooks * .75) + (masks * 1);
                schoolWorKRequest.setAmount(amount);
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(schoolWorKRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(schoolWorKRequest);
                }
                schoolWorKRequest.setMessage("Request Processed.Please complete the payment");
            } else if (approvedBoards > boards || approvedTables > tables || approvedNotebooks > notebooks || approvedMasks > masks) {
                if (approvedBoards > boards) {
                    amount = amount + (boards * 5);
                    lesserBoards = approvedBoards - boards;
                    testResult = lesserBoards + " " + "Boards are lesser in quantity. ";
                } else {
                    amount = amount + (approvedBoards * 5);
                }
                if (approvedTables > tables) {
                    amount = amount + (tables * 2);
                    lesserTables = approvedTables - tables;
                    testResult = testResult + lesserTables + " " + "Desks are lesser in quantity. ";
                } else {
                    amount = amount + (approvedTables * 2);
                }
                if (approvedNotebooks > notebooks) {
                    amount = amount + (notebooks * .75);
                    lesserNotebooks = approvedNotebooks - notebooks;
                    testResult = testResult + lesserNotebooks + " " + "Notebooks are lesser in quantity. ";
                } else {
                    amount = amount + (approvedNotebooks * .75);
                }
                if (approvedMasks > masks) {
                    amount = amount + (masks * 1);
                    lesserMasks = approvedMasks - masks;
                    testResult = testResult + lesserMasks + " " + "Masks are lesser in quantity. ";
                } else {
                    amount = amount + (approvedMasks * 1);
                }
                schoolWorKRequest.setAmount(amount);
                schoolWorKRequest.setTestResult(testResult);

                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(schoolWorKRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(schoolWorKRequest);
                    JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to School as requested quantity is not available. ");
                }
                schoolWorKRequest.setMessage("Request Processed.Please complete the payment");
            } else if (approvedBoards > boards && approvedTables > tables && approvedNotebooks > notebooks && approvedMasks > masks) {
                schoolWorKRequest.setMessage("Request Cannot be Processed.");
                schoolWorKRequest.setAmount(0.0);
                schoolWorKRequest.setTestResult("All the requested quantities are not available.");
            }

            for (int i = 0; i < result.size(); i++) {
                ManufacturingWorkRequest manufacturingworkrequest = (ManufacturingWorkRequest) result.get(i);
                SchoolPackage schoolPackage = manufacturingworkrequest.getSchoolPackage();
                if (lesserBoards == 0) {
                    schoolPackage.setNumberOfBoards(boards - approvedBoards);
                }
                if (lesserTables == 0) {
                    schoolPackage.setNumberOfTables(tables - approvedTables);
                }
                if (lesserNotebooks == 0) {
                    schoolPackage.setNumberOfNotebooks(notebooks - approvedNotebooks);
                }
                if (lesserMasks == 0) {
                    schoolPackage.setNumberOfMasks(masks - approvedMasks);
                }
            }
            populateTable();
            request.setStatus("completed");
        } else if (jLabel2.getText().equals("Orphanage Package")) {
            int beds = (int) packageJTable.getValueAt(0, 1);
            int blankets = (int) packageJTable.getValueAt(1, 1);
            int notebooks = (int) packageJTable.getValueAt(2, 1);
            int artSupplies = (int) packageJTable.getValueAt(3, 1);
            int masks = (int) packageJTable.getValueAt(4, 1);

            int approvedBeds = Integer.parseInt(JText3.getText());
            int approvedBlankets = Integer.parseInt(JText4.getText());
            int approvedNotebooks = Integer.parseInt(JText2.getText());
            int approvedArtSupplies = Integer.parseInt(JText1.getText());
            int approvedMasks = Integer.parseInt(JText5.getText());

            OrphanageWorkRequest ngorequest = new OrphanageWorkRequest();
            ngorequest.setSender(userAccount);
            ngorequest.setStatus("Sent");
            String testResult = "";
            int lesserBeds = 0;
            int lesserBlankets = 0;
            int lesserNotebooks = 0;
            int lesserArtSupplies = 0;
            int lesserMasks = 0;

            Organization org = null;
            for (Network network : business.getNetworkList()) {
                for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                    for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
                        if (organization instanceof OrphanageOrganization) {
                            org = organization;
                            break;
                        }
                    }
                }
            }
            double amount = 0.0;
            if (approvedBeds <= beds && approvedBlankets <= blankets && approvedNotebooks <= notebooks && approvedArtSupplies <= artSupplies && approvedMasks <= masks) {
                JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to Orphanage for payment details. ");
                ngorequest.setTestResult("Completed");

                amount = (approvedBeds * 30) + (approvedBlankets * 10) + (approvedNotebooks * 0.75) + (approvedArtSupplies * 5) + (approvedMasks * 1);
                ngorequest.setAmount(amount);
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(ngorequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                }
                ngorequest.setMessage("Request Processed.Please complete the payment");
            } else if (approvedBeds > beds || approvedBlankets > blankets || approvedNotebooks > notebooks || approvedArtSupplies > artSupplies || approvedMasks > masks) {
                if (approvedBeds > beds) {
                    amount = amount + (beds * 30);
                    lesserBeds = approvedBeds - beds;
                    testResult = lesserBeds + " " + "Beds are lesser in quantity. ";
                } else {
                    amount = amount + (approvedBlankets * 10);
                }
                if (approvedBlankets > blankets) {
                    amount = amount + (blankets * 10);
                    lesserBlankets = approvedBlankets - blankets;
                    testResult = testResult + lesserBlankets + " " + "Blankets are lesser in quantity. ";
                } else {
                    amount = amount + (blankets * 10);
                }
                if (approvedNotebooks > notebooks) {
                    amount = amount + (notebooks * 0.75);
                    lesserNotebooks = approvedNotebooks - notebooks;
                    testResult = testResult + lesserNotebooks + " " + "NoteBooks are lesser in quantity. ";
                } else {
                    amount = amount + (notebooks * 0.75);
                }
                if (approvedArtSupplies > artSupplies) {
                    amount = amount + (artSupplies * 5);
                    lesserArtSupplies = approvedArtSupplies - artSupplies;
                    testResult = testResult + lesserArtSupplies + " " + "Art Supplies are lesser in quantity. ";
                } else {
                    amount = amount + (artSupplies * 5);
                }
                if (approvedMasks > masks) {
                    amount = amount + (masks * 1);
                    lesserMasks = approvedMasks - masks;
                    testResult = testResult + lesserMasks + " " + "Masks are lesser in quantity. ";
                } else {
                    amount = amount + (masks * 1);
                }
                ngorequest.setAmount(amount);
                ngorequest.setTestResult(testResult);
                ngorequest.setMessage("Request Processed.Please complete the payment");
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(ngorequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(ngorequest);
                    JOptionPane.showMessageDialog(null, "Request Processed and New Request raised to NGO as requested quantity is not available.");
                }
            } else if (approvedBeds > beds || approvedBlankets > blankets || approvedNotebooks > notebooks || approvedArtSupplies > artSupplies || approvedMasks > masks) {
                ngorequest.setMessage("Request Cannot be Processed.");
                ngorequest.setAmount(0.0);
                ngorequest.setTestResult("All the requested quantities are not available.");

            }
            for (int i = 0; i < result.size(); i++) {
                ManufacturingWorkRequest manufacturingworkrequest = (ManufacturingWorkRequest) result.get(i);
                OrphanagePackage orphanagepackage = manufacturingworkrequest.getOrphanagePackage();
                if (lesserBeds == 0) {
                    orphanagepackage.setNumberOfBeds(beds - approvedBeds);
                }
                if (lesserBlankets == 0) {
                    orphanagepackage.setNumberOfBlankets(blankets - approvedBlankets);
                }
                if (lesserNotebooks == 0) {
                    orphanagepackage.setNumberOfNotebooks(notebooks - approvedNotebooks);
                }
                if (lesserArtSupplies == 0) {
                    orphanagepackage.setNumberOfArtSupplies(artSupplies - approvedArtSupplies);
                }
                if (lesserMasks == 0) {
                    orphanagepackage.setNumberOfMasks(masks - approvedMasks);
                }
            }
            populateTable();
            request.setStatus("completed");
        }
        JText1.setText("");
        JText2.setText("");
        JText3.setText("");
        JText4.setText("");
        JText5.setText("");
    }//GEN-LAST:event_processJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel17MouseClicked

    private void JText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText1ActionPerformed

    private void JText5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText5ActionPerformed

    private void JText2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JText2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JText2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JText1;
    private javax.swing.JTextField JText2;
    private javax.swing.JTextField JText3;
    private javax.swing.JTextField JText4;
    private javax.swing.JTextField JText5;
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable packageJTable;
    private javax.swing.JButton processJButton;
    // End of variables declaration//GEN-END:variables
}
