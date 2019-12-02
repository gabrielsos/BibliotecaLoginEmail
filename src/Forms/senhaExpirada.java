package Forms;

import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Classes.criptografarSenha;
import java.sql.PreparedStatement;

public class senhaExpirada extends javax.swing.JFrame {

    String id1, senhaAtual, senhaDigitada;
    char[] c;
    public senhaExpirada(String id) {
        initComponents();
        id1 = id;
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Senha Expirada");

        jLabel1.setText("Senha Atual");

        jLabel2.setText("Nova Senha");

        jLabel3.setText("Confirme Nova Senha");

        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            
            senhaDigitada = criptografarSenha.criptografar(jPasswordField1.getText());
            
                Connection con = ConexaoMySQL.getInstance().getConnection();
                String cmd = "select senhaCliente from Cliente where cpfCliente = '" + id1 +"'";
                ResultSet rs = con.createStatement().executeQuery(cmd);
                while(rs.next()){
                    senhaAtual = rs.getString("senhaCliente");
                }
                
                if(!senhaAtual.equals(senhaDigitada)){
                    JOptionPane.showMessageDialog(null,"Sua Senha atual está errada");
                } else {
                boolean a = true, b = true;
          
                if(jPasswordField2.getText().equals(jPasswordField3.getText())){
                    c = jPasswordField2.getText().toCharArray();
                    for ( int i = 0; i < c.length; i++ ){

                    if (!Character.isDigit(c[i])){
                        a = false;
                    }
                    else{
                        b = false;
                    }
                    }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Senhas Diferentes");
                    }
                    if (a == true || b == true){
                        JOptionPane.showMessageDialog(null, "Sua Senha Precisa Conter Letras e Números!");
                    }
                    else{
                        if(criptografarSenha.criptografar(jPasswordField2.getText()).equals(senhaAtual)){
                            JOptionPane.showMessageDialog(null, "Sua nova senha não pode ser igual a senha expirada");
                        }
                        else{
                            if(c.length < 8){
                                JOptionPane.showMessageDialog(null, "Sua senha precisa ter pelo menos 8 digitos");
                            }
                            else{
                                try{
                                    PreparedStatement pstm = con.prepareStatement("update cliente set senhaExpirada = ? where cpfCliente = ?");
                                    pstm.setString(1, "0");
                                    pstm.setString(2, id1);
                                    pstm.execute();
                                }catch(Exception e){
                                    System.err.println(e.getMessage());
                                }
                                try{
                                    PreparedStatement pstm = con.prepareStatement("update cliente set senhaCliente = ? where cpfCliente = ?");
                                    pstm.setString(1, criptografarSenha.criptografar(jPasswordField2.getText()));
                                    pstm.setString(2, id1);
                                    pstm.execute();
                                }catch(Exception e){
                                    System.err.println(e.getMessage());
                                }
                                Principal formPrincipal = new Principal(id1);
                                formPrincipal.show();
                                this.dispose();
                            }
                        }
                        }
                        }
        }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Senha Atual inválida!");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    // End of variables declaration//GEN-END:variables
}
