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
 * @author SOFIA ELIZONDO
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    ModuloMantenimientoUsuarios mantenimientoUsuarios;

    
    public Login(ModuloMantenimientoUsuarios mantenimientoUsuarios,Controlador_Usuario controlador) {
        initComponents();
        setLocation(500,200);
        setVisible(true);
    }
    
    public String devolverUsuario()
    {
        return this.jt_Usuario.getText();
    }
    
    public String[] devolverInformacion()
    {
        String informacion[]=new String[3];
        informacion[0]=this.jt_Usuario.getText();
        informacion[2]=this.jt_Contrasenia.getText();
        
        return informacion;
    }
    
    public void agregarEventos(Controlador_Usuario controlador)
    {
        this.jbtn_Aceptar.addActionListener(controlador);
        this.jbt_NuevoRegistro.addActionListener(controlador);
    }
    
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

        jl_Usuario.setText("Usuario");

        jl_Contraseña.setText("Contraseña");

        jbtn_Aceptar.setText("Aceptar");

        jbt_NuevoRegistro.setText("Nuevo Registro");
        jbt_NuevoRegistro.setActionCommand("Registro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Usuario)
                    .addComponent(jl_Contraseña))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jt_Contrasenia))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jbtn_Aceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jbt_NuevoRegistro)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Usuario)
                    .addComponent(jt_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contraseña)
                    .addComponent(jt_Contrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtn_Aceptar)
                    .addComponent(jbt_NuevoRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbt_NuevoRegistro;
    private javax.swing.JButton jbtn_Aceptar;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jt_Contrasenia;
    private javax.swing.JTextField jt_Usuario;
    // End of variables declaration//GEN-END:variables
}
