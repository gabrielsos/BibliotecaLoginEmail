package Forms;

import Classes.criptografarSenha;
import Classes.enviarEmail;
import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class esqueciMinhaSenha extends javax.swing.JFrame {

    private String cliente, cpfCliente, esqueceu, senha;
    public esqueciMinhaSenha() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Esqueci Minha Senha");

        jLabel1.setText("Digite seu usuário");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "Select cpfCliente, emailCliente, esqueceuSenha from Cliente where cpfCliente = '" + jTextField1.getText() + "'";
            ResultSet rs = con.createStatement().executeQuery(cmd);
                while(rs.next()){
                    cpfCliente = rs.getString("cpfCliente");
                    cliente = rs.getString("emailCliente");
                    esqueceu = rs.getString("esqueceuSenha");
                }
                if (!cpfCliente.equals("")){
                                        String[] carct ={"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
                    for (int x=0; x<10; x++){
                        int j = (int) (Math.random()*carct.length);
                        senha += carct[j];
                    }
                    enviandoEmail enviar = new enviandoEmail();
                    enviar.setVisible(true);

                    Thread emailT = new Thread(){
                        @Override
                        public void run(){
                            enviarEmail email = new enviarEmail();
                            email.enviarSenhaNova(cpfCliente, cliente, senha);
                            enviar.dispose();
                        }
                    };
                    emailT.start();
                    
                    try{
                        PreparedStatement pstm = con.prepareStatement("update cliente set senhaCliente = ? where cpfCliente = ?");
                        pstm.setString(1, criptografarSenha.criptografar(senha));
                        pstm.setString(2, cpfCliente);
                        pstm.execute();
                        PreparedStatement pstm2 = con.prepareStatement("update cliente set esqueceuSenha = ? where cpfCliente = ?");
                        pstm2.setString(1, "1");
                        pstm2.setString(2, cpfCliente);
                        pstm2.execute();
                    }catch(Exception e){
                        System.err.println(e.getMessage());
                    }
                    this.dispose();
                    
                }
                
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Usuário não cadastrado");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new esqueciMinhaSenha().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
