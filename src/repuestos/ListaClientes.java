/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class ListaClientes extends javax.swing.JFrame {
    DefaultTableModel modelo;
    public WindowListener c = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            cerrar();
        }
    };
    /**
     * Creates new form ListaClientes
     */
    public ListaClientes() {
        initComponents();
        modelo = (DefaultTableModel) ListaClientes.getModel();
        llenarTabla();
        this.setVisible(true);
        this.addWindowListener(c);
        this.setLocationRelativeTo(null);
    }
    
    void cerrar() {
        Principal.listaAbierta = false;
        this.dispose();
    }
    
    void llenarTabla(){
        modelo.addRow(new Object[]{"1","2","3","4","5","6","7","8","9"});
        modelo.addRow(new Object[]{"2","2","3","4","5","6","7","8","9"});
        

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
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lista Clientes");
        setBackground(new java.awt.Color(51, 51, 51));
        setMaximumSize(new java.awt.Dimension(900, 500));
        setMinimumSize(new java.awt.Dimension(815, 300));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setMaximumSize(new java.awt.Dimension(900, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));

        jScrollPane1.setBackground(new java.awt.Color(51, 51, 51));

        ListaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tipo", "Nombre", "Cédula", "Cédula Jurídica", "Dirección", "Ciudad", "Teléfono/s", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListaClientes.setPreferredSize(new java.awt.Dimension(800, 32));
        ListaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ListaClientes);
        if (ListaClientes.getColumnModel().getColumnCount() > 0) {
            ListaClientes.getColumnModel().getColumn(0).setMinWidth(50);
            ListaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
            ListaClientes.getColumnModel().getColumn(0).setMaxWidth(50);
            ListaClientes.getColumnModel().getColumn(1).setMinWidth(75);
            ListaClientes.getColumnModel().getColumn(1).setPreferredWidth(75);
            ListaClientes.getColumnModel().getColumn(1).setMaxWidth(75);
            ListaClientes.getColumnModel().getColumn(2).setMinWidth(160);
            ListaClientes.getColumnModel().getColumn(2).setPreferredWidth(160);
            ListaClientes.getColumnModel().getColumn(2).setMaxWidth(160);
            ListaClientes.getColumnModel().getColumn(3).setMinWidth(80);
            ListaClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
            ListaClientes.getColumnModel().getColumn(3).setMaxWidth(80);
            ListaClientes.getColumnModel().getColumn(4).setMinWidth(95);
            ListaClientes.getColumnModel().getColumn(4).setPreferredWidth(95);
            ListaClientes.getColumnModel().getColumn(4).setMaxWidth(95);
            ListaClientes.getColumnModel().getColumn(5).setMinWidth(90);
            ListaClientes.getColumnModel().getColumn(5).setPreferredWidth(90);
            ListaClientes.getColumnModel().getColumn(5).setMaxWidth(250);
            ListaClientes.getColumnModel().getColumn(6).setMinWidth(85);
            ListaClientes.getColumnModel().getColumn(6).setPreferredWidth(85);
            ListaClientes.getColumnModel().getColumn(6).setMaxWidth(85);
            ListaClientes.getColumnModel().getColumn(8).setMinWidth(90);
            ListaClientes.getColumnModel().getColumn(8).setPreferredWidth(90);
            ListaClientes.getColumnModel().getColumn(8).setMaxWidth(90);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

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
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListaClientes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
