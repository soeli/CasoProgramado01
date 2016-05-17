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
public class Controlador_Cursos implements ActionListener{

    FRM_MantenimientoCursos frm_mantenimientoCursos;
    
    public ConexionBD conexionBD;
    public Controlador_Cursos(FRM_MantenimientoCursos frm_mantenimientoCursos, ConexionBD conexionBD)
    {
        this.frm_mantenimientoCursos=frm_mantenimientoCursos;
        this.conexionBD=conexionBD;
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            conexionBD.registrarCurso(frm_mantenimientoCursos.devolverInformacion());
            frm_mantenimientoCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            frm_mantenimientoCursos.resetearGUI();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            conexionBD.actualizarCurso(frm_mantenimientoCursos.devolverInformacion(),"cursos");
            frm_mantenimientoCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();     
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            conexionBD.eliminarEstudiante(frm_mantenimientoCursos.devolverSigla(),"cursos","sigla");
            frm_mantenimientoCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            frm_mantenimientoCursos.resetearGUI();
        }
    
    }
    public void buscar()
    {
        if(conexionBD.consultarCurso(frm_mantenimientoCursos.devolverSigla()))
       {
           
            frm_mantenimientoCursos.mostrarInformacion(conexionBD.getArregloInformacion());
            frm_mantenimientoCursos.habilitarEdicion();
       }
       else
       {
           frm_mantenimientoCursos.mostrarMensaje("La sigla buscada no se encuentra.");
            frm_mantenimientoCursos.habilitarAgregar();
       }
    
    }

    

    
}
