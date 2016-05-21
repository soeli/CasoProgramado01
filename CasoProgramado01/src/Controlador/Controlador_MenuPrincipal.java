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
import Modelo.Metodos_XML_Cursos;
import Modelo.Metodos_XML_Estudiante;
import Modelo.Metodos_XML_Matricula;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.ModuloMantenimientoUsuarios;
import Vista.VentanaAlmacenamiento;
import Vista.VentanaCursos;
import Vista.VentanaEstudiantes;
import Vista.VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */

//Controlador General, crea la mayoria de las clases y controla al MenuPrincipal
public class Controlador_MenuPrincipal implements ActionListener{
    ArchivoEstudiante archivoEstudiante;
    ArchivoCurso archivoCurso;
    ArchivoMatricula archivoMatricula;
    ConexionBD conexionBD;
    VentanaEstudiantes ventanaEstudiantes;
    VentanaCursos ventanaCursos;
    VentanaMatricula ventanaMatricula;
    ModuloMantenimientoUsuarios mantenimientoUsuarios;
    MenuPrincipal menuPrincipal;
    Login login;
    Metodos_XML_Estudiante metodos_XML_Estudiante;
    Metodos_XML_Cursos metodos_XML_Cursos;
    Metodos_XML_Matricula metodos_XML_Matricula;
    
    //Metodo constructor, recibe el menu Principal
    //Crea la mayoria de las clases e ingresa sus parametros
    public Controlador_MenuPrincipal(MenuPrincipal menuPrincipal)
    {
      this.menuPrincipal=menuPrincipal;
      conexionBD=new ConexionBD();
      metodos_XML_Estudiante =new Metodos_XML_Estudiante(ventanaEstudiantes);
      metodos_XML_Cursos=new Metodos_XML_Cursos(ventanaCursos);
      metodos_XML_Matricula=new Metodos_XML_Matricula(ventanaMatricula);
      ventanaEstudiantes= new VentanaEstudiantes(conexionBD,archivoEstudiante,metodos_XML_Estudiante);
      ventanaCursos= new VentanaCursos(conexionBD,archivoCurso,metodos_XML_Cursos); 
      ventanaMatricula =new VentanaMatricula(ventanaEstudiantes,ventanaCursos,conexionBD,archivoMatricula,metodos_XML_Matricula);    
      mantenimientoUsuarios=new ModuloMantenimientoUsuarios(menuPrincipal);
    }
    
    //Escucha los botones de VentanaPrincipal
    public void actionPerformed(ActionEvent e)
    {
        //Envia el String de tipo almacenamiento de archivo a las clases
        if(e.getActionCommand().equals("Archivos"))
        {
            System.out.println("Archivos MenuPrincipal");
            ventanaEstudiantes.seleccionAlmacenamiento("Archivos");
            ventanaCursos.seleccionAlmacenamiento("Archivos");
            ventanaMatricula.seleccionAlmacenamiento("Archivos");
            
        }
        //Envia el String de tipo almacenamiento de BD a las clases
        if(e.getActionCommand().equals("BD"))
        {
            System.out.println("BD MenuPrincipal");
            ventanaEstudiantes.seleccionAlmacenamiento("BD");
            ventanaCursos.seleccionAlmacenamiento("BD");
            ventanaMatricula.seleccionAlmacenamiento("BD");
            
        }
        //Envia el String de tipo almacenamiento de XML a las clases
        if(e.getActionCommand().equals("XML"))
        {
             System.out.println("XML MenuPrincipal");
            ventanaEstudiantes.seleccionAlmacenamiento("XML");
            ventanaCursos.seleccionAlmacenamiento("XML");
            ventanaMatricula.seleccionAlmacenamiento("XML");
           
        }
        //Abre la ventana de seleccion de almacenamiento
        if(e.getActionCommand().equals("Almacenamiento"))
        {
            mantenimientoUsuarios.mostrarAlmacenamiento();
        }
        //Abre la ventana para crar un nuevo usuario
        if(e.getActionCommand().equals("Usuario"))
        {
            mantenimientoUsuarios.setVisible(true);
        }
        
        //Cierra el programa
        if(e.getActionCommand().equals("Salir"))
        {
            System.out.println("Salir");
            System.exit(0);
        }
        
        //Abre la ventana Estudiantes
        if(e.getActionCommand().equals("Estudiantes"))
        {
            System.out.println("Estudiantes");
            ventanaEstudiantes.setVisible(true);
        }
        
        //Abre la ventana Cursos
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
