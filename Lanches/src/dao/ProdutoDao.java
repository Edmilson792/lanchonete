package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edmilson
 */
public class ProdutoDao {
    
    public static boolean existeProduto(String nome) throws Exception {
        // preparar a instrução
        PreparedStatement ps = null;
        Connection con = Conexao.getInstancia();
        
        try {
            String sql = "SELECT * FROM produtos WHERE nome = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, nome);
            
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {                
                    return true;
                } 
            return false;
        } catch (Exception e) {
            throw e;
        } finally {
            ps.close();
        }
    }
}
