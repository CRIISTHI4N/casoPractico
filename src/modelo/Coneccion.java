/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class Coneccion {
    
    
    private final String base="casopractico1";
    private final String user="root";
    private final String password="";
    private final String url="jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;
    
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("EXITO");
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("ERROR");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Coneccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return con;    }
    
    /*private static Connection con;
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/hospital";
    
    public static void main(String args[]) {
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                System.out.println("exito");
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("error");
        }
    }*/
    
}
