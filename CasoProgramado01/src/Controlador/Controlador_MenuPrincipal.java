/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Modelo.ArchivoCurso;
import Modelo.ArchivoEstudiante;
import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Vista.VentanaCursos;
import Vista.VentanaEstudiantes;
import Vista.VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_MenuPrincipal implements ActionListener{
    

    ArchivoEstudiante archivoEstudiante;
    ArchivoCurso archivoCurso;
    ArchivoMatricula archivoMatricula;
    ConexionBD conexionBD;
    VentanaEstudiantes ventanaEstudiantes;
    VentanaCursos ventanaCursos;
    VentanaMatricula ventanaMatricula;
    
    
    public Controlador_MenuPrincipal()
    {
      ventanaEstudiantes= new VentanaEstudiantes(conexionBD,archivoEstudiante);
      ventanaCursos= new VentanaCursos(conexionBD,archivoCurso); 
      ventanaMatricula =new VentanaMatricula(ventanaEstudiantes,ventanaCursos,conexionBD,archivoMatricula);    
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Archivos"))
        {
            System.out.println("Archivos");
        }
        if(e.getActionCommand().equals("BD"))
        {
            conexionBD = new ConexionBD();

            System.out.println("BD");
        }
        if(e.getActionCommand().equals("XML"))
        {
            System.out.println("XML");
            System.exit(0);
        }
        if(e.getActionCommand().equals("Salir"))
        {
            System.out.println("Salir");
            System.exit(0);
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            
            System.out.println("Estudiantes");
            ventanaEstudiantes.setVisible(true);
           
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            System.out.println("Cursos");
            ventanaCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            System.out.println("Matricula");
            ventanaMatricula.setVisible(true);
           
        }
    
    }
    
    
}
