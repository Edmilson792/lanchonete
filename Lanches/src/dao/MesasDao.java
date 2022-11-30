package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edmilson
 */
public class MesasDao {
        public static boolean existeMesa(String numero) throws Exception {
        // preparar a instrução
        PreparedStatement ps = null;
        Connection con = Conexao.getInstancia();

        try {
            String sql = "SELECT * FROM mesas WHERE numero = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, numero);

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
