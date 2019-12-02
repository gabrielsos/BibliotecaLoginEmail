package Forms;

import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class mostrarClientes extends javax.swing.JFrame {

    public mostrarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select cpfCliente, nmCliente, endCliente, cidadeCliente, telCliente from cliente";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("cpfCliente"),rs.getString("nmCliente"),rs.getString("endCliente"), rs.getString("cidadeCliente"), rs.getString("telCliente")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF", "Nome", "Endereço", "Cidade", "Telefone"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("CPF:");

        jButton2.setText("Limpar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            PreparedStatement pstm = con.prepareStatement("select cpfCliente, nmCliente, endCliente, cidadeCliente, telCliente from cliente where cpfCliente = ?");
            pstm.setString(1, jTextField1.getText());
            pstm.execute();
            ResultSet rs = pstm.executeQuery();
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("cpfCliente"),rs.getString("nmCliente"),rs.getString("endCliente"), rs.getString("cidadeCliente"), rs.getString("telCliente")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select cpfCliente, nmCliente, endCliente, cidadeCliente, telCliente from cliente";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("cpfCliente"),rs.getString("nmCliente"),rs.getString("endCliente"), rs.getString("cidadeCliente"), rs.getString("telCliente")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        jTextField1.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mostrarClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
