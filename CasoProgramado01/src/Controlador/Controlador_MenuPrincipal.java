/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_MenuPrincipal implements ActionListener{
    

    
    public Controlador_MenuPrincipal()
    {
        //conexionBD = new ConexionBD();
//        frm_MantenimientoEstufiantes= new FRM_MantenimientoEstudiantes(conexionBD);
//        frm_MantenimientoCursos= new FRM_MantenimientoCursos(conexionBD); 
//        frm_Matricula =new FRM_Matricula(frm_MantenimientoEstufiantes,frm_MantenimientoCursos, conexionBD);
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.out.println("Salir");
            System.exit(0);
        }
        if(e.getActionCommand().equals("Usuario"))
        {
            System.out.println("Administrador");
            //frm_MantenimientoEstufiantes.setVisible(true);    
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            
            System.out.println("Estudiantes");
            //frm_Matricula.setVisible(true);
           
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            System.out.println("Cursos");
            //frm_MantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            System.out.println("Matricula");
            //frm_Matricula.setVisible(true);
           
        }
    
    }
    
    
}
