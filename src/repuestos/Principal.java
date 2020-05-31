/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Principal extends javax.swing.JFrame {

    int x = 0;
    public static boolean listaAbierta = false;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
        Panel1.setVisible(true);
        Panel2.setVisible(false);
        Panel3.setVisible(false);
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
        InsertarClientes = new javax.swing.JButton();
        ModificarClientes = new javax.swing.JButton();
        SuspenderClientes = new javax.swing.JButton();
        VerClientes = new javax.swing.JButton();
        LabelAdminCliente = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        verPartesButton = new javax.swing.JButton();
        InsertarParteButton = new javax.swing.JButton();
        BorrarParteButton = new javax.swing.JButton();
        AsociarProvButton = new javax.swing.JButton();
        AsociaAutoButton = new javax.swing.JButton();
        ActualizaCostosProvButton = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        WAS = new javax.swing.JLabel();
        BarraMenu = new javax.swing.JMenuBar();
        MenuAdministrar = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        MenuPartes = new javax.swing.JMenuItem();
        MenuOrdenes = new javax.swing.JMenuItem();
        MenuAcercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("App Repuestos");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel1.setBackground(new java.awt.Color(51, 51, 51));
        Panel1.setForeground(new java.awt.Color(102, 102, 102));
        Panel1.setPreferredSize(new java.awt.Dimension(720, 600));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InsertarClientes.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        InsertarClientes.setText("Insertar Clientes");
        InsertarClientes.setPreferredSize(new java.awt.Dimension(285, 75));
        InsertarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarClientesActionPerformed(evt);
            }
        });
        Panel1.add(InsertarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        ModificarClientes.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        ModificarClientes.setText("Modificar Clientes");
        ModificarClientes.setPreferredSize(new java.awt.Dimension(285, 75));
        ModificarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarClientesActionPerformed(evt);
            }
        });
        Panel1.add(ModificarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        SuspenderClientes.setFont(new java.awt.Font("Dialog", 1, 26)); // NOI18N
        SuspenderClientes.setText("Suspender Clientes");
        SuspenderClientes.setPreferredSize(new java.awt.Dimension(285, 75));
        SuspenderClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuspenderClientesActionPerformed(evt);
            }
        });
        Panel1.add(SuspenderClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, -1, -1));

        VerClientes.setFont(new java.awt.Font("Dialog", 1, 28)); // NOI18N
        VerClientes.setText("Ver Clientes");
        VerClientes.setPreferredSize(new java.awt.Dimension(285, 75));
        VerClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerClientesActionPerformed(evt);
            }
        });
        Panel1.add(VerClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 470, -1, -1));

        LabelAdminCliente.setBackground(new java.awt.Color(255, 255, 255));
        LabelAdminCliente.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        LabelAdminCliente.setForeground(new java.awt.Color(204, 204, 204));
        LabelAdminCliente.setText("Administrar Clientes");
        Panel1.add(LabelAdminCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        getContentPane().add(Panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Panel2.setBackground(new java.awt.Color(51, 51, 51));
        Panel2.setForeground(new java.awt.Color(153, 153, 153));
        Panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        verPartesButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        verPartesButton.setText("Ver Partes");
        verPartesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPartesButtonActionPerformed(evt);
            }
        });
        Panel2.add(verPartesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 270, 80));

        InsertarParteButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        InsertarParteButton.setText("Insertar Parte");
        InsertarParteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertarParteButtonActionPerformed(evt);
            }
        });
        Panel2.add(InsertarParteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 80));

        BorrarParteButton.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BorrarParteButton.setText("Borrar Parte");
        BorrarParteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarParteButtonActionPerformed(evt);
            }
        });
        Panel2.add(BorrarParteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, 80));

        AsociarProvButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        AsociarProvButton.setText("Asociar partes proveedor ");
        AsociarProvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AsociarProvButtonActionPerformed(evt);
            }
        });
        Panel2.add(AsociarProvButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 270, 80));

        AsociaAutoButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AsociaAutoButton.setText("Asociar partes Auto");
        Panel2.add(AsociaAutoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 270, 80));

        ActualizaCostosProvButton.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ActualizaCostosProvButton.setText("Acutalizar costos proveedor");
        ActualizaCostosProvButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizaCostosProvButtonActionPerformed(evt);
            }
        });
        Panel2.add(ActualizaCostosProvButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 270, 80));

        getContentPane().add(Panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 600));

        Panel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        WAS.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        WAS.setText("jLabel3");
        Panel3.add(WAS, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 285, -1, -1));

        getContentPane().add(Panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 600));

        MenuAdministrar.setText("Administrar");

        MenuClientes.setText("Clientes");
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        MenuAdministrar.add(MenuClientes);

        MenuPartes.setText("Partes");
        MenuPartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPartesActionPerformed(evt);
            }
        });
        MenuAdministrar.add(MenuPartes);

        MenuOrdenes.setText("Órdenes");
        MenuOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOrdenesActionPerformed(evt);
            }
        });
        MenuAdministrar.add(MenuOrdenes);

        BarraMenu.add(MenuAdministrar);

        MenuAcercaDe.setText("Acerca de");
        MenuAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuAcercaDeMouseClicked(evt);
            }
        });
        BarraMenu.add(MenuAcercaDe);

        setJMenuBar(BarraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuAcercaDeMouseClicked
        JOptionPane.showMessageDialog(this, "       App de Repuestos\n" +
                                            "Desarrollada por " +
                                            "Gustavo Blanco Alfaro"
                                            , "Acerca de", 1);
    }//GEN-LAST:event_MenuAcercaDeMouseClicked

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        Panel1.setVisible(true);
        Panel2.setVisible(false);
        Panel3.setVisible(false);
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void MenuPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPartesActionPerformed
        Panel1.setVisible(false);
        Panel2.setVisible(true);
        Panel3.setVisible(false);
    }//GEN-LAST:event_MenuPartesActionPerformed

    private void MenuOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOrdenesActionPerformed
        Panel1.setVisible(false);
        Panel2.setVisible(false);
        Panel3.setVisible(true);
    }//GEN-LAST:event_MenuOrdenesActionPerformed

    private void VerClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerClientesActionPerformed
        if(!listaAbierta){
            new ListaClientes();
            listaAbierta = true;
        }
    }//GEN-LAST:event_VerClientesActionPerformed

    private void InsertarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarClientesActionPerformed
        new InsertarClientes(this);
        this.setVisible(false);
    }//GEN-LAST:event_InsertarClientesActionPerformed

    private void ModificarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarClientesActionPerformed
        new ModificarClientes(this);
        this.setVisible(false);
    }//GEN-LAST:event_ModificarClientesActionPerformed

    private void SuspenderClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuspenderClientesActionPerformed
        new SuspenderClientes(this);
        this.setVisible(false);
    }//GEN-LAST:event_SuspenderClientesActionPerformed

    private void verPartesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPartesButtonActionPerformed
       new VerPartes(this);
       this.setVisible(false);
    }//GEN-LAST:event_verPartesButtonActionPerformed

    private void InsertarParteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertarParteButtonActionPerformed
        new InsertarParte(this);
       this.setVisible(false);
    }//GEN-LAST:event_InsertarParteButtonActionPerformed

    private void BorrarParteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarParteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BorrarParteButtonActionPerformed

    private void AsociarProvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AsociarProvButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AsociarProvButtonActionPerformed

    private void ActualizaCostosProvButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizaCostosProvButtonActionPerformed
        new PartesCostos(this);
       this.setVisible(false);
    }//GEN-LAST:event_ActualizaCostosProvButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizaCostosProvButton;
    private javax.swing.JButton AsociaAutoButton;
    private javax.swing.JButton AsociarProvButton;
    private javax.swing.JMenuBar BarraMenu;
    private javax.swing.JButton BorrarParteButton;
    private javax.swing.JButton InsertarClientes;
    private javax.swing.JButton InsertarParteButton;
    private javax.swing.JLabel LabelAdminCliente;
    private javax.swing.JMenu MenuAcercaDe;
    private javax.swing.JMenu MenuAdministrar;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuOrdenes;
    private javax.swing.JMenuItem MenuPartes;
    private javax.swing.JButton ModificarClientes;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JButton SuspenderClientes;
    private javax.swing.JButton VerClientes;
    private javax.swing.JLabel WAS;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton verPartesButton;
    // End of variables declaration//GEN-END:variables
}