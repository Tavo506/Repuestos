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
 * @author iFreuk
 */
public class AsociarPartesProvedor extends javax.swing.JFrame {

    /**
     * Creates new form InsertarParte
     */
    JFrame principal;
    
    public WindowListener c = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrar(principal);
        }
    };
    
    public AsociarPartesProvedor(JFrame p) {
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

        jPanel1 = new javax.swing.JPanel();
        ParteAsoLabel = new javax.swing.JLabel();
        ComboAsoPart = new javax.swing.JComboBox<>();
        ProveedorAsoLabel = new javax.swing.JLabel();
        ComboAsoProv = new javax.swing.JComboBox<>();
        AsociarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ParteAsoLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ParteAsoLabel.setText("Parte");
        jPanel1.add(ParteAsoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 29, -1, -1));

        ComboAsoPart.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboAsoPart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(ComboAsoPart, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 73, -1, -1));

        ProveedorAsoLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ProveedorAsoLabel.setText("Proveedor");
        jPanel1.add(ProveedorAsoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 137, -1, -1));

        ComboAsoProv.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboAsoProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(ComboAsoProv, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 187, -1, -1));

        AsociarButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        AsociarButton.setText("Asociar");
        jPanel1.add(AsociarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AsociarPartesProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsociarPartesProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsociarPartesProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsociarPartesProvedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsociarPartesProvedor(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AsociarButton;
    private javax.swing.JComboBox<String> ComboAsoPart;
    private javax.swing.JComboBox<String> ComboAsoProv;
    private javax.swing.JLabel ParteAsoLabel;
    private javax.swing.JLabel ProveedorAsoLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
