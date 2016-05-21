/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;

import Controlador.Controlador_Matricula;
import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Modelo.MetodosMatricula;
import Modelo.Metodos_XML_Matricula;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class VentanaMatricula extends javax.swing.JFrame {

    public VentanaMatricula() {
        initComponents();
    }
    
    DefaultTableModel modelo;
    Controlador_Matricula controlador;
    MetodosMatricula metodosMatricula;
    String tipoAlmacenamiento;
    
    public VentanaMatricula(VentanaEstudiantes ventanaEstudiantes,VentanaCursos ventanaCursos,ConexionBD conexionBD,ArchivoMatricula archivoMatricula,Metodos_XML_Matricula metodos_XML) {
        initComponents();
        setLocation(200,200);
        controlador= new Controlador_Matricula(ventanaEstudiantes,ventanaCursos,this,conexionBD,archivoMatricula, metodos_XML);
        agregarEventos();
        metodosMatricula=controlador.metodosMatricula;
        modelo=new DefaultTableModel();
        colocarTitulosTabla();
    }
    
    public void seleccionAlmacenamiento(String almacenamiento)
    {
        controlador.seleccionAlmacenamiento(almacenamiento);
        System.out.println(almacenamiento+" VentanaMatricula");
        tipoAlmacenamiento=almacenamiento;   
    }
    
    public String almacenamientoArchivo()
    {
        return tipoAlmacenamiento;
    }
    
   public void agregarInformacionTabla()
    {
        String arreglo[]=new String[4];
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=this.jt_Cedula.getText();
        arreglo[2]=this.jt_NombreEstudiante.getText();
        arreglo[3]=this.jt_Sigla.getText();
        modelo.addRow(arreglo);
        
    }
    
    public void agregarInformacion(String string)
    {
        String arreglo[]=new String[4];
        arreglo[0]=this.jt_CodigoMatricula.getText();
        arreglo[1]=this.jt_Cedula.getText();
        arreglo[2]=string;
        arreglo[3]=this.jt_Sigla.getText();
        modelo.addRow(arreglo);  
    }

    public void devolverInformacionTabla(String[] arreglo)
    {
        modelo.addRow(arreglo);  
    }
    
    
    public void agregarEventos()
    {
        this.btn_ConsultaRapidaCedula.addActionListener(controlador);
        this.btn_ConsultaRapidaSigla.addActionListener(controlador);
        this.btn_Finalizar.addActionListener(controlador);
        this.botones2.agregarEventos(controlador);
        
    }
    public void resetearVentana()
    {
        this.jt_Cedula.setText("");
        this.jt_NombreEstudiante.setText("");
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
        for(int contador=0;contador<modelo.getRowCount();contador++)
        {
            modelo.removeRow(contador);
           
        }
    }
    public void limpiarSigla()
    {
        this.jt_Sigla.setText("");
        this.jt_NombreCurso.setText("");
    }
    public String devolverCedula()
    {
        return this.jt_Cedula.getText();
    }
    public String devolverSigla()
    {
        return this.jt_Sigla.getText();
    }
    
    public void colocarCedula(String cedula)
    {
        this.jt_Cedula.setText(cedula);
    }
    public void colocarSigla(String sigla)
    {
        this.jt_Sigla.setText(sigla);
    }
    public String devolverCodigo()
    {
        return this.jt_CodigoMatricula.getText();
    }
    public void colocarNombreEstudiante(String nombre)
    {
        this.jt_NombreEstudiante.setText(nombre);
    }
    public String devolverDato(int fila, int columna)
    {
        return ""+modelo.getValueAt(fila, columna);
    }
    public void colocarNombreCurso(String nombre)
    {
        this.jt_NombreCurso.setText(nombre);
    }
    
    
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    public void colocarTitulosTabla()
    {
        this.tbl_Tabla.setModel(modelo);
        modelo.addColumn("Código");
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre Est.");
        modelo.addColumn("Sigla");
    }
    public void habilitarAgregar()
    {
        this.botones2.habilitarAgregar();
    }
    public void colocarCodigo(String codigo)
    {
        this.jt_CodigoMatricula.setText(codigo); 
    }
    public void habilitarEdicion()
    {
        this.botones2.habilitarEdicion();
        this.jt_Cedula.setEnabled(true);
        this.jt_CodigoMatricula.setEnabled(false);
        this.jt_Sigla.setEnabled(true);
    }
    
    public int getCantidadFilas()
    {
        return modelo.getRowCount();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_codigoMatricula = new javax.swing.JLabel();
        jt_Cedula = new javax.swing.JTextField();
        jt_CodigoMatricula = new javax.swing.JTextField();
        btn_ConsultaRapidaCedula = new javax.swing.JButton();
        btn_Finalizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jt_NombreEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jt_Sigla = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jt_NombreCurso = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Tabla = new javax.swing.JTable();
        btn_ConsultaRapidaSigla = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        botones2 = new Vista.Botones();
        jLabel6 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(941, 670));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        getContentPane().setLayout(null);

        jl_codigoMatricula.setText("Código Matrícula");
        getContentPane().add(jl_codigoMatricula);
        jl_codigoMatricula.setBounds(100, 200, 79, 14);

        jt_Cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_CedulaKeyPressed(evt);
            }
        });
        getContentPane().add(jt_Cedula);
        jt_Cedula.setBounds(230, 230, 128, 20);

        jt_CodigoMatricula.setText("001");
        getContentPane().add(jt_CodigoMatricula);
        jt_CodigoMatricula.setBounds(230, 200, 206, 20);

        btn_ConsultaRapidaCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N
        btn_ConsultaRapidaCedula.setActionCommand("ConsultaRapidaCedula");
        btn_ConsultaRapidaCedula.setContentAreaFilled(false);
        btn_ConsultaRapidaCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ConsultaRapidaCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ConsultaRapidaCedula);
        btn_ConsultaRapidaCedula.setBounds(370, 230, 70, 70);

        btn_Finalizar.setText("Finalizar Matrícula");
        btn_Finalizar.setActionCommand("Finalizar");
        getContentPane().add(btn_Finalizar);
        btn_Finalizar.setBounds(790, 590, 117, 23);

        jLabel2.setText("Nombre Estudiante");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 270, 91, 14);

        jt_NombreEstudiante.setEnabled(false);
        getContentPane().add(jt_NombreEstudiante);
        jt_NombreEstudiante.setBounds(230, 270, 128, 20);

        jLabel3.setText("Sigla");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(510, 200, 22, 14);

        jt_Sigla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt_SiglaKeyPressed(evt);
            }
        });
        getContentPane().add(jt_Sigla);
        jt_Sigla.setBounds(548, 200, 180, 20);

        jLabel4.setText("Nombre Curso");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(510, 240, 68, 14);

        jt_NombreCurso.setEnabled(false);
        getContentPane().add(jt_NombreCurso);
        jt_NombreCurso.setBounds(600, 240, 128, 20);

        tbl_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_Tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(280, 310, 460, 100);

        btn_ConsultaRapidaSigla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N
        btn_ConsultaRapidaSigla.setActionCommand("ConsultaRapidaSigla");
        btn_ConsultaRapidaSigla.setContentAreaFilled(false);
        getContentPane().add(btn_ConsultaRapidaSigla);
        btn_ConsultaRapidaSigla.setBounds(740, 190, 70, 70);

        jLabel1.setText("Cédula");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 230, 33, 14);
        getContentPane().add(botones2);
        botones2.setBounds(270, 460, 470, 100);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondomatricula2-01.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 940, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
        if(almacenamientoArchivo()=="Archivos")
        {
            controlador.ingresarInfo();
        }
    }//GEN-LAST:event_formComponentHidden

    private void btn_ConsultaRapidaCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ConsultaRapidaCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ConsultaRapidaCedulaActionPerformed

    private void jt_CedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_CedulaKeyPressed
        if(evt.getKeyCode()==10)
        {
            controlador.consultaRapidaCedula();
        }
    }//GEN-LAST:event_jt_CedulaKeyPressed

    private void jt_SiglaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt_SiglaKeyPressed
        if(evt.getKeyCode()==10)
        {
            //
        }
    }//GEN-LAST:event_jt_SiglaKeyPressed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.Botones botones2;
    private javax.swing.JButton btn_ConsultaRapidaCedula;
    private javax.swing.JButton btn_ConsultaRapidaSigla;
    private javax.swing.JButton btn_Finalizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl_codigoMatricula;
    private javax.swing.JTextField jt_Cedula;
    private javax.swing.JTextField jt_CodigoMatricula;
    private javax.swing.JTextField jt_NombreCurso;
    private javax.swing.JTextField jt_NombreEstudiante;
    private javax.swing.JTextField jt_Sigla;
    private javax.swing.JTable tbl_Tabla;
    // End of variables declaration//GEN-END:variables
}
