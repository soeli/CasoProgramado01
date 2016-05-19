/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ArchivoCurso;
import Modelo.ConexionBD;
import Modelo.Cursos;
import Modelo.MetodosCursos;
import Vista.VentanaCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Controlador_Cursos implements ActionListener{

    public MetodosCursos metodosCursos;
    VentanaCursos ventanaCursos;
    public ConexionBD conexionBD;
    ArchivoCurso archivoCurso;
    String metodoAlmacenamiento;

    public Controlador_Cursos(VentanaCursos ventanaCursos, ConexionBD conexionBD,ArchivoCurso archivoCurso)
    {
        this.ventanaCursos=ventanaCursos;
        this.conexionBD=conexionBD;
        this.archivoCurso=archivoCurso;

    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosCursos.agregarCurso(ventanaCursos.devolverInformacion());
            }
            if(metodoAlmacenamiento=="BD")
            {
               conexionBD.registrarCurso(ventanaCursos.devolverInformacion());
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            
            ventanaCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            ventanaCursos.resetearGUI();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosCursos.modificarCurso(ventanaCursos.devolverInformacion());
            }
            if(metodoAlmacenamiento=="BD")
            {
               conexionBD.actualizarCurso(ventanaCursos.devolverInformacion(),"cursos");
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            
            ventanaCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            ventanaCursos.resetearGUI();     
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosCursos.eliminarCurso(ventanaCursos.devolverInformacion());
            }
            if(metodoAlmacenamiento=="BD")
            {
               conexionBD.eliminarEstudiante(ventanaCursos.devolverSigla(),"cursos","sigla");
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            
            ventanaCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            ventanaCursos.resetearGUI();
        }
    
    }
    public void buscar()
    {
        if(metodoAlmacenamiento=="Archivos")
            {
                    if(metodosCursos.consultarCurso(ventanaCursos.devolverSigla()))
                    {
                        ventanaCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                        modificar();
                   }
                   else
                   {
                        agregar();
                   }
            }
            if(metodoAlmacenamiento=="BD")
            {
                   if(conexionBD.consultarEstudiante(ventanaCursos.devolverSigla()))
                   {
                       ventanaCursos.mostrarInformacion(conexionBD.getArregloInformacion());
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
        ventanaCursos.habilitarEdicion();
    }
    public void agregar()
    {
        ventanaCursos.mostrarMensaje("El curso buscado no se encuentra.");
        ventanaCursos.habilitarAgregar();
    }
    
    public void ingresarInfo()
    {
        ArrayList <Cursos> array=metodosCursos.getArray();
        archivoCurso.crearArchivoCurso();
        for(int contador=0;contador<array.size();contador++)
        {
            archivoCurso.ingresarInformacionArchivoCurso(array.get(contador));
        }
    }
 

    public void seleccionAlmacenamiento(String almacenamiento) {
        metodoAlmacenamiento=almacenamiento; 
        if(metodoAlmacenamiento=="Archivos")
            {
                metodosCursos= new MetodosCursos();
                archivoCurso=new ArchivoCurso();
                if(this.archivoCurso.cargarArchivoCurso())
                {
                    metodosCursos.setArray(archivoCurso.devolverInfromacionDelArchivoCurso());

                }
                else
                {          
                }
            }
    }

    

    
}
