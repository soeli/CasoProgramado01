/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controlador;

import Vista.Login;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class Controlador_Programa implements ActionListener{
    
    
    MenuPrincipal menuPrincipal;
            
    public Controlador_Programa()
    {
        menuPrincipal= new MenuPrincipal();
        menuPrincipal.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        
    }
    
}
