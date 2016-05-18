/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import Controlador.Controlador_Matricula;
import java.util.ArrayList;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class MetodosMatricula {
    
    private ArrayList <Matricula> arrayMatricula;
    String[] arregloInformacionMatricula=new String[2];
    String[] arregloInformacionConsultada=new String[4];
    Controlador_Matricula controlador;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    
    public MetodosMatricula(MetodosEstudiantes metodosEstudiantes,MetodosCursos metodosCursos)
    {
        arrayMatricula=new ArrayList <Matricula>();
        this.metodosCursos=metodosCursos;
        this.metodosEstudiantes=metodosEstudiantes;
        this.controlador=controlador;
    }
    
    public void agregarMatricula(String informacion[])
    {
        Matricula temporal=new Matricula(informacion[0], informacion[1], informacion[2]);
        arrayMatricula.add(temporal);    
    }
    
    public void setArray(ArrayList<Matricula> array)
    {
        this.arrayMatricula=array;
    }
    
    public ArrayList<Matricula> getArray()
    {
        return this.arrayMatricula;
    }
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            System.out.println(arrayMatricula.get(contador).getInformacion());
        }
    }
    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(codigo))
            {
                arregloInformacionMatricula[0]=arrayMatricula.get(contador).getCedula();
               // arregloInformacionConsultada[1]=metodosEstudiantes.getArregloInformacion()[0];
                arregloInformacionMatricula[1]=arrayMatricula.get(contador).getSigla();
               // arregloInformacionConsultada[3]=arrayMatricula.get(contador).getCedula();
                existe=true;
            }         
        }
        return existe;
    }
    public void modificarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.get(contador).setCedula(arreglo[1]);
                arrayMatricula.get(contador).setSigla(arreglo[2]);
            }
        }
    }
    public void eliminarMatricula(String arreglo[])
    {
        for(int contador=0;contador<arrayMatricula.size();contador++)
        {
            if(arrayMatricula.get(contador).getCodigo().equals(arreglo[0]))
            {
                arrayMatricula.remove(contador);
            }
        }
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionMatricula;
    } 
    
    public String[] getArregloInformacionMatricula(String[] detalleMatricula)
    {
        arregloInformacionConsultada[0]=arregloInformacionMatricula[0];
        arregloInformacionConsultada[1]=detalleMatricula[0];
        arregloInformacionConsultada[2]=arregloInformacionMatricula[1];
        arregloInformacionConsultada[3]=detalleMatricula[1];
        return this.arregloInformacionConsultada;
    }
    
    public String devolverCodigo()
    {
        String codigo= "0000";
        if(arrayMatricula.size()==0)
        {
            codigo+=1;
        }
        else
        {
            int numero=Integer.parseInt(arrayMatricula.get(arrayMatricula.size()-1).getCodigo());
            numero++;
            codigo="0000"+numero;
        }
        codigo=codigo.substring(codigo.length()-5, codigo.length());
        return codigo; 
    }
    
    
    
    
    
    
    
}
