/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Vista.VentanaCursos;
import Vista.VentanaEstudiantes;
import Vista.VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Controlador_Matricula implements ActionListener{
    
    VentanaMatricula ventanaMatricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    public ConexionBD conexionBD;
    
    public Controlador_Matricula(VentanaEstudiantes ventanaEstudiantes,VentanaCursos ventanaCursos,VentanaMatricula ventanaMatricula,ConexionBD conexionBD,ArchivoMatricula archivoMatricula)
    {
        this.conexionBD=ventanaCursos.controlador.conexionBD;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("ConsultaRapidaCedula"))
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
        if(e.getActionCommand().equals("ConsultaRapidaSigla"))
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
                conexionBD.registrarMatricula(arreglo);
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

    public void seleccionAlmacenamiento(String almacenamiento) {
        
    }
    
    
    
    
    
}
