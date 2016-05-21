/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Usuario;
import Vista.ModuloMantenimientoUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Login extends javax.swing.JFrame {

  
    ModuloMantenimientoUsuarios mantenimientoUsuarios;

    //Metodo constructor de la clase
    public Login(ModuloMantenimientoUsuarios mantenimientoUsuarios,Controlador_Usuario controlador) {
        initComponents();
        setLocation(500,200);
        setVisible(true);
    }
    
    //Metodo que devuelve el usuario
    public String devolverUsuario()
    {
        return this.jt_Usuario.getText();
    }
    
    //Metodo que devuelve la informacion
    public String[] devolverInformacion()
    {
        String informacion[]=new String[3];
        informacion[0]=this.jt_Usuario.getText();
        informacion[1]=this.jt_Contrasenia.getText();
        
        return informacion;
    }
    
    //Metodo que agrega eventos a los botones
    public void agregarEventos(Controlador_Usuario controlador)
    {
        this.jbtn_Aceptar.addActionListener(controlador);
        this.jbt_NuevoRegistro.addActionListener(controlador);
    }

    //Metodos para mostrar mensajes
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Usuario = new javax.swing.JLabel();
        jt_Usuario = new javax.swing.JTextField();
        jl_Contraseña = new javax.swing.JLabel();
        jbtn_Aceptar = new javax.swing.JButton();
        jt_Contrasenia = new javax.swing.JPasswordField();
        jbt_NuevoRegistro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(320, 185));
        getContentPane().setLayout(null);

        jl_Usuario.setText("Usuario");
        getContentPane().add(jl_Usuario);
        jl_Usuario.setBounds(25, 23, 43, 16);
        getContentPane().add(jt_Usuario);
        jt_Usuario.setBounds(118, 20, 169, 22);

        jl_Contraseña.setText("Contraseña");
        getContentPane().add(jl_Contraseña);
        jl_Contraseña.setBounds(25, 66, 65, 16);

        jbtn_Aceptar.setText("Aceptar");
        getContentPane().add(jbtn_Aceptar);
        jbtn_Aceptar.setBounds(43, 103, 77, 25);
        getContentPane().add(jt_Contrasenia);
        jt_Contrasenia.setBounds(118, 63, 169, 22);

        jbt_NuevoRegistro.setText("Nuevo Registro");
        jbt_NuevoRegistro.setActionCommand("Registro");
        getContentPane().add(jbt_NuevoRegistro);
        jbt_NuevoRegistro.setBounds(155, 103, 119, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondocurso-01.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 310, 140);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbt_NuevoRegistro;
    private javax.swing.JButton jbtn_Aceptar;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jt_Contrasenia;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
