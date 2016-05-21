

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */

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
            System.out.println("SQLException ejecutando sentencia elminar estudiante: " + e.getMessage());
            return false;
        }  
    }
    
    // Metodos Cursos
    public boolean registrarCurso(String informacion[])
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO cursos (sigla, nombre, creditos, horario) VALUES ('"+informacion[0]+"','"+informacion[1]+"','"+informacion[2]+"','"+informacion[3]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia Cursos: " + e.getMessage());
            return false;
        } 
        
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
                    String nombreCurso = rs.getString("nombre");
                    String creditos = rs.getString("creditos");
                    String horario = rs.getString("horario");
                    arregloInformacionConsultada[0]=nombreCurso;
                    arregloInformacionConsultada[1]=creditos;
                    arregloInformacionConsultada[2]=horario;
                    existe=true;
                    System.out.println("Información de la BD:nombre: "+nombreCurso+" Creditos: "+creditos); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    
    
    public boolean actualizarCurso(String informacion[],String nombreTabla)
    {
        ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("UPDATE `"+nombreTabla+"` SET nombre='"+informacion[1]+"', creditos='"+informacion[2]+"', horario='"+informacion[3]+"' WHERE sigla='"+informacion[0]+"'");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        }
    }
    
    
    // Metodos matricula
    public boolean registrarMatricula(String[] informacion) {
        
       ResultSet rs = null;
        Statement cmd = null;
        boolean ejecuto;
        try {
                cmd = con.createStatement();
                ejecuto = cmd.execute("INSERT INTO detalle_matricula (numero, sigla) VALUES ('"+informacion[0]+"','"+informacion[2]+"')");
                ejecuto = cmd.execute("INSERT INTO matricula (numero, cedula) VALUES ('"+informacion[0]+"','"+informacion[1]+"')");
                
               return true;
               // rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
            return false;
        } 
    }
    
    public boolean consultarMatricula(String numero)
    {
        boolean existe=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                
                rs = cmd.executeQuery("SELECT * FROM matricula where numero='"+numero+"'");
                
                while (rs.next()) 
                {
                    String cedula = rs.getString("cedula");
                    //String sigla = rs.getString("sigla");
                    arregloInformacionConsultada[0]=cedula;
                    //arregloInformacionConsultada[1]=sigla;
                    existe=true;
                    System.out.println("Información de la BD:Cedula Estudiante: "+cedula); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia: " + e.getMessage());
        }
        return existe;
    }
    
    public boolean consultarDetalleMatricula(String numero)
    {
        boolean existe=false;
        ResultSet rs = null;
        Statement cmd = null;

        try {
                cmd = con.createStatement();
                rs = cmd.executeQuery("SELECT * FROM detalle_matricula where numero='"+numero+"'");
                
                while (rs.next()) 
                {
                    String sigla = rs.getString("sigla");
                    arregloInformacionConsultada[1]=sigla;
                    existe=true;
                    System.out.println("Información de la BD:Sigla: "+sigla); 
                }
                rs.close();
        }
        catch(Exception e)
        {
            System.out.println("SQLException ejecutando sentencia : " + e.getMessage());
        }
        return existe;
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
