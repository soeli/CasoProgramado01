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

        setOpaque(false);
        setLayout(null);

        btn_Eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-04.png"))); // NOI18N
        btn_Eliminar.setToolTipText("");
        btn_Eliminar.setOpaque(false);
        add(btn_Eliminar);
        btn_Eliminar.setBounds(433, 0, 137, 113);

        btn_Consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-01.png"))); // NOI18N
        btn_Consultar.setActionCommand("Consultar");
        btn_Consultar.setOpaque(false);
        add(btn_Consultar);
        btn_Consultar.setBounds(1, 0, 137, 113);

        btn_Agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-02.png"))); // NOI18N
        btn_Agregar.setOpaque(false);
        add(btn_Agregar);
        btn_Agregar.setBounds(145, 0, 137, 113);

        btn_Modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buttons2-03.png"))); // NOI18N
        btn_Modificar.setOpaque(false);
        add(btn_Modificar);
        btn_Modificar.setBounds(289, 0, 137, 113);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Agregar;
    private javax.swing.JButton btn_Consultar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Modificar;
    // End of variables declaration//GEN-END:variables
}
