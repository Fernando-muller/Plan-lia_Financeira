package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import until.Conexao;

public class Movimentacao {

    public void salvar(String tipo, String descricao, double valor) {
        String sql = "INSERT INTO movimentacoes (tipo, descricao, valor) VALUES (?, ?, ?)";

        try {
            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, tipo);
            ps.setString(2, descricao);
            ps.setDouble(3, valor);

            ps.execute();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}