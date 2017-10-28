/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.WindowConstants;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import org.optizen.util.Settings;
import org.optizen.util.Util;

/**
 *
 * @author r.hendrick
 */
public class LinkFrame extends javax.swing.JInternalFrame implements InternalFrameListener {

    /**
     * Counter frame allow to count the frame
     */
    static Integer openFrameCount = 0;
    static final int xOffset = 30, yOffset = 30;

    /**
     * Creates new form LinkFrame
     */
    public LinkFrame() {
        initComponents();
        
        // Initialisation des tables disponibles
        DefaultComboBoxModel cbModelDataZen = new javax.swing.DefaultComboBoxModel<>(Settings.zenTableData().toArray());
        cbFilterTableZen.setModel(cbModelDataZen);
        
        // Chargement des données de la table zenon
        
        
        
        
        // Register Internal frame
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainSplitPane = new javax.swing.JSplitPane();
        counterPane = new javax.swing.JPanel();
        subSplitPaneCounter = new javax.swing.JSplitPane();
        zenPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfFilterVariable = new javax.swing.JTextField();
        tfFilterNames = new javax.swing.JTextField();
        cbFilterTableZen = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableZen = new javax.swing.JTable();
        tfSetZen = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        optiPane = new javax.swing.JPanel();
        tfFilterEquCode = new javax.swing.JTextField();
        tfFilterEqui = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfFilterOrgCode = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfFilterOrg = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfFilterUnite = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableOpti = new javax.swing.JTable();
        tfSetOpti = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        LinkPane = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLink = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Correspondance des données");
        setToolTipText("Cette fenêtre vous permet d'établir des liaisons entre les données");
        setFrameIcon(Ico.i16("/img/admin/smq_nc_actions.png"));
        setPreferredSize(new java.awt.Dimension(1024, 680));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        mainSplitPane.setDividerLocation(300);
        mainSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        counterPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Compteurs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(102, 102, 255))); // NOI18N

        subSplitPaneCounter.setDividerLocation(350);
        subSplitPaneCounter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        zenPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ZENON", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 102, 51))); // NOI18N
        zenPane.setPreferredSize(new java.awt.Dimension(350, 335));

        jLabel1.setText("VARIABLES");

        jLabel2.setText("VARIABLES");

        tableZen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "Variable", "Name", "GUID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableZen);
        if (tableZen.getColumnModel().getColumnCount() > 0) {
            tableZen.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableZen.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableZen.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        tfSetZen.setEditable(false);

        jLabel8.setText("Set");

        javax.swing.GroupLayout zenPaneLayout = new javax.swing.GroupLayout(zenPane);
        zenPane.setLayout(zenPaneLayout);
        zenPaneLayout.setHorizontalGroup(
            zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zenPaneLayout.createSequentialGroup()
                .addGroup(zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfFilterVariable)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(zenPaneLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(197, Short.MAX_VALUE))
                    .addComponent(tfFilterNames)))
            .addComponent(cbFilterTableZen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zenPaneLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSetZen))
        );
        zenPaneLayout.setVerticalGroup(
            zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zenPaneLayout.createSequentialGroup()
                .addGroup(zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFilterVariable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFilterNames, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFilterTableZen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(zenPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSetZen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)))
        );

        subSplitPaneCounter.setLeftComponent(zenPane);

        optiPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "OPTIMAINT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 51, 51))); // NOI18N

        jLabel3.setText("Code EQU.");

        jLabel4.setText("EQUIPEMENT");

        jLabel5.setText("Code Organe");

        jLabel6.setText("ORGANE");

        jLabel7.setText("UNITE");

        tableOpti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "CPT_EQUIPEMENT", "EQU_DESIGNATION", "CPT_ORGANE", "ORG_DESIGNATION", "CPT_UNITE", "CPT_COMMENTAIRE", "CPT_SOCIETE"
            }
        ));
        jScrollPane2.setViewportView(tableOpti);
        if (tableOpti.getColumnModel().getColumnCount() > 0) {
            tableOpti.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableOpti.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableOpti.getColumnModel().getColumn(3).setPreferredWidth(20);
            tableOpti.getColumnModel().getColumn(5).setPreferredWidth(20);
            tableOpti.getColumnModel().getColumn(7).setPreferredWidth(20);
        }

        tfSetOpti.setEditable(false);

        jLabel9.setText("Set");

        javax.swing.GroupLayout optiPaneLayout = new javax.swing.GroupLayout(optiPane);
        optiPane.setLayout(optiPaneLayout);
        optiPaneLayout.setHorizontalGroup(
            optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optiPaneLayout.createSequentialGroup()
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfFilterEquCode)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFilterEqui)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFilterOrgCode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfFilterOrg)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfFilterUnite, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
            .addGroup(optiPaneLayout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSetOpti))
        );
        optiPaneLayout.setVerticalGroup(
            optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optiPaneLayout.createSequentialGroup()
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(optiPaneLayout.createSequentialGroup()
                        .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFilterOrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFilterUnite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFilterOrgCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(optiPaneLayout.createSequentialGroup()
                        .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfFilterEquCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfFilterEqui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSetOpti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)))
        );

        subSplitPaneCounter.setRightComponent(optiPane);

        javax.swing.GroupLayout counterPaneLayout = new javax.swing.GroupLayout(counterPane);
        counterPane.setLayout(counterPaneLayout);
        counterPaneLayout.setHorizontalGroup(
            counterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subSplitPaneCounter, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        counterPaneLayout.setVerticalGroup(
            counterPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(subSplitPaneCounter, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
        );

        mainSplitPane.setTopComponent(counterPane);

        LinkPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Correspondance Existantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 153, 0))); // NOI18N

        tableLink.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "TABLE", "VARIABLE", "NOM", "CODE EQU.", "EQUIPEMENT", "CODE ORG.", "ORGANE", "UNITE", "COMMENTAIRES", "DATE MODIF."
            }
        ));
        jScrollPane3.setViewportView(tableLink);
        if (tableLink.getColumnModel().getColumnCount() > 0) {
            tableLink.getColumnModel().getColumn(0).setPreferredWidth(20);
            tableLink.getColumnModel().getColumn(1).setPreferredWidth(20);
            tableLink.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        javax.swing.GroupLayout LinkPaneLayout = new javax.swing.GroupLayout(LinkPane);
        LinkPane.setLayout(LinkPaneLayout);
        LinkPaneLayout.setHorizontalGroup(
            LinkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE)
        );
        LinkPaneLayout.setVerticalGroup(
            LinkPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
        );

        mainSplitPane.setRightComponent(LinkPane);

        jPanel4.setMinimumSize(new java.awt.Dimension(485, 46));
        jPanel4.setPreferredSize(new java.awt.Dimension(949, 46));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 2));

        jButton1.setIcon(Ico.i32("/img/std/ExtXLSX.png"));
        jButton1.setText("EXPORTER");
        jButton1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton1.setMaximumSize(null);
        jButton1.setMinimumSize(null);
        jButton1.setPreferredSize(null);
        jPanel4.add(jButton1);

        jButton2.setIcon(Ico.i32("/img/std/ExtXLSX.png"));
        jButton2.setText("IMPORTER");
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.setMaximumSize(null);
        jButton2.setMinimumSize(null);
        jButton2.setPreferredSize(null);
        jPanel4.add(jButton2);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator3.setPreferredSize(new java.awt.Dimension(3, 36));
        jPanel4.add(jSeparator3);

        jButton4.setIcon(Ico.i32("/img/std/Connect.png")
        );
        jButton4.setText("LIER");
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.setMaximumSize(null);
        jButton4.setMinimumSize(null);
        jButton4.setPreferredSize(null);
        jPanel4.add(jButton4);

        jButton3.setIcon(Ico.i32("/img/std/Refresh.png"));
        jButton3.setText("RAFRAICHIR");
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.setMaximumSize(new java.awt.Dimension(3200, 3200));
        jButton3.setMinimumSize(new java.awt.Dimension(0, 36));
        jButton3.setPreferredSize(null);
        jPanel4.add(jButton3);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setPreferredSize(new java.awt.Dimension(3, 36));
        jPanel4.add(jSeparator2);

        jButton6.setIcon(Ico.i32("/img/std/Save.png"));
        jButton6.setText("SAUVER");
        jButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton6.setMaximumSize(new java.awt.Dimension(3200, 3200));
        jButton6.setMinimumSize(new java.awt.Dimension(0, 36));
        jButton6.setPreferredSize(null);
        jPanel4.add(jButton6);

        jButton5.setIcon(Ico.i32("/img/std/Cancel.png"));
        jButton5.setText("ANNULER");
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton5.setMaximumSize(null);
        jButton5.setMinimumSize(null);
        jButton5.setPreferredSize(null);
        jPanel4.add(jButton5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainSplitPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainSplitPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LinkPane;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbFilterTableZen;
    private javax.swing.JPanel counterPane;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSplitPane mainSplitPane;
    private javax.swing.JPanel optiPane;
    private javax.swing.JSplitPane subSplitPaneCounter;
    private javax.swing.JTable tableLink;
    private javax.swing.JTable tableOpti;
    private javax.swing.JTable tableZen;
    private javax.swing.JTextField tfFilterEquCode;
    private javax.swing.JTextField tfFilterEqui;
    private javax.swing.JTextField tfFilterNames;
    private javax.swing.JTextField tfFilterOrg;
    private javax.swing.JTextField tfFilterOrgCode;
    private javax.swing.JTextField tfFilterUnite;
    private javax.swing.JTextField tfFilterVariable;
    private javax.swing.JTextField tfSetOpti;
    private javax.swing.JTextField tfSetZen;
    private javax.swing.JPanel zenPane;
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
}