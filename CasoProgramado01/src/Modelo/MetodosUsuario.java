/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.ArrayList;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class MetodosUsuario {
      
    private ArrayList <Usuario> arrayUsuario;
    String arregloInformacionConsultada[]=new String[2];
    
    public MetodosUsuario()
    {
        arrayUsuario=new ArrayList <Usuario>();
    }
    public void agregarUsuario(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0], informacion[1], informacion[2]);
        arrayUsuario.add(temporal);
        
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            System.out.println(arrayUsuario.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarUsuario(String usuario)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getUsuario().equals(usuario))
            {
                arregloInformacionConsultada[0]=arrayUsuario.get(contador).getUsuario();
                arregloInformacionConsultada[1]=arrayUsuario.get(contador).getNombre();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public void modificarUsuario(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getUsuario().equals(arreglo[0]))
            {
                arrayUsuario.get(contador).setNombre(arreglo[1]);
                arrayUsuario.get(contador).setContrasenia(arreglo[2]);
            }
        }
    }
    public void eliminarUsuario(String arreglo[])
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            if(arrayUsuario.get(contador).getUsuario().equals(arreglo[0]))
            {
                arrayUsuario.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }    
    
    
    //Archivos
    public int getTamnio()
    {
        return arrayUsuario.size();
    }
    
    
    public Usuario getObjeto(int n)
    {
        return this.arrayUsuario.get(n);
    }
    
    public void llenarArray(ArrayList<Usuario> usuario)
    {
        this.arrayUsuario=usuario;
    }
    
}
