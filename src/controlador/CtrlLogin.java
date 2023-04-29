/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasLogin;
import modelo.Login;
import vista.FrmRegistro;
import vista.frmLogin;

/**
 *
 * @author crist
 */
public class CtrlLogin implements ActionListener{
    private Login login;
    private ConsultasLogin consultasLogin;
    private frmLogin frmLogin;
    private FrmRegistro frmRegistro;
    
    
    
    public CtrlLogin(Login login, ConsultasLogin consultasLogin, frmLogin frmLogin){
        this.login = login;
        this.consultasLogin = consultasLogin;
        this.frmLogin = frmLogin;
        this.frmLogin.btnGuardar.addActionListener(this);
        
    }
    
    public void iniciar(){
        frmLogin.setTitle("Registro");
        frmLogin.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == frmLogin.btnGuardar) {
            login.setUser(frmLogin.txtUser.getText());
            login.setPass(frmLogin.txtPass.getText());
            
            if (consultasLogin.registrar(login)) {
                JOptionPane.showMessageDialog(null, "OK");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
                limpiar();
            }
        }
        
        if (e.getSource() == frmLogin.btnModificar) {
            login.setId(frm.txtId.getText())
            login.setUser(frmLogin.txtUser.getText());
            login.setPass(frmLogin.txtPass.getText());
            
            if (consultasLogin.modififcar(login)) {
                JOptionPane.showMessageDialog(null, "OK");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
                limpiar();
            }
        }
        
        if (e.getSource() == frmLogin.btnEliminar) {
            login.setId(frm.txtId.getText())
            
            if (consultasLogin.eliminar(login)) {
                JOptionPane.showMessageDialog(null, "OK");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
                limpiar();
            }
        }
        
        if (e.getSource() == frmLogin.btnBuscar) {
            login.setId(frm.txtId.getText())
            
            if (consultasLogin.buscar(login)) {
                JOptionPane.showMessageDialog(null, "OK");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR");
                limpiar();
            }
        }
    }
    
    public void limpiar(){
        frmLogin.txtUser.setText(null);
        frmLogin.txtPass.setText(null);
    }
}
