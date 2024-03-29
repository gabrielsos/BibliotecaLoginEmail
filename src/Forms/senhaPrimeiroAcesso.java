
package Forms;

import Classes.criptografarSenha;
import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;


public class senhaPrimeiroAcesso extends javax.swing.JFrame {
    String id1;
    int modol;
    char [] c;
    public senhaPrimeiroAcesso(String id, int modo) {
        initComponents();
        modol = modo;
        id1 = id;
        this.setLocationRelativeTo(null);
    }

    senhaPrimeiroAcesso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nova Senha");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Senha");

        jLabel2.setText("Confirme a Senha");

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField1)
                            .addComponent(jPasswordField2, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        boolean a = true, b = true;
          
        if(jPasswordField2.getText().equals(jPasswordField1.getText())){
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
            if(c.length < 8){
                JOptionPane.showMessageDialog(null, "Sua senha precisa ter pelo menos 8 digitos");
            }
            else{
                if (modol == 0){
                    try{
                        Connection con = ConexaoMySQL.getInstance().getConnection();
                        PreparedStatement pstm = con.prepareStatement("update cliente set primeiroAcesso = ? where cpfCliente = ?");
                        pstm.setString(1, "0");
                        pstm.setString(2, id1);
                        pstm.execute();
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                }
                else{
                    try{
                        Connection con = ConexaoMySQL.getInstance().getConnection();
                        PreparedStatement pstm = con.prepareStatement("update cliente set esqueceuSenha = ? where cpfCliente = ?");
                        pstm.setString(1, "0");
                        pstm.setString(2, id1);
                        pstm.execute();
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                }
                try{
                    Connection con = ConexaoMySQL.getInstance().getConnection();
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
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new senhaPrimeiroAcesso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    // End of variables declaration//GEN-END:variables
}
