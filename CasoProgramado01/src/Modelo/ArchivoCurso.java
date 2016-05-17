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
public class ArchivoCurso {
    
    ObjectOutputStream archivoSalidaCurso;
    ObjectInputStream archivoEntradaCurso;
    
    public ArchivoCurso()
    {
        
    }
    
   public boolean cargarArchivoCurso()
    {
        boolean existe=false;
        try
        {
            archivoEntradaCurso= new ObjectInputStream(new FileInputStream ("cursos.dat"));
            existe=true;
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo  de cursos"+e);
        }    
        return existe;
    }
    public void crearArchivoCurso()
    {
        try
        {
            archivoSalidaCurso= new ObjectOutputStream(new FileOutputStream("cursos.dat"));
            System.out.println("Se creo el archivo de forma correcta  de cursos");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo  de cursos");
        }   
    }
    
    public void ingresarInformacionArchivoCurso(Cursos curso)
    {
        try
        {
            archivoSalidaCurso.writeObject(curso);
            System.out.println("Se escribió la informacion de forma correcta  de cursos");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar informacion al archivo  de cursos"+e);
        }      
    }
    
    public ArrayList<Cursos> devolverInfromacionDelArchivoCurso()
    {
        ArrayList <Cursos> array=new ArrayList<Cursos>();
        
        try
        {
          while(true)
          {
              array.add((Cursos)archivoEntradaCurso.readObject());
          }
        }
        catch(Exception e)
        {
            System.out.println("Se llego al final del archivo de cursos"+e);
        } 
        return array;
    }
}
