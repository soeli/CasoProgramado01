

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConexionBD {
    
    Connection con = null;
    String[] arregloInformacionConsultada=new String[3];;
    public ConexionBD()
    {
        realizarConexion();
    }
    
    public void realizarConexion()
    {
        try {
            String userName = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/matricula";//Ruta por la que se coneca.... numero de MySQL...escribir \s en consola MySql/nombre del archivo en web ruta 80
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Conexión Realizada BD");
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } 
    }
    public boolean registrarEstudiante(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO estudiantes (cedula, nombre, direccion) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia de Estudiantes" + e.getMessage());
            return false;
        } 
        
    }
    
    public boolean registrarCurso(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos (sigla, nombreCurso, creditos, horario) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
        
    }
    
    public boolean registrarMatricula(String[] informacion) {
        
       ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO matricula (codigo, cedula, sigla) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM estudiantes where cedula='"+cedula+"'");
                
                while (rs.next()) 
                {
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    arregloInformacionConsultada[0]=nombre;
                    arregloInformacionConsultada[1]=direccion;
                    existe=true;
                    System.out.println("Información de la BD:Nombre: "+nombre+" Direccion: "+direccion); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia Consultar Estudiante: " + e.getMessage());
        }
        return existe;
    }
    
    
    public boolean consultarCurso(String sigla)
    {
        boolean existe=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM cursos where sigla='"+sigla+"'");
                
                while (rs.next()) 
                {
                    String nombreCurso = rs.getString("nombreCurso");
                    String creditos = rs.getString("creditos");
                    String horario = rs.getString("horario");
                    arregloInformacionConsultada[0]=nombreCurso;
                    arregloInformacionConsultada[1]=creditos;
                    arregloInformacionConsultada[2]=horario;
                    existe=true;
                    System.out.println("Información de la BD:NombreCurso: "+nombreCurso+" Creditos: "+creditos); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }

    public boolean consultarMatricula(String codigo)
    {
        boolean existe=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM matricula where codigo='"+codigo+"'");
                
                while (rs.next()) 
                {
                    String cedula = rs.getString("cedula");
                    String creditos = rs.getString("sigla");
                    arregloInformacionConsultada[0]=cedula;
                    arregloInformacionConsultada[1]=creditos;
                    existe=true;
                    System.out.println("Información de la BD:NombreCurso: "+cedula+" Creditos: "+creditos); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }  
    
    public boolean actualizarEstudiante(String informacion[],String nombreTabla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `"+nombreTabla+"` SET nombre='"+informacion[1]+"', direccion='"+informacion[2]+"' WHERE cedula='"+informacion[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    
    
    public boolean actualizarCurso(String informacion[],String nombreTabla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `"+nombreTabla+"` SET nombreCurso='"+informacion[1]+"', creditos='"+informacion[2]+"', horario='"+informacion[3]+"' WHERE sigla='"+informacion[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    
    public boolean eliminarEstudiante(String informacion,String nombreTabla,String nombreColumna)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("DELETE FROM `"+nombreTabla+"` WHERE "+nombreColumna+"='"+informacion+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }  
    }

    
    public String devolverCodigo(String codigo)
    {
        String codigoNuevo="";
        int numero=Integer.parseInt(codigo);
        
        
            numero++;
           codigoNuevo="000"+numero;
           
        System.out.println(codigo+"-"+codigoNuevo+"-"+numero);
       
       return codigoNuevo; 
    }
   
    
}
