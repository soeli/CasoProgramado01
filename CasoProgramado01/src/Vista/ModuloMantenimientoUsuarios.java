/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Usuario;
import javax.swing.JOptionPane;
import Vista.Login;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class ModuloMantenimientoUsuarios extends javax.swing.JFrame {

    Controlador_Usuario controlador;
    Login login;
    MenuPrincipal menuPrincipal;
    
    //Metodo constructor de la clase
    public ModuloMantenimientoUsuarios(MenuPrincipal menuPrincipal) {
        initComponents();
        deshabilitarCampos();
        setVisible(false);
        this.setLocation(250, 200);
        this.menuPrincipal=menuPrincipal;
        login=new Login(this,controlador);
        controlador=new Controlador_Usuario(this, login);
        login.agregarEventos(controlador);
        this.botones2.agregarEventosUsuario(controlador);
        
    }

  //Metodo que devuelve la informacion del arreglo
    public String[] devolverInformacion()
    {
        String informacion[]=new String[3];
        informacion[0]=this.jt_Usuario.getText();
        informacion[1]=this.jt_NombreCompleto.getText();
        informacion[2]=this.jt_Contrasenia.getText();
        
        return informacion;
    }
    //Metodo que devuelve el usuario
    public String devolverUsuario()
    {
        return this.jt_Usuario.getText();
    }
    //Metodo que muestra la informacion del arreglo
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Usuario.setText(arreglo[0]);
        this.jt_NombreCompleto.setText(arreglo[1]);
    }
    //Metodo que habilita los campos para escribir
    public void habilitarCampos()
    {
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Usuario.setEnabled(true);
        this.jt_Contrasenia.setEnabled(true);
    }
    //Metodo que deshabilita los campos para escribir
    public void deshabilitarCampos()
    {
        this.jt_Usuario.setEnabled(true);
        this.jt_Usuario.setText("");
        this.jt_NombreCompleto.setText("");
        this.jt_Contrasenia.setText("");
        this.jt_NombreCompleto.setEnabled(false);
        this.jt_Contrasenia.setEnabled(false);
    }
    //Metodo que modifica los botones y los cuadros de texto para modificar informacion
    public void habilitarEdicion()
    {
        this.jt_Usuario.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Contrasenia.setEnabled(true);
        this.botones2.habilitarEdicion();
    }
    //Metodo que modifica los botones y los cuadros de texto para agregar informacion
    public void habilitarAgregar()
    {
        this.botones2.habilitarAgregar();
        this.habilitarCampos();
    }
    //Metodo que modifica los botones y los cuadros de texto para resetear la ventana con informacion
    public void resetearVentana()
    {
        this.botones2.deshabilitarBotones();
        this.deshabilitarCampos();
    }
    //Metodo para saber si el usuario es correcto o no
     public void usuarioCorrecto()
    {
        mostrarMensaje("        ********Usuario Correcto********\nProceda a seleccionar el tipo de almacenamiento");
        login.setVisible(false);
        menuPrincipal.setVisible(true);
        menuPrincipal.mostrarAlmacenamiento();
        //setVisible(false);
    }
     //Metodo que controla el nuevo registr de un usuario
     public void nuevoRegistro()
     {
         login.setVisible(false);
         menuPrincipal.setVisible(true);
         menuPrincipal.mostrarAlmacenamiento();
         setVisible(true);
     }
     //Metodo que muestra el tipo de almacenamiento
     public void mostrarAlmacenamiento()
     {
         menuPrincipal.mostrarAlmacenamiento();
     }
    //Metodo para mostrar un mensaje
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_NombreCompleto = new javax.swing.JLabel();
        jl_Usuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jt_NombreCompleto = new javax.swing.JTextField();
        jt_Usuario = new javax.swing.JTextField();
        jt_Contrasenia = new javax.swing.JPasswordField();
        botones2 = new Vista.Botones();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(530, 340));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(null);

        jl_NombreCompleto.setText("Nombre Completo");
        getContentPane().add(jl_NombreCompleto);
        jl_NombreCompleto.setBounds(110, 70, 103, 16);

        jl_Usuario.setText("Nombre Usuario");
        getContentPane().add(jl_Usuario);
        jl_Usuario.setBounds(110, 30, 92, 16);

        jl_Contraseña.setText("Contraseña");
        getContentPane().add(jl_Contraseña);
        jl_Contraseña.setBounds(110, 110, 65, 16);

        jt_NombreCompleto.setToolTipText("");
        getContentPane().add(jt_NombreCompleto);
        jt_NombreCompleto.setBounds(250, 70, 163, 22);
        getContentPane().add(jt_Usuario);
        jt_Usuario.setBounds(250, 30, 163, 22);
        getContentPane().add(jt_Contrasenia);
        jt_Contrasenia.setBounds(250, 110, 163, 22);
        getContentPane().add(botones2);
        botones2.setBounds(20, 170, 470, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondocurso-01.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 520, 290);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controlador.ingresarInfo();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jt_Contrasenia;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
