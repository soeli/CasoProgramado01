/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoEstudiante;
import Modelo.ConexionBD;
import Modelo.MetodosEstudiantes;
import Vista.VentanaEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Controlador_Estudiantes implements ActionListener{
    
    public MetodosEstudiantes metodosEstudiantes;
    VentanaEstudiantes ventanaEstudiantes;
    ConexionBD conexionBD; 
    ArchivoEstudiante archivoEstudiante;
 
    public Controlador_Estudiantes(VentanaEstudiantes ventanaEstudiantes,ConexionBD conexionBD,ArchivoEstudiante archivoEstudiante)
    {
        this.conexionBD=conexionBD;
        this.ventanaEstudiantes=ventanaEstudiantes;
        this.archivoEstudiante=archivoEstudiante;
        metodosEstudiantes= new MetodosEstudiantes();
        
    }
    
   
    
    public void actionPerformed(ActionEvent e)
    {
        
        
        
        if(e.getActionCommand().equals("Agregar"))
        {
            conexionBD.registrarEstudiante(ventanaEstudiantes.devolverInformacion());
            ventanaEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            ventanaEstudiantes.resetearVentana();
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            conexionBD.actualizarEstudiante(ventanaEstudiantes.devolverInformacion(),"estudiantes");
            ventanaEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            ventanaEstudiantes.resetearVentana();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            conexionBD.eliminarEstudiante(ventanaEstudiantes.devolverCedula(),"estudiantes","cedula");
            ventanaEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            ventanaEstudiantes.resetearVentana();
        }
    }
    public void buscar()
    {
        
       if(conexionBD.consultarEstudiante(ventanaEstudiantes.devolverCedula()))
       {
           
            ventanaEstudiantes.mostrarInformacion(conexionBD.getArregloInformacion());
            ventanaEstudiantes.habilitarEdicion();
       }
       else
       {
           ventanaEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
            ventanaEstudiantes.habilitarAgregar();
       }
    }
    
    public void ingresarInfo()
    {
        archivoEstudiante.crearArchivoEstudiante();
        for(int contador=0;contador<this.metodosEstudiantes.getTamnio();contador++)
        {
            this.archivoEstudiante.ingresarInformacionArchivoEstudiante(this.metodosEstudiantes.getObjeto(contador));
        }
    }

    public void seleccionAlmacenamiento(String almacenamiento) {
        
        if(almacenamiento=="archivos")
        {
            
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
