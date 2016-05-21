/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vista;
import Controlador.Controlador_MenuPrincipal;
import Vista.Login;
import Vista.VentanaAlmacenamiento;
import javax.swing.JOptionPane;
/**
 *
 * @author Sofia Elizondo y Erika Jones
 */
public class MenuPrincipal extends javax.swing.JFrame {

    Controlador_MenuPrincipal controlador_MenuPrincipal;
    VentanaAlmacenamiento almacenamiento;
    
    //Metodo constructor de la clase
    public MenuPrincipal() 
    {
        initComponents();
        this.setLocation(200, 100);
        controlador_MenuPrincipal= new Controlador_MenuPrincipal(this);
        agregarEventos();
        almacenamiento= new VentanaAlmacenamiento();
        almacenamiento.agregarEventos(controlador_MenuPrincipal);
    }
    //Metodo para mostrar un mensaje
    public void mostrarMensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    //Metodo que agrega eventos a los botones, items del menu y demas
    public void agregarEventos()
    {
        this.jm_Salir.addActionListener(controlador_MenuPrincipal);
        this.btn_Estudiantes.addActionListener(controlador_MenuPrincipal);
        this.btn_Cursos.addActionListener(controlador_MenuPrincipal);
        this.btn_Matricula.addActionListener(controlador_MenuPrincipal);
        this.jm_Usuario.addActionListener(controlador_MenuPrincipal);
        this.jl_Almacenamiento.addActionListener(controlador_MenuPrincipal);
    }
    
    //Metodo que controla la vista del almacenamiento
    public void mostrarAlmacenamiento()
    {
        almacenamiento.setVisible(true);
    }
    ///metodo para ocultar la vista del almacenamiento
    public void ocultarAlmacenamiento()
    {
        almacenamiento.setVisible(false);
    } 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Estudiantes = new javax.swing.JButton();
        btn_Cursos = new javax.swing.JButton();
        btn_Matricula = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jm_Administrador = new javax.swing.JMenu();
        jl_Almacenamiento = new javax.swing.JMenuItem();
        jm_Usuario = new javax.swing.JMenuItem();
        jm_Propiedades = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Estudiantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/estudiante.png"))); // NOI18N
        btn_Estudiantes.setActionCommand("Estudiantes");
        btn_Estudiantes.setContentAreaFilled(false);
        getContentPane().add(btn_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, -1, -1));

        btn_Cursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cursos.png"))); // NOI18N
        btn_Cursos.setActionCommand("Cursos");
        btn_Cursos.setContentAreaFilled(false);
        getContentPane().add(btn_Cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, -1, -1));

        btn_Matricula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/matricula.png"))); // NOI18N
        btn_Matricula.setActionCommand("Matricula");
        btn_Matricula.setContentAreaFilled(false);
        btn_Matricula.setFocusPainted(false);
        getContentPane().add(btn_Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoprin-01.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jm_Administrador.setText("Administrador");

        jl_Almacenamiento.setText("Almacenamiento");
        jm_Administrador.add(jl_Almacenamiento);

        jm_Usuario.setText("Nuevo Usuario");
        jm_Administrador.add(jm_Usuario);

        jMenuBar1.add(jm_Administrador);

        jm_Propiedades.setText("Propiedades");

        jm_Salir.setText("Salir");
        jm_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jm_SalirActionPerformed(evt);
            }
        });
        jm_Propiedades.add(jm_Salir);

        jMenuBar1.add(jm_Propiedades);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jm_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jm_SalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jm_SalirActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btn_Cursos;
    private javax.swing.JButton btn_Estudiantes;
    private javax.swing.JButton btn_Matricula;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jl_Almacenamiento;
    private javax.swing.JMenu jm_Administrador;
    private javax.swing.JMenu jm_Propiedades;
    private javax.swing.JMenuItem jm_Salir;
    private javax.swing.JMenuItem jm_Usuario;
    // End of variables declaration//GEN-END:variables
}
