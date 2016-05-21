/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Vista.VentanaCursos;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/**
 *
 * @author Erika
 */
public class Metodos_XML_Cursos {
    
    VentanaCursos ventanaCursos;
    DocumentBuilderFactory factory;
    DocumentBuilder builder;
    DOMImplementation implementation;
    Document document;
    ArrayList titulos;
    ArrayList valores;
    Element raiz,principal;
    String arregloInformacion[];
    Source source;
    Result result;
    Result console;
    Transformer transformer;
    String archivoCurso;
    
    //Metodo COnstructor de la clase
    public Metodos_XML_Cursos(VentanaCursos ventanaCursos)
    {
       archivoCurso="Curso";
       
         if(cargarXMLCursos())
        {
            System.out.println("Ya existe un archivo Cursos XML creado, ya fue cargado y puede proceder a utilizarlo");
        }
        else
        {
            crearXMLCursos();
            System.out.println("No existía un archivo Cursos XML creado, ya fue creado y puede proceder a utilizarlo");
        }
         
        arregloInformacion=new String[4];
        titulos = new ArrayList();
        valores = new ArrayList();
    }
    
    ///////////////////////////////////////////////Metodos para gestionar XML de Cursos////////////////////////////////////////////////////
    //Metodo para crear el archivo XML para la informacion de los Cursos
    public void crearXMLCursos()
        {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(archivoCurso+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo  curso XML: " + e);
        }
    }
    
    //Metodo para cargar el archivo XML de los Cursos. 
      public boolean cargarXMLCursos() //Método nuevo en pruebas
        {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(archivoCurso+".xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("Curso");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo Cursos XML"+e);
        }
        return cargo;
    } 
      
       //Metodo para guardar informacion en el archivo XML de los estudiantes.
        public void guardarEnXML(String arregloInformacion[])//Método nuevo en pruebas
    {
        try{
            
            raiz = document.createElement("Curso");
            principal = document.createElement("Curso");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor1 = document.createElement("sigla");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("nombre");
            Text text2 = document.createTextNode(arregloInformacion[1]);
            Element valor3 = document.createElement("creditos");
            Text text3 = document.createTextNode(arregloInformacion[2]);
             Element valor4 = document.createElement("horario");
            Text text4 = document.createTextNode(arregloInformacion[3]);
            
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            raiz.appendChild(valor4);
            valor4.appendChild(text4);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(archivoCurso+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar: " + e);
        }
    }
      
      //Metodo para consultar el curso dentro del XML
      public boolean consultarInformacionDelXml(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Curso");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false,tituloSigla=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+sigla) )
                 {
                    itemEncontrado=true; 
                 }
                 if(itemEncontrado && contador<4)
                 {
                     System.out.println(datoContenido.getNodeValue());
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
      
      //Metodo para modificar la informacion de los cursos dentro del XML
       public void modificarInformacionDelXmlCursos(String informacion[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Curso");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[4];
         boolean itemEncontrado=false,tituloSigla=false;
         int contador=0;
         try
         {
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {   
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("curso") && datoContenido.getNodeValue().equals(""+informacion[0]) )
                    {   
                       itemEncontrado=true;     
                    }
                    if(itemEncontrado && contador<3)
                    {
                        datoContenido.setNodeValue(informacion[contador]);                    
                        contador++;
                    }
                }
            }
           source = new DOMSource(document);
           result = new StreamResult(new java.io.File(archivoCurso+".xml"));
           console = new StreamResult(System.out);
           transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           transformer.transform(source, console);
        }
        catch (Exception e) 
        {
            System.err.println("Error al modificar Cursos: " + e);
        }
    }
       
       //Metodo para eliminar la informacion de los XML de cursos
       public void eliminarInformacionDelXmlCursos(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Curso");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false,tituloSigla=false;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("sigla") && datoContenido.getNodeValue().equals(""+sigla) )
                    {
                       itemEncontrado=true;
                       raiz.removeChild(item);
                       source = new DOMSource(document);
                       result = new StreamResult(new java.io.File(archivoCurso+".xml"));
                       console = new StreamResult(System.out);
                       transformer = TransformerFactory.newInstance().newTransformer();
                       transformer.transform(source, result);
                       transformer.transform(source, console);
                    } 
                }
            }
         }
        catch (Exception e) 
        {
            System.err.println("Error al eliminar Cursos: " + e);
        }
    }
       
        public void crearArchivo(String nombreArchivo) 
    {
        try{
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, nombreArchivo, null);
            document.setXmlVersion("1.0");
            raiz = document.getDocumentElement();
            Source source = new DOMSource(document);
            Result result = new StreamResult(new java.io.File(nombreArchivo+".xml")); 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            System.out.println("Archivo XML creado con el nombre: "+nombreArchivo);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Metodos_XML_Cursos.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TransformerException ex) {
            Logger.getLogger(Metodos_XML_Cursos.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
       
       //Metodo que devuelve la informacion guardada
        public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
}
