package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.Seguranca;

/**
 *
 * @author Edmilson
 */
public class UsuarioDao {
    
    public static boolean existeUsuario(String usuario, String senha) throws Exception {
        // preparar a instrução
        PreparedStatement ps = null;
        Connection con = Conexao.getInstancia();
        
        try {
            String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, Seguranca.hash(senha));
            
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
