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
    String metodoAlmacenamiento;
 
    public Controlador_Estudiantes(VentanaEstudiantes ventanaEstudiantes,ConexionBD conexionBD,ArchivoEstudiante archivoEstudiante)
    {
        this.conexionBD=conexionBD;
        this.ventanaEstudiantes=ventanaEstudiantes;
        this.archivoEstudiante=archivoEstudiante;
        
        
        
    }
    
   
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosEstudiantes.agregarEstudiante(ventanaEstudiantes.devolverInformacion());
            }
            if(metodoAlmacenamiento=="BD")
            {
               conexionBD.registrarEstudiante(ventanaEstudiantes.devolverInformacion());
            }
            if(metodoAlmacenamiento=="XML")
            {

            } 
            ventanaEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            ventanaEstudiantes.resetearVentana();
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosEstudiantes.modificarEstudiante(ventanaEstudiantes.devolverInformacion());
            }
            if(metodoAlmacenamiento=="BD")
            {
               conexionBD.actualizarEstudiante(ventanaEstudiantes.devolverInformacion(),"estudiantes");
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            ventanaEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            ventanaEstudiantes.resetearVentana();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosEstudiantes.eliminarEstudiante(ventanaEstudiantes.devolverInformacion());
            }
            if(metodoAlmacenamiento=="BD")
            {
               conexionBD.eliminarEstudiante(ventanaEstudiantes.devolverCedula(),"estudiantes","cedula");
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            ventanaEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            ventanaEstudiantes.resetearVentana();
        }
    }
    public void buscar()
    {
       if(metodoAlmacenamiento=="Archivos")
            {
                    if(metodosEstudiantes.consultarEstudiante(ventanaEstudiantes.devolverCedula()))
                    {
                        ventanaEstudiantes.mostrarInformacion(metodosEstudiantes.getArregloInformacion());
                        modificar();
                   }
                   else
                   {
                        agregar();
                   }
            }
            if(metodoAlmacenamiento=="BD")
            {
                   if(conexionBD.consultarEstudiante(ventanaEstudiantes.devolverCedula()))
                   {
                       ventanaEstudiantes.mostrarInformacion(conexionBD.getArregloInformacion());
                        modificar();
                   }
                   else
                   {
                        agregar();
                   }
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
       
    }
    
    public void modificar()
    {
        
        ventanaEstudiantes.habilitarEdicion();
    }
    public void agregar()
    {
        ventanaEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
        ventanaEstudiantes.habilitarAgregar();
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
        metodoAlmacenamiento=almacenamiento; 
        if(metodoAlmacenamiento=="Archivos")
            {
                metodosEstudiantes= new MetodosEstudiantes();
                archivoEstudiante=new ArchivoEstudiante();
                if(this.archivoEstudiante.cargarArchivoEstudiante())
                {
                    metodosEstudiantes.llenarArray(archivoEstudiante.devolverInfromacionDelArchivoEstudiante());

                }
                else
                {          
                }
            }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
