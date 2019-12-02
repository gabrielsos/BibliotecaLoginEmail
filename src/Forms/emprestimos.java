package Forms;

import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;


public class emprestimos extends javax.swing.JFrame {

    private Object value;
    private Object value2;
    private Object value3;
    private String data2;
    private String hora;
    private int qtd;
    private String codLivro;
    
    public emprestimos() {
        initComponents();
        this.setLocationRelativeTo(null);
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select a.idAluguel, c.cpfCliente, c.nmCliente, s.nmSituacao, l.nmLivro, dataAluguel, hrAluguel,qtdLivros, dataDevolucao, hrDevolucao from itemaluguel i inner join livro l on (i.idLivro = l.idLivro) inner join aluguel a on (i.idAluguel = a.idAluguel) inner join Situacao s on (a.idSituacao = s.idSituacao) inner join Cliente c on (a.cpfCliente = c.cpfCliente)";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) tbEmprestimo.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("idAluguel"),rs.getString("cpfCliente"),rs.getString("nmCliente"), rs.getString("nmSituacao"), rs.getString("nmLivro"),rs.getString("qtdLivros"), rs.getString("dataAluguel"), rs.getString("hrAluguel"), rs.getString("dataDevolucao"), rs.getString("hrDevolucao")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbDados = new javax.swing.JScrollPane();
        tbEmprestimo = new javax.swing.JTable();
        btnDevolver = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtCpf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Histórico Empréstimos");

        tbDados.setViewportBorder(javax.swing.BorderFactory.createCompoundBorder());

        tbEmprestimo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "CPF", "Nome", "Situação", "Livro", "Quantidade", "Data Aluguel", "Hora Aluguel", "Data Devolução", "Hora Devolução"
            }
        ));
        tbDados.setViewportView(tbEmprestimo);

        btnDevolver.setText("Devolvido");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        jLabel1.setText("CPF:");

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbDados, javax.swing.GroupLayout.DEFAULT_SIZE, 1099, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDevolver))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(tbDados, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnDevolver)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            PreparedStatement pstm = con.prepareStatement("select a.idAluguel, c.cpfCliente, c.nmCliente, s.nmSituacao, l.nmLivro, qtdLivros, dataAluguel, hrAluguel, dataDevolucao, hrDevolucao from itemaluguel i inner join livro l on (i.idLivro = l.idLivro) inner join aluguel a on (i.idAluguel = a.idAluguel) inner join Situacao s on (a.idSituacao = s.idSituacao) inner join Cliente c on (a.cpfCliente = c.cpfCliente) where c.cpfCliente = ?");
            pstm.setString(1, txtCpf.getText());
            pstm.execute();
            ResultSet rs = pstm.executeQuery();
            
            DefaultTableModel modelo = (DefaultTableModel) tbEmprestimo.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("idAluguel"),rs.getString("cpfCliente"),rs.getString("nmCliente"), rs.getString("nmSituacao"), rs.getString("nmLivro"),rs.getString("qtdLivros"), rs.getString("dataAluguel"), rs.getString("hrAluguel"), rs.getString("dataDevolucao"), rs.getString("hrDevolucao")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        try{
            txtCpf.setText("");
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select a.idAluguel, c.cpfCliente, c.nmCliente, s.nmSituacao, l.nmLivro,qtdLivros, dataAluguel, hrAluguel, dataDevolucao, hrDevolucao from itemaluguel i inner join livro l on (i.idLivro = l.idLivro) inner join aluguel a on (i.idAluguel = a.idAluguel) inner join Situacao s on (a.idSituacao = s.idSituacao) inner join Cliente c on (a.cpfCliente = c.cpfCliente)";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) tbEmprestimo.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("idAluguel"),rs.getString("cpfCliente"),rs.getString("nmCliente"), rs.getString("nmSituacao"), rs.getString("nmLivro"),rs.getString("qtdLivros"), rs.getString("dataAluguel"), rs.getString("hrAluguel"), rs.getString("dataDevolucao"), rs.getString("hrDevolucao")});
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed

      int row = tbEmprestimo.getSelectedRow();
      if(row > -1){
           value = tbEmprestimo.getValueAt(row, 0);
           value2 = tbEmprestimo.getValueAt(row, 4);
           value3 = tbEmprestimo.getValueAt(row, 5);
      }else 
            JOptionPane.showMessageDialog(null, "Nenhum Empréstimo Selecionado"); 
      
      JOptionPane.showMessageDialog(null, "Devolução Feita Com Sucesso!");
      
      try{
        Connection con = ConexaoMySQL.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("update aluguel set idSituacao = ? where idAluguel = ?");
        pstm.setInt(1, 2);
        pstm.setString(2, value.toString());
        pstm.execute();
        ResultSet rs = pstm.executeQuery();
        
      }catch(Exception e){
            System.err.println(e.getMessage());
      }
      try{
        try{
        Connection con = ConexaoMySQL.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("select idLivro from livro where nmLivro = ?");
        pstm.setString(1, value2.toString());
        pstm.execute();
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            codLivro = rs.getString("idLivro");
        }
      }catch(Exception e){
            System.err.println(e.getMessage());
      }
        
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        data2 = formatarData.format(data);
        SimpleDateFormat formatarHora = new SimpleDateFormat("HH:mm:ss");
        hora = formatarHora.format(data);

        Connection con = ConexaoMySQL.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("update itemAluguel set dataDevolucao = ?, hrDevolucao = ? where idAluguel = ? and idLivro = ?");
        pstm.setString(1, data2);
        pstm.setString(2, hora);
        pstm.setString(3, value.toString());
        pstm.setString(4, codLivro.toString());
        pstm.execute();
        ResultSet rs = pstm.executeQuery();
        
      }catch(Exception e){
            System.err.println(e.getMessage());
      }
              try{
        Connection con = ConexaoMySQL.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("select qtdEstoque from livro where nmLivro = ?");
        pstm.setString(1, value2.toString());
        pstm.execute();
        ResultSet rs = pstm.executeQuery();
        
        while(rs.next()){
            qtd = rs.getInt("qtdEstoque");
        }
      }catch(Exception e){
            System.err.println(e.getMessage());
      }
      try{
        Connection con = ConexaoMySQL.getInstance().getConnection();
        PreparedStatement pstm = con.prepareStatement("update livro set qtdEstoque = ? where nmLivro = ?");
        pstm.setInt(1, qtd + Integer.parseInt(value3.toString()));
        pstm.setString(2, value2.toString());
        pstm.execute();
        
      }catch(Exception e){
            System.err.println(e.getMessage());
      }        
              
      try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select a.idAluguel, c.cpfCliente, c.nmCliente, s.nmSituacao, l.nmLivro, qtdLivros, dataAluguel, hrAluguel, dataDevolucao, hrDevolucao from itemaluguel i inner join livro l on (i.idLivro = l.idLivro) inner join aluguel a on (i.idAluguel = a.idAluguel) inner join Situacao s on (a.idSituacao = s.idSituacao) inner join Cliente c on (a.cpfCliente = c.cpfCliente)";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            DefaultTableModel modelo = (DefaultTableModel) tbEmprestimo.getModel();
            modelo.setNumRows(0);
            
            while(rs.next()){
                modelo.addRow(new Object[]{rs.getString("idAluguel"),rs.getString("cpfCliente"),rs.getString("nmCliente"), rs.getString("nmSituacao"), rs.getString("nmLivro"),rs.getString("qtdLivros"), rs.getString("dataAluguel"), rs.getString("hrAluguel"), rs.getString("dataDevolucao"), rs.getString("hrDevolucao")});
            }
            
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
      txtCpf.setText("");
    }//GEN-LAST:event_btnDevolverActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new emprestimos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane tbDados;
    private javax.swing.JTable tbEmprestimo;
    private javax.swing.JTextField txtCpf;
    // End of variables declaration//GEN-END:variables
}
