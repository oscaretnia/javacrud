/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.dao.UsuarioDao;
import vista.Vista;

/**
 *
 * @author Mariana
 */
public class LoginControlador {
    
    private final UsuarioDao model;
    private final Vista vista;
    
    public LoginControlador(Vista vista) {
        this.model = new UsuarioDao();
        this.vista = vista;
    }
    
    public void iniciarSesion(String correo, String clave) {
        
        try {
            if (model.findUsuario(correo).getClave().equals(clave)) {
                vista.navegar();
            } else {
                vista.mostrarError("");
            }
        } catch(Exception ex) {
            vista.mostrarError("");
        }
        
    }
    
}
