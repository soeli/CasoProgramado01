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
public class ArchivoMatricula {
    
    ObjectOutputStream archivoSalidaMatricula;
    ObjectInputStream archivoEntradaMatricula;
    
    public ArchivoMatricula()
    {
    
    }
    
   public boolean cargarArchivoMatricula()
    {
        boolean existe=false;
        try
        {
            archivoEntradaMatricula= new ObjectInputStream(new FileInputStream ("matricula.dat"));
            existe=true;
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo  de Matrícula"+e);
        }    
        return existe;
    }
    public void crearArchivoMatricula()
    {
        try
        {
            archivoSalidaMatricula= new ObjectOutputStream(new FileOutputStream("matricula.dat"));
            System.out.println("Se creo el archivo de Matrícula de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo de Matrícula");
        }   
    }
    
    public void ingresarInformacionArchivoMatricula(Matricula matricula)
    {
        try
        {
            archivoSalidaMatricula.writeObject(matricula);
            System.out.println("Se escribió la informacion de forma correcta de Matrícula");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar informacion al archivo de Matrícula"+e);
        }      
    }
    
    public ArrayList<Matricula> devolverInfromacionDelArchivoMatricula()
    {
        ArrayList <Matricula> array=new ArrayList<Matricula>();
        
        try
        {
          while(true)
          {
              array.add((Matricula)archivoEntradaMatricula.readObject());
          }
        }
        catch(Exception e)
        {
            System.out.println("Se llego al final del archivo  de Matrícula"+e);
        } 
        return array;
    }
}
