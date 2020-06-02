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
    
    public static boolean InsertClienteP(String estado, String tipo, int cedula, String nombre, String direccion, String ciudad, ArrayList<Integer> telefonos) throws SQLException{
        try {  
            
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(rs.next())
                return false;
            
            PreparedStatement cstmt = con.prepareStatement("EXEC SPIcliente ?, ?");
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
            return true;
        }  catch (SQLException e){
            throw e;
        }
    }
   
    public static boolean InsertClienteO(String estado, String tipo, int cedula, String nombre, String direccion, String ciudad, String nombreContacto, String cargoContacto, int telefonoContacto) throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(rs.next())
                return false;
            
            PreparedStatement cstmt = con.prepareStatement("EXEC SPIcliente ?, ?"); 

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
            return true;
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static boolean SuspenderPersona(int cedula)throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSuspPersona ?");
            ps.setInt(1, cedula);
            ps.executeUpdate();
            
            return true;
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static boolean SuspenderOrg(int cedula)throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSuspOrg ?");
            ps.setInt(1, cedula);
            ps.executeUpdate();
            
            return true;
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static ArrayList<String> getPersona(int cedula)throws SQLException{
        try{
            ArrayList<String> datos = new ArrayList<>();
        
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            
            if(rs.next()){
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
                datos.add(rs.getString(3));
                datos.add(rs.getString(4));
            }else{
                return null;
            }
            return datos;
        } catch (SQLException e){
            throw e;
        }
    }
    
    public static ArrayList<String> getOrganizacion(int cedula)throws SQLException{
        try{
            ArrayList<String> datos = new ArrayList<>();
        
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            
            if(rs.next()){
                datos.add(rs.getString(1));
                datos.add(rs.getString(2));
                datos.add(rs.getString(3));
                datos.add(rs.getString(4));
                datos.add(rs.getString(5));
                datos.add(Integer.toString(rs.getInt(6)));
                datos.add(rs.getString(7));
            }else{
                return null;
            }
            return datos;
        } catch (SQLException e){
            throw e;
        }
    }
}
