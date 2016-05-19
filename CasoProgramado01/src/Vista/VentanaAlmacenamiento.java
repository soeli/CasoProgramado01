/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class VentanaAlmacenamiento extends javax.swing.JFrame implements ActionListener{

    Controlador_MenuPrincipal controlador; 
    public VentanaAlmacenamiento() {
        initComponents();
        setVisible(false);
        this.setLocation(250, 200);
    }
    public void agregarEventos(Controlador_MenuPrincipal controlador)
    {
        this.jbt_Archivos.addActionListener(controlador);
        this.jbt_Archivos.addActionListener(this);
        this.jbt_BD.addActionListener(controlador);
        this.jbt_BD.addActionListener(this);
        this.jbt_XML.addActionListener(controlador);
        this.jbt_XML.addActionListener(this);
        this.jbt_Salir.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Archivos"))
        {
            setVisible(false);
        }
        if(e.getActionCommand().equals("BD"))
        {
            setVisible(false);
        }
        if(e.getActionCommand().equals("XML"))
        {
            setVisible(false);
        }
        if(e.getActionCommand().equals("Salir"))
        {
            setVisible(false);
        }
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbt_Archivos = new javax.swing.JButton();
        jbt_BD = new javax.swing.JButton();
        jbt_XML = new javax.swing.JButton();
        jbt_Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(886, 314));
        getContentPane().setLayout(null);

        jbt_Archivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CASO-01.png"))); // NOI18N
        jbt_Archivos.setActionCommand("Archivos");
        jbt_Archivos.setOpaque(false);
        jbt_Archivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ArchivosActionPerformed(evt);
            }
        });
        jbt_Archivos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbt_ArchivosKeyPressed(evt);
            }
        });
        getContentPane().add(jbt_Archivos);
        jbt_Archivos.setBounds(310, 90, 140, 140);

        jbt_BD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CASO-02.png"))); // NOI18N
        jbt_BD.setActionCommand("BD");
        jbt_BD.setOpaque(false);
        getContentPane().add(jbt_BD);
        jbt_BD.setBounds(480, 90, 140, 140);

        jbt_XML.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CASO-03.png"))); // NOI18N
        jbt_XML.setActionCommand("XML");
        jbt_XML.setOpaque(false);
        getContentPane().add(jbt_XML);
        jbt_XML.setBounds(650, 90, 140, 140);

        jbt_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CASO-08.png"))); // NOI18N
        jbt_Salir.setActionCommand("Salir");
        getContentPane().add(jbt_Salir);
        jbt_Salir.setBounds(770, 240, 70, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondocaso-01.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 850, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_ArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ArchivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_ArchivosActionPerformed

    private void jbt_ArchivosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbt_ArchivosKeyPressed
        setVisible(false);
        System.out.println("Presionado");
        
    }//GEN-LAST:event_jbt_ArchivosKeyPressed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbt_Archivos;
    private javax.swing.JButton jbt_BD;
    private javax.swing.JButton jbt_Salir;
    private javax.swing.JButton jbt_XML;
    // End of variables declaration//GEN-END:variables
}
