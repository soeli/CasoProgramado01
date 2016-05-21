/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import Vista.VentanaMatricula;
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
public class Metodos_XML_Matricula {
    
    VentanaMatricula ventanaMatricula;
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
    String archivoMatricula;
    
    //Metodo constructor de la clase
    public Metodos_XML_Matricula(VentanaMatricula ventanaMatricula)
    {
       this.ventanaMatricula=ventanaMatricula;
        archivoMatricula="Matricula";
        
        if(cargarXMLMatricula())
        {
            System.out.println("Ya existe un archivo Matricula XML creado, ya fue cargado y puede proceder a utilizarlo");
        }
        else
        {
            crearXMLMatricula();
            System.out.println("No existía un archivo Matricula XML creado, ya fue creado y puede proceder a utilizarlo");
        }
        
         arregloInformacion=new String[4];
        titulos = new ArrayList();
        valores = new ArrayList();
    }
    
      ///////////////////////////////////////////////Metodos para gestionar XML de Matricula////////////////////////////////////////////////////
    //Metodo para crear el archivo XML para la informacion de la matricula
       public void crearXMLMatricula() 
        {
        factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();
            document = implementation.createDocument(null, "xml", null);
            document.setXmlVersion("1.0");
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(archivoMatricula+".xml"));
 
            console = new StreamResult(System.out);
 
            transformer = TransformerFactory.newInstance().newTransformer();
 
            transformer.transform(source, result);
            transformer.transform(source, console);
 
        } catch (Exception e) {
            System.err.println("Error al crear el archivo Matricula XML: " + e);
        }
    }
       //Metodo para cargar el archivo XML de la Matricula
        public boolean cargarXMLMatricula() 
        {
        boolean cargo=false;
        try {
        
            File fXmlFile = new File(archivoMatricula+".xml");
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            document = builder.parse(fXmlFile);
            document.getDocumentElement().normalize();
            cargo=true;
            
            NodeList nList = document.getElementsByTagName("Matricula");
            Node nNode = nList.item(0);
            raiz = (Element) nNode;
                
        } catch (Exception e) {
            System.out.println("Error al cargar el archivo Matricula XML"+e);
        }
        return cargo;
    } 
        
    //Metodo para guardar informacion en el archivo XML de la Matricula
        public void guardarEnXMLMatricula(String arregloInformacion[])
        {
        try{
            
            raiz = document.createElement("Matricula");
            principal = document.createElement("Matricula");
            document.getDocumentElement().appendChild(raiz);
            
            Element valor1 = document.createElement("codigo");
            Text text = document.createTextNode(arregloInformacion[0]);
            Element valor2 = document.createElement("cedula");
            Text text2 = document.createTextNode(arregloInformacion[1]);
            Element valor3 = document.createElement("sigla");
            Text text3 = document.createTextNode(arregloInformacion[2]);
            
            raiz.appendChild(valor1);
            valor1.appendChild(text);
            raiz.appendChild(valor2);
            valor2.appendChild(text2);
            raiz.appendChild(valor3);
            valor3.appendChild(text3);
            
            source = new DOMSource(document);
            result = new StreamResult(new java.io.File(archivoMatricula+".xml"));
            console = new StreamResult(System.out);
            transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            transformer.transform(source, console);
            
            }
        catch (Exception e) 
        {
            System.err.println("Error al guardar Matricula: " + e);
        }
    }
 
        //Metodo para consultar de la matricula dentro del XML por la cedula
    public boolean consultarInformacionDelXmlCedula(String cedula)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false;//tituloCedula=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("cedula") && datoContenido.getNodeValue().equals(""+cedula) )
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<4)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    
    //Metodo para consultar la infromacion por sigla del XML
    public boolean consultarInformacionDelXmlSigla(String sigla)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false;//tituloCedula=false;
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
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    
    //Metodo para buscar por codigo
      public boolean consultarInformacionDelXmlCodigo(String codigo)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;

         boolean itemEncontrado=false;//tituloCedula=false;
         int contador=0;

         for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
         {   
             Node item = listaDeItems.item(contadorItems);
             NodeList datosItem = item.getChildNodes();
             for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
             {           
                 tag = datosItem.item(contadorTags); 
                 datoContenido = tag.getFirstChild();

                 if(tag.getNodeName().equals("codigo") && datoContenido.getNodeValue().equals(""+codigo) )
                 {
                    itemEncontrado=true;     
                 }
                 if(itemEncontrado && contador<4)
                 {
                    arregloInformacion[contador]=datoContenido.getNodeValue();
                    contador++;
                 }
             }

         }
         return itemEncontrado;
    }
    
    //Metodo para modificar la informacion de la matricula dentro del XML
    public void modificarInformacionDelXmlMatricula(String informacion[])
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false;//,tituloCedula=false;
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
                    if(tag.getNodeName().equals("codigo") && datoContenido.getNodeValue().equals(""+informacion[0]) )
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
           result = new StreamResult(new java.io.File(archivoMatricula+".xml"));
           console = new StreamResult(System.out);
           transformer = TransformerFactory.newInstance().newTransformer();
           transformer.transform(source, result);
           transformer.transform(source, console);
        }
        catch (Exception e) 
        {
            System.err.println("Error al modificar Matricula: " + e);
        }
    }
    
    //Metodo para eliminar informacion del XML matricula
    public void eliminarInformacionDelXmlMatricula(String codigo)
    { 
         Element raiz = document.getDocumentElement();
         NodeList listaDeItems = raiz.getElementsByTagName("Matricula");
         Node tag=null,datoContenido=null;
         String arregloInformacion[]=new String[3];
         boolean itemEncontrado=false;//,tituloCedula=false;

         try{
            for(int contadorItems=0; contadorItems<listaDeItems.getLength(); contadorItems++) 
            {   
                
                Node item = listaDeItems.item(contadorItems);
                NodeList datosItem = item.getChildNodes();
                for(int contadorTags=0; contadorTags<datosItem.getLength(); contadorTags++) 
                {
                    tag = datosItem.item(contadorTags); 
                    datoContenido = tag.getFirstChild();
                    if(tag.getNodeName().equals("codigo") && datoContenido.getNodeValue().equals(""+codigo) )
                    {
                       itemEncontrado=true;
                       raiz.removeChild(item);
                       source = new DOMSource(document);
                       result = new StreamResult(new java.io.File( archivoMatricula+".xml"));
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
            System.err.println("Error al eliminar Matricula: " + e);
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
            Logger.getLogger(Metodos_XML_Matricula.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (TransformerException ex) {
            Logger.getLogger(Metodos_XML_Matricula.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
       //Metodo que devuelve la informacion guardada
        public String[] getArregloInformacion()
    {
        return this.arregloInformacion;
    }
    
}
