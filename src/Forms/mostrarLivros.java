
package Forms;

import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class mostrarLivros extends javax.swing.JFrame {
    public mostrarLivros() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select nmLivro, autorLivro, g.nmGenero, e.nmEditora, qtdEstoque from livro i inner join genero g on (i.idGenero = g.idGenero) inner join editora e on (i.idEditora = e.idEditora)";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("nmLivro"),rs.getString("autorLivro"),rs.getString("nmGenero"), rs.getString("nmEditora"), rs.getString("qtdEstoque")});
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Livros");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Autor", "Gênero", "Editora", "Estoque"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Nome:");

        jButton1.setText("Limpar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Buscar");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            PreparedStatement pstm = con.prepareStatement("select nmLivro, autorLivro, g.nmGenero, e.nmEditora, qtdEstoque from livro i inner join genero g on (i.idGenero = g.idGenero) inner join editora e on (i.idEditora = e.idEditora) where nmLivro = ?");
            pstm.setString(1, jTextField1.getText());
            pstm.execute();
            ResultSet rs = pstm.executeQuery();
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("nmLivro"),rs.getString("autorLivro"),rs.getString("nmGenero"), rs.getString("nmEditora"), rs.getString("qtdEstoque")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select nmLivro, autorLivro, g.nmGenero, e.nmEditora, qtdEstoque from livro i inner join genero g on (i.idGenero = g.idGenero) inner join editora e on (i.idEditora = e.idEditora)";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("nmLivro"),rs.getString("autorLivro"),rs.getString("nmGenero"), rs.getString("nmEditora"), rs.getString("qtdEstoque")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mostrarLivros().setVisible(true);
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
