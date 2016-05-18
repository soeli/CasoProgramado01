/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ArchivoUsuario;
import Modelo.MetodosUsuario;
import Vista.Login;
import Vista.ModuloMantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SOFIA ELIZONDO
 */
//Cambiar nombre de mesajes
public class Controlador_Usuario implements ActionListener{
    
   public MetodosUsuario metodosUsuario;
    ModuloMantenimientoUsuarios mantenimientoUsuarios;
    ArchivoUsuario archivo;
    Login login;
    Controlador_MenuPrincipal controlador_MenuPrincipal;
    public Controlador_Usuario(ModuloMantenimientoUsuarios mantenimientoUsuarios, Login login)
    {
        archivo=new ArchivoUsuario();
       
        metodosUsuario= new MetodosUsuario();
        this.mantenimientoUsuarios=mantenimientoUsuarios;
        this.login=login;
        if(this.archivo.cargarArchivoUsuario())
        {
            metodosUsuario.llenarArray(archivo.devolverInfromacionDelArchivoUsuario());
            
        }
        else
        {
            
        }
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("Aceptar"))
        {
          if(metodosUsuario.consultarUsuario(login.devolverUsuario()))
          {
              mantenimientoUsuarios.usuarioCorrecto();
          }
          else
          {
              login.mostrarMensaje("El usurario y la contraseña no coninciden");
          }
        
            System.out.println("Aceptar");
        }
        
        if(e.getActionCommand().equals("Registro"))
        {
           mantenimientoUsuarios.nuevoRegistro();
        
            System.out.println("Registro");
        }
        
        
        if(e.getActionCommand().equals("Agregar"))
        {
            metodosUsuario.agregarUsuario(mantenimientoUsuarios.devolverInformacion());
            mantenimientoUsuarios.mostrarMensaje("El estudiante fue registrado de forma correcta");
            mantenimientoUsuarios.resetearVentana();
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            metodosUsuario.modificarUsuario(mantenimientoUsuarios.devolverInformacion());
            mantenimientoUsuarios.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            mantenimientoUsuarios.resetearVentana();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            metodosUsuario.eliminarUsuario(mantenimientoUsuarios.devolverInformacion());
            mantenimientoUsuarios.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            mantenimientoUsuarios.resetearVentana();
        }
    }
    public void buscar()
    {
        if(metodosUsuario.consultarUsuario(mantenimientoUsuarios.devolverUsuario()))
            {
                mantenimientoUsuarios.mostrarInformacion(metodosUsuario.getArregloInformacion());
                mantenimientoUsuarios.habilitarEdicion();
            }
            else
            {
                mantenimientoUsuarios.mostrarMensaje("La cédula buscada no se encuentra.");
                mantenimientoUsuarios.resetearVentana();
            }
    }
    
    public void ingresarInfo()
    {
        archivo.crearArchivoUsuario();
        for(int contador=0;contador<this.metodosUsuario.getTamnio();contador++)
        {
            this.archivo.ingresarInformacionArchivoUsuario(this.metodosUsuario.getObjeto(contador));
        }
    }
    
}
