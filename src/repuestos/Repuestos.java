/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Repuestos {
    
    public static Connection con;
    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        
        
        
        try {
          String connectionUrl = "jdbc:sqlserver://;database=REPUESTOS;integratedSecurity=true;";
          Connection c = DriverManager.getConnection(connectionUrl);
          con = c;
          System.out.println("Conectado.");
          new Principal();
        } 
        catch (SQLException ex) 
        {
            System.err.println(ex.toString());
        }
    }
    
    public void verPersonas() throws SQLException{
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select * from Persona");
            
        while(rs.next()){
            int cedula = rs.getInt(1);
            String nombre = rs.getString(2);
            String direccion = rs.getString(3);
            String ciudad = rs.getString(4);
            int telefono = rs.getInt(5);
            System.out.println("Cédula: " + cedula
                            + ", Nombre: " + nombre
                            + ", direccion: " + direccion
                            + ", ciudad: " + ciudad
                            + ", teléfono/s: " + telefono);
        }
    }
    
    public void addPersona() throws SQLException{
        Statement instruccion = con.createStatement();
        instruccion.execute("insert into Persona values (208130469, 'Miguel Alejandro Araya Blanco', 'San Pedro', 'San José', 61498787)");
    }
    
    /**
     *
     * @param cadena
     * @return
     */
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    public static void InsertClienteP(String estado, String tipo, int cedula, String nombre, String direccion, String ciudad, ArrayList<Integer> telefonos) throws SQLException{
        try(PreparedStatement cstmt = con.prepareStatement("EXEC SPIcliente ?, ?");) {  

            cstmt.setString(1, estado);
            cstmt.setString(2, tipo);
            cstmt.executeUpdate();  
            
            PreparedStatement ps = con.prepareStatement("EXEC SPIpersonas ?,?,?,?");
            
            ps.setInt(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, ciudad);
            
            ps.executeUpdate();
            
            PreparedStatement cs = con.prepareStatement("EXEC SPItelefono ?,?");
            cs.setInt(2, cedula);
            
            for (Integer telefono : telefonos) {
                cs.setInt(1, telefono);
                cs.executeUpdate();
            }
        }  
    }
   
    public static void InsertClienteO(String estado, String tipo, int cedula, String nombre, String direccion, String ciudad, String nombreContacto, String cargoContacto, int telefonoContacto) throws SQLException{
        try(PreparedStatement cstmt = con.prepareStatement("EXEC SPIcliente ?, ?");) {  

            cstmt.setString(1, estado);
            cstmt.setString(2, tipo);
            cstmt.executeUpdate(); 
            
            PreparedStatement ps = con.prepareStatement("EXEC SPIorganizacion ?,?,?,?,?,?,?");
            
            ps.setInt(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, ciudad);
            ps.setString(5, nombreContacto);
            ps.setString(6, cargoContacto);
            ps.setInt(7, telefonoContacto);
            
            ps.executeUpdate();

        }  
    }
}
