/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.main;

import java.io.File;
import rm_lib.application.init.RM_AppInit;
import rm_lib.application.init.RM_DataBase;
import rswin.ui.file.RSwinFileSelect;
import rytable.RY_DataBaseExcelExport;
import rytable.RY_TableManager;
import ui.database.DBScriptDlg;

/**
 *
 * @author renhongxiang
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem_DB_Spec = new javax.swing.JMenuItem();
        jMenuItem_DB_Script = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("DataBase");

        jMenuItem_DB_Spec.setText("Export Database Specification");
        jMenuItem_DB_Spec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DB_SpecActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_DB_Spec);

        jMenuItem_DB_Script.setText("Database Script");
        jMenuItem_DB_Script.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DB_ScriptActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem_DB_Script);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_DB_SpecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DB_SpecActionPerformed
        // TODO add your handling code here:
        
        File selectFile = RSwinFileSelect.doSelectSaveFile(this);
        if(selectFile != null){
            RY_DataBaseExcelExport export = new RY_DataBaseExcelExport();
            if(export != null){
                RM_AppInit ini = new RM_AppInit();
                RY_TableManager db = ini.getTableManager();
                if(db!=null){
                    export.setDataBase(db);
                    export.exportSpec(selectFile);
                }
            }
        }                
        
    }//GEN-LAST:event_jMenuItem_DB_SpecActionPerformed

    private void jMenuItem_DB_ScriptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DB_ScriptActionPerformed
        // TODO add your handling code here:
        DBScriptDlg dlg = new DBScriptDlg(this, true);
        dlg.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem_DB_ScriptActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_DB_Script;
    private javax.swing.JMenuItem jMenuItem_DB_Spec;
    // End of variables declaration//GEN-END:variables
}
