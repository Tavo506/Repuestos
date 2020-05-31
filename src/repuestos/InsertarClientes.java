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
public class InsertarClientes extends javax.swing.JFrame {

    /**
     * Creates new form InsertarClientes
     */
    JFrame principal;
    
    public WindowListener c = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrar(principal);
        }
    };
    
    public InsertarClientes(JFrame p) {
        initComponents();
        Panel2.setVisible(false);
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
        Panel3 = new javax.swing.JPanel();
        RadioPersona = new javax.swing.JRadioButton();
        RadioOrg = new javax.swing.JRadioButton();
        Label = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        LabelNombreCliente = new javax.swing.JLabel();
        TextNombreCliente = new javax.swing.JTextField();
        LabelCedulaCliente = new javax.swing.JLabel();
        TextCedulaCliente = new javax.swing.JTextField();
        LabelDireccionCliente = new javax.swing.JLabel();
        TextDireccionCliente = new javax.swing.JTextField();
        LabelCiudadCliente = new javax.swing.JLabel();
        TextCiudadCliente = new javax.swing.JTextField();
        LabelTeléfonosCliente = new javax.swing.JLabel();
        TextTeléfonoCliente = new javax.swing.JTextField();
        AgregarTelefono = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Telefonos = new javax.swing.JTextArea();
        Panel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Insertar Cliente");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel3.setBackground(new java.awt.Color(51, 51, 51));
        Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RadioPersona.setBackground(new java.awt.Color(55, 55, 55));
        buttonGroup1.add(RadioPersona);
        RadioPersona.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        RadioPersona.setForeground(new java.awt.Color(204, 204, 204));
        RadioPersona.setText("Persona");
        RadioPersona.setFocusPainted(false);
        RadioPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioPersonaActionPerformed(evt);
            }
        });
        Panel3.add(RadioPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

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
        Panel3.add(RadioOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        Label.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Label.setForeground(new java.awt.Color(204, 204, 204));
        Label.setText("Insertar Cliente");
        Panel3.add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        getContentPane().add(Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        Panel1.setBackground(new java.awt.Color(51, 51, 51));
        Panel1.setPreferredSize(new java.awt.Dimension(500, 600));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelNombreCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelNombreCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelNombreCliente.setText("Nombre:");
        Panel1.add(LabelNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        TextNombreCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel1.add(TextNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 360, -1));

        LabelCedulaCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelCedulaCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelCedulaCliente.setText("Cédula:");
        Panel1.add(LabelCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        TextCedulaCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel1.add(TextCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 360, -1));

        LabelDireccionCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelDireccionCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelDireccionCliente.setText("Dirección:");
        Panel1.add(LabelDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        TextDireccionCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel1.add(TextDireccionCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 360, -1));

        LabelCiudadCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelCiudadCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelCiudadCliente.setText("Ciudad:");
        Panel1.add(LabelCiudadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        TextCiudadCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel1.add(TextCiudadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 360, -1));

        LabelTeléfonosCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelTeléfonosCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelTeléfonosCliente.setText("Teléfonos:");
        Panel1.add(LabelTeléfonosCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        TextTeléfonoCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel1.add(TextTeléfonoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 310, -1));

        AgregarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonMas.png"))); // NOI18N
        AgregarTelefono.setBorderPainted(false);
        AgregarTelefono.setPreferredSize(new java.awt.Dimension(37, 37));
        AgregarTelefono.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BotonMasP.png"))); // NOI18N
        AgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarTelefonoActionPerformed(evt);
            }
        });
        Panel1.add(AgregarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setEnabled(false);

        Telefonos.setColumns(20);
        Telefonos.setRows(5);
        jScrollPane1.setViewportView(Telefonos);

        Panel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, -1, -1));

        getContentPane().add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 470));

        Panel2.setBackground(new java.awt.Color(51, 51, 51));
        Panel2.setPreferredSize(new java.awt.Dimension(500, 600));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RadioPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPersonaActionPerformed
        Panel1.setVisible(true);
        Panel2.setVisible(false);
    }//GEN-LAST:event_RadioPersonaActionPerformed

    private void RadioOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioOrgActionPerformed
        Panel1.setVisible(false);
        Panel2.setVisible(true);
    }//GEN-LAST:event_RadioOrgActionPerformed

    private void AgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarTelefonoActionPerformed
        String t = TextTeléfonoCliente.getText();
        TextTeléfonoCliente.setText("");
        Telefonos.setText(Telefonos.getText() + t + "\n");
    }//GEN-LAST:event_AgregarTelefonoActionPerformed

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
            java.util.logging.Logger.getLogger(InsertarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsertarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsertarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsertarClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsertarClientes(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarTelefono;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel LabelCedulaCliente;
    private javax.swing.JLabel LabelCiudadCliente;
    private javax.swing.JLabel LabelDireccionCliente;
    private javax.swing.JLabel LabelNombreCliente;
    private javax.swing.JLabel LabelTeléfonosCliente;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JRadioButton RadioOrg;
    private javax.swing.JRadioButton RadioPersona;
    private javax.swing.JTextArea Telefonos;
    private javax.swing.JTextField TextCedulaCliente;
    private javax.swing.JTextField TextCiudadCliente;
    private javax.swing.JTextField TextDireccionCliente;
    private javax.swing.JTextField TextNombreCliente;
    private javax.swing.JTextField TextTeléfonoCliente;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
