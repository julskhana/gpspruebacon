/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import bd.ConexionBD;
import javax.swing.JOptionPane;
import objetos.dispositivo;

/**
 *
 * @author Leonel
 */
public class frmIngresarDerivador extends javax.swing.JFrame {

    /**
     * Creates new form frmIngresarDerivador
     */
    public frmIngresarDerivador() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txMac = new javax.swing.JTextField();
        txNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txDescripcion = new javax.swing.JTextField();
        btIngresar = new javax.swing.JButton();
        btLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Derivador");

        jLabel1.setText("Direccion MAC:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripcion:");

        txMac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txMacActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8-circuit-48.png"))); // NOI18N

        btIngresar.setText("Ingresar");
        btIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIngresarActionPerformed(evt);
            }
        });

        btLimpiar.setText("Limpiar");
        btLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txMac)
                                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txMac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btIngresar)
                    .addComponent(btLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txMacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txMacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txMacActionPerformed

    private void btLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimpiarActionPerformed
        // TODO add your handling code here:
        txMac.setText("");
        txNombre.setText("");
        txDescripcion.setText("");
    }//GEN-LAST:event_btLimpiarActionPerformed

    private void btIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIngresarActionPerformed
        // TODO add your handling code here:
        ConexionBD c = new ConexionBD();
        if(formularioValido()){
            String mac = txMac.getText();
            String nombre = txNombre.getText();
            String descripcion = txDescripcion.getText();           
            dispositivo d = new dispositivo(mac, nombre, descripcion);
            try{
                c.conectar();
                if(c.ingresarDerivador(d)){
                    JOptionPane.showMessageDialog(this,"Ingreso Exitoso a la base de datos","Validación",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            }catch (Exception e){
                System.out.println("Error al ingresar el derivador..." +e);
            }
        }
        /*
        if(formularioValido()){
            String nombre            = tfnombre.getText();
            String ruc               = tfruc.getText();
            String direccion         = tfdireccion.getText();
            String direccion_planta  = tfdirplanta.getText();
            String telefono          = tftelefono.getText();
            String correo            = tfcorreo.getText();
            int id_usuario           = ingresar_id_usuario;
            
            try{
                c.conectar();
                empresa e = new empresa(nombre,ruc,direccion,direccion_planta,telefono,correo,id_usuario);
                if(c.ingresarEmpresa(e)){
                    JOptionPane.showMessageDialog(this,"Ingreso Exitoso a la base de datos","Validación",JOptionPane.INFORMATION_MESSAGE);
                    frmMantenimientoEmpresas frm = new frmMantenimientoEmpresas();
                    frm.setVisible(true);
                    this.dispose();
                }else
                JOptionPane.showMessageDialog(this,"Ingreso Fallido","Validación",JOptionPane.ERROR_MESSAGE);
                c.desconectar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(this,"Ocurrio un problema durante el ingreso","Validación",JOptionPane.ERROR_MESSAGE);
            }
        }
        */
    }//GEN-LAST:event_btIngresarActionPerformed

    /**
     * @param args the command line arguments
     */
    private boolean formularioValido(){
        if(txMac.getText().equals("") ||
            txNombre.getText().equals("") ||
            txDescripcion.getText().equals("")){    
                JOptionPane.showMessageDialog(this,"Formulario incompleto","Validación",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIngresar;
    private javax.swing.JButton btLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txDescripcion;
    private javax.swing.JTextField txMac;
    private javax.swing.JTextField txNombre;
    // End of variables declaration//GEN-END:variables
}
