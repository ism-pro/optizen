/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.optizen.util.DateUtil;
import org.optizen.util.Settings;
import org.optizen.util.Util;
import org.optizen.util.model.LinkModel;

/**
 *
 * @author r.hendrick
 */
public class TransferFrame extends javax.swing.JInternalFrame implements InternalFrameListener {

    /**
     * Counter frame allow to count the frame
     */
    static Integer openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    /**
     * Creates new form TransferFrame
     */
    public TransferFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        search = new javax.swing.JButton();
        moveToTr = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnSendToDatabase = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        subProgress = new javax.swing.JProgressBar();
        mainProgress = new javax.swing.JProgressBar();
        jSeparator1 = new javax.swing.JSeparator();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Transférer");
        setToolTipText("Permet de transférer les données en base opérationnelle optimaint");
        setFrameIcon(Ico.i16("/img/oz/transfer.png"));
        setPreferredSize(new java.awt.Dimension(1024, 840));

        jSplitPane1.setDividerLocation(375);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel1.setPreferredSize(new java.awt.Dimension(1022, 400));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TRCPT_ID", "TRCPT_SOCIETE", "TRCPT_EQUIPEMENT", "TRCPT_UNITE", "TRCPT_ORGANE", "TRCPT_VALEUR", "TRCPT_DATE_MVT", "TRCPT_INTERVENANT", "TRCPT_MESSAGE", "TRCPT_DATE_CREATION", "TRCPT_DATE_MOD", "TRCPT_CHRONO", "TRCPT_SITUATION"
            }
        ));
        jScrollPane1.setViewportView(tableData);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(1062, 34));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 2, 5));

        search.setIcon(Ico.i16("/img/oz/search.png")
        );
        search.setText("Chercher...");
        search.setToolTipText("Chercher les données disponibles pour transérer dans la bse optimaint");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel3.add(search);

        moveToTr.setIcon(Ico.i16("/img/oz/db_update.png")
        );
        moveToTr.setText("Envoyer en table TR");
        moveToTr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveToTrActionPerformed(evt);
            }
        });
        jPanel3.add(moveToTr);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jSplitPane1.setTopComponent(jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1006, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(jPanel2);

        jPanel4.setMinimumSize(new java.awt.Dimension(485, 46));
        jPanel4.setPreferredSize(new java.awt.Dimension(949, 46));

        btnCancel.setIcon(Ico.i32("/img/oz/cancel.png"));
        btnCancel.setText("ANNULER");
        btnCancel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancel.setMaximumSize(null);
        btnCancel.setMinimumSize(null);
        btnCancel.setPreferredSize(null);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(Ico.i32("/img/oz/refresh.png"));
        btnRefresh.setText("Rafraîchir");
        btnRefresh.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRefresh.setMaximumSize(new java.awt.Dimension(3200, 3200));
        btnRefresh.setMinimumSize(new java.awt.Dimension(0, 36));
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnSendToDatabase.setIcon(Ico.i32("/img/oz/transfer.png"));
        btnSendToDatabase.setText("Envoyer en base Optimaint");
        btnSendToDatabase.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSendToDatabase.setMaximumSize(new java.awt.Dimension(3200, 3200));
        btnSendToDatabase.setMinimumSize(new java.awt.Dimension(0, 36));
        btnSendToDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToDatabaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(subProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendToDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSendToDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
//        // TODO add your handling code here:
//        int result = JOptionPane.showConfirmDialog(this, "Les données non sauvées vont être perdu si vous continuer, voulez-vous sauvegarder d'abord ?",
//            "Rafraîchir : confirmer les données perdu",
//            JOptionPane.OK_CANCEL_OPTION);
//        if (result == JOptionPane.OK_CANCEL_OPTION) {
//            return;
//        }
//        clearAndLoadSavedLink();
//        JOptionPane.showMessageDialog(this,
//            "Rafraîchissement terminé !",
//            "Rafraîchir : fin", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSendToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToDatabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendToDatabaseActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        new WorkOnSearching().execute();

    }//GEN-LAST:event_searchActionPerformed

    private void moveToTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveToTrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_moveToTrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSendToDatabase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JProgressBar mainProgress;
    private javax.swing.JButton moveToTr;
    private javax.swing.JButton search;
    private javax.swing.JProgressBar subProgress;
    private javax.swing.JTable tableData;
    // End of variables declaration//GEN-END:variables
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + Logger.getLogger(Util.class
                .getName()).getResourceBundleName() + " : internalFrameOpened() >> ";
        System.out.println(methodName + "internalFrameOpened !");
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        String methodName = getClass().getSimpleName() + " : internalFrameClosing() >> ";
        Util.out(methodName + "internal Frame Is Closing !");

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

    public class WorkOnSearching extends SwingWorker<String, String> {

        @Override
        protected String doInBackground() throws Exception {
            //This is what's called in the .execute method
            try {
                // Remove all the specify row
                DefaultTableModel tm = (DefaultTableModel) tableData.getModel();

                // Load from file
                Object obj = Settings.read(Settings.LINK_LINK, Settings.COUNTER);
                Integer counter = Integer.valueOf(obj == null ? "0" : obj.toString());
                String company = Settings.read(Settings.CONFIG, Settings.COMPANY).toString();

                // Loop over available link
                Connection zenConn = DatabaseFrame.loadConnectionZenon();
                Statement zenState = zenConn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                Connection optConn = DatabaseFrame.loadConnectionOptimaint();
                Statement optiState = optConn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                mainProgress.setValue(0);
                subProgress.setValue(0);
                for (int count = 0; count < counter; count++) {
                    // Gett link from settings
                    LinkModel link = Settings.readLinkModel(count);

                    // Get last record from optimaint for this link
                    String qLastOptiRecord
                            = "SELECT TOP 1  CMV_DATE_MVT "
                            + "FROM Optimaint.dbo.COMPTEURS_MVTS "
                            + "WHERE CMV_SOCIETE = '%s' AND CMV_EQUIPEMENT='%s' AND CMV_ORGANE='%s' AND CMV_UNITE='%s' "
                            + "ORDER BY CMV_DATE_MVT DESC";
                    qLastOptiRecord = String.format(qLastOptiRecord,
                            company,
                            link.getEquEquipement(),
                            link.getOrgOrgane(),
                            link.getUnite());
                    //Util.out("QLastOptiRecord : " + qLastOptiRecord);

                    String lastOptiDateTime = "2000-01-01";

                    //L'objet ResultSet contient le résultat de la requête SQL
                    ResultSet optiResult = optiState.executeQuery(qLastOptiRecord);
                    if (optiResult.next()) { // Date déjà existante
                        lastOptiDateTime = optiResult.getObject(1).toString();
                    }

                    // Recherche les données après la date enregistrée dans zenon
                    //
                    //link.getVariable();
                    String queryDatas
                            = "SELECT \"VALUE\", DATEADD (second , TIMESTAMP_S , '1970-01-01' ) AS CPT_DATE_MVT "
                            + "FROM %s "
                            + "WHERE \"VARIABLE\"='%s' AND TIMESTAMP_S > cast(DATEDIFF(s, '1970-01-01 00:00:00.000', '%s' ) as bigint) "
                            + "ORDER BY TIMESTAMP_S DESC";
                    queryDatas = String.format(queryDatas,
                            link.getTable(),
                            link.getVariable(),
                            lastOptiDateTime);
                    //Util.out("Query Datas : " + queryDatas);

                    ResultSet zenResult = zenState.executeQuery(queryDatas);

                    zenResult.last();
                    int size = zenResult.getRow();
                    zenResult.beforeFirst();
                    subProgress.setValue(0);
                    int subs = 0;
                    while (zenResult.next()) {
                        String value = zenResult.getObject(1).toString();
                        String dateMvt = zenResult.getObject(2).toString();

                        Object[] rowObject = new Object[]{
                            tableData.getRowCount() + 1, company, link.getEquEquipement(), link.getUnite(),
                            link.getOrgOrgane(), value, dateMvt, "MPRV", "", "", "", "", 0
                        };
                        tm.addRow(rowObject);
                        subProgress.setValue((100 * (subs + 1)) / size);
                        subs++;
                    }
                    mainProgress.setValue((100 *(count + 1)) / counter);
                    Thread.sleep(5);
                }
                tableData.setModel(tm);
            } catch (SQLException ex) {
                Logger.getLogger(TransferFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            return null;
        }

        @Override
        protected void process(List<String> item) {
            //This updates the UI
            //textArea.append(item + "\n");
        }
    }
}