/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import org.optizen.util.Settings;
import org.optizen.util.Util;

/**
 *
 * @author r.hendrick
 */
public class MainWindow extends javax.swing.JFrame implements InternalFrameListener {

    /**
     * Configuration Frame contains all configuration for alication.
     */
    private ConfigFrame configFrame = null;
    /**
     * Link Frame contains all link between zenon and optimaint and allow to
     * create and remove them
     */
    private LinkFrame linkFrame = null;

    /**
     * Transfer frame allow to view and transfer available data from zenon to
     * optimaint
     */
    private TransferFrame transferFrame = null;
    
    
    private ArrayList<InternalFrameListener> internalFrameListeners = new ArrayList<>();

    public void addListener(InternalFrameListener listener) {
        internalFrameListeners.add(listener);
    }

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
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

        desktopPane = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        tbBtnConfigurations = new javax.swing.JButton();
        tbBtnLinks = new javax.swing.JButton();
        tbBtnTransfer = new javax.swing.JButton();
        tbBtnExit = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuItemConfigurations = new javax.swing.JMenuItem();
        menuItemLinks = new javax.swing.JMenuItem();
        menuItemTransfer = new javax.swing.JMenuItem();
        themeMenu = new javax.swing.JMenu();
        menuItemThemeMetal = new javax.swing.JMenuItem();
        menuItemThemeNimbus = new javax.swing.JMenuItem();
        menuItemThemeCDEMotif = new javax.swing.JMenuItem();
        menuItemThemeMetal3 = new javax.swing.JMenuItem();
        menuItemThemWindowsClassic = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("bundles/Fr_fr"); // NOI18N
        setTitle(bundle.getString("AppVersion")); // NOI18N
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/img/optizen.png")).getImage()
        );
        setName("MainWindowFrame"); // NOI18N
        setSize(new java.awt.Dimension(1024, 680));

        desktopPane.setBackground(new java.awt.Color(153, 153, 153));
        desktopPane.setLayout(new java.awt.BorderLayout());

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        tbBtnConfigurations.setIcon(Ico.i48("/img/oz/config.png"));
        tbBtnConfigurations.setText("Configurations");
        tbBtnConfigurations.setFocusable(false);
        tbBtnConfigurations.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBtnConfigurations.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbBtnConfigurations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBtnConfigurationsActionPerformed(evt);
            }
        });
        jToolBar1.add(tbBtnConfigurations);

        tbBtnLinks.setIcon(Ico.i48("/img/oz/link.png"));
        tbBtnLinks.setText("Correspondance");
        tbBtnLinks.setFocusable(false);
        tbBtnLinks.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBtnLinks.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbBtnLinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBtnLinksActionPerformed(evt);
            }
        });
        jToolBar1.add(tbBtnLinks);

        tbBtnTransfer.setIcon(Ico.i48("/img/oz/transfer.png"));
        tbBtnTransfer.setText("Transférer");
        tbBtnTransfer.setFocusable(false);
        tbBtnTransfer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBtnTransfer.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbBtnTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBtnTransferActionPerformed(evt);
            }
        });
        jToolBar1.add(tbBtnTransfer);

        tbBtnExit.setIcon(Ico.i48("/img/oz/exit.png"));
        tbBtnExit.setText("Quitter");
        tbBtnExit.setFocusable(false);
        tbBtnExit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbBtnExit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbBtnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBtnExitActionPerformed(evt);
            }
        });
        jToolBar1.add(tbBtnExit);

        fileMenu.setMnemonic('f');
        fileMenu.setText(bundle.getString("MenuFile")); // NOI18N
        fileMenu.setToolTipText("Gestion de l'application");

        exitMenuItem.setIcon(Ico.i16("/img/oz/exit.png")
        );
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText(bundle.getString("MenuFileExit")); // NOI18N
        exitMenuItem.setToolTipText("Permet de quitter l'application");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText(bundle.getString("MenuEdit")); // NOI18N

        menuItemConfigurations.setIcon(Ico.i16("/img/oz/config.png"));
        menuItemConfigurations.setMnemonic('t');
        menuItemConfigurations.setText("Configurations");
        menuItemConfigurations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemConfigurationsActionPerformed(evt);
            }
        });
        editMenu.add(menuItemConfigurations);

        menuItemLinks.setIcon(Ico.i16("/img/oz/link.png")
        );
        menuItemLinks.setMnemonic('y');
        menuItemLinks.setText(bundle.getString("MenuEditLink")); // NOI18N
        menuItemLinks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLinksActionPerformed(evt);
            }
        });
        editMenu.add(menuItemLinks);

        menuItemTransfer.setIcon(Ico.i16("/img/oz/transfer.png"));
        menuItemTransfer.setMnemonic('p');
        menuItemTransfer.setText(bundle.getString("MenuEditTransfert")); // NOI18N
        menuItemTransfer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTransferActionPerformed(evt);
            }
        });
        editMenu.add(menuItemTransfer);

        menuBar.add(editMenu);

        themeMenu.setText("Thèmes");

        menuItemThemeMetal.setMnemonic('t');
        menuItemThemeMetal.setText("Metal");
        menuItemThemeMetal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThemeMetalActionPerformed(evt);
            }
        });
        themeMenu.add(menuItemThemeMetal);

        menuItemThemeNimbus.setMnemonic('t');
        menuItemThemeNimbus.setText("Nimbus");
        menuItemThemeNimbus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThemeNimbusActionPerformed(evt);
            }
        });
        themeMenu.add(menuItemThemeNimbus);

        menuItemThemeCDEMotif.setMnemonic('t');
        menuItemThemeCDEMotif.setText("CDE/Motif");
        menuItemThemeCDEMotif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThemeCDEMotifActionPerformed(evt);
            }
        });
        themeMenu.add(menuItemThemeCDEMotif);

        menuItemThemeMetal3.setMnemonic('t');
        menuItemThemeMetal3.setText("Windows");
        menuItemThemeMetal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThemeMetal3ActionPerformed(evt);
            }
        });
        themeMenu.add(menuItemThemeMetal3);

        menuItemThemWindowsClassic.setMnemonic('t');
        menuItemThemWindowsClassic.setText("Windows Classic");
        menuItemThemWindowsClassic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemThemWindowsClassicActionPerformed(evt);
            }
        });
        themeMenu.add(menuItemThemWindowsClassic);

        menuBar.add(themeMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText(bundle.getString("MenuHelp")); // NOI18N

        contentMenuItem.setIcon(Ico.i16("/img/std/DlgInfos.png"));
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText(bundle.getString("MenuHelpDocs")); // NOI18N
        helpMenu.add(contentMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText(bundle.getString("MenuHelpAbout")); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void menuItemConfigurationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemConfigurationsActionPerformed
        if (ConfigFrame.openFrameCount == 0) {
            configFrame = new ConfigFrame();
            desktopPane.add(configFrame);
        } else {
            revalidate();
            repaint();
        }
        configFrame.setVisible(true);
        try {
            //configFrame.setMaximum(true);
            configFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_menuItemConfigurationsActionPerformed

    private void tbBtnConfigurationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBtnConfigurationsActionPerformed
        // TODO add your handling code here:
        menuItemConfigurationsActionPerformed(evt);
    }//GEN-LAST:event_tbBtnConfigurationsActionPerformed

    private void tbBtnLinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBtnLinksActionPerformed
        // TODO add your handling code here:
        menuItemLinksActionPerformed(evt);
    }//GEN-LAST:event_tbBtnLinksActionPerformed

    private void menuItemLinksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLinksActionPerformed
        if (LinkFrame.openFrameCount == 0) {
            linkFrame = new LinkFrame();
            desktopPane.add(linkFrame);
            internalFrameListeners.add(linkFrame);
        } else {
            revalidate();
            repaint();
        }
        linkFrame.setVisible(true);
        try {
            //linkFrame.setMaximum(true);
            linkFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuItemLinksActionPerformed

    private void menuItemThemeMetalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThemeMetalActionPerformed
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Util.out(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemThemeMetalActionPerformed

    private void menuItemThemeNimbusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThemeNimbusActionPerformed
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Util.out(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemThemeNimbusActionPerformed

    private void menuItemThemeCDEMotifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThemeCDEMotifActionPerformed
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Util.out(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemThemeCDEMotifActionPerformed

    private void menuItemThemeMetal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThemeMetal3ActionPerformed
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Util.out(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemThemeMetal3ActionPerformed

    private void menuItemThemWindowsClassicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemThemWindowsClassicActionPerformed
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
            pack();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            Util.out(e.getLocalizedMessage());
        }
    }//GEN-LAST:event_menuItemThemWindowsClassicActionPerformed

    private void tbBtnTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBtnTransferActionPerformed
        // TODO add your handling code here:
        menuItemTransferActionPerformed(evt);
    }//GEN-LAST:event_tbBtnTransferActionPerformed

    private void menuItemTransferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTransferActionPerformed
        if (TransferFrame.openFrameCount == 0) {
            transferFrame = new TransferFrame();
            desktopPane.add(transferFrame);
        } else {
            revalidate();
            repaint();
        }
        transferFrame.setVisible(true);
        try {
            //configFrame.setMaximum(true);
            transferFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
            Util.out("MainWindow : menuItemTransferActionPerformed >> " +  ex.getMessage());
        }
    }//GEN-LAST:event_menuItemTransferActionPerformed

    private void tbBtnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBtnExitActionPerformed
         exitMenuItemActionPerformed(evt);
    }//GEN-LAST:event_tbBtnExitActionPerformed

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
                //Util.out("Look and fell " + info.getName() + " use class : " + info.getClassName());
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    //break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Util.out("OptiZen - Start...");
            Settings.iniFilename = "OptiZen.ini";
            Util.out("Initialisation du fichier de configuration...");
            if (Settings.createIniFile()) {
                Settings.writeDefaultClientSetup();
            }
            
            MainWindow w = new MainWindow();
            w.setVisible(true);
            // Affichage plein écrant
            Util.out("OptiZen - End run...");
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemConfigurations;
    private javax.swing.JMenuItem menuItemLinks;
    private javax.swing.JMenuItem menuItemThemWindowsClassic;
    private javax.swing.JMenuItem menuItemThemeCDEMotif;
    private javax.swing.JMenuItem menuItemThemeMetal;
    private javax.swing.JMenuItem menuItemThemeMetal3;
    private javax.swing.JMenuItem menuItemThemeNimbus;
    private javax.swing.JMenuItem menuItemTransfer;
    private javax.swing.JButton tbBtnConfigurations;
    private javax.swing.JButton tbBtnExit;
    private javax.swing.JButton tbBtnLinks;
    private javax.swing.JButton tbBtnTransfer;
    private javax.swing.JMenu themeMenu;
    // End of variables declaration//GEN-END:variables



    @Override
    public void internalFrameOpened(InternalFrameEvent e) {}

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        System.out.println("internalFrameClosing");
        JInternalFrame iframe = e.getInternalFrame();
        if (iframe instanceof LinkFrame) {
            LinkFrame.openFrameCount--;
            linkFrame = null;
        } else if (iframe instanceof ConfigFrame) {
            ConfigFrame.openFrameCount--;
            configFrame = null;
        }

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) { }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {}

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {}

    @Override
    public void internalFrameActivated(InternalFrameEvent e) { }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) { }

}
