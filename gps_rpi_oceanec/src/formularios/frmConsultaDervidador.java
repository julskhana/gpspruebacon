/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import bd.ConexionBD;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import objetos.evento;
import objetos.ubicacion;

/**
 *
 * @author Julian
 */
public class frmConsultaDervidador extends javax.swing.JFrame {

    /**
     * Creates new form consulta
     */
    public static int repetidor = 0;
    
    public frmConsultaDervidador() {
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txlatitud = new javax.swing.JTextField();
        txlongitud = new javax.swing.JTextField();
        txaltitud = new javax.swing.JTextField();
        txtiempo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizador de Derivadores");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Derivador #1", "Derivador #2" }));

        jLabel1.setText("Dispositivo:");

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jLabel2.setText("Latitud:");

        jLabel3.setText("Longitud:");

        jLabel4.setText("Altitud:");

        jLabel5.setText("Tiempo:");

        txlatitud.setEditable(false);
        txlatitud.setText("-0.9260204");
        txlatitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txlatitudActionPerformed(evt);
            }
        });

        txlongitud.setEditable(false);
        txlongitud.setText("-80.744644");

        txaltitud.setEditable(false);
        txaltitud.setText("0.23523581");

        txtiempo.setEditable(false);
        txtiempo.setText("2019-08-01 21:41:04.469");

        jLabel6.setText("[m]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btConsultar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txlatitud)
                            .addComponent(txlongitud)
                            .addComponent(txaltitud)
                            .addComponent(txtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txlatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txlongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txaltitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        // TODO add your handling code here:
        float latitud = funciones.gps.generarlatitud();
        float longitud = funciones.gps.generarlongitud();
        float elevacion = funciones.gps.generarelevacion();
        
        txlatitud.setText(String.valueOf(latitud));
        txlongitud.setText(String.valueOf(longitud));
        txaltitud.setText(String.valueOf(elevacion));
        txtiempo.setText(String.valueOf(funciones.gps.generertiempo()));
        try {
            ConexionBD c = new ConexionBD();
            c.conectar();
            ubicacion u = new ubicacion(latitud, longitud, elevacion,1);
            c.ingresarUbicacion(u);
            if (Float.valueOf(txlatitud.getText()) < -0.93f){
                System.out.println("\nAlerta - El dispisitivo esta fuera de rango.\n");
                evento ev = new evento("Rango","El dispisitivo esta fuera de rango.", latitud, longitud, elevacion, repetidor);
                c.ingresarEvento(ev);
                JOptionPane.showMessageDialog(this,"El dispositivo esta fuera de la zona permitida.","Alerta GPS",JOptionPane.ERROR_MESSAGE);
            }
            c.desconectar();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }//GEN-LAST:event_btConsultarActionPerformed

    private void txlatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txlatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txlatitudActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConsultar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txaltitud;
    private javax.swing.JTextField txlatitud;
    private javax.swing.JTextField txlongitud;
    private javax.swing.JTextField txtiempo;
    // End of variables declaration//GEN-END:variables
}
