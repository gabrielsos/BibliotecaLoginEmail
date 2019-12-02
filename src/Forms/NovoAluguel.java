package Forms;

import java.util.Calendar;
import java.util.ArrayList;
import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NovoAluguel extends javax.swing.JFrame {
    ArrayList<String> codLivro = new ArrayList<String>();
    ArrayList<String> codCliente = new ArrayList<String>();
    private int idAluguel;
    private String data2;
    private String hora;
    private String sCodLivro;
    private String sCodCliente;
    private int qtd;
    private int qtd1;
    private int naosei = -1;
    private boolean igual;
    private int qtdLivro = 1;
    private int qtdCarrinho = 0;
    Object value;
    Object value2;
    Object value3;
            
    public NovoAluguel() {
    
        initComponents();
        this.setLocationRelativeTo(null);
        
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select idLivro, nmLivro from livro";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            while(rs.next()){
                jComboBoxLivro.addItem(rs.getString("nmLivro"));
                sCodLivro = rs.getString("idLivro");
                codLivro.add(sCodLivro);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "select cpfCliente, nmCliente from Cliente";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            while(rs.next()){
                jComboBoxCliente.addItem(rs.getString("nmCLiente"));
                sCodCliente = rs.getString("cpfCliente");
                codCliente.add(sCodCliente);
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxLivro = new javax.swing.JComboBox<>();
        jComboBoxCliente = new javax.swing.JComboBox();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCarrinho = new javax.swing.JTable();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Novo Empréstimo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Nome:");

        jLabel2.setText("Livro:");

        jButton1.setText("Confirmar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tbCarrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Livro", "Nome", "Autor", "Quantidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCarrinho);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jComboBoxLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(btCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton1)))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btCancelar))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        data2 = formatarData.format(data);
        SimpleDateFormat formatarHora = new SimpleDateFormat("HH:mm:ss");
        hora = formatarHora.format(data);
        
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            
            String query = "insert into aluguel (cpfCliente, idSituacao) values (?, ?)";
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, codCliente.get(jComboBoxCliente.getSelectedIndex()));
            pstm.setInt(2, 1);
            pstm.execute();

        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            
            String cmd = "select max(i.idAluguel) as max from aluguel i where 1=1";
            ResultSet rs = con.createStatement().executeQuery(cmd);
            
            while (rs.next()){
                idAluguel = rs.getInt("max");
            }
            for (int i = 0; i < qtdCarrinho; i++){
                
                value = tbCarrinho.getValueAt(i, 0);
                value2 = tbCarrinho.getValueAt(i, 3);
                
                String query = " insert into itemAluguel values (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1, idAluguel);
                pstm.setString(2, value.toString());
                pstm.setString(3, value2.toString());
                pstm.setString(4,data2);
                pstm.setString(5, hora);
                pstm.setString(6,null);
                pstm.setString(7,null);
                pstm.execute();
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        JOptionPane.showMessageDialog(null, "Empréstimo Feito com Sucesso!");
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        
        try{

            Connection con = ConexaoMySQL.getInstance().getConnection();
            PreparedStatement pstm = con.prepareStatement("select idLivro, nmLivro, autorLivro, qtdEstoque from livro where idLivro = ?");
            pstm.setString(1, codLivro.get(jComboBoxLivro.getSelectedIndex()));
            pstm.execute();
            ResultSet rs = pstm.executeQuery();

            
            DefaultTableModel modelo = (DefaultTableModel) tbCarrinho.getModel();
            
            while(rs.next()){
                igual = true;
                qtd1 = rs.getInt("qtdEstoque");
                if(qtd1 > 0){
                    naosei++;
                    
                    try{
                    PreparedStatement pstm2 = con.prepareStatement("update Livro set qtdEstoque = ? where idLivro = ?");
                    pstm2.setInt(1, qtd1-1);
                    pstm2.setString(2, codLivro.get(jComboBoxLivro.getSelectedIndex()));
                    pstm2.execute();
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    for (int i=0; i < qtdCarrinho; i++){
                        value2 = codLivro.get(jComboBoxLivro.getSelectedIndex());
                        value = tbCarrinho.getValueAt(i, 0);
                        value3 = tbCarrinho.getValueAt(i,3);
                        
                        if (Integer.parseInt(value.toString()) == Integer.parseInt(value2.toString())){

                            tbCarrinho.setValueAt(Integer.parseInt(value3.toString()) + 1, i, 3);
                            igual = false;
                            break;
                        }else{
                            igual = true;
                        }
                    }
                    if (igual == true){
                        modelo.addRow(new Object[]{rs.getString("idLivro"),rs.getString("nmLivro"),rs.getString("autorLivro"), 1});
                        qtdCarrinho++;  
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Sem Estoque!");
                }
            }
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        
        
           
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
       
        for(int i=0; i < qtdCarrinho; i++){
            try
            {
                value = tbCarrinho.getValueAt(i, 0); 
                
                Connection con = ConexaoMySQL.getInstance().getConnection();
                PreparedStatement pstm1 = con.prepareStatement("select qtdEstoque from livro where idLivro = ?");
                pstm1.setString(1, value.toString());
                pstm1.execute();
                ResultSet rs = pstm1.executeQuery();
                while(rs.next()){
                    qtd = rs.getInt("qtdEstoque");
                }
                
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            try
            { 
                Connection con2 = ConexaoMySQL.getInstance().getConnection();
                PreparedStatement pstm = con2.prepareStatement("update Livro set qtdEstoque = ? where idLivro = ?");
                
                pstm.setInt(1, qtd+1);
                pstm.setString(2, value.toString());
                pstm.execute();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
            for(int i=0; i < qtdCarrinho; i++){
            try
            {
                value = tbCarrinho.getValueAt(i, 0); 
                
                Connection con = ConexaoMySQL.getInstance().getConnection();
                PreparedStatement pstm1 = con.prepareStatement("select qtdEstoque from livro where idLivro = ?");
                pstm1.setString(1, value.toString());
                pstm1.execute();
                ResultSet rs = pstm1.executeQuery();
                while(rs.next()){
                    qtd = rs.getInt("qtdEstoque");
                }
                
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
            try
            { 
                Connection con2 = ConexaoMySQL.getInstance().getConnection();
                PreparedStatement pstm = con2.prepareStatement("update Livro set qtdEstoque = ? where idLivro = ?");
                
                pstm.setInt(1, qtd+1);
                pstm.setString(2, value.toString());
                pstm.execute();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NovoAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NovoAluguel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxCliente;
    private javax.swing.JComboBox<Object> jComboBoxLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCarrinho;
    // End of variables declaration//GEN-END:variables
}
