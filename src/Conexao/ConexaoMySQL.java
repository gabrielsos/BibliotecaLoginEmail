package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    private static ConexaoMySQL instance = null;
    private Connection connection = null;
    private ConexaoMySQL() {
        try {
            
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            String serverName = "localhost:3306";
            String dbName = "biblioteca";
            
            String url = "jdbc:mysql://"+ serverName + "/"+ dbName+"?useSSL=false&useTimezone=true&serverTimezone=UTC";
            String username = "root";
            String password = "root";     
            connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("STATUS--->Conectado com sucesso!");
            } else {
                System.err.println("STATUS--->Não foi "
                        + "possivel realizar conexão");
            }
            connection.setAutoCommit(true);
            
        } catch (ClassNotFoundException e) {

            System.out.println("O driver expecificado"
                    + " nao foi encontrado.");
        } catch (SQLException e) {

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            //e.printStackTrace();
            System.err.println(e.getMessage());
                    
        }
    }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
