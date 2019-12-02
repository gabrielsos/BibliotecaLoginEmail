
package Classes;

import Conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class LoginCls {
    
    public boolean estado;
    private String cliente;
    
    public void fazerLogin(String usuario, String senha){
        try{
            Connection con = ConexaoMySQL.getInstance().getConnection();
            String cmd = "Select cpfCliente from Cliente where cpfCliente = '" + usuario + "' AND senhaCliente = " + "md5('" + senha + "')";
            ResultSet rs = con.createStatement().executeQuery(cmd);
                while(rs.next()){
                    cliente = rs.getString("cpfCliente");
                }        
                if (!cliente.equals("")){
                    estado = true;
                }
                else{
                    estado = false;
                }
            
            
        }catch(Exception e){
        }
    
    }
}
