/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.ini4j.Wini;
import org.optizen.listeners.DatabaseFrameListener;
import org.optizen.model.DatabaseModel;
import org.optizen.model.TableParamDataModel;
import org.optizen.util.Settings;
import org.optizen.util.Util;

/**
 *
 * @author r.hendrick
 */
public class ConfigFrame extends javax.swing.JInternalFrame implements InternalFrameListener, DatabaseFrameListener {

    /**
     * Counter frame allow to count the frame
     */
    static Integer openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    /**
     *
     */
    DatabaseFrame dbf = null;

    /**
     * Creates new form ConfigFrame
     */
    public ConfigFrame() {
        initComponents();

        // Read company
        String company = Settings.read(Settings.CONFIG, Settings.COMPANY).toString();
        tfCompany.setText(company);

        // Read GMT
        Object o = Settings.read(Settings.CONFIG, Settings.GMT);
        Integer gmt = 0;
        if (o != null) {
            gmt = Integer.valueOf(o.toString());
        }
        fillGMT();
        cbGMT.setSelectedIndex(gmt);

        // Read saved data
        String urlOpti = Settings.read(Settings.CONFIG, Settings.URL_OPTI).toString();//"jdbc:sqlserver:10.116.26.35\\SQLSERVER:1433;databaseName=optimaint?sa?Opt!M@!nt";
        String urlZen = Settings.read(Settings.CONFIG, Settings.URL_ZEN).toString();//"jdbc:sqlserver:10.243.59.27\\SQLSERVER;databaseName=scada?sa?s@z3non";
        schemaOpti.setText(urlOpti);
        schemaZen.setText(urlZen);

        // Init table model
        Integer counter = Integer.valueOf(Settings.read(Settings.LINK_ZEN, Settings.COUNTER).toString());
        TableParamDataModel tm = new TableParamDataModel();
        for (int count = 0; count < counter; count++) {
            String param = Settings.read(Settings.LINK_ZEN + "\\" + count, "param").toString();
            String data = Settings.read(Settings.LINK_ZEN + "\\" + count, "data").toString();
            tm.addRow(param, data);
        }
        tableLink.setModel(tm);

        // 
        this.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        openFrameCount++; // increment configFrame counter

        this.setClosable(true);
        addInternalFrameListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tableLinkPopupMenu = new javax.swing.JPopupMenu();
        menuItemPopupDelete = new javax.swing.JMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfCompany = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbGMT = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnDBConnectOpti = new javax.swing.JButton();
        schemaOpti = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        schemaZen = new javax.swing.JTextField();
        btnDBConnectZen = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        cbTableParam = new javax.swing.JComboBox<>();
        btnAddLink = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbTableData = new javax.swing.JComboBox<>();
        btnUpdateLink = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLink = new javax.swing.JTable();
        btnDelLink = new javax.swing.JButton();
        btnCancelConfig = new javax.swing.JButton();
        btnSaveConfig = new javax.swing.JButton();

        menuItemPopupDelete.setIcon(Ico.i16("/img/std/Delete.png")
        );
        menuItemPopupDelete.setText("Supprimer la sélection");
        menuItemPopupDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPopupDeleteActionPerformed(evt);
            }
        });
        tableLinkPopupMenu.add(menuItemPopupDelete);

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("bundles/Fr_fr"); // NOI18N
        setTitle(bundle.getString("ConfigFrameTitle")); // NOI18N
        setToolTipText("Fenêtre des configurations");
        setFrameIcon(Ico.i16("/img/oz/config.png"));
        setPreferredSize(new java.awt.Dimension(800, 480));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(bundle.getString("ConfigFrameField_companyCode")); // NOI18N

        tfCompany.setText("11");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("GMT");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbGMT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbGMT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(314, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(bundle.getString("ConfigFrameField_company"), jPanel1); // NOI18N

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText(bundle.getString("ConfigFrameField_dbSchemaOptimaint")); // NOI18N

        btnDBConnectOpti.setText(bundle.getString("BtnField_Edit")); // NOI18N
        btnDBConnectOpti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBConnectOptiActionPerformed(evt);
            }
        });

        schemaOpti.setText("jdbc:sqlserver://10.116.26.35\\SQLSERVER:1433;databaseName=optimaint");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText(bundle.getString("ConfigFrameField_dbSchemaZenon")); // NOI18N

        schemaZen.setText("jdbc:sqlserver://10.243.59.27\\SQLSERVER;databaseName=scada");

        btnDBConnectZen.setText(bundle.getString("BtnField_Edit")); // NOI18N
        btnDBConnectZen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDBConnectZenActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText(bundle.getString("ConfigFrameField_dbTableVariable")); // NOI18N

        btnAddLink.setIcon(Ico.i32("/img/oz/db_update.png"));
        btnAddLink.setToolTipText("Lier la table variable à celle des données");
        btnAddLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddLinkActionPerformed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText(bundle.getString("ConfigFrameField_dbTableData")); // NOI18N

        btnUpdateLink.setIcon(Ico.i32("/img/oz/refresh.png"));
        btnUpdateLink.setToolTipText(bundle.getString("BtnField_Refresh")); // NOI18N
        btnUpdateLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateLinkActionPerformed(evt);
            }
        });

        tableLink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Designation table des variables", "Designation table données"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableLink);

        btnDelLink.setIcon(Ico.i32("/img/oz/db_comit.png"));
        btnDelLink.setToolTipText("Supprimer le lien sélectionner dans la table");
        btnDelLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelLinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnUpdateLink, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTableParam, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTableData, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddLink, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelLink, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(schemaOpti, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDBConnectOpti))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(schemaZen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDBConnectZen)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnDBConnectOpti)
                    .addComponent(schemaOpti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnDBConnectZen)
                    .addComponent(schemaZen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cbTableParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbTableData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnUpdateLink, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnAddLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDelLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab(bundle.getString("ConfigFrameField_database"), jPanel2); // NOI18N

        btnCancelConfig.setIcon(Ico.i32("/img/oz/cancel.png"));
        btnCancelConfig.setText(bundle.getString("BtnField_Cancel")); // NOI18N
        btnCancelConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelConfigActionPerformed(evt);
            }
        });

        btnSaveConfig.setIcon(Ico.i32("/img/oz/save.png"));
        btnSaveConfig.setText(bundle.getString("BtnField_Save")); // NOI18N
        btnSaveConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSaveConfig)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelConfig)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelConfig)
                    .addComponent(btnSaveConfig))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDBConnectOptiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBConnectOptiActionPerformed
        if (dbf == null) {
            dbf = new DatabaseFrame(null, false);
            dbf.addListener(this);
        }
        dbf.setLocationRelativeTo(this);
        dbf.setModel(DatabaseModel.parse(schemaOpti.getText()));
        dbf.setSchemaReceiver(schemaOpti);
        dbf.setVisible(true);

    }//GEN-LAST:event_btnDBConnectOptiActionPerformed

    private void btnDBConnectZenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDBConnectZenActionPerformed
        if (dbf == null) {
            dbf = new DatabaseFrame(null, false);
            dbf.addListener(this);
        }
        dbf.setLocationRelativeTo(this);
        dbf.setModel(DatabaseModel.parse(schemaZen.getText()));
        dbf.setSchemaReceiver(schemaZen);
        dbf.setVisible(true);
    }//GEN-LAST:event_btnDBConnectZenActionPerformed

    private void btnUpdateLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateLinkActionPerformed
        // Init the content
        Connection conn = DatabaseFrame.loadConnection(DatabaseModel.parse(schemaZen.getText()));
        if (conn != null) {
            try {
                ArrayList<String> l = new ArrayList<>();
                DatabaseMetaData md = conn.getMetaData();
                ResultSet rs = md.getTables(null, null, null, new String[]{"TABLE"});
                while (rs.next()) {
                    String t = rs.getString(3);
                    System.out.println(t);
                    l.add(t);
                }
                DefaultComboBoxModel cbModelParam = new javax.swing.DefaultComboBoxModel<>(l.toArray());
                DefaultComboBoxModel cbModelData = new javax.swing.DefaultComboBoxModel<>(l.toArray());
                cbTableParam.setModel(cbModelParam);
                cbTableData.setModel(cbModelData);

            } catch (SQLException ex) {
                Logger.getLogger(ConfigFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Actualisation des données terminée", "Mise à jour des tables zenon", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Impossible de rafraichir les données du schéma ZENON \n" + DatabaseFrame.queryLastError,
                    "Mise à jour des tables zenon", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateLinkActionPerformed

    private void btnAddLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddLinkActionPerformed
        TableParamDataModel tm = (TableParamDataModel) tableLink.getModel();
        tm.addRow(cbTableParam.getSelectedItem().toString(), cbTableData.getSelectedItem().toString());
    }//GEN-LAST:event_btnAddLinkActionPerformed

    private void btnSaveConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveConfigActionPerformed
        // TODO add your handling code here:
        try {
            Wini ini = new Wini(new File(Settings.iniFilename));
            ini.put(Settings.CONFIG, Settings.COMPANY, tfCompany.getText());
            ini.put(Settings.CONFIG, Settings.GMT, cbGMT.getSelectedIndex());

            ini.put(Settings.CONFIG, Settings.URL_OPTI, schemaOpti.getText());
            ini.put(Settings.CONFIG, Settings.URL_ZEN, schemaZen.getText());

            // Clean previous table 
            Integer counter = Integer.valueOf(Settings.read(Settings.LINK_ZEN, Settings.COUNTER).toString());
            for (int count = 0; count < counter; count++) {
                ini.remove(Settings.LINK_ZEN + "\\" + count);
            }

            TableParamDataModel tm = (TableParamDataModel) tableLink.getModel();
            ini.put(Settings.LINK_ZEN, Settings.COUNTER, tm.getRowCount());
            for (int row = 0; row < tm.getRowCount(); row++) {
                ini.add(Settings.LINK_ZEN + "\\" + row + "\\param");
                ini.add(Settings.LINK_ZEN + "\\" + row + "\\data");

                Wini.Section root = ini.get(Settings.LINK_ZEN);
                Wini.Section sec = root.lookup("" + row);
                sec.add("param", tm.getValueAt(row, 1).toString());
                sec.add("data", tm.getValueAt(row, 2).toString());

                //ini.put(Settings.LINK_ZEN, ""+row , tm.getValueAt(row, 1).toString() + " + " + tm.getValueAt(row, 2));
            }
            ini.store();
            JOptionPane.showMessageDialog(this, "Sauvegarde terminée avec succès", "Sauvegarde", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveConfigActionPerformed

    private void btnDelLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelLinkActionPerformed
        TableParamDataModel tm = (TableParamDataModel) tableLink.getModel();
        tm.removeRow(tableLink.getSelectedRow());
    }//GEN-LAST:event_btnDelLinkActionPerformed

    private void btnCancelConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelConfigActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_btnCancelConfigActionPerformed

    private void menuItemPopupDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPopupDeleteActionPerformed
        // TODO add your handling code here:
        int[] rows = tableLink.getSelectedRows();
        // Remove all the specify row
        DefaultTableModel tm = (DefaultTableModel) tableLink.getModel();
        for (int row = rows.length - 1; row >= 0; row--) {
            tm.removeRow(rows[row]);
        }

        for (int row = 0; row < tableLink.getRowCount(); row++) {
            tm.setValueAt(row + 1, row, 0);
        }
    }//GEN-LAST:event_menuItemPopupDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddLink;
    private javax.swing.JButton btnCancelConfig;
    private javax.swing.JButton btnDBConnectOpti;
    private javax.swing.JButton btnDBConnectZen;
    private javax.swing.JButton btnDelLink;
    private javax.swing.JButton btnSaveConfig;
    private javax.swing.JButton btnUpdateLink;
    private javax.swing.JComboBox<String> cbGMT;
    private javax.swing.JComboBox<String> cbTableData;
    private javax.swing.JComboBox<String> cbTableParam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem menuItemPopupDelete;
    private javax.swing.JTextField schemaOpti;
    private javax.swing.JTextField schemaZen;
    private javax.swing.JTable tableLink;
    private javax.swing.JPopupMenu tableLinkPopupMenu;
    private javax.swing.JTextField tfCompany;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameOpened() >> ";
        System.out.println(methodName + "internalFrameOpened !");
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameClosing() >> ";
        System.out.println(methodName + "internalFrameClosing !");
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameClosed() >> ";
        System.out.println(methodName + "internalFrameClosed !");
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameIconified() >> ";
        System.out.println(methodName + "internalFrameIconified !");
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameDeiconified() >> ";
        System.out.println(methodName + "internalFrameDeiconified !");
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameActivated() >> ";
        System.out.println(methodName + "internalFrameActivated !");
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameDeactivated() >> ";
        System.out.println(methodName + "internalFrameDeactivated !");
    }

    @Override
    public void databaseFrameEventValidate(DatabaseModel model) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : databaseFrameEventValidate() >> ";
        System.out.println(methodName + "databaseFrameEventValidate !");
        //schemaOpti.setText(DatabaseModel.unparse(model));
    }

    @Override
    public void databaseFrameEventCancel(DatabaseModel model) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : databaseFrameEventCancel() >> ";
        System.out.println(methodName + "databaseFrameEventCancel !");
    }

    private void fillGMT() {
        List<String> l = orderTimeZones();
        for (String s : l) {
            cbGMT.addItem(s);
        }
    }

    private static List<String> orderTimeZones() {
        List<String> tzs = timeZones();
        Collections.sort(tzs);
        return tzs;
    }

    private static List<String> timeZones() {
        List<String> tzs = new ArrayList<>();
        String[] ids = TimeZone.getAvailableIDs();
        for (String id : ids) {
            tzs.add(displayTimeZone(TimeZone.getTimeZone(id)));
        }
        return tzs;
    }

    private static String displayTimeZone(TimeZone tz) {

        long hours = TimeUnit.MILLISECONDS.toHours(tz.getRawOffset());
        long minutes = TimeUnit.MILLISECONDS.toMinutes(tz.getRawOffset()) - TimeUnit.HOURS.toMinutes(hours);
        // avoid -4:-30 issue
        minutes = Math.abs(minutes);

        String result = "";
        if (hours >= 0) {
            result = String.format("[GMT]+[%02d:%02d] \t %s", hours, minutes, tz.getID());
        } else {
            result = String.format("[GMT]-[%02d:%02d] \t %s", hours, minutes, tz.getID());
        }

        return result;

    }

    /**
     * Get part hour from a display time zone
     *
     * @param timeZone is like [GMT]+[%02d:%02d] \t %s or like [GMT]-[%02d:%02d]
     * \t %s
     * @return
     */
    public static Integer hourFromDisplayTimeZone(String timeZone) {
        if (timeZone == null) {
            return 0;
        }
        if (timeZone.isEmpty()) {
            return 0;
        }
        String clean = timeZone.replace("[GMT]", "").split("\t")[0].replace("+", "").replace("-", "").replace("[", "").replace("]", "");
        String[] a = clean.split(":");
        if (a.length >= 1) {
            return Integer.valueOf(a[0]);
        }
        return 0;
    }

    /**
     * Get part hour from a display time zone
     *
     * @param timeZone is like [GMT]+[%02d:%02d] \t %s or like [GMT]-[%02d:%02d]
     * \t %s
     * @return
     */
    public static Integer minFromDisplayTimeZone(String timeZone) {
        if (timeZone == null) {
            return 0;
        }
        if (timeZone.isEmpty()) {
            return 0;
        }
        String clean = timeZone.replace("[GMT]", "").split("\t")[0].replace("+", "").replace("-", "").replace("[", "").replace("]", "");
        String[] a = clean.split(":");
        if (a.length >= 2) {
            return Integer.valueOf(a[1]);
        }
        return 0;
    }

    public static Integer hourAtOrderTimeZonePosition(Integer position) {
        return hourFromDisplayTimeZone(orderTimeZones().get(position));
    }

    public static Integer minAtOrderTimeZonePosition(Integer position) {
        return minFromDisplayTimeZone(orderTimeZones().get(position));
    }

    /**
     * HTZ hours of time zone saved
     *
     * @return hours of time zone save in config
     */
    public static Integer hTZ() {
        Object o = Settings.read(Settings.CONFIG, Settings.GMT);
        Integer gmt = 0;
        if (o != null) {
            gmt = Integer.valueOf(o.toString());
        }
        return hourAtOrderTimeZonePosition(gmt);
    }

    /**
     * MTZ minute of time zone saved
     *
     * @return minute of time zone saved in config
     */
    public static Integer mTZ() {
        Object o = Settings.read(Settings.CONFIG, Settings.GMT);
        Integer gmt = 0;
        if (o != null) {
            gmt = Integer.valueOf(o.toString());
        }
        return minAtOrderTimeZonePosition(gmt);
    }
    
    /**
     * STZ secode corresponding of time zone saved mean combination of hour and minute
     * @return 
     */
    public static Integer sTZ(){
        return (hTZ()*3600)+(mTZ()*60);
    }

}
