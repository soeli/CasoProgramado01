/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Estudiantes;
import Modelo.ArchivoEstudiante;
import Modelo.ConexionBD;
import javax.swing.JOptionPane;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class VentanaEstudiantes extends javax.swing.JFrame {

    /**
     * Creates new form VentanaEstudiantes
     */
    public Controlador_Estudiantes controlador_Estudiantes;
    
    public VentanaEstudiantes(ConexionBD conexionBD,ArchivoEstudiante archivoEstudiante) {
        initComponents();
        setVisible(false);
        this.setLocation(250, 200);
        controlador_Estudiantes = new Controlador_Estudiantes(this,conexionBD,archivoEstudiante);
        this.botones1.agregarEventos(controlador_Estudiantes);
        this.informacionPersonal2.agregarEventos(controlador_Estudiantes);
    }
    
    public void seleccionAlmacenamiento(String almacenamiento)
    {
        controlador_Estudiantes.seleccionAlmacenamiento(almacenamiento);
        System.out.println(almacenamiento+" VentanaEstudiantes");
    }
    

    public String[] devolverInformacion()
    {
        return this.informacionPersonal2.devolverInformacion();
    }
    public String devolverCedula()
    {
        return this.informacionPersonal2.devolverCedula();
    
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.informacionPersonal2.mostrarInformacion(arreglo);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void habilitarAgregar()
    {
        this.botones1.habilitarAgregar();
        this.informacionPersonal2.habilitarCampos();
    }
    public void resetearVentana()
    {
        this.botones1.deshabilitarBotones();
        this.informacionPersonal2.deshabilitarCampos();
    }
    public void habilitarEdicion()
    {
        this.botones1.habilitarEdicion();
        this.informacionPersonal2.habilitarEdicion();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones1 = new Vista.Botones();
        botones2 = new Vista.Botones();
        informacionPersonal2 = new Vista.InformacionPersonal();
        jLabel2 = new javax.swing.JLabel();

        getContentPane().setLayout(null);
        getContentPane().add(botones1);
        botones1.setBounds(589, 492, 0, 0);
        getContentPane().add(botones2);
        botones2.setBounds(40, 380, 570, 110);
        getContentPane().add(informacionPersonal2);
        informacionPersonal2.setBounds(70, 160, 500, 170);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoestudiante-01.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 660, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones1;
    private Vista.Botones botones2;
    private Vista.InformacionPersonal informacionPersonal2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

  
}
