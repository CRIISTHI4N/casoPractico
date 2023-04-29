/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author crist
 */
public class ConsultasLogin extends Coneccion{
    
    public boolean registrar(Login login){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO login (usuario, pass) VALUES(?,?)";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getUser());
            ps.setString(2, login.getPass());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public boolean modificar(Login login){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "UPDATE login SET usuario=?, pass=? WHERE idUser=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, login.getUser());
            ps.setString(2, login.getPass());
            ps.setInt(3, login.getIdUser());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public boolean eliminar(Login login){
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "DELETE FROM login WHERE idUser=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, login.getIdUser());
            ps.execute();
            return true;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
    public boolean buscar(Login login){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        
        String sql = "SELECT * FROM login WHERE idUser=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, login.getIdUser());
            ps.executeQuery();
            
            // utilizar while si son barios registros
            if (rs.next()) {
                login.setIdUser(Integer.parseInt(rs.getString("idUser")));
                login.setUser(rs.getString("usuario"));
                login.setPass(rs.getString("pass"));
                return true;
            }
            
            return false;
            
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
