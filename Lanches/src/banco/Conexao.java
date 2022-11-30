package banco;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Edmilson
 */
public class Conexao {
    
    private static Connection con;
    
    private Conexao() throws Exception {
        
        try {
            String conexao = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://127.0.0.1:3306/lanchonete";
            String usuario = "root";
            String senha = "";
            
            Class.forName(conexao);
            con = DriverManager.getConnection(url, usuario, senha);
            con.setAutoCommit(true);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static Connection getInstancia() throws Exception {
        if (con == null) {
            new Conexao();
        }
        return con;
    }
    
    public static void main(String[] args) {
        try {
            System.out.println(Conexao.getInstancia());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
