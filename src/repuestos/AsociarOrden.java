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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class AsociarOrden extends javax.swing.JFrame {

    /**
     * Creates new form AsociarOrden
     */
    JFrame principal;
    
    public WindowListener c = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrar(principal);
        }
    };
    
    public AsociarOrden(JFrame p) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.addWindowListener(c);
        Panel3.setVisible(false);
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
        jPanel1 = new javax.swing.JPanel();
        RadioOrg = new javax.swing.JRadioButton();
        Panel2 = new javax.swing.JPanel();
        LabelCedulaCliente = new javax.swing.JLabel();
        TextCedulaPersona = new javax.swing.JTextField();
        Panel3 = new javax.swing.JPanel();
        LabelCedulaOrg = new javax.swing.JLabel();
        TextCedulaOrg = new javax.swing.JTextField();
        RadioPersona = new javax.swing.JRadioButton();
        Label = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TextNombreParte = new javax.swing.JTextField();
        BuscarProveedor = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaProveedores = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        BotonBuscarOrdenes = new javax.swing.JButton();
        LabelCedulaCliente1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaOrdenes = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Asociar Orden");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(RadioOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        Panel2.setBackground(new java.awt.Color(51, 51, 51));
        Panel2.setPreferredSize(new java.awt.Dimension(500, 650));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelCedulaCliente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelCedulaCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelCedulaCliente.setText("Cédula:");
        Panel2.add(LabelCedulaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        TextCedulaPersona.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Panel2.add(TextCedulaPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 320, -1));

        jPanel1.add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 430, 90));

        Panel3.setBackground(new java.awt.Color(51, 51, 51));
        Panel3.setPreferredSize(new java.awt.Dimension(500, 520));
        Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelCedulaOrg.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        LabelCedulaOrg.setForeground(new java.awt.Color(204, 204, 204));
        LabelCedulaOrg.setText("Cédula Jurídica:");
        Panel3.add(LabelCedulaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        TextCedulaOrg.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TextCedulaOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCedulaOrgActionPerformed(evt);
            }
        });
        Panel3.add(TextCedulaOrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 270, -1));

        jPanel1.add(Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 430, 90));

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
        jPanel1.add(RadioPersona, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        Label.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        Label.setForeground(new java.awt.Color(204, 204, 204));
        Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label.setText("Asociar Orden");
        jPanel1.add(Label, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 20, 610, -1));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Nombre Parte:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        TextNombreParte.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel1.add(TextNombreParte, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 420, -1));

        BuscarProveedor.setFont(new java.awt.Font("Dialog", 1, 20)); // NOI18N
        BuscarProveedor.setText("Buscar Proveedores");
        BuscarProveedor.setFocusPainted(false);
        BuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarProveedorActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, -1, 50));

        TablaProveedores.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        TablaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaProveedores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TablaProveedores.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(TablaProveedores);
        if (TablaProveedores.getColumnModel().getColumnCount() > 0) {
            TablaProveedores.getColumnModel().getColumn(0).setMinWidth(400);
            TablaProveedores.getColumnModel().getColumn(0).setPreferredWidth(400);
            TablaProveedores.getColumnModel().getColumn(0).setMaxWidth(400);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 560, 110));

        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Seleccione una fecha *");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, 170, -1));

        BotonBuscarOrdenes.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BotonBuscarOrdenes.setText("Buscar Órdenes");
        BotonBuscarOrdenes.setFocusPainted(false);
        BotonBuscarOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarOrdenesActionPerformed(evt);
            }
        });
        jPanel1.add(BotonBuscarOrdenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 150, 40));

        LabelCedulaCliente1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelCedulaCliente1.setForeground(new java.awt.Color(204, 204, 204));
        LabelCedulaCliente1.setText("Órdenes:");
        jPanel1.add(LabelCedulaCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        TablaOrdenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Monto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaOrdenes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TablaOrdenes);
        if (TablaOrdenes.getColumnModel().getColumnCount() > 0) {
            TablaOrdenes.getColumnModel().getColumn(0).setMinWidth(100);
            TablaOrdenes.getColumnModel().getColumn(0).setPreferredWidth(100);
            TablaOrdenes.getColumnModel().getColumn(0).setMaxWidth(100);
            TablaOrdenes.getColumnModel().getColumn(1).setMinWidth(185);
            TablaOrdenes.getColumnModel().getColumn(1).setPreferredWidth(185);
            TablaOrdenes.getColumnModel().getColumn(1).setMaxWidth(185);
        }

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 460, 90));

        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Seleccione un proveedor *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 570, 170, -1));

        jButton1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jButton1.setText("Asociar Piesa");
        jButton1.setFocusPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 600, 320, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarProveedorActionPerformed
        try{
            String nombreParte = TextNombreParte.getText();
            
            Repuestos.selectProveedores(nombreParte, (DefaultTableModel)TablaProveedores.getModel());
        }catch(SQLException e){
            
        }
    }//GEN-LAST:event_BuscarProveedorActionPerformed

    private void RadioPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioPersonaActionPerformed
        Panel2.setVisible(true);
        Panel3.setVisible(false);
    }//GEN-LAST:event_RadioPersonaActionPerformed

    private void RadioOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioOrgActionPerformed
        Panel2.setVisible(false);
        Panel3.setVisible(true);
    }//GEN-LAST:event_RadioOrgActionPerformed

    private void TextCedulaOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCedulaOrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCedulaOrgActionPerformed

    private void BotonBuscarOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarOrdenesActionPerformed
        try{
            int cedula;
            String tipo;
            
            if(RadioPersona.isSelected()){
                tipo = "Persona";
                if(TextCedulaPersona.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(this, "El campo de cedula no puede ser vacío", "Advertencia", 2);
                    return;
                }else if(TextCedulaPersona.getText().trim().length() < 9){
                    JOptionPane.showMessageDialog(this, "Cédula inválida (menor a 9 dígitos)", "Advertencia", 2);
                    return;
                }
                cedula = Integer.parseInt(TextCedulaPersona.getText());
                
            }else{
                tipo = "Organizacion";
                if(TextCedulaOrg.getText().trim().isEmpty()){
                    JOptionPane.showMessageDialog(this, "El campo de cedula jurídica no puede ser vacío", "Advertencia", 2);
                    return;
                }else if(TextCedulaOrg.getText().trim().length() < 9){
                    JOptionPane.showMessageDialog(this, "Cédula jurídica inválida (menor a 9 dígitos)", "Advertencia", 2);
                    return;
                }
                cedula = Integer.parseInt(TextCedulaOrg.getText());
            }
            
            Repuestos.selectOrdenes(cedula, tipo, (DefaultTableModel)TablaOrdenes.getModel());
        }catch(SQLException ex){
            Logger.getLogger(AsociarOrden.class.getName()).log(Level.SEVERE, null, ex);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Error, cédula debe ser un número entero", "Advertencia", 2);
        }
    }//GEN-LAST:event_BotonBuscarOrdenesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AsociarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsociarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsociarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsociarOrden.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsociarOrden(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscarOrdenes;
    private javax.swing.JButton BuscarProveedor;
    private javax.swing.JLabel Label;
    private javax.swing.JLabel LabelCedulaCliente;
    private javax.swing.JLabel LabelCedulaCliente1;
    private javax.swing.JLabel LabelCedulaOrg;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JRadioButton RadioOrg;
    private javax.swing.JRadioButton RadioPersona;
    private javax.swing.JTable TablaOrdenes;
    private javax.swing.JTable TablaProveedores;
    private javax.swing.JTextField TextCedulaOrg;
    private javax.swing.JTextField TextCedulaPersona;
    private javax.swing.JTextField TextNombreParte;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
