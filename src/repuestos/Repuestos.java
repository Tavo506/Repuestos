/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repuestos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
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
            
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");  //Revisa si la persona existe
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
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");  //Revisa si la organizacion existe
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
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");  //Revisa si la persona existe
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
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");  //Revisa si la organizacion existe
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
            
            PreparedStatement ps = con.prepareStatement("EXEC SPStelefonos ?");
            ps.setInt(1, cedula);
            ResultSet t = ps.executeQuery();
            String telefonos = "";
            while(t.next()){
                if(telefonos == "")
                    telefonos = Integer.toString(t.getInt(1));
                else
                    telefonos += "," + Integer.toString(t.getInt(1));
            }
            datos.add(telefonos);
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
    
    public static boolean updatePersona(String estado, int cedula, String nombre, String direccion, String ciudad, ArrayList<Integer> telefonos) throws SQLException{
        try {  
            
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;  
            
            PreparedStatement ps = con.prepareStatement("EXEC SPUpersonas ?,?,?,?,?");
            
            ps.setInt(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, ciudad);
            ps.setString(5, estado);
            
            ps.executeUpdate();
            
            PreparedStatement cs = con.prepareStatement("EXEC SPItelefono ?,?");
            cs.setInt(2, cedula);
            
            for (Integer telefono : telefonos) {
                try{
                cs.setInt(1, telefono);
                cs.executeUpdate();
                }catch(Exception e){
                }
            }
            return true;
        }  catch (SQLException e){
            throw e;
        }
    }
    
    public static boolean updateOrg (String estado, int cedula, String nombre, String direccion, String ciudad, String nombreContacto, String cargoContacto, int telefonoContacto) throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");  //Revisa si la organizacion existe
            ct.setInt(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            PreparedStatement ps = con.prepareStatement("EXEC SPUorganizacion ?,?,?,?,?,?,?,?");
            
            ps.setInt(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, ciudad);
            ps.setString(5, nombreContacto);
            ps.setString(6, cargoContacto);
            ps.setInt(7, telefonoContacto);
            ps.setString(8, estado);
            
            ps.executeUpdate();
            return true;
        }catch (SQLException e){
            throw e;
        }
        
    }
    
    public static ArrayList<String> SelectClientes() throws SQLException{
        
        try{
            ArrayList<String> clientes = new ArrayList<>();
            
            PreparedStatement ct = con.prepareStatement("EXEC SPSpersonas");
            PreparedStatement ctmts = con.prepareStatement("EXEC SPSorganizacion");
            PreparedStatement ps = con.prepareStatement("EXEC SPStelefonos ?");
            
            ResultSet rt = ct.executeQuery();
            
            String persona, idP, nomP, cedP, dirP, ciudP, estP, telefonos;
            
            while(rt.next()){
                idP = Integer.toString(rt.getInt(1));
                nomP = rt.getString(2);
                cedP = Integer.toString(rt.getInt(3));
                dirP = rt.getString(4);
                ciudP = rt.getString(5);
                estP = rt.getString(6);
                
                ps.setInt(1, Integer.parseInt(cedP));
                ResultSet t = ps.executeQuery();
                telefonos = "";
                
                while(t.next()){
                    if("".equals(telefonos))
                        telefonos = Integer.toString(t.getInt(1));
                    else
                        telefonos += "," + Integer.toString(t.getInt(1));
                }
                persona = idP + ",Persona," + nomP + "," + cedP + ","+ dirP + "," + ciudP + "," + estP + "," + telefonos;
                clientes.add(persona);
            }
            ResultSet org = ctmts.executeQuery();
            
            String organizacion, idO, nomO, cedO, dirO, ciudO, estO, nomCont;
            while(org.next()){
                idO = Integer.toString(org.getInt(1));
                nomO = org.getString(2);
                cedO = Integer.toString(org.getInt(3));
                dirO = org.getString(4);
                ciudO = org.getString(5);
                estO = org.getString(6);
                nomCont = org.getString(7);
                
                organizacion = idO + ",Organizacion," + nomO + "," + cedO + ","+ dirO + "," + ciudO + "," + estO + "," + nomCont;
                clientes.add(organizacion);
            }
        
        return clientes;
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static boolean Verpartes(int anno, String modelo, DefaultTableModel tabla) throws SQLException{
        try{
        
            PreparedStatement ps = con.prepareStatement("EXEC SPSpartes ?, ?");
            ps.setInt(1,anno);
            ps.setString(2, modelo);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            tabla.addRow(new Object[]{rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
            return true;
        }
        
        catch(SQLException e)
            {throw e;}
    }
    
    public static boolean InsertPartes(int fabricante, String nombre, int marca) throws SQLException{
        try{
        
            PreparedStatement ps = con.prepareStatement("EXEC SPIpartes ?, ?, ?");
            ps.setInt(1,fabricante);
            ps.setString(2, nombre);
            ps.setInt(3, marca);
            ps.executeUpdate();
            return true;
        }
        
        catch(SQLException e)
            {throw e;}
    }
    
     public static boolean getPartes() throws SQLException{
        try{
            PreparedStatement ps = con.prepareStatement("EXEC SPSpartestotales");
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                System.out.println(resultado.getString(1));
                
                }
            return true;
    
        }catch(SQLException e)
            {throw e;}
    }
    
    public static boolean CreaAso(String ParteN, String Modelo) throws SQLException{
        int ParteID;
        int AnnoCarro;
    try{
            PreparedStatement ps = con.prepareStatement("EXEC SPSAsoParteAuto ?, ?");
            ps.setString(1, ParteN);
            ps.setString(2, Modelo);
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                ParteID = resultado.getInt(1);
                AnnoCarro = resultado.getInt(2);
                PreparedStatement ps2 = con.prepareStatement("EXEC SPIAsoParteAuto ?, ?, ?");
                ps2.setInt(1, ParteID);
                ps2.setString(2, Modelo);
                ps2.setInt(3, AnnoCarro);
                ps2.executeUpdate();
                }
            return true;
    
        }catch(SQLException e)
        {throw e;}
   
    }

    static boolean crearOrden(int cedula, String tipo, Date sqlFecha) throws SQLException{
        try{
            PreparedStatement ps = con.prepareStatement("EXEC SPIorden ?, ?, ?");
            PreparedStatement ct = con.prepareStatement("EXEC SPgetID ?, ?");
            ct.setInt(1, cedula);
            ct.setString(2, tipo);
            
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            ps.setInt(1, cedula);
            ps.setString(2, tipo);
            ps.setDate(3, sqlFecha);
            
            ps.executeUpdate();
            
            return true;
        }catch(SQLException e){
            throw e;
        }
    }
    

    static boolean selectProveedores(String nombreParte, DefaultTableModel tabla)throws SQLException{
        try{
            tabla.setRowCount(0);
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSprovedor ?");
            ps.setString(1, nombreParte);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                tabla.addRow(new Object[]{rs.getString(1), rs.getInt(4)});
            }
            
            return true;
        }catch(SQLException e){
            throw e;
        }
    }
    
    static boolean selectOrdenes(int cedula, String tipo, DefaultTableModel tabla)throws SQLException{
        try{
            tabla.setRowCount(0);
            
            PreparedStatement ct = con.prepareStatement("EXEC SPgetID ?, ?");
            ct.setInt(1, cedula);
            ct.setString(2, tipo);
            
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            int id = rs.getInt(1);
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSorden ?");
            ps.setInt(1, id);
            
            ResultSet result = ps.executeQuery();
            
            while(result.next()){
                tabla.addRow(new Object[]{result.getInt(1), result.getString(2), result.getInt(3)});
            }
            
            return true;
        }catch(SQLException e){
            throw e;
        }
    }

    static boolean asociarOrden(int idOrden, String Parte, int cantidad, String proveedor, int monto)throws SQLException{
        try{
            
            PreparedStatement ps = con.prepareStatement("EXEC SPIdetalle ?,?,?,?,?");
            ps.setInt(1, idOrden);
            ps.setString(2, Parte);
            ps.setInt(3, cantidad);
            ps.setString(4, proveedor);
            ps.setInt(5, monto);
            
            ps.executeUpdate();
            
            return true;
        }catch(SQLException e){
            throw e;
        }
    }
    static boolean BorrarParte(String NombreP) throws SQLException{
        
        PreparedStatement ps = con.prepareStatement("EXEC SPDparte ?");
        ps.setString(1, NombreP);
        ps.executeQuery();
        
        return false;
    }
}
