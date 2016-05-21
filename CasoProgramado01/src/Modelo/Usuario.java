/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.Serializable;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Usuario implements Serializable{

    private String usuario;
    private String contrasenia;
    private String nombre;

    public Usuario(String usuario, String nombre, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getInformacion()
    {
        return "Usuario: "+usuario+"Nombre: "+nombre;
    }

    
    
    
    
    
    
    
    
}
