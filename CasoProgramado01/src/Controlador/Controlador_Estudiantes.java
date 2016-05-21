/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoEstudiante;
import Modelo.ConexionBD;
import Modelo.MetodosEstudiantes;
import Modelo.Metodos_XML_Estudiante;
import Vista.VentanaEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
//Controla la ventanaEstudiantes
public class Controlador_Estudiantes implements ActionListener{
    
    public MetodosEstudiantes metodosEstudiantes;
    VentanaEstudiantes ventanaEstudiantes;
    ConexionBD conexionBD; 
    ArchivoEstudiante archivoEstudiante;
    String metodoAlmacenamiento;
    Metodos_XML_Estudiante metodos_XML;
 
    //MetodoConstructor recibe la ventanaEstudiantes y las diferentes formas de almacenamiento
    //Crea la clase de metodosEstudiante
    public Controlador_Estudiantes(VentanaEstudiantes ventanaEstudiantes,ConexionBD conexionBD,ArchivoEstudiante archivoEstudiante,Metodos_XML_Estudiante metodos_XML)
    {
        metodosEstudiantes= new MetodosEstudiantes();
        this.conexionBD=conexionBD;
        this.ventanaEstudiantes=ventanaEstudiantes;
        this.archivoEstudiante=archivoEstudiante; 
        this.metodos_XML=metodos_XML;
        
    }
    
   
    //Escucha a los botones de la VentanaEstudiantes
    public void actionPerformed(ActionEvent e)
    {
        //Agrega a los estudiantes segun el metodo seleccionado
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
               metodos_XML.guardarEnXMLEstudiante(ventanaEstudiantes.devolverInformacion());
            } 
            ventanaEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            ventanaEstudiantes.resetearVentana();
            
        }
        //Llama al metodo buscar para realizar la consulta
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        
        //Modifica a los estudiantes creados
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
                metodos_XML.modificarInformacionDelXmlEstudiante(ventanaEstudiantes.devolverInformacion());

            }
            ventanaEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            ventanaEstudiantes.resetearVentana();
        }
        
        //Elimina a los estudiantes
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
                metodos_XML.eliminarInformacionDelXmlEstudiante(ventanaEstudiantes.devolverCedula());
            }
            ventanaEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            ventanaEstudiantes.resetearVentana();
        }
    }
    
    //Realiza la consulta de los Estudiantes y determina si existe o no
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
                if(metodos_XML.consultarInformacionDelXmlEstudiante(ventanaEstudiantes.devolverCedula()))
                {
                    ventanaEstudiantes.mostrarInformacion(metodos_XML.getArregloInformacion());
                    modificar();
                }
                else
                {
                    agregar();
                } 
            }
       
    }
    
    //habilita las opciones para modificar Estudiantes
    public void modificar()
    {
        ventanaEstudiantes.habilitarEdicion();
    }
    
    //habilita las opciones para agregar Estudiantes
    public void agregar()
    {
        ventanaEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
        ventanaEstudiantes.habilitarAgregar();
    }
    
    //permite ingresar la informacion de Estudiantes al archivo Estudiantes
    public void ingresarInfo()
    {
        archivoEstudiante.crearArchivoEstudiante();
        for(int contador=0;contador<this.metodosEstudiantes.getTamnio();contador++)
        {
            this.archivoEstudiante.ingresarInformacionArchivoEstudiante(this.metodosEstudiantes.getObjeto(contador));
        }
    }
 
    //Recibe el string que determina el tipo de almacenamiento a utilizar
    public void seleccionAlmacenamiento(String almacenamiento) {
        metodoAlmacenamiento=almacenamiento; 
        if(metodoAlmacenamiento=="Archivos")
            {
                
                System.out.println("Metodos Estudiantes iniciado");
                archivoEstudiante=new ArchivoEstudiante();
                if(this.archivoEstudiante.cargarArchivoEstudiante())
                {
                    metodosEstudiantes.llenarArray(archivoEstudiante.devolverInfromacionDelArchivoEstudiante());

                }
                else
                {          
                }
            }
        
        if(metodoAlmacenamiento=="XML")
        {
           //metodos_XML.determinarArchivo("Estudiante");
        }
        if(metodoAlmacenamiento==null)
        {
           ventanaEstudiantes.mostrarMensaje("Porfavor seleccione un metodo de almacenamiento");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
