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
import Modelo.Metodos_XML_Cursos;
import Vista.VentanaCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */

// Esta clase se encanga de controlar la ventanaCursos

public class Controlador_Cursos implements ActionListener{

    public MetodosCursos metodosCursos;
    VentanaCursos ventanaCursos;
    public ConexionBD conexionBD;
    ArchivoCurso archivoCurso;
    String metodoAlmacenamiento;
    Metodos_XML_Cursos metodos_XML;
    
    //Metodo contructor, recibe la ventanaCursos y los diferentes parametros para cada tipo de almacenamiento
    // Se inicia la clase de metodos cursos
    public Controlador_Cursos(VentanaCursos ventanaCursos, ConexionBD conexionBD,ArchivoCurso archivoCurso,Metodos_XML_Cursos metodos_XML_Cursos)
    {
        metodosCursos= new MetodosCursos();
        this.ventanaCursos=ventanaCursos;
        this.conexionBD=conexionBD;
        this.archivoCurso=archivoCurso;
        this.metodos_XML=metodos_XML_Cursos;

    }
    
    //Escucha los borones de la clase ventanaCursos
    public void actionPerformed(ActionEvent evento)
    {
        //Agrega nuevos cursos
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
               metodos_XML.guardarEnXML(ventanaCursos.devolverInformacion());
            }
            
            ventanaCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            ventanaCursos.resetearGUI();
        }
        //Llama metodo buscar que realiza la consulta de los cursos
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        //Modifica los cursos
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
               metodos_XML.modificarInformacionDelXmlCursos(ventanaCursos.devolverInformacion());
            }
            
            ventanaCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            ventanaCursos.resetearGUI();     
        }
        
        //Elimina los cursos 
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
               metodos_XML.eliminarInformacionDelXmlCursos(ventanaCursos.devolverSigla());
            }
            
            ventanaCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            ventanaCursos.resetearGUI();
        }
    
    }
    
    //Metodo de consulta de los cursos existentes
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
                   if(conexionBD.consultarCurso(ventanaCursos.devolverSigla()))
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
             if(metodos_XML.consultarInformacionDelXml(ventanaCursos.devolverSigla()))
        {
            ventanaCursos.mostrarInformacion(metodos_XML.getArregloInformacion());
            
            ventanaCursos.mostrarMensaje("Información encontrada con la sigla : "+ventanaCursos.devolverSigla());
            modificar();
        }
        else
        {
            
          agregar();
        }
            }
    }
    

    //Habilita las opciones para modificar cursos
    public void modificar()
    {
        ventanaCursos.habilitarEdicion();
    }
    
    //Habilita las opciones para agregar cursos
    public void agregar()
    {
        ventanaCursos.mostrarMensaje("El curso buscado no se encuentra.");
        ventanaCursos.habilitarAgregar();
    }
    
    //En caso del uso de archivos incribe la informacion al cerrar la ventana
    public void ingresarInfo()
    {
        ArrayList <Cursos> array=metodosCursos.getArray();
        archivoCurso.crearArchivoCurso();
        for(int contador=0;contador<array.size();contador++)
        {
            archivoCurso.ingresarInformacionArchivoCurso(array.get(contador));
        }
    }
 
    //Recibe el String que determina la forma en que se almacena la informacion
    public void seleccionAlmacenamiento(String almacenamiento) {
        metodoAlmacenamiento=almacenamiento; 
        if(metodoAlmacenamiento=="Archivos")
            {
                archivoCurso=new ArchivoCurso();
                if(this.archivoCurso.cargarArchivoCurso())
                {
                    metodosCursos.setArray(archivoCurso.devolverInfromacionDelArchivoCurso());

                }
                else
                {          
                }
            }
        if(metodoAlmacenamiento==null)
        {
           ventanaCursos.mostrarMensaje("Porfavor seleccione un metodo de almacenamiento");
        }
    }

    

    
}
