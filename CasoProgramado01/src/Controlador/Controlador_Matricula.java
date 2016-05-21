/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Modelo.Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Modelo.Metodos_XML_Cursos;
import Modelo.Metodos_XML_Estudiante;
import Modelo.Metodos_XML_Matricula;
import Vista.VentanaCursos;
import Vista.VentanaEstudiantes;
import Vista.VentanaMatricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
//Controla la clase Ventana Matricula
public class Controlador_Matricula implements ActionListener{
    
    VentanaMatricula ventanaMatricula;
    boolean encontroEstudiante=false;
    boolean encontroCurso=false;
    public ConexionBD conexionBD;
    public MetodosMatricula metodosMatricula; 
    ArchivoMatricula archivoMatricula;
    String metodoAlmacenamiento;
    VentanaEstudiantes ventanaEstudiantes;
    VentanaCursos ventanaCursos;
    MetodosCursos metodosCursos;
    MetodosEstudiantes metodosEstudiantes;
    Metodos_XML_Matricula metodos_XML;
    Metodos_XML_Cursos metodos_XML_Cursos;
    Metodos_XML_Estudiante metodos_XML_Estudiante;
    
    
    //Metodo Contructor, recibe a la ventana Estudiantes, Cursos y Matricula
    //Recibe los diferentes tipos de almacenamiento
    //Crea la clase de metodos matricula
    
