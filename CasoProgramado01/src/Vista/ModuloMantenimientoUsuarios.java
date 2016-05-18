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
 * @author SOFIA ELIZONDO
 */
public class ModuloMantenimientoUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form ModuloMantenimientoUsuarios
     */
    Controlador_Usuario controlador;
    Login login;
    MenuPrincipal menuPrincipal;
    public ModuloMantenimientoUsuarios(MenuPrincipal menuPrincipal) {
        initComponents();
        deshabilitarCampos();
        setVisible(false);
        this.setLocation(250, 200);
        this.menuPrincipal=menuPrincipal;
        login=new Login(this,controlador);
        controlador=new Controlador_Usuario(this, login);
        login.agregarEventos(controlador);
        this.botones1.agregarEventosUsuario(controlador);
        
    }

  
    public String[] devolverInformacion()
    {
        String informacion[]=new String[3];
        informacion[0]=this.jt_Usuario.getText();
        informacion[1]=this.jt_NombreCompleto.getText();
        informacion[2]=this.jt_Contrasenia.getText();
        
        return informacion;
    }
    public String devolverUsuario()
    {
        return this.jt_Usuario.getText();
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.jt_Usuario.setText(arreglo[0]);
        this.jt_NombreCompleto.setText(arreglo[1]);
    }
    public void habilitarCampos()
    {
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Usuario.setEnabled(true);
        this.jt_Contrasenia.setEnabled(true);
    }
    public void deshabilitarCampos()
    {
        this.jt_Usuario.setEnabled(true);
        this.jt_Usuario.setText("");
        this.jt_NombreCompleto.setText("");
        this.jt_Contrasenia.setText("");
        this.jt_NombreCompleto.setEnabled(false);
        this.jt_Contrasenia.setEnabled(false);
    }
    public void habilitarEdicion()
    {
        this.jt_Usuario.setEnabled(false);
        this.jt_NombreCompleto.setEnabled(true);
        this.jt_Contrasenia.setEnabled(true);
        this.botones1.habilitarEdicion();
    }
    
    public void habilitarAgregar()
    {
        this.botones1.habilitarAgregar();
        this.habilitarCampos();
    }
    public void resetearVentana()
    {
        this.botones1.deshabilitarBotones();
        this.deshabilitarCampos();
    }
    
     public void usuarioCorrecto()
    {
        login.setVisible(false);
        menuPrincipal.setVisible(true);
    }
     
     public void nuevoRegistro()
     {
         login.setVisible(false);
         menuPrincipal.setVisible(true);
         menuPrincipal.mostrarAlmacenamiento();
         setVisible(true);
     }
    
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
        botones1 = new Vista.Botones();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        jl_NombreCompleto.setText("Nombre Completo");

        jl_Usuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        jt_NombreCompleto.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jl_NombreCompleto)
                            .addComponent(jl_Contraseña)
                            .addComponent(jl_Usuario))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                                .addComponent(jt_Contrasenia))
                            .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Usuario)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_NombreCompleto)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Contraseña))
                .addGap(18, 18, 18)
                .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        controlador.ingresarInfo();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones1;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_NombreCompleto;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jt_Contrasenia;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
