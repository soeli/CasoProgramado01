/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_MenuPrincipal;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class VentanaAlmacenamiento extends javax.swing.JFrame {

    Controlador_MenuPrincipal controlador; 
    public VentanaAlmacenamiento() {
        initComponents();
    }
    public void agregarEventos(Controlador_MenuPrincipal controlador)
    {
        this.jbt_Archivos.addActionListener(controlador);
        this.jbt_BD.addActionListener(controlador);
        this.jbt_XML.addActionListener(controlador);
        this.jbt_Salir.addActionListener(controlador);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbt_Archivos = new javax.swing.JButton();
        jbt_BD = new javax.swing.JButton();
        jbt_XML = new javax.swing.JButton();
        jbt_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbt_Archivos.setText("Archivos");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbt_Salir)
                    .addComponent(jbt_XML))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbt_Archivos)
                    .addComponent(jbt_BD)
                    .addComponent(jbt_XML))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jbt_Salir)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
