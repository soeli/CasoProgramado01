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
        this.jbt_BD.addActionListener(controlador);
        this.jbt_XML.addActionListener(controlador);
        this.jbt_Salir.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
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

        jbt_Archivos.setText("Archivos");
        jbt_Archivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbt_ArchivosActionPerformed(evt);
            }
        });

        jbt_BD.setText("BD");

        jbt_XML.setText("XML");

        jbt_Salir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jbt_Archivos)
                .addGap(46, 46, 46)
                .addComponent(jbt_BD)
                .addGap(47, 47, 47)
                .addComponent(jbt_XML)
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbt_Salir)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_Archivos)
                    .addComponent(jbt_BD)
                    .addComponent(jbt_XML))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jbt_Salir)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbt_ArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbt_ArchivosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbt_ArchivosActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbt_Archivos;
    private javax.swing.JButton jbt_BD;
    private javax.swing.JButton jbt_Salir;
    private javax.swing.JButton jbt_XML;
    // End of variables declaration//GEN-END:variables
}
