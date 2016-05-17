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
public class Controlador_Estudiantes implements ActionListener{
    
   // public MetodosEstudiantes metodosEstudiantes;
    FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes;
    ConexionBD conexionBD; 
 
    public Controlador_Estudiantes(FRM_MantenimientoEstudiantes frm_MantenimientoEstudiantes, ConexionBD conexionBD)
    {
        this.conexionBD=conexionBD;
        this.frm_MantenimientoEstudiantes=frm_MantenimientoEstudiantes;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        
        
        
        if(e.getActionCommand().equals("Agregar"))
        {
            conexionBD.registrarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion());
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue registrado de forma correcta");
            frm_MantenimientoEstudiantes.resetearGUI();
            
        }
        if(e.getActionCommand().equals("Consultar") || e.getActionCommand().equals("Consulta_Rapida"))
        {            
            buscar();
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            conexionBD.actualizarEstudiante(frm_MantenimientoEstudiantes.devolverInformacion(),"estudiantes");
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue modificado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            conexionBD.eliminarEstudiante(frm_MantenimientoEstudiantes.devolverCedula(),"estudiantes","cedula");
            frm_MantenimientoEstudiantes.mostrarMensaje("El estudiante fue eliminado de forma correcta.");
            frm_MantenimientoEstudiantes.resetearGUI();
        }
    }
    public void buscar()
    {
       if(conexionBD.consultarEstudiante(frm_MantenimientoEstudiantes.devolverCedula()))
       {
           
            frm_MantenimientoEstudiantes.mostrarInformacion(conexionBD.getArregloInformacion());
            frm_MantenimientoEstudiantes.habilitarEdicion();
       }
       else
       {
           frm_MantenimientoEstudiantes.mostrarMensaje("La cédula buscada no se encuentra.");
            frm_MantenimientoEstudiantes.habilitarAgregar();
       }
    }
    
    
    
    
    
    
    
    
    
    
    
}
