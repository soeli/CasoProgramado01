/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class ArchivoEstudiante {
    
    ObjectOutputStream archivoSalidaEstudiante;
    ObjectInputStream archivoEntradaEstudiante;
    
    public ArchivoEstudiante()
    {
        
    }
    
   public boolean cargarArchivoEstudiante()
    {
        boolean existe=false;
        try
        {
            archivoEntradaEstudiante= new ObjectInputStream(new FileInputStream ("archivoEstudiante.dat"));
            existe=true;
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo  de estudiantes"+e);
        }    
        return existe;
    }
    public void crearArchivoEstudiante()
    {
        try
        {
            archivoSalidaEstudiante= new ObjectOutputStream(new FileOutputStream("archivoEstudiante.dat"));
            System.out.println("Se creo el archivo  de estudiantes de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo  de estudiantes");
        }   
    }
    
    public void ingresarInformacionArchivoEstudiante(Estudiante estudiante)
    {
        try
        {
            archivoSalidaEstudiante.writeObject(estudiante);
            System.out.println("Se escribió la informacion  de estudiantes de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar informacion al archivo  de estudiantes"+e);
        }      
    }
    
    public ArrayList<Estudiante> devolverInfromacionDelArchivoEstudiante()
    {
        ArrayList <Estudiante> arrayEstudiante=new ArrayList<Estudiante>();
        
        try
        {
          while(true)
          {
              arrayEstudiante.add((Estudiante)archivoEntradaEstudiante.readObject());
          }
        }
        catch(Exception e)
        {
            System.out.println("Se llego al final del archivo  de estudiantes"+e);
        } 
        return arrayEstudiante;
    }
}
