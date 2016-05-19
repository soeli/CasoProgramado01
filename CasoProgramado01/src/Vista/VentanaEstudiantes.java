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
        this.informacionPersonal1.agregarEventos(controlador_Estudiantes);
    }
    
    public void seleccionAlmacenamiento(String almacenamiento)
    {
        controlador_Estudiantes.seleccionAlmacenamiento(almacenamiento);
        System.out.println(almacenamiento+" VentanaEstudiantes");
    }
    

    public String[] devolverInformacion()
    {
        return this.informacionPersonal1.devolverInformacion();
    }
    public String devolverCedula()
    {
        return this.informacionPersonal1.devolverCedula();
    
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.informacionPersonal1.mostrarInformacion(arreglo);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void habilitarAgregar()
    {
        this.botones1.habilitarAgregar();
        this.informacionPersonal1.habilitarCampos();
    }
    public void resetearVentana()
    {
        this.botones1.deshabilitarBotones();
        this.informacionPersonal1.deshabilitarCampos();
    }
    public void habilitarEdicion()
    {
        this.botones1.habilitarEdicion();
        this.informacionPersonal1.habilitarEdicion();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacionPersonal1 = new Vista.InformacionPersonal();
        botones1 = new Vista.Botones();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informacionPersonal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(informacionPersonal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones1;
    private Vista.InformacionPersonal informacionPersonal1;
    // End of variables declaration//GEN-END:variables

  
}
