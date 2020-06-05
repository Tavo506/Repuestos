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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
        try{
            ArrayList<String> clientes = Repuestos.SelectClientes();
            String[] cliente;
            for (String c : clientes) {
                if(c.contains("Persona")){
                    cliente = c.split(",", 8);
                    addPersona(cliente);
                }
                else{
                    cliente = c.split(",");
                    addOrg(cliente);
                }
            }
            TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
            ListaClientes.setRowSorter(sorter);

            List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
            sorter.setSortKeys(sortKeys);
            
        }catch (SQLException ex){
            Logger.getLogger(InsertarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //modelo.addRow(new Object[]{id, tipo, nombre, cedula, cedula Juridica, dirección, ciudad, telefonos, estado});
    }
    
    //persona = [0:id, 1:tipo, 2:nombre, 3:cedula, 4:direccion, 5:ciudad, 6:estado, 7:telefonos]
    void addPersona(String[] cliente){
        modelo.addRow(new Object[]{Integer.parseInt(cliente[0]), cliente[1], cliente[2], cliente[3], "", cliente[4], cliente[5], cliente[7], cliente[6]});
    }
    
    void addOrg(String[] cliente){
        modelo.addRow(new Object[]{Integer.parseInt(cliente[0]), cliente[1], cliente[2], "", cliente[3], cliente[4], cliente[5], "", cliente[6]});
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
        jScrollPane2 = new javax.swing.JScrollPane();
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
        jPanel1.setLayout(new java.awt.BorderLayout());

        ListaClientes.setAutoCreateRowSorter(true);
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
                false, false, false, false, false, false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(ListaClientes);
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
            ListaClientes.getColumnModel().getColumn(6).setMaxWidth(110);
            ListaClientes.getColumnModel().getColumn(8).setMinWidth(90);
            ListaClientes.getColumnModel().getColumn(8).setPreferredWidth(90);
            ListaClientes.getColumnModel().getColumn(8).setMaxWidth(90);
        }

        jPanel1.add(jScrollPane2, java.awt.BorderLayout.CENTER);

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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
