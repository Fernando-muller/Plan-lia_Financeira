package dao;

import java.sql.*;
import java.util.ArrayList;
import until.Conexao;

public class MovimentacaoDAO {

    // 🔹 LISTAR
    public ArrayList<String> listar() {
        ArrayList<String> lista = new ArrayList<>();

        String sql = "SELECT * FROM movimentacoes";

        try {
            Connection conn = Conexao.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                String m = rs.getString("tipo") + " - " +
                           rs.getString("descricao") + " - R$ " +
                           rs.getDouble("valor");

                lista.add(m);
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // 🔹 CALCULAR SALDO
    public double calcularSaldo() {
        double saldo = 0;

        String sql = "SELECT * FROM movimentacoes";

        try {
            Connection conn = Conexao.conectar();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()) {
                if(rs.getString("tipo").equals("Entrada")){
                    saldo += rs.getDouble("valor");
                } else {
                    saldo -= rs.getDouble("valor");
                }
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return saldo;
    }
    
    public void salvar(String tipo, String descricao, double valor, int idUsuario) {
    String sql = "INSERT INTO movimentacoes (tipo, descricao, valor, id_usuario) VALUES (?, ?, ?, ?)";

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, tipo);
        ps.setString(2, descricao);
        ps.setDouble(3, valor);
        ps.setInt(4, idUsuario);

        ps.execute();
        conn.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}