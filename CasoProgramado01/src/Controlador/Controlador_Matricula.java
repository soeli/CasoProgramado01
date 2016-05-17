/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Controlador_Matricula implements ActionListener{
    
    FRM_Matricula frm_matricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    public ConexionBD conexionBD;
    
    public Controlador_Matricula(FRM_MantenimientoEstudiantes frm_MantenimientoEstufiantes,FRM_MantenimientoCursos frm_MantenimientoCursos,FRM_Matricula frm_matricula,ConexionBD conexionBD)
    {
        this.conexionBD=frm_MantenimientoCursos.controlador.conexionBD;
        conexionBD=frm_MantenimientoCursos.controlador.conexionBD;
        conexionBD=frm_MantenimientoEstufiantes.controlador_FRM_MantenimientoEstudiantes.conexionBD;
        this.frm_matricula=frm_matricula;
        this.conexionBD=conexionBD;
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getActionCommand().equals("ConsultaRapidaCedula"))
        {
            if(conexionBD.consultarEstudiante(frm_matricula.devolverCedula()))
            {
                String arreglo[]=conexionBD.getArregloInformacion();
                frm_matricula.colocarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;
            }
            else
            {
                frm_matricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
            }
            
        }
        if(e.getActionCommand().equals("ConsultaRapidaSigla"))
        {
            if(conexionBD.consultarCurso(frm_matricula.devolverSigla()))
            {
                String arreglo[]=conexionBD.getArregloInformacion();
                frm_matricula.colocarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }
            else
            {
                frm_matricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            frm_matricula.agregarInformacionTabla();
            frm_matricula.limpiarSigla();
        }
        if(e.getActionCommand().equals("Finalizar"))
        {
            String arreglo[]=new String[3];
            for(int contador=0;contador<frm_matricula.getCantidadFilas();contador++)
            {
                arreglo[0]=frm_matricula.devolverCodigo();
                arreglo[1]=frm_matricula.devolverDato(contador,1);
                arreglo[2]=frm_matricula.devolverDato(contador,3);
                conexionBD.registrarMatricula(arreglo);
            }
            //frm_matricula.colocarCodigo();
            frm_matricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            frm_matricula.mostrarMensaje("no entra ");
            if(conexionBD.consultarMatricula(frm_matricula.devolverCodigo()))
            {
                String arreglo[]=conexionBD.getArregloInformacion();
                frm_matricula.colocarNombreEstudiante(arreglo[0]);
                frm_matricula.colocarNombreCurso(arreglo[1]);
                
                
            }
            else
            {
            
            }
        
        
        }if(e.getActionCommand().equals("Eliminar"))
        {
            conexionBD.eliminarEstudiante(frm_matricula.devolverSigla(),"matricula","codigo");
            frm_matricula.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_matricula.colocarCodigo();
            frm_matricula.resetearVentana();
        }
        
        
        
        
        verificarConsultas();
    }
    public void verificarConsultas()
    {
        if(encontroEstudiante && encontroCurso)
        {
            this.frm_matricula.habilitarAgregar();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
