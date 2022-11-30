package util;

/**
 *
 * @author aluno
 */
import banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author chs
 */
public class Combobox extends JComboBox {

    //  public static Connection conexao1;
    public String querycombo;
    public List codigo = new ArrayList();
    public List<String> nomes = new ArrayList();
    public String dica;
    public boolean obrigatorio;

    public String getQuerycombo() {
        return querycombo;
    }

    public void setQuerycombo(String querycombo) {
        this.querycombo = querycombo;
    }

    public List getCodigo() {
        return codigo;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }

    public int getValor() {
        return (Integer) codigo.get(getSelectedIndex());

    }

    public void setValor(int valor) {
        for (int contador = 0; contador < codigo.size(); contador++) {
            if ((Integer) codigo.get(contador) == valor) {
                setSelectedIndex(contador);
                break;
            }
        }

    }

    /*
    para usar este metodo faça um select com o codigo e o nome/n
    um campo inteiro e uma String
     */
    public Combobox() {

        this.setFont(new java.awt.Font("Tahoma", 0, 12));
    }

    /*
    para usar este metodo faça um select com o codigo e o nome/n
    um campo inteiro e uma String
     */
    public Combobox(boolean obrigatorio, String dica) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        this.setFont(new java.awt.Font("Tahoma", 0, 12));
    }

    /*
    para usar este metodo faça um select com o codigo e o nome/n
    um campo inteiro e uma String
     */
    public Combobox(String descripition) {
        this.setBackground(new java.awt.Color(224, 224, 224));
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(null, descripition, javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Dialog", 0, 11), java.awt.Color.black)); // NOI18N
    }

    public void buscaResult(String sql) {
        try {
            Connection con = Conexao.getInstancia();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            displayResultSet(rs);
            rs.close();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na consulta: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void displayResultSet(ResultSet rs) {

        try {

            codigo.clear();
            this.removeAllItems();
            codigo.add(0);
            this.addItem("Selecione");
            nomes.add("Selecione");
            rs.first();
            do {

                codigo.add(rs.getInt(1));

                this.addItem(rs.getString(2));
                nomes.add(rs.getString(2));

            } while (rs.next());

        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "NAO ACHEI DADOS DO COMBO");
        }
    }

    public void limpar() {
        setSelectedIndex(0);
    }

    public void habilitar(boolean status) {
        setEnabled(status);
    }

    public void editar(boolean status) {
        setEditable(status);
    }

    public boolean eObrigatorio() {
        if (obrigatorio == false && this.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }

    public boolean eVazio() {
        if (this.getSelectedIndex() != -1) {
            return false;
        }
        return true;
    }

    public boolean eValido() {
        return true;
    }

    public String getDica() {
        return dica;
    }

    public void alterarCampos(boolean status) {
    }

    public void comboFiltro(int[] tipo, String[] nome) {
        codigo.clear();
        this.removeAllItems();
        for (int x = 0; x < tipo.length; x++) {
            codigo.add(tipo[x]);
            this.addItem(nome[x]);
        }

    }

    public void achaId(Integer id) {
        for (int i = 0; i < codigo.size(); i++) {
            if (codigo.get(i) == id) {
                this.setSelectedIndex(i);
            }
        }
    }

    public void achaNome(String nome) {
        for (int i = 0; i < codigo.size(); i++) {

            this.setSelectedIndex(i);
            if (nomes.get(i).equals(nome)) {
                this.setSelectedItem(nome);
            }
            
            System.out.println(this.getSelectedItem().toString());
        }
    }
}
