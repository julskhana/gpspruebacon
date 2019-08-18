/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import bd.ConexionBD;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetos.dispositivo;
import objetos.ubicacion;

/**
 *
 * @author Julian
 */
public class frmUbicaciones extends javax.swing.JFrame {

    /**
     * Creates new form frmDerivadores
     */
    public frmUbicaciones() {
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

        txDescripcion = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        btBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUbicaciones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizar Ubicaciones GPS");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Latitud", "Longitud", "Fecha", "Derivador" }));

        btBuscar.setText("Consultar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripcion:");

        tbUbicaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Identificador", "Latitud", "Longitud", "Elevacion", "Fecha Hora", "Derivador"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbUbicaciones);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDescripcion)
                        .addGap(18, 18, 18)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        
        String tipo = cbTipo.getSelectedItem().toString();
        String descripcion = txDescripcion.getText();        
        //consultar
        try{
            //cunsolta a la base
            try{
                ConexionBD c = new ConexionBD();
                c.conectar();
                ArrayList<ubicacion> reg = c.consultarUbicacion(tipo,"ubicacion");
                ArrayList<ubicacion> res = new ArrayList<ubicacion>();
                //Consultar tipo y descripcion
                if (tipo.equals("Todos")){
                        res = reg;
                }else{
                    for (ubicacion ubi:reg){
                        if(tipo.equals("ID")&&(descripcion.length()>0)){
                            if(String.valueOf(ubi.getId()).equals(descripcion)){
                                res.add(ubi);
                            }
                        }else if(tipo.equals("Latitud")){
                            if(String.valueOf(ubi.getLatitud()).equals(descripcion)){
                                res.add(ubi);
                            }
                        }else if(tipo.equals("Longitud")){
                            if(String.valueOf(ubi.getLongitud()).equals(descripcion)){
                                res.add(ubi);
                            }
                        }else if(tipo.equals("Elevacion")){
                            if(String.valueOf(ubi.getElevacion()).equals(descripcion)){
                                res.add(ubi);
                            }
                        }else if(tipo.equals("Tiempo")){
                            if(String.valueOf(ubi.getTiempo()).contains(descripcion)){
                                res.add(ubi);
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"Descripcion vacia.","Consulta Invalida",JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

                DefaultTableModel dtm = (DefaultTableModel)tbUbicaciones.getModel();
                dtm.setRowCount(0);
                
                //recorriendo base de datos
                for (ubicacion u:res){
                    Object[] fila = new Object[6];
                    fila[0] = u.getId();
                    fila[1] = u.getLatitud();
                    fila[2] = u.getLongitud();
                    fila[3] = u.getElevacion();
                    fila[4] = u.getTiempo();
                    fila[5] = u.getId_dispositivo();
                    dtm.addRow(fila);
                }
            c.desconectar();
            }catch (Exception e){
                System.out.println("error al consultar ubicaciones"+e);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al consultar ubicaciones","Consulta",JOptionPane.ERROR_MESSAGE);
            System.out.println("consulta de registros ubicaciones: "+e);
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbUbicaciones;
    private javax.swing.JTextField txDescripcion;
    // End of variables declaration//GEN-END:variables
}
