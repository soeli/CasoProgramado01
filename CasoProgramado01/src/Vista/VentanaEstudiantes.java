/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Estudiantes;
import Modelo.ArchivoEstudiante;
import Modelo.ConexionBD;
import Modelo.Metodos_XML_Estudiante;
import javax.swing.JOptionPane;

/**
 *
 * @author SOFIA ELIZONDO
 */
public class VentanaEstudiantes extends javax.swing.JFrame {

  /**
 *
 * @author Sofia Elizondo y Erika Jones
 */
    public Controlador_Estudiantes controlador_Estudiantes;
    String tipoAlmacenamiento;
    
    // Metodo Constructor de la clase
    public VentanaEstudiantes(ConexionBD conexionBD,ArchivoEstudiante archivoEstudiante,Metodos_XML_Estudiante metodos_XML) {
        initComponents();
        setVisible(false);
        this.setLocation(250, 200);
        controlador_Estudiantes = new Controlador_Estudiantes(this,conexionBD,archivoEstudiante,metodos_XML);
        this.botones2.agregarEventos(controlador_Estudiantes);
        this.informacionPersonal1.agregarEventos(controlador_Estudiantes);
    }
    
    //Metodo para seleccionar el tipo de almacenamiento
    public void seleccionAlmacenamiento(String almacenamiento)
    {
        controlador_Estudiantes.seleccionAlmacenamiento(almacenamiento);
        System.out.println(almacenamiento+" VentanaEstudiantes");
        tipoAlmacenamiento=almacenamiento;
    }
    
    //Metodo para almacenar en Archivos
    public String almacenamientoArchivo()
    {
        return tipoAlmacenamiento;
    }
    
    //Metodo que devuelve la informacion personal del estudiante guardada en un arreglo
    public String[] devolverInformacion()
    {
        return this.informacionPersonal1.devolverInformacion();
    }
    //Metodo que devuelve la cedula de un estudiante
    public String devolverCedula()
    {
        return this.informacionPersonal1.devolverCedula();
    
    }
    //MEtodo para mostrar la informacion contenida en el arreglo
    public void mostrarInformacion(String arreglo[])
    {
        this.informacionPersonal1.mostrarInformacion(arreglo);
    }
    //Metodo para mostrar un mensaje
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    //Metodo que modifica los botones y los cuadros de texto para agregar informacion
    public void habilitarAgregar()
    {
        this.botones2.habilitarAgregar();
        this.informacionPersonal1.habilitarCampos();
    }
    //Metodo que modifica los botones y los cuadros de texto para resetear informacion
    public void resetearVentana()
    {
        this.botones2.deshabilitarBotones();
        this.informacionPersonal1.deshabilitarCampos();
    }
    //Metodo que modifica los botones y los cuadros de texto para modificar informacion
    public void habilitarEdicion()
    {
        this.botones2.habilitarEdicion();
        this.informacionPersonal1.habilitarEdicion();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informacionPersonal1 = new Vista.InformacionPersonal();
        botones2 = new Vista.Botones();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(650, 550));
        setPreferredSize(new java.awt.Dimension(650, 550));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(informacionPersonal1);
        informacionPersonal1.setBounds(90, 170, 430, 160);
        getContentPane().add(botones2);
        botones2.setBounds(100, 360, 470, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoestudiante-01.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 640, 530);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        if(almacenamientoArchivo()=="Archivos")
        {
            controlador_Estudiantes.ingresarInfo();
        }
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones2;
    private Vista.InformacionPersonal informacionPersonal1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

  
}
