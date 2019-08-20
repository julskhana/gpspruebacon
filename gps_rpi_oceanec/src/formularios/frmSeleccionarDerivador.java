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

/**
 *
 * @author Leonel
 */
public class frmSeleccionarDerivador extends javax.swing.JFrame {

    /**
     * Creates new form frmDerivadores
     */
    public frmSeleccionarDerivador() {
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
        tbDerivador = new javax.swing.JTable();
        btSeleccionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccion Derivadores");

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "ID", "MAC", "Nombre" }));

        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("Descripcion:");

        tbDerivador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Identificador", "Direccion MAC", "Nombre", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbDerivador);

        btSeleccionar.setText("Seleccionar");
        btSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarActionPerformed(evt);
            }
        });

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
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(btSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btSeleccionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        consultarRegistro();
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleccionarActionPerformed
        // TODO add your handling code here:
        if(seleccionValida()){
            int fila = tbDerivador.getSelectedRow();
            
            int id = Integer.parseInt(tbDerivador.getValueAt(fila,0).toString());
            String mac = tbDerivador.getValueAt(fila,1).toString();
            
            dispositivo disp = new dispositivo(id, mac);
            frmConsultaDervidador.txIdDerivador.setText(String.valueOf(id));
            frmConsultaDervidador.txMac.setText(mac);
            this.dispose();
        }else{
            consultarRegistro();
        }
        consultarRegistro();
    }//GEN-LAST:event_btSeleccionarActionPerformed

    private boolean seleccionValida(){ 
        int n = tbDerivador.getSelectedRowCount();
        if(n==0){
            JOptionPane.showMessageDialog(this,"Debe seleccionar mínimo un registro.","Seleccion",JOptionPane.ERROR_MESSAGE);
            return false;        
        }
        return true;
    }
    
    public void consultarRegistro(){
        String tipo = cbTipo.getSelectedItem().toString();
        String descripcion = txDescripcion.getText();        
        //consultar
        try{
            //cunsolta a la base
            try{
                ConexionBD c = new ConexionBD();
                c.conectar();
                ArrayList<dispositivo> reg = c.consultarDispositivos(tipo,"dispositivo");
                ArrayList<dispositivo> res = new ArrayList<dispositivo>();
                //Consultar tipo y descripcion
                if (tipo.equals("Todos")){
                        res = reg;
                }else{
                    for (dispositivo disp:reg){
                        if(tipo.equals("ID")&&(descripcion.length()>0)){
                            if(String.valueOf(disp.getId()).equals(descripcion)){
                                res.add(disp);
                            }
                        }else if(tipo.equals("MAC")){
                            if(disp.getMac().toUpperCase().contains(descripcion.toUpperCase())){
                                res.add(disp);
                            }
                        }else if(tipo.equals("Nombre")){
                            if(disp.getNombre().toUpperCase().contains(descripcion.toUpperCase())){
                                res.add(disp);
                            }
                        }else{
                            JOptionPane.showMessageDialog(this,"Descripcion vacia.","Consulta Invalida",JOptionPane.ERROR_MESSAGE);
                            break;
                        }
                    }
                }

                DefaultTableModel dtm = (DefaultTableModel)tbDerivador.getModel();
                dtm.setRowCount(0);
                
                //recorriendo base de datos
                for (dispositivo d:res){
                    Object[] fila = new Object[4];
                    fila[0] = d.getId();
                    fila[1] = d.getMac();
                    fila[2] = d.getNombre();
                    fila[3] = d.getDescripcion();
                    dtm.addRow(fila);
                }
            c.desconectar();
            }catch (Exception e){
                System.out.println("error al consultar derivadores"+e);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(this,"Ocurrió un error al consultar derivadores","Consulta",JOptionPane.ERROR_MESSAGE);
            System.out.println("consulta de registros derivadores: "+e);
        }
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btSeleccionar;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDerivador;
    private javax.swing.JTextField txDescripcion;
    // End of variables declaration//GEN-END:variables
}
