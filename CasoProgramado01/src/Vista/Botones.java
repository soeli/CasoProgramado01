/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Cursos;
import Controlador.Controlador_Estudiantes;
import Controlador.Controlador_Matricula;
import Controlador.Controlador_Usuario;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class Botones extends javax.swing.JPanel {

    /**
     * Creates new form Botones
     */
    
    public Botones() {
        initComponents();
        this.btn_Agregar.setEnabled(false);
        this.btn_Modificar.setEnabled(false);
        this.btn_Eliminar.setEnabled(false);
    }

 
    public void agregarEventos(Controlador_Estudiantes controlador)
    {
        this.btn_Consultar.addActionListener(controlador);
        this.btn_Agregar.addActionListener(controlador);
        this.btn_Modificar.addActionListener(controlador);
        this.btn_Eliminar.addActionListener(controlador);
    }
    public void agregarEventos(Controlador_Matricula controlador)
    {
        this.btn_Consultar.addActionListener(controlador);
        this.btn_Agregar.addActionListener(controlador);
        this.btn_Modificar.addActionListener(controlador);
        this.btn_Eliminar.addActionListener(controlador);
    }
    public void agregarEventosCursos(Controlador_Cursos controlador)
    {
        this.btn_Consultar.addActionListener(controlador);
        this.btn_Agregar.addActionListener(controlador);
        this.btn_Modificar.addActionListener(controlador);
        this.btn_Eliminar.addActionListener(controlador);
    }
    public void agregarEventosUsuario(Controlador_Usuario controlador)
    {
        this.btn_Consultar.addActionListener(controlador);
        this.btn_Agregar.addActionListener(controlador);
        this.btn_Modificar.addActionListener(controlador);
        this.btn_Eliminar.addActionListener(controlador);
    }
    public void habilitarAgregar()
    {
        this.btn_Agregar.setEnabled(true);
    }
    public void deshabilitarBotones()
    {
        this.btn_Agregar.setEnabled(false);
        this.btn_Modificar.setEnabled(false);
        this.btn_Eliminar.setEnabled(false);
    }
    public void habilitarEdicion()
    {
        this.btn_Modificar.setEnabled(true);
        this.btn_Eliminar.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Eliminar = new javax.swing.JButton();
        btn_Consultar = new javax.swing.JButton();
        btn_Agregar = new javax.swing.JButton();
        btn_Modificar = new javax.swing.JButton();

        setOpaque(false);
        setLayout(null);

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-04.png"))); // NOI18N
        btn_Eliminar.setToolTipText("");
        btn_Eliminar.setActionCommand("Eliminar");
        btn_Eliminar.setContentAreaFilled(false);
        add(btn_Eliminar);
        btn_Eliminar.setBounds(360, 0, 110, 100);

        btn_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-01.png"))); // NOI18N
        btn_Consultar.setActionCommand("Consultar");
        btn_Consultar.setContentAreaFilled(false);
        btn_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultarActionPerformed(evt);
            }
        });
        add(btn_Consultar);
        btn_Consultar.setBounds(0, 0, 110, 100);

        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-02.png"))); // NOI18N
        btn_Agregar.setActionCommand("Agregar");
        btn_Agregar.setContentAreaFilled(false);
        add(btn_Agregar);
        btn_Agregar.setBounds(120, 0, 110, 100);

        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-03.png"))); // NOI18N
        btn_Modificar.setActionCommand("Modificar");
        btn_Modificar.setContentAreaFilled(false);
        add(btn_Modificar);
        btn_Modificar.setBounds(240, 0, 110, 100);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Consultar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    // End of variables declaration//GEN-END:variables
}