    public Controlador_Matricula(VentanaEstudiantes ventanaEstudiantes,VentanaCursos ventanaCursos,VentanaMatricula ventanaMatricula,ConexionBD conexionBD,ArchivoMatricula archivoMatricula, Metodos_XML_Matricula metodos_XML)
    {
        this.metodosEstudiantes=ventanaEstudiantes.controlador_Estudiantes.metodosEstudiantes;
        this.metodosCursos=ventanaCursos.controlador.metodosCursos;
        this.conexionBD=ventanaCursos.controlador.conexionBD;
        this.archivoMatricula=archivoMatricula;
        this.conexionBD=conexionBD;
        this.ventanaMatricula=ventanaMatricula;
        metodosMatricula= new MetodosMatricula(metodosEstudiantes,metodosCursos,this);
        this.metodos_XML=metodos_XML;
        this.metodos_XML_Estudiante=ventanaEstudiantes.controlador_Estudiantes.metodos_XML;
        this.metodos_XML_Cursos=ventanaCursos.controlador.metodos_XML;
 
    }
    
    
    //Escucha  a los botones de la ventanaMatricula
    public void actionPerformed(ActionEvent e)
    {
        
        //Llama al metodo que consulta al estudiante... funciona con el enter en la intefaz
        if(e.getActionCommand().equals("ConsultaRapidaCedula"))
        {
            consultaRapidaCedula();
        }
        //Consulta el curso
        if(e.getActionCommand().equals("ConsultaRapidaSigla"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                    consultaSiglaArchivos();
            }
            if(metodoAlmacenamiento=="BD")
            {
                       if(conexionBD.consultarCurso(ventanaMatricula.devolverSigla()))
                    {
                        String arreglo[]=conexionBD.getArregloInformacion();
                        ventanaMatricula.colocarNombreCurso(arreglo[0]);
                        encontroCurso=true;
                    }
                    else
                    {
                        ventanaMatricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                    }
            }
            if(metodoAlmacenamiento=="XML")
            {
                if(metodos_XML_Cursos.consultarInformacionDelXml(ventanaMatricula.devolverSigla()))
            {
                String arreglo[]=metodos_XML_Cursos.getArregloInformacion();
                ventanaMatricula.colocarNombreCurso(arreglo[1]);
                encontroCurso=true;
            }
            else
            {
                ventanaMatricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
            }
            }
            
        }
        
        //Llama al metodo que agregrega la informacion a la tabla
        if(e.getActionCommand().equals("Agregar"))
        {
            metodosAgregar();
        }
        
        //Guarda la matricula 
        if(e.getActionCommand().equals("Finalizar"))
        {
            String arreglo[]=new String[3];
            for(int contador=0;contador<ventanaMatricula.getCantidadFilas();contador++)
            {
                arreglo[0]=ventanaMatricula.devolverCodigo();
                arreglo[1]=ventanaMatricula.devolverDato(contador,1);
                arreglo[2]=ventanaMatricula.devolverDato(contador,3);
                
                if(metodoAlmacenamiento=="Archivos")
                {
                    metodosMatricula.agregarMatricula(arreglo);
                    ventanaMatricula.colocarCodigo(metodosMatricula.devolverCodigo(ventanaMatricula.devolverCodigo()));
                    
                }
                if(metodoAlmacenamiento=="BD")
                {
                   conexionBD.registrarMatricula(arreglo);
                   ventanaMatricula.colocarCodigo(metodosMatricula.devolverCodigo(ventanaMatricula.devolverCodigo()));
                }
                if(metodoAlmacenamiento=="XML")
                {
                    metodos_XML.guardarEnXMLMatricula(arreglo);
                    ventanaMatricula.colocarCodigo(metodosMatricula.devolverCodigo(ventanaMatricula.devolverCodigo()));

                }   
            }
            
            ventanaMatricula.resetearVentana();
            encontroEstudiante=false;
            encontroCurso=false;
        }
        
        //Determina si una matricula existe o no y trae la informacion desde los archivos
        if(e.getActionCommand().equals("Consultar"))
        {
            
            if(metodoAlmacenamiento=="Archivos")
                {
                    if(metodosMatricula.consultarMatricula(ventanaMatricula.devolverCodigo()))
                    {
                        if(metodosMatricula.consultarMatricula(ventanaMatricula.devolverCodigo()))
                        {
                            detalleMatriculaArchivos();
                            modificar();
                        }
                   else
                   {
                       agregar();
                   }
                    }
                    else
                    {
                        ventanaMatricula.mostrarMensaje("Matricula no registada\nAhora puede agregarla");
                    }
                }
                if(metodoAlmacenamiento=="BD")
                {
                   if(conexionBD.consultarMatricula(ventanaMatricula.devolverCodigo())&&conexionBD.consultarDetalleMatricula(ventanaMatricula.devolverCodigo())==true)
                        {
                        detalleMatriculaBD();
                        modificar();
                        }
                   else
                       {
                           agregar();
                       }
                    }

                    if(metodoAlmacenamiento=="XML")
                    {
                       if(metodos_XML.consultarInformacionDelXmlCodigo(ventanaMatricula.devolverCodigo()))
                        {
                            detalleMatriculaXML();
                            modificar();

                        }
                        else
                        {
                        agregar();
                        }

            }
            verificarConsultas();

        }

        //Elimina las matriculas
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(metodoAlmacenamiento=="Archivos")
            {
                metodosMatricula.eliminarMatricula(ventanaMatricula.devolverCodigo());
                ventanaMatricula.colocarCodigo(metodosMatricula.devolverCodigo(ventanaMatricula.devolverCodigo()));
            }
            if(metodoAlmacenamiento=="BD")
            {
                conexionBD.eliminarEstudiante(ventanaMatricula.devolverSigla(),"matricula","codigo");
                ventanaMatricula.colocarCodigo(metodosMatricula.devolverCodigo(ventanaMatricula.devolverCodigo()));  
            }
            if(metodoAlmacenamiento=="XML")
            {
                metodos_XML.eliminarInformacionDelXmlMatricula(ventanaMatricula.devolverCodigo());
                ventanaMatricula.colocarCodigo(metodosMatricula.devolverCodigo(ventanaMatricula.devolverCodigo()));

            }
            
            ventanaMatricula.mostrarMensaje("La matricula fue eliminada de forma correcta.");
            ventanaMatricula.resetearVentana();
            }
    }
    
    // Metodos 
    
    //Metodo que muestra el nombre del estudiante por medio de la cedula
    public void consultaRapidaCedula()
    {
        if(metodoAlmacenamiento=="Archivos")
            {
                consultaCedulaArchivos();
            }
            if(metodoAlmacenamiento=="BD")
            {
                   if(conexionBD.consultarEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arreglo[]=conexionBD.getArregloInformacion();
                    ventanaMatricula.colocarNombreEstudiante(arreglo[0]);
                    encontroEstudiante=true;
                }
                else
                {
                    ventanaMatricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(metodoAlmacenamiento=="XML")
            {
                    if(metodos_XML_Estudiante.consultarInformacionDelXmlEstudiante(ventanaMatricula.devolverCedula()))
            {
                String arreglo[]=metodos_XML_Estudiante.getArregloInformacion();
                ventanaMatricula.colocarNombreEstudiante(arreglo[1]);
                encontroEstudiante=true;
            }
            else
            {
                ventanaMatricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
            }
            }
    }
    
    //Devuelve a la clase VentanaMatricula la informacion de la matricula que ha sido guardada en BD
    public void detalleMatriculaBD()
    {
        String arreglo[]=conexionBD.getArregloInformacion();
        ventanaMatricula.colocarCedula(arreglo[0]);
        ventanaMatricula.colocarSigla(arreglo[1]);             
        if(conexionBD.consultarEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arregloEstudiante[]=conexionBD.getArregloInformacion();
                    ventanaMatricula.agregarInformacion(arregloEstudiante[0]);
                    System.out.println("Cedula "+arreglo[0]+" Nombre: "+arregloEstudiante[0]);
                }
        
    }
    

    
    //Devuelve a la clase VentanaMatricula la informacion de la matricula que ha sido guardada en Archivos
    public void detalleMatriculaArchivos()
    {
        String arreglo[]=metodosMatricula.getArregloInformacion();
        ventanaMatricula.colocarCedula(arreglo[0]);
        ventanaMatricula.colocarSigla(arreglo[1]);             
        if(metodosEstudiantes.consultarEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arregloEstudiante[]=metodosEstudiantes.getArregloInformacion();
                    ventanaMatricula.agregarInformacion(arregloEstudiante[0]);
                    System.out.println("Cedula "+arreglo[0]+" Nombre: "+arregloEstudiante[0]);
                }
    }
    
   
    //Devuelve a la clase VentanaMatricula la informacion de la matricula que ha sido guardada en XML
    public void detalleMatriculaXML()
    {
      String arreglo[]=metodos_XML.getArregloInformacion();
        ventanaMatricula.colocarCedula(arreglo[0]);
        ventanaMatricula.colocarSigla(arreglo[1]);             
        if(metodos_XML_Estudiante.consultarInformacionDelXmlEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arregloEstudiante[]=metodos_XML_Estudiante.getArregloInformacion();
                    ventanaMatricula.agregarInformacion(arregloEstudiante[0]);
                    System.out.println("Cedula "+arreglo[0]+" Nombre: "+arregloEstudiante[0]);
                }   
        
    }
    
    
    //Metodo de archivos para consultar y mostrar el nombre del estudiante
    public void consultaCedulaArchivos()
    {
        if(metodosEstudiantes.consultarEstudiante(ventanaMatricula.devolverCedula()))
                {
                    String arreglo[]=metodosEstudiantes.getArregloInformacion();
                    ventanaMatricula.colocarNombreEstudiante(arreglo[0]);
                    encontroEstudiante=true;
                }
                else
                {
                    ventanaMatricula.mostrarMensaje("El estudiante no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
    }
    
    //Metodo de archivos para consultar y mostrar el nombre del curso
    public void consultaSiglaArchivos()
    {
        if(metodosCursos.consultarCurso(ventanaMatricula.devolverSigla()))
                    {
                        String arreglo[]=metodosCursos.getArregloInformacion();
                        ventanaMatricula.colocarNombreCurso(arreglo[0]);
                        encontroCurso=true;
                    }
                    else
                    {
                        ventanaMatricula.mostrarMensaje("El curso no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
                    }
    }
    
    //metodo que permite agregar informacion a la tabla de la ventana
    public void metodosAgregar()
    {
        ventanaMatricula.agregarInformacionTabla();
            ventanaMatricula.limpiarSigla();
    }
    
    //Verifica si se encuantra estudiante y curso para permitir agregar la matricula
        public void verificarConsultas()
        {
            if(encontroEstudiante && encontroCurso)
            {
                this.ventanaMatricula.habilitarAgregar();
            }
        }

        //Habilita los botones para modificar
    public void modificar()
    {
        ventanaMatricula.habilitarEdicion();
    }
    
    //habilita la interaz para agregar
    public void agregar()
    {
        ventanaMatricula.mostrarMensaje("La matricula buscada no se encuentra.");
        ventanaMatricula.habilitarAgregar();
    }
    
    //Guarda la informacion en archivos al cerrar la ventana
    public void ingresarInfo()
    {
        ArrayList <Matricula> array=metodosMatricula.getArray();
        archivoMatricula.crearArchivoMatricula();
        for(int contador=0;contador<array.size();contador++)
        {
            archivoMatricula.ingresarInformacionArchivoMatricula(array.get(contador));
        }
    }
 
    //Trae el string que determina el tipo de almacenamiento a utilizar
    public void seleccionAlmacenamiento(String almacenamiento) {
        metodoAlmacenamiento=almacenamiento; 
        if(metodoAlmacenamiento=="Archivos")
            {
                System.out.println("metodoMatriculaIniciado");
                archivoMatricula=new ArchivoMatricula();
                if(this.archivoMatricula.cargarArchivoMatricula())
                {
                    metodosMatricula.setArray(archivoMatricula.devolverInfromacionDelArchivoMatricula());

                }
                else
                {          
                }
            }
        if(metodoAlmacenamiento==null)
        {
           ventanaMatricula.mostrarMensaje("Porfavor seleccione un metodo de almacenamiento");
        }
    }
    
    
    
    
    
}
