package main;

import dao.MovimentacaoDAO;

public class Main {

    public static void main(String[] args) {

        MovimentacaoDAO dao = new MovimentacaoDAO();

        // 🔹 SALVAR DADOS
        String descricao = "Salário";
        double valor = 2500;
        String tipo = "Entrada";

        dao.salvar(tipo, descricao, valor, 1); // usuário fixo

        System.out.println("Lista de movimentações:");

        // 🔹 LISTAR DADOS
        for (String mov : dao.listar()) {
            System.out.println(mov);
        }

        // 🔹 MOSTRAR SALDO
        System.out.println("Saldo: R$ " + dao.calcularSaldo());
    }
}