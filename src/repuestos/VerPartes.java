/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author iFreuk
 */
public class VerPartes extends javax.swing.JFrame {

    /**
     * Creates new form VerPartes
     */
    JFrame principal;
    
    public WindowListener c = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrar(principal);
        }
    };
    
    private int Anno;
    private String Modelo;
    public DefaultTableModel tabla;
    
    public VerPartes(JFrame p) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.addWindowListener(c);
        this.setVisible(true);
        this.tabla = (DefaultTableModel) TablaPartes.getModel();
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
        ModeloPartesField = new javax.swing.JLabel();
        AnnoParteField = new javax.swing.JTextField();
        AnnoPartesLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        TITULOINSERTARp = new javax.swing.JLabel();
        ComboAutos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPartes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ModeloPartesField.setBackground(new java.awt.Color(255, 255, 255));
        ModeloPartesField.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ModeloPartesField.setForeground(new java.awt.Color(255, 255, 255));
        ModeloPartesField.setText("Modelo:");
        jPanel1.add(ModeloPartesField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, -1));

        AnnoParteField.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel1.add(AnnoParteField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 140, -1));

        AnnoPartesLabel.setBackground(new java.awt.Color(255, 255, 255));
        AnnoPartesLabel.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        AnnoPartesLabel.setForeground(new java.awt.Color(255, 255, 255));
        AnnoPartesLabel.setText("Año:");
        jPanel1.add(AnnoPartesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jButton1.setText("🔎");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 60, -1));

        TITULOINSERTARp.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        TITULOINSERTARp.setForeground(new java.awt.Color(255, 255, 255));
        TITULOINSERTARp.setText("Ver Partes");
        jPanel1.add(TITULOINSERTARp, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        ComboAutos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ComboAutos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camry", "Corolla", "CX-5", "Eclipse", "F18", "Fox", "Golf", "Lancer", "Mazda 6", "Murano", "Pajero", "Prius", "Sentra", "Terrano", "Titan", "X6 M", "X-Trail", "Yaris" }));
        ComboAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAutosActionPerformed(evt);
            }
        });
        jPanel1.add(ComboAutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 180, 30));

        TablaPartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Marca", "Nombre", "Fabricante"
            }
        ));
        jScrollPane1.setViewportView(TablaPartes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 640, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Modelo = ComboAutos.getSelectedItem().toString();
        if(Repuestos.isNumeric(AnnoParteField.getText())){
            Anno = Integer.parseInt(AnnoParteField.getText());
            try{
                tabla.setRowCount(0);
                Repuestos.Verpartes(Anno, Modelo, tabla);
            }catch(SQLException e){
                Logger.getLogger(VerPartes.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        else{AnnoParteField.setText("Año invalido");}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboAutosActionPerformed

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
            java.util.logging.Logger.getLogger(VerPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerPartes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VerPartes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AnnoParteField;
    private javax.swing.JLabel AnnoPartesLabel;
    private javax.swing.JComboBox<String> ComboAutos;
    private javax.swing.JLabel ModeloPartesField;
    private javax.swing.JLabel TITULOINSERTARp;
    private javax.swing.JTable TablaPartes;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
