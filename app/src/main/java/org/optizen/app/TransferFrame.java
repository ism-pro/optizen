/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.awt.Dialog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import org.optizen.model.ResultSetTableModel;
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

    LoadingFrame loadingFrame;

    /**
     * Creates new form TransferFrame
     */
    public TransferFrame() {
        initComponents();
        refreshTableTr();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTr = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnSendToDatabase = new javax.swing.JButton();
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

        tableTr.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableTr);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1006, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
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

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendToDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSendToDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1008, Short.MAX_VALUE)
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
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refreshTableTr();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnSendToDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToDatabaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendToDatabaseActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

        // Remove existing rows
        DefaultTableModel tm = (DefaultTableModel) tableData.getModel();
        tm.getDataVector().removeAllElements();
        tm.fireTableDataChanged();

        search.setEnabled(false);
        moveToTr.setEnabled(false);

        WorkOnSearching wons = new WorkOnSearching();
        wons.execute();

        //This is what's called in the .execute method
        loadingFrame = new LoadingFrame(null, "", Dialog.ModalityType.MODELESS);
        loadingFrame.setLocationRelativeTo(this);
        loadingFrame.setVisible(true);

        search.setEnabled(true);
        moveToTr.setEnabled(true);


    }//GEN-LAST:event_searchActionPerformed

    private void moveToTrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveToTrActionPerformed

        // Vérifie que des données sont disponible pour le transfere
        if (tableData.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Aucune données à placer dans la table TR !\nExécuter une recherche ...",
                    "Envoyer en table TR : pas de données à transférer",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Informe sur la suppression de donnée en table TR si des données sont existante
        if (tableTr.getRowCount() > 0) {
            int result = JOptionPane.showConfirmDialog(this,
                    "Des données sont disponible dans la base TR ! En poursuivant, vous allez les perdres.\n"
                    + "Voulez-vous continuer ?",
                    "Rafraîchir : confirmer les données perdu",
                    JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_CANCEL_OPTION) {
                refreshTableTr();
                return;
            }
        }

        search.setEnabled(false);
        moveToTr.setEnabled(false);

        WorkOnMoveToTr wonm = new WorkOnMoveToTr();
        wonm.execute();

        //This is what's called in the .execute method
        loadingFrame = new LoadingFrame(null, "", Dialog.ModalityType.MODELESS);
        loadingFrame.setLocationRelativeTo(this);
        loadingFrame.setVisible(true);

        search.setEnabled(true);
        moveToTr.setEnabled(true);
    }//GEN-LAST:event_moveToTrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSendToDatabase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JButton moveToTr;
    private javax.swing.JButton search;
    private javax.swing.JTable tableData;
    private javax.swing.JTable tableTr;
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

    /**
     * Refresh the table tr to see current content
     */
    private void refreshTableTr() {
        try {
            ResultSetTableModel tm = new ResultSetTableModel(
                    DatabaseFrame.loadConnectionOptimaint(),
                    "SELECT * FROM TR_CPT_MVTS"
            );
            tableTr.setModel(tm);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(TransferFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This class searching available data from zenon to be import to optimaint
     * This is process in background.
     */
    public class WorkOnSearching extends SwingWorker<String, String> {

        @Override
        protected String doInBackground() throws Exception {

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

                loadingFrame.onInit();
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
                    loadingFrame.sub(0);
                    int subs = 0;
                    while (zenResult.next()) {
                        String value = zenResult.getObject(1).toString();
                        String dateMvt = zenResult.getObject(2).toString();

                        Object[] rowObject = new Object[]{
                            tableData.getRowCount() + 1, company, link.getEquEquipement(), link.getUnite(),
                            link.getOrgOrgane(), value, dateMvt, "MPRV", "", "", "", "", 0
                        };
                        tm.addRow(rowObject);
                        Integer subValue = (100 * (subs + 1)) / size;
                        loadingFrame.sub(subValue);
                        subs++;
                    }
                    Integer mainValue = (100 * (count + 1)) / counter;
                    loadingFrame.main(mainValue);
                    Thread.sleep(5);
                }
                tableData.setModel(tm);
                loadingFrame.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TransferFrame.class.getName()).log(Level.SEVERE, null, ex);
                loadingFrame.setVisible(false);
            }
            loadingFrame.setVisible(false);
            return null;
        }

        @Override
        protected void process(List<String> item) {
            //This updates the UI
            //textArea.append(item + "\n");
        }
    }

    public class WorkOnMoveToTr extends SwingWorker<String, String> {

        @Override
        protected String doInBackground() {

            try {
                // Suppression du contenu de la table
                ResultSetTableModel tm = (ResultSetTableModel) tableTr.getModel();
                tm.setQueryDeleteOnAllRow("TR_CPT_MVTS");

                // Démarrage du transfer
                DefaultTableModel tmd = (DefaultTableModel) tableData.getModel();
                // Prepare the statement
                Connection conn = DatabaseFrame.loadConnectionOptimaint();
                Statement state = conn.createStatement();
                loadingFrame.onInit();
                loadingFrame.sub(100);
                Integer rowCount = tableData.getRowCount();
                for (int row = 0; row < rowCount; row++) {
                    Vector v = (Vector) tmd.getDataVector().elementAt(row);
                    ArrayList<Object> rowObject = new ArrayList<>();
                    for (int i = 0; i < v.capacity(); i++) {
                        rowObject.add(v.elementAt(i));
                    }
                    tm.setQueryInsert("", rowObject);

                    // Create insert query
                    String sql = "INSERT INTO TR_CPT_MVTS values (";
                    for (int i = 0; i < rowObject.size(); i++) {
                        if (i != 0) {
                            sql += ",";
                        }
                        sql += rowObject.toString();
                    }
                    sql += ")";

                    state.execute(sql);
                    loadingFrame.main((100 * (row + 1)) / rowCount);
                }
                loadingFrame.onFinish();
                loadingFrame.setVisible(false);
                return null;
            } catch (SQLException ex) {
                Logger.getLogger(TransferFrame.class.getName()).log(Level.SEVERE, null, ex);
                loadingFrame.onFinish();
                loadingFrame.setVisible(false);
                return null;
            }
        }

        @Override
        protected void process(List<String> item
        ) {
            //This updates the UI
            //textArea.append(item + "\n");
        }
    }

}
