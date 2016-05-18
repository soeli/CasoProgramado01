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
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    
    Controlador_MenuPrincipal controlador_MenuPrincipal;
    
    public MenuPrincipal() 
    {
        initComponents();
        this.setLocation(200, 100);
        controlador_MenuPrincipal= new Controlador_MenuPrincipal();
        agregarEventos();
    }
    
    
    public void agregarEventos()
    {
        this.jm_Salir.addActionListener(controlador_MenuPrincipal);
        this.btn_Estudiantes.addActionListener(controlador_MenuPrincipal);
        this.btn_Cursos.addActionListener(controlador_MenuPrincipal);
        this.btn_Matricula.addActionListener(controlador_MenuPrincipal);
        this.jm_Usuario.addActionListener(controlador_MenuPrincipal);
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
        jm_Usuario = new javax.swing.JMenuItem();
        jm_Propiedades = new javax.swing.JMenu();
        jm_Salir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Estudiantes.setText("Estudiantes");
        btn_Estudiantes.setContentAreaFilled(false);
        getContentPane().add(btn_Estudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        btn_Cursos.setText("Cursos");
        btn_Cursos.setContentAreaFilled(false);
        getContentPane().add(btn_Cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        btn_Matricula.setText("Matricula");
        btn_Matricula.setContentAreaFilled(false);
        btn_Matricula.setFocusPainted(false);
        getContentPane().add(btn_Matricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jm_Administrador.setText("Administrador");

        jm_Usuario.setText("Usuario");
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
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btn_Cursos;
    private javax.swing.JButton btn_Estudiantes;
    private javax.swing.JButton btn_Matricula;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jm_Administrador;
    private javax.swing.JMenu jm_Propiedades;
    private javax.swing.JMenuItem jm_Salir;
    private javax.swing.JMenuItem jm_Usuario;
    // End of variables declaration//GEN-END:variables
}
