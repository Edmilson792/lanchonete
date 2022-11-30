package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

/**
 *
 * @author Edmilson
 */
public class PedidoDao {
    public static boolean existePedido(Timestamp datapedido) throws Exception {
        // preparar a instrução
        PreparedStatement ps = null;
        Connection con = Conexao.getInstancia();

        try {
            String sql = "SELECT * FROM pedidos WHERE datapedido = ?";
            ps = con.prepareStatement(sql);
            ps.setTimestamp(1, datapedido);

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
