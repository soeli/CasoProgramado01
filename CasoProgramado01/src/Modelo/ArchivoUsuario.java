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
 * @author SOFIA ELIZONDO
 */
public class ArchivoUsuario {
    ObjectOutputStream archivoSalidaUsuario;
    ObjectInputStream archivoEntradaUsuario;
    
    public ArchivoUsuario()
    {
        
    }
    
   public boolean cargarArchivoUsuario()
    {
        boolean existe=false;
        try
        {
            archivoEntradaUsuario= new ObjectInputStream(new FileInputStream ("archivoUsuario.dat"));
            existe=true;
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo  de usuario"+e);
        }    
        return existe;
    }
    public void crearArchivoUsuario()
    {
        try
        {
            archivoSalidaUsuario= new ObjectOutputStream(new FileOutputStream("archivoUsuario.dat"));
            System.out.println("Se creo el archivo  de Usuario de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear archivo  de Usuario");
        }   
    }
    
    public void ingresarInformacionArchivoUsuario(Usuario usuario)
    {
        try
        {
            archivoSalidaUsuario.writeObject(usuario);
            System.out.println("Se escribió la informacion  de Usuario de forma correcta");
        }
        catch(Exception e)
        {
            System.out.println("Error al ingresar informacion al archivo  de Usuario"+e);
        }      
    }
    
    public ArrayList<Usuario> devolverInfromacionDelArchivoUsuario()
    {
        ArrayList <Usuario> arrayUsuario=new ArrayList<Usuario>();
        
        try
        {
          while(true)
          {
              arrayUsuario.add((Usuario)archivoEntradaUsuario.readObject());
          }
        }
        catch(Exception e)
        {
            System.out.println("Se llego al final del archivo  de Usuario"+e);
        } 
        return arrayUsuario;
    }
}
