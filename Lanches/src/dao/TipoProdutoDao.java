/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Edmilson
 */
public class TipoProdutoDao {
    
    public static boolean existeTipoProduto(String tipoP) throws Exception {
        // preparar a instrução
        PreparedStatement ps = null;
        Connection con = Conexao.getInstancia();

        try {
            String sql = "SELECT * FROM tipoProduto WHERE tipo = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, tipoP);

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
