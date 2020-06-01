/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class SuspenderClientes extends javax.swing.JFrame {

    /**
     * Creates new form SuspenderClientes
     */
    JFrame principal;
    
    public WindowListener c = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrar(principal);
        }
    };
    
    public SuspenderClientes(JFrame p) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.addWindowListener(c);
        this.setVisible(true);
        principal = p;
    }
    
    void cerrar(JFrame p){
        p.setVisible(true);
        this.dispose();
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
        Panel1 = new javax.swing.JPanel();
        RadioPersona = new javax.swing.JRadioButton();
        RadioOrg = new javax.swing.JRadioButton();
        Label = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        LabelCedulaCliente = new javax.swing.JLabel();
        TextCedulaCliente = new javax.swing.JTextField();
        SuspenderPersona = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        TextCedulaOrg = new javax.swing.JTextField();
        LabelCedulaOrg = new javax.swing.JLabel();
        SuspenderOrg = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Suspender Cliente");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setBackground(new java.awt.Color(51, 51, 51));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RadioPersona.setBackground(new java.awt.Color(55, 55, 55));
        buttonGroup1.add(RadioPersona);
        RadioPersona.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        RadioPersona.setForeground(new java.awt.Color(204, 204, 204));
        RadioPersona.setSelected(true);
        RadioPersona.setText("Persona");
        RadioPersona.setFocusPainted(false);
        RadioPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPersonaActionPerformed(evt);
            }
        });
        Panel1.add(RadioPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        RadioOrg.setBackground(new java.awt.Color(55, 55, 55));
        buttonGroup1.add(RadioOrg);
        RadioOrg.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        RadioOrg.setForeground(new java.awt.Color(204, 204, 204));
        RadioOrg.setText("Organización");
        RadioOrg.setFocusPainted(false);
        RadioOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioOrgActionPerformed(evt);
            }
        });
        Panel1.add(RadioOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        Label.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Label.setForeground(new java.awt.Color(204, 204, 204));
        Label.setText("Suspender Cliente");
        Panel1.add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, 50));

        getContentPane().add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        Panel2.setBackground(new java.awt.Color(51, 51, 51));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelCedulaCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelCedulaCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelCedulaCliente.setText("Cédula:");
        Panel2.add(LabelCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        TextCedulaCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel2.add(TextCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 360, -1));

        SuspenderPersona.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        SuspenderPersona.setText("Suspender");
        Panel2.add(SuspenderPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 290, 60));

        getContentPane().add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 500, 180));

        Panel3.setBackground(new java.awt.Color(51, 51, 51));
        Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextCedulaOrg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel3.add(TextCedulaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 330, -1));

        LabelCedulaOrg.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        LabelCedulaOrg.setForeground(new java.awt.Color(204, 204, 204));
        LabelCedulaOrg.setText("Cédula Jurídica:");
        Panel3.add(LabelCedulaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        SuspenderOrg.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        SuspenderOrg.setText("Suspender");
        Panel3.add(SuspenderOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 290, 60));

        getContentPane().add(Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 500, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RadioPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPersonaActionPerformed
        Panel2.setVisible(true);
        Panel3.setVisible(false);
    }//GEN-LAST:event_RadioPersonaActionPerformed

    private void RadioOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioOrgActionPerformed
        Panel2.setVisible(false);
        Panel3.setVisible(true);
    }//GEN-LAST:event_RadioOrgActionPerformed

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
            java.util.logging.Logger.getLogger(SuspenderClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuspenderClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuspenderClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuspenderClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuspenderClientes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label;
    private javax.swing.JLabel LabelCedulaCliente;
    private javax.swing.JLabel LabelCedulaOrg;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JRadioButton RadioOrg;
    private javax.swing.JRadioButton RadioPersona;
    private javax.swing.JButton SuspenderOrg;
    private javax.swing.JButton SuspenderPersona;
    private javax.swing.JTextField TextCedulaCliente;
    private javax.swing.JTextField TextCedulaOrg;
    private javax.swing.ButtonGroup buttonGroup1;
    // End of variables declaration//GEN-END:variables
}
