/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.optizen.app;

import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author r.hendrick
 */
public class LoadingFrame extends javax.swing.JDialog {

    /**
     * Creates new form LoadingFrame
     * @param parent
     * @param modal
     */
    public LoadingFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public LoadingFrame(JFrame parent, boolean modal){
        super(parent, modal);
        initComponents();
    }

    public LoadingFrame(Window owner, ModalityType modalityType) {
        super(owner, "", modalityType);
        initComponents();
    }
    
    public LoadingFrame(Window owner, String title, ModalityType modalityType) {
        super(owner, title, modalityType);
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

        jPanel1 = new javax.swing.JPanel();
        loading = new javax.swing.JLabel();
        sub = new javax.swing.JProgressBar();
        main = new javax.swing.JProgressBar();
        hideLoadingFrame = new javax.swing.JButton();
        stopLoadingFrame = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Loading");
        setBackground(new java.awt.Color(255, 252, 177));
        setFocusable(false);
        setFocusableWindowState(false);
        setForeground(new java.awt.Color(255, 153, 102));
        setModal(true);
        setName(""); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(153, 255, 102));

        loading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loading.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/oz/searching.gif"))); // NOI18N

        sub.setValue(100);
        sub.setStringPainted(true);

        main.setValue(100);
        main.setStringPainted(true);

        hideLoadingFrame.setText("Cacher");
        hideLoadingFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideLoadingFrameActionPerformed(evt);
            }
        });

        stopLoadingFrame.setText("Arrêter");
        stopLoadingFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopLoadingFrameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(loading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(main, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                    .addComponent(sub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hideLoadingFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stopLoadingFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sub, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hideLoadingFrame))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(main, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stopLoadingFrame)))
                    .addComponent(loading)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void stopLoadingFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopLoadingFrameActionPerformed
        stopLoadingFrame();
    }//GEN-LAST:event_stopLoadingFrameActionPerformed

    private void hideLoadingFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideLoadingFrameActionPerformed
        hideLoadingFrame();
    }//GEN-LAST:event_hideLoadingFrameActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hideLoadingFrame;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loading;
    private javax.swing.JProgressBar main;
    private javax.swing.JButton stopLoadingFrame;
    private javax.swing.JProgressBar sub;
    // End of variables declaration//GEN-END:variables

    /**
     * On Init set Main and Sub progress to 0
     */
    void onInit() {
        main.setValue(0);
        sub.setValue(0);
    }
    
    /**
     * On finish set Main and Sub progress to 100
     */
    void onFinish(){
        main.setValue(100);
        sub.setValue(100);
    }
    
    /**
     * Specify the current main value
     * @param progress value to be affect
     */
    void main(Integer progress){
        main.setValue(progress);
    }
    
    /**
     * Specify the current sub value
     * @param progress curent value t oset
     */
    void sub(Integer progress){
        sub.setValue(progress);
    }

    public void stopLoadingFrame() {
        TransferFrame.stopBackgroundProcess = true;
    }

    private void hideLoadingFrame() {
        setVisible(false);
    }
    
}
