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
import objetos.evento;

/**
 *
 * @author Leonel
 */
public class frmEventos extends javax.swing.JFrame {

    /**
     * Creates new form frmDerivadores
     */
    public frmEventos() {
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
        tbEventos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Visualizar Eventos GPS");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "Tipo", "Descripcion", "Dispositivo" }));

        btBuscar.setText("Consultar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripcion:");

        tbEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Identificador", "Tipo", "Descripcion", "Fecha Hora", "Dispositivo", "Latitud", "Longitud", "Elevacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbEventos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(16, 16, 16))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btBuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    public void consultarRegistro(){
        String tipo = cbTipo.getSelectedItem().toString();
        String descripcion = txDescripcion.getText();        
        //consultar
        try{
            //cunsolta a la base
            try{
                ConexionBD c = new ConexionBD();
                c.conectar();
                ArrayList<evento> reg = c.consultarEventos(tipo,"evento");
                ArrayList<evento> res = new ArrayList<evento>();
                //Consultar tipo y descripcion
                if (tipo.equals("Todos")){
                        res = reg;
                }else{
                    for (evento even:reg){
                        if(tipo.equals("ID")&&(descripcion.length()>0)){
                            if(String.valueOf(even.getId()).equals(descripcion)){
                                res.add(even);
                            }
                        }else if(tipo.equals("Tipo")){
                            if(even.getTipo().toUpperCase().contains(descripcion.toUpperCase())){
                                res.add(even);
                            }
                        }else if(tipo.equals("Descripcion")){
                            if(even.getDescripcion().toUpperCase().contains(descripcion.toUpperCase())){
                                res.add(even);
                            }
                        }else if(tipo.equals("Dispositivo")){
                            if(String.valueOf(even.getId_derivador()).equals(descripcion)){
                                res.add(even);
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"Descripcion vacia.","Consulta Invalida",JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

                DefaultTableModel dtm = (DefaultTableModel)tbEventos.getModel();
                dtm.setRowCount(0);
                
                //recorriendo base de datos
                for (evento d:res){
                    Object[] fila = new Object[8];
                    fila[0] = d.getId();
                    fila[1] = d.getTipo();
                    fila[2] = d.getDescripcion();
                    fila[3] = d.getTiempo();
                    fila[4] = d.getId_derivador();
                    fila[5] = d.getLatitud();
                    fila[6] = d.getLongitud();
                    fila[7] = d.getElevacion();
                    dtm.addRow(fila);
                }
            c.desconectar();
            }catch (Exception e){
                System.out.println("error al consultar eventos"+e);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al consultar eventos","Consulta",JOptionPane.ERROR_MESSAGE);
            System.out.println("consulta de registros eventos: "+e);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEventos;
    private javax.swing.JTextField txDescripcion;
    // End of variables declaration//GEN-END:variables
}
