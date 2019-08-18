/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import bd.ConexionBD;
import javax.swing.JOptionPane;
import objetos.usuario;

/**
 *
 * @author Julian
 */
public class frmIngresarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form frmIngresarUsuarios
     */
    public frmIngresarUsuarios() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        icono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbRol = new javax.swing.JComboBox<>();
        txCuenta = new javax.swing.JTextField();
        pfClave = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        VerificacionClave = new javax.swing.JLabel();
        pfClaveConfirmada = new javax.swing.JPasswordField();
        txCedula = new javax.swing.JTextField();
        txTelefono = new javax.swing.JTextField();
        btLimpiar = new javax.swing.JButton();
        btIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso Usuarios");

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/usuario.png"))); // NOI18N
        icono.setMinimumSize(new java.awt.Dimension(48, 48));
        icono.setPreferredSize(new java.awt.Dimension(48, 48));

        jLabel1.setText("Cuenta:");

        jLabel2.setText("Clave:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Cedula:");

        jLabel5.setText("Telefono:");

        jLabel6.setText("Rol:");

        cbRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Usuario" }));

        txCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCuentaActionPerformed(evt);
            }
        });

        jLabel7.setText("Confirme Clave:");

        txNombre.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txNombreInputMethodTextChanged(evt);
            }
        });

        VerificacionClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                VerificacionClaveFocusGained(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txCedula, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(txNombre)
                            .addComponent(txCuenta)
                            .addComponent(pfClave)
                            .addComponent(pfClaveConfirmada)
                            .addComponent(txTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(cbRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btLimpiar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIngresar)
                    .addComponent(VerificacionClave, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(VerificacionClave, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfClaveConfirmada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(17, 66, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btLimpiar)
                            .addComponent(btIngresar))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txCuentaActionPerformed

    private void VerificacionClaveFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_VerificacionClaveFocusGained
        // TODO add your handling code here:
        if(pfClave==pfClaveConfirmada){
            VerificacionClave.setText("Clave Confirmada");
        }else{
            VerificacionClave.setText("Claves no coinciden...");
        }
    }//GEN-LAST:event_VerificacionClaveFocusGained

    private void txNombreInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txNombreInputMethodTextChanged
        // TODO add your handling code here:
        VerificacionClave.setFocusable(true);
    }//GEN-LAST:event_txNombreInputMethodTextChanged

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        limpiar();
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        // TODO add your handling code here:
        String cuenta = txCuenta.getText();
        String clave = pfClave.getText();
        String nombre = txNombre.getText();
        String cedula = txCedula.getText();
        String telefono = txTelefono.getText();
        String rol = cbRol.getSelectedItem().toString();
        usuario u = new usuario(cuenta, clave, nombre, cedula, telefono, rol);
        ConexionBD c = new ConexionBD();
        try {
            c.conectar();
            c.ingresarUsuario(u);
            c.desconectar();
            JOptionPane.showMessageDialog(this,"Ingreso exitoso de datos.","Usuarios",JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (Exception e) {
            System.out.println("Error al ingresar usuario: "+e);
            JOptionPane.showMessageDialog(this,"No se pudo ingresar el nuevo usuario.","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private void limpiar(){
        txCuenta.setText("");
        pfClave.setText("");
        pfClaveConfirmada.setText("");
        txNombre.setText("");
        txCedula.setText("");
        txTelefono.setText("");        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel VerificacionClave;
    private javax.swing.JButton btIngresar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JComboBox<String> cbRol;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField pfClave;
    private javax.swing.JPasswordField pfClaveConfirmada;
    private javax.swing.JTextField txCedula;
    private javax.swing.JTextField txCuenta;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txTelefono;
    // End of variables declaration//GEN-END:variables
}
