/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Cursos;
import Modelo.ArchivoCurso;
import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import javax.swing.JOptionPane;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class VentanaCursos extends javax.swing.JFrame {

    /**
     * Creates new form VentanaCursos
     */
     public Controlador_Cursos controlador;
    public VentanaCursos(ConexionBD conexionBD,ArchivoCurso archivoCurso) {
        initComponents();
        this.setLocation(250, 200);
        controlador=new Controlador_Cursos(this, conexionBD,archivoCurso);
        agregarEventos();
    }
    
    public void agregarEventos()
    {
        this.botones1.agregarEventosCursos(controlador);
        this.informacionCursos1.agregarEventos(controlador);
    }
    public String devolverSigla()
    {
        return this.informacionCursos1.devolverSigla();
    }
    public void habilitarEdicion()
    {
        this.botones1.habilitarEdicion();
        this.informacionCursos1.habilitarEdicion();
    }
    public void mostrarInformacion(String arreglo[])
    {
        this.informacionCursos1.mostrarInformacion(arreglo);
    }
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public void habilitarAgregar()
    {
        this.botones1.habilitarAgregar();
        this.informacionCursos1.habilitarCampos();
    }
    public String[] devolverInformacion()
    {
        return this.informacionCursos1.devolverInformacion();
    }
    public void resetearGUI()
    {
        this.botones1.deshabilitarBotones();
        this.informacionCursos1.deshabilitarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacionCursos1 = new Vista.InformacionCursos();
        botones1 = new Vista.Botones();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(informacionCursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(informacionCursos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones1;
    private Vista.InformacionCursos informacionCursos1;
    // End of variables declaration//GEN-END:variables
}
