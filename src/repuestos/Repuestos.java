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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
            Long.parseLong(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    
    public static boolean InsertClienteP(String estado, String tipo, String cedula, String nombre, String direccion, String ciudad, ArrayList<Integer> telefonos) throws SQLException{
        try {  
            
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");  //Revisa si la persona existe
            ct.setString(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(rs.next())
                return false;
            
            PreparedStatement cstmt = con.prepareStatement("EXEC SPIcliente ?, ?");
            cstmt.setString(1, estado);
            cstmt.setString(2, tipo);
            cstmt.executeUpdate();  
            
            PreparedStatement ps = con.prepareStatement("EXEC SPIpersonas ?,?,?,?");
            
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, ciudad);
            
            ps.executeUpdate();
            
            PreparedStatement cs = con.prepareStatement("EXEC SPItelefono ?,?");
            cs.setString(2, cedula);
            
            for (Integer telefono : telefonos) {
                cs.setInt(1, telefono);
                cs.executeUpdate();
            }
            return true;
        }  catch (SQLException e){
            throw e;
        }
    }
   
    public static boolean InsertClienteO(String estado, String tipo, String cedula, String nombre, String direccion, String ciudad, String nombreContacto, String cargoContacto, int telefonoContacto) throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");  //Revisa si la organizacion existe
            ct.setString(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(rs.next())
                return false;
            
            PreparedStatement cstmt = con.prepareStatement("EXEC SPIcliente ?, ?"); 

            cstmt.setString(1, estado);
            cstmt.setString(2, tipo);
            cstmt.executeUpdate(); 
            
            PreparedStatement ps = con.prepareStatement("EXEC SPIorganizacion ?,?,?,?,?,?,?");
            
            ps.setString(1, cedula);
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
    
    public static boolean SuspenderPersona(String cedula)throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");  //Revisa si la persona existe
            ct.setString(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSuspPersona ?");
            ps.setString(1, cedula);
            ps.executeUpdate();
            
            return true;
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static boolean SuspenderOrg(String cedula)throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");  //Revisa si la organizacion existe
            ct.setString(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSuspOrg ?");
            ps.setString(1, cedula);
            ps.executeUpdate();
            
            return true;
        }catch (SQLException e){
            throw e;
        }
    }
    
    public static ArrayList<String> getPersona(String cedula)throws SQLException{
        try{
            ArrayList<String> datos = new ArrayList<>();
        
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");
            ct.setString(1, cedula);
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
            ps.setString(1, cedula);
            ResultSet t = ps.executeQuery();
            String telefonos = "";
            while(t.next()){
                if("".equals(telefonos))
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
    
    public static ArrayList<String> getOrganizacion(String cedula)throws SQLException{
        try{
            ArrayList<String> datos = new ArrayList<>();
        
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");
            ct.setString(1, cedula);
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
    
    public static boolean updatePersona(String estado, String cedula, String nombre, String direccion, String ciudad, ArrayList<Integer> telefonos) throws SQLException{
        try {  
            
            PreparedStatement ct = con.prepareStatement("EXEC SPS1persona ?");
            ct.setString(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;  
            
            PreparedStatement ps = con.prepareStatement("EXEC SPUpersonas ?,?,?,?,?");
            
            ps.setString(1, cedula);
            ps.setString(2, nombre);
            ps.setString(3, direccion);
            ps.setString(4, ciudad);
            ps.setString(5, estado);
            
            ps.executeUpdate();
            
            PreparedStatement getTel = con.prepareStatement("EXEC SPStelefonos ?");
            getTel.setString(1, cedula);
            ResultSet t = getTel.executeQuery();
            ArrayList<Integer> telefonosEx = new ArrayList<>();
            while(t.next()){
                telefonosEx.add(t.getInt(1));
            }
            PreparedStatement delT = con.prepareStatement("EXEC SPDtelefonos ?");
            PreparedStatement cs = con.prepareStatement("EXEC SPItelefono ?,?");
            cs.setString(2, cedula);
            
            
            for (Integer telefono : telefonosEx) {
                try{
                    if(!telefonos.contains(telefono)){
                        System.out.println(telefono + " ya no existe");
                        delT.setInt(1, telefono);
                        delT.executeUpdate();
                    }
                }catch(SQLException e){
                }
            }
            
            
            for (Integer telefono : telefonos) {
                try{
                    if(!telefonosEx.contains(telefono)){
                        cs.setInt(1, telefono);
                        cs.executeUpdate();
                    }
                }catch(SQLException e){
                }
            }
            return true;
        }  catch (SQLException e){
            throw e;
        }
    }
    
    public static boolean updateOrg (String estado, String cedula, String nombre, String direccion, String ciudad, String nombreContacto, String cargoContacto, int telefonoContacto) throws SQLException{
        try{
            PreparedStatement ct = con.prepareStatement("EXEC SPS1org ?");  //Revisa si la organizacion existe
            ct.setString(1, cedula);
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            
            PreparedStatement ps = con.prepareStatement("EXEC SPUorganizacion ?,?,?,?,?,?,?,?");
            
            ps.setString(1, cedula);
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
    
    public static void SelectClientes(DefaultTableModel tabla) throws SQLException{
        
        try{
            
            PreparedStatement ct = con.prepareStatement("EXEC SPSpersonas");
            PreparedStatement ctmts = con.prepareStatement("EXEC SPSorganizacion");
            PreparedStatement ps = con.prepareStatement("EXEC SPStelefonos ?");
            
            ResultSet rt = ct.executeQuery();
            
            String idP, nomP, cedP, dirP, ciudP, estP, telefonos;
            
            while(rt.next()){
                idP = Integer.toString(rt.getInt(1));
                nomP = rt.getString(2);
                cedP = rt.getString(3);
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
                tabla.addRow(new Object[]{Integer.parseInt(idP), "Persona", nomP, cedP, "", dirP, ciudP, telefonos, estP, ""});

            }
            ResultSet org = ctmts.executeQuery();
            
            String idO, nomO, cedO, dirO, ciudO, estO, nomCont;
            while(org.next()){
                idO = Integer.toString(org.getInt(1));
                nomO = org.getString(2);
                cedO = org.getString(3);
                dirO = org.getString(4);
                ciudO = org.getString(5);
                estO = org.getString(6);
                nomCont = org.getString(7);
                
                tabla.addRow(new Object[]{Integer.parseInt(idO), "Organizacion", nomO, "", cedO, dirO, ciudO, "", estO, nomCont});
            }
        
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
    
     public static boolean getPartes(JComboBox combo) throws SQLException{
        try{
            PreparedStatement ps = con.prepareStatement("EXEC SPSpartestotales");
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()){
                combo.addItem(resultado.getString(1));
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

    static boolean crearOrden(String cedula, String tipo, Date sqlFecha, JFrame p) throws SQLException{
        try{
            PreparedStatement ps = con.prepareStatement("EXEC SPIorden ?, ?, ?");
            PreparedStatement ct = con.prepareStatement("EXEC SPgetID ?, ?");
            ct.setString(1, cedula);
            ct.setString(2, tipo);
            
            ResultSet rs = ct.executeQuery();
            if(!rs.next()){
                JOptionPane.showMessageDialog(p, "El cliente no existe", "Advertencia", 2);
                return false;
            }
            
            if(!verificarEstado(cedula)){
                JOptionPane.showMessageDialog(p, "Cliente suspendido, no puede tener ordenes", "Advertencia", 2);
                return false;
            }
            
            ps.setString(1, cedula);
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
    
    static boolean selectOrdenes(String cedula, String tipo, DefaultTableModel tabla, String fecha)throws SQLException{
        try{
            tabla.setRowCount(0);
            
            PreparedStatement ct = con.prepareStatement("EXEC SPgetID ?, ?");
            ct.setString(1, cedula);
            ct.setString(2, tipo);
            
            ResultSet rs = ct.executeQuery();
            if(!rs.next())
                return false;
            int id = rs.getInt(1);
            
            PreparedStatement ps = con.prepareStatement("EXEC SPSorden ?");
            ps.setInt(1, id);
            
            ResultSet result = ps.executeQuery();
            
            PreparedStatement monto = con.prepareStatement("EXEC SPSMontoDetalle ?");
            monto.setInt(1, id);
            ResultSet rMonto = monto.executeQuery();
            
            int MontoTotal = 0;
            while(rMonto.next()){
                MontoTotal += rMonto.getInt(1);
            }
            MontoTotal += MontoTotal*13/100;
            
            if(fecha == null){
                while(result.next()){
                    tabla.addRow(new Object[]{result.getInt(1), result.getString(2), MontoTotal});
                    
                }
            }else{
                while(result.next()){
                    if(result.getString(2).equals(fecha))
                        tabla.addRow(new Object[]{result.getInt(1), result.getString(2), MontoTotal});
                }
            }
            
            
            return true;
        }catch(SQLException e){
            throw e;
        }
    }

    static boolean asociarOrden(String cedula, int idOrden, String Parte, int cantidad, String proveedor, int monto)throws SQLException{
        try{
            if(!verificarEstado(cedula))
                return false;
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
        try{
            PreparedStatement ps = con.prepareStatement("EXEC SPDparte ?");
            ps.setString(1, NombreP);
            ps.executeUpdate();

            return true;
        }catch(SQLException e){
            throw e;
        }
    }
    
    
    static boolean verificarEstado(String cedula) throws SQLException{
        try{
            PreparedStatement ps = con.prepareStatement("EXEC SPverEstado ?");
            ps.setString(1, cedula);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if("Suspendido".equals(rs.getString(1)))
                    return false;
            }

            return true;
        }catch(SQLException e){
            throw e;
        }
    }
    
    static boolean CostoCreate(String Provedor, String Parte, int Precio, int Ganancia) throws SQLException{
        try{
            int ParteID;
            PreparedStatement obtenerID = con.prepareStatement("EXEC SPgetParteID ?");
            obtenerID.setString(1, Parte);
            ResultSet ID = obtenerID.executeQuery();
            if(ID.next())
                ParteID = ID.getInt(1);
            else
                return false;
            System.out.println("Precio: " + Precio + " Ganancia:" + Ganancia);
            PreparedStatement ps = con.prepareStatement("EXEC SPSpartesCosto ?, ?");
            PreparedStatement Insertps = con.prepareStatement("EXEC SPIpartesCosto ?, ?, ?, ?");
            ps.setString(1, Provedor);
            ps.setInt(2, ParteID);
            ResultSet rs = ps.executeQuery();
            if(!rs.next()){
                Insertps.setString(1, Provedor);
                Insertps.setInt(2, ParteID);
                Insertps.setInt(3, Precio);
                Insertps.setInt(4, Ganancia);
                Insertps.executeUpdate();
                return true;
            }

            return false;
        }catch(SQLException e){
            throw e;
        }
    }
    
    static boolean CostoUpdate(String Provedor, String Parte, int Precio, int Ganancia) throws SQLException{
        try{
            int ParteID;
            PreparedStatement obtenerID = con.prepareStatement("EXEC SPgetParteID ?");
            obtenerID.setString(1, Parte);
            ResultSet ID = obtenerID.executeQuery();
            if(ID.next())
                ParteID = ID.getInt(1);
            else
                return false;
            
            System.out.println("Precio: " + Precio + " Ganancia:" + Ganancia);
            PreparedStatement ps = con.prepareStatement("EXEC SPSpartesCosto ?, ?");
            PreparedStatement UpdatePs = con.prepareStatement("EXEC SPUpartesCosto ?, ?, ?, ?");
            ps.setString(1, Provedor);
            ps.setInt(2, ParteID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                UpdatePs.setString(1, Provedor);
                UpdatePs.setInt(2, ParteID);
                UpdatePs.setInt(3, Precio);
                UpdatePs.setInt(4, Ganancia);
                UpdatePs.executeUpdate();
                return true;
            }

            return false;
        }catch(SQLException e){
            throw e;
        }
    }
}
