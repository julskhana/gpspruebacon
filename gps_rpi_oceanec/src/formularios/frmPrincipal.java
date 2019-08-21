/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import javax.swing.JOptionPane;
import objetos.usuario;

/**
 *
 * @author Leonel
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    public static usuario userAct;
    
    public frmPrincipal(usuario u) {
        initComponents();
        
        txuser.setText(u.getNombre());
        userAct = u;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txuser = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mArchivo = new javax.swing.JMenu();
        mnCuenta = new javax.swing.JMenuItem();
        mnSalir = new javax.swing.JMenuItem();
        mMantenimiento = new javax.swing.JMenu();
        mnDerivadores = new javax.swing.JMenuItem();
        mnUsuarios = new javax.swing.JMenuItem();
        mAcciones = new javax.swing.JMenu();
        mnVerDerivador = new javax.swing.JMenuItem();
        mnVerUbicaciones = new javax.swing.JMenuItem();
        mAcercaDe = new javax.swing.JMenu();
        mnAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal - Derivador GPS");

        jLabel1.setText("Usuario Activo:");

        txuser.setEditable(false);

        mArchivo.setText("Archivo");

        mnCuenta.setText("Cuenta");
        mnCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCuentaActionPerformed(evt);
            }
        });
        mArchivo.add(mnCuenta);

        mnSalir.setText("Salir");
        mnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSalirActionPerformed(evt);
            }
        });
        mArchivo.add(mnSalir);

        jMenuBar1.add(mArchivo);

        mMantenimiento.setText("Mantenimiento");

        mnDerivadores.setText("Derivadores");
        mnDerivadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDerivadoresActionPerformed(evt);
            }
        });
        mMantenimiento.add(mnDerivadores);

        mnUsuarios.setText("Usuarios");
        mnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUsuariosActionPerformed(evt);
            }
        });
        mMantenimiento.add(mnUsuarios);

        jMenuBar1.add(mMantenimiento);

        mAcciones.setText("Acciones");
        mAcciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAccionesActionPerformed(evt);
            }
        });

        mnVerDerivador.setText("Ver Derivadores");
        mnVerDerivador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVerDerivadorActionPerformed(evt);
            }
        });
        mAcciones.add(mnVerDerivador);

        mnVerUbicaciones.setText("Ver Ubicaciones");
        mnVerUbicaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnVerUbicacionesActionPerformed(evt);
            }
        });
        mAcciones.add(mnVerUbicaciones);

        jMenuBar1.add(mAcciones);

        mAcercaDe.setText("Información");
        mAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAcercaDeActionPerformed(evt);
            }
        });

        mnAcercaDe.setText("Acerca De...");
        mnAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnAcercaDeActionPerformed(evt);
            }
        });
        mAcercaDe.add(mnAcercaDe);

        jMenuBar1.add(mAcercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txuser, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(444, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(346, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSalirActionPerformed
        // TODO add your handling code here:
        int opcion = JOptionPane.showConfirmDialog(this,"¿Desea salir?","Atención",JOptionPane.YES_NO_OPTION);
        if(opcion==0){
            System.exit(0);
        }
    }//GEN-LAST:event_mnSalirActionPerformed

    private void mAccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mAccionesActionPerformed

    private void mnVerDerivadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVerDerivadorActionPerformed
        // TODO add your handling code here:
        frmConsultaDervidador verder = new frmConsultaDervidador();
        verder.setVisible(true);
    }//GEN-LAST:event_mnVerDerivadorActionPerformed

    private void mnDerivadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDerivadoresActionPerformed
        // TODO add your handling code here:
        frmDerivadores dr = new frmDerivadores();
        dr.setVisible(true);
    }//GEN-LAST:event_mnDerivadoresActionPerformed

    private void mnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUsuariosActionPerformed
        // TODO add your handling code here:
        frmUsuarios usr = new frmUsuarios();
        usr.setVisible(true);
    }//GEN-LAST:event_mnUsuariosActionPerformed

    private void mnVerUbicacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnVerUbicacionesActionPerformed
        // TODO add your handling code here:
        frmUbicaciones ubis = new frmUbicaciones();
        ubis.setVisible(true);
    }//GEN-LAST:event_mnVerUbicacionesActionPerformed

    private void mnCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCuentaActionPerformed
        // TODO add your handling code here:
        frmCuentaUsuario cuenta = new frmCuentaUsuario(userAct);
        cuenta.setVisible(true);
    }//GEN-LAST:event_mnCuentaActionPerformed

    private void mAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAcercaDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mAcercaDeActionPerformed

    private void mnAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnAcercaDeActionPerformed
        // TODO add your handling code here:
        frmAcercaDe ad = new frmAcercaDe();
        ad.setVisible(true);
    }//GEN-LAST:event_mnAcercaDeActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAcciones;
    private javax.swing.JMenu mAcercaDe;
    private javax.swing.JMenu mArchivo;
    private javax.swing.JMenu mMantenimiento;
    private javax.swing.JMenuItem mnAcercaDe;
    private javax.swing.JMenuItem mnCuenta;
    private javax.swing.JMenuItem mnDerivadores;
    private javax.swing.JMenuItem mnSalir;
    private javax.swing.JMenuItem mnUsuarios;
    private javax.swing.JMenuItem mnVerDerivador;
    private javax.swing.JMenuItem mnVerUbicaciones;
    private javax.swing.JTextField txuser;
    // End of variables declaration//GEN-END:variables
}
