/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudmvc;

import controlador.CtrlLogin;
import modelo.Coneccion;
import modelo.ConsultasLogin;
import modelo.Login;
import vista.FrmRegistro;
import vista.frmLogin;

/**
 *
 * @author crist
 */
public class CrudMvc {
    public static void main(String[] args) {
        
        Login login = new Login();
        ConsultasLogin consultasLogin = new ConsultasLogin();
        FrmRegistro frmRegistro = new FrmRegistro();
        frmLogin frmLogin = new frmLogin();
        CtrlLogin ctrlLogin = new CtrlLogin(login, consultasLogin, frmLogin);
        
        
        //ctrlLogin.iniciar();
        frmRegistro.setVisible(true);
        
    }
}
