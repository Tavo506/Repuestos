/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

/**
 *
 * @author iFreuk
 */
public class VerPartes extends javax.swing.JFrame {

    /**
     * Creates new form VerPartes
     */
    public VerPartes() {
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

        AnnoCombo = new javax.swing.JComboBox();
        ModeloCombo = new javax.swing.JComboBox();
        AnnoLabel = new javax.swing.JLabel();
        ModeloLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPartes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AnnoCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        AnnoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnoComboActionPerformed(evt);
            }
        });
        getContentPane().add(AnnoCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        ModeloCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(ModeloCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 170, -1));

        AnnoLabel.setText("Año:");
        getContentPane().add(AnnoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        ModeloLabel.setText("Modelo");
        getContentPane().add(ModeloLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        TablaPartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Marca", "Nombre", "Fabricante-ID", "Detalle"
            }
        ));
        jScrollPane1.setViewportView(TablaPartes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 660, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnnoComboActionPerformed

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
                new VerPartes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox AnnoCombo;
    private javax.swing.JLabel AnnoLabel;
    private javax.swing.JComboBox ModeloCombo;
    private javax.swing.JLabel ModeloLabel;
    private javax.swing.JTable TablaPartes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
