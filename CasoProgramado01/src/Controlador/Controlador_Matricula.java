/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Modelo.Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Vista.VentanaCursos;
import Vista.VentanaEstudiantes;
import Vista.VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Controlador_Matricula implements ActionListener{
    
    VentanaMatricula ventanaMatricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    public ConexionBD conexionBD;
    public MetodosMatricula metodosMatricula; 
    ArchivoMatricula archivoMatricula;
    String metodoAlmacenamiento;
    VentanaEstudiantes ventanaEstudiantes;
    VentanaCursos ventanaCursos;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    
    public Controlador_Matricula(VentanaEstudiantes ventanaEstudiantes,VentanaCursos ventanaCursos,VentanaMatricula ventanaMatricula,ConexionBD conexionBD,ArchivoMatricula archivoMatricula)
    {
        this.metodosEstudiantes=ventanaEstudiantes.controlador_Estudiantes.metodosEstudiantes;
        this.metodosCursos=ventanaCursos.controlador.metodosCursos;
        this.conexionBD=ventanaCursos.controlador.conexionBD;
        this.archivoMatricula=archivoMatricula;
        this.ventanaMatricula=ventanaMatricula;
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("ConsultaRapidaCedula"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                 if(metodosEstudiantes.consultarEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arreglo[]=metodosEstudiantes.getArregloInformacion();
                    ventanaMatricula.colocarNombreEstudiante(arreglo[0]);
                    encontroEstudiante=true;
                }
                else
                {
                    ventanaMatricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(metodoAlmacenamiento=="BD")
            {
                   if(conexionBD.consultarEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arreglo[]=conexionBD.getArregloInformacion();
                    ventanaMatricula.colocarNombreEstudiante(arreglo[0]);
                    encontroEstudiante=true;
                }
                else
                {
                    ventanaMatricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            
            
        }
        if(e.getActionCommand().equals("ConsultaRapidaSigla"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                    if(metodosCursos.consultarCurso(ventanaMatricula.devolverSigla()))
                    {
                        String arreglo[]=metodosCursos.getArregloInformacion();
                        ventanaMatricula.colocarNombreCurso(arreglo[0]);
                        encontroCurso=true;
                    }
                    else
                    {
                        ventanaMatricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                    }
            }
            if(metodoAlmacenamiento=="BD")
            {
                       if(conexionBD.consultarCurso(ventanaMatricula.devolverSigla()))
                    {
                        String arreglo[]=conexionBD.getArregloInformacion();
                        ventanaMatricula.colocarNombreCurso(arreglo[0]);
                        encontroCurso=true;
                    }
                    else
                    {
                        ventanaMatricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                    }
            }
            if(metodoAlmacenamiento=="XML")
            {

            }
            
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            ventanaMatricula.agregarInformacionTabla();
            ventanaMatricula.limpiarSigla();
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            String arreglo[]=new String[3];
            for(int contador=0;contador<ventanaMatricula.getCantidadFilas();contador++)
            {
                arreglo[0]=ventanaMatricula.devolverCodigo();
                arreglo[1]=ventanaMatricula.devolverDato(contador,1);
                arreglo[2]=ventanaMatricula.devolverDato(contador,3);
                
                if(metodoAlmacenamiento=="Archivos")
                {
                    metodosMatricula.agregarMatricula(arreglo);
                }
                if(metodoAlmacenamiento=="BD")
                {
                   conexionBD.registrarMatricula(arreglo);
                }
                if(metodoAlmacenamiento=="XML")
                {

                }   
            }
            //frm_matricula.colocarCodigo();
            ventanaMatricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            ventanaMatricula.mostrarMensaje("no entra ");
            if(conexionBD.consultarMatricula(ventanaMatricula.devolverCodigo()))
            {
                String arreglo[]=conexionBD.getArregloInformacion();
                ventanaMatricula.colocarNombreEstudiante(arreglo[0]);
                ventanaMatricula.colocarNombreCurso(arreglo[1]);
                
                
            }
            else
            {
            
            }
        
        
        }if(e.getActionCommand().equals("Eliminar"))
        {
            conexionBD.eliminarEstudiante(ventanaMatricula.devolverSigla(),"matricula","codigo");
            ventanaMatricula.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            ventanaMatricula.colocarCodigo();
            ventanaMatricula.resetearVentana();
        }
        
        
        
        
        verificarConsultas();
    }
    public void verificarConsultas()
    {
        if(encontroEstudiante && encontroCurso)
        {
            this.ventanaMatricula.habilitarAgregar();
        }
    }

    public void modificar()
    {
        //ventanaMatricula.habilitarEdicion();
    }
    public void agregar()
    {
        ventanaMatricula.mostrarMensaje("El curso buscado no se encuentra.");
        ventanaMatricula.habilitarAgregar();
    }
    
    public void ingresarInfo()
    {
        ArrayList <Matricula> array=metodosMatricula.getArray();
        archivoMatricula.crearArchivoMatricula();
        for(int contador=0;contador<array.size();contador++)
        {
            archivoMatricula.ingresarInformacionArchivoMatricula(array.get(contador));
        }
    }
 

    public void seleccionAlmacenamiento(String almacenamiento) {
        metodoAlmacenamiento=almacenamiento; 
        if(metodoAlmacenamiento=="Archivos")
            {
                metodosMatricula= new MetodosMatricula(metodosEstudiantes,metodosCursos,this);
                System.out.println("metodoMatriculaIniciado");
                archivoMatricula=new ArchivoMatricula();
                if(this.archivoMatricula.cargarArchivoMatricula())
                {
                    metodosMatricula.setArray(archivoMatricula.devolverInfromacionDelArchivoMatricula());

                }
                else
                {          
                }
            }
    }
    
    
    
    
    
}
