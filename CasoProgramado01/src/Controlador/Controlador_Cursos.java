/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ArchivoCurso;
import Modelo.ConexionBD;
import Vista.VentanaCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Controlador_Cursos implements ActionListener{

    VentanaCursos ventanaCursos;
    
    public ConexionBD conexionBD;
    public Controlador_Cursos(VentanaCursos ventanaCursos, ConexionBD conexionBD,ArchivoCurso archivoCurso)
    {
        this.ventanaCursos=ventanaCursos;
        this.conexionBD=conexionBD;
    }
    
    public void actionPerformed(ActionEvent evento)
    {
        if(evento.getActionCommand().equals("Agregar"))
        {
            conexionBD.registrarCurso(ventanaCursos.devolverInformacion());
            ventanaCursos.mostrarMensaje("El curso fue registrado de forma correcta");
            ventanaCursos.resetearGUI();
        }
        if(evento.getActionCommand().equals("Consultar") || evento.getActionCommand().equals("ConsultaRapida"))
        {
            buscar();
        }
        if(evento.getActionCommand().equals("Modificar"))
        {
            conexionBD.actualizarCurso(ventanaCursos.devolverInformacion(),"cursos");
            ventanaCursos.mostrarMensaje("El curso fue modificado de forma correcta.");
            ventanaCursos.resetearGUI();     
        }
        if(evento.getActionCommand().equals("Eliminar"))
        {
            conexionBD.eliminarEstudiante(ventanaCursos.devolverSigla(),"cursos","sigla");
            ventanaCursos.mostrarMensaje("El curso fue eliminado de forma correcta.");
            ventanaCursos.resetearGUI();
        }
    
    }
    public void buscar()
    {
        if(conexionBD.consultarCurso(ventanaCursos.devolverSigla()))
       {
           
            ventanaCursos.mostrarInformacion(conexionBD.getArregloInformacion());
            ventanaCursos.habilitarEdicion();
       }
       else
       {
           ventanaCursos.mostrarMensaje("La sigla buscada no se encuentra.");
            ventanaCursos.habilitarAgregar();
       }
    
    }

    

    
}
