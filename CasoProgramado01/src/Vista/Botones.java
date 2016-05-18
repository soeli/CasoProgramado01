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
 * @author SOFIA ELIZONDO
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

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.setToolTipText("");
        btn_Eliminar.setActionCommand("Eliminar");

        btn_Consultar.setText("Buscar");
        btn_Consultar.setActionCommand("Consultar");

        btn_Agregar.setText("Agregar");
        btn_Agregar.setActionCommand("Agregar");

        btn_Modificar.setText("Modificar");
        btn_Modificar.setActionCommand("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Consultar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Eliminar)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Eliminar)
                    .addComponent(btn_Modificar)
                    .addComponent(btn_Agregar)
                    .addComponent(btn_Consultar))
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Consultar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    // End of variables declaration//GEN-END:variables
}
