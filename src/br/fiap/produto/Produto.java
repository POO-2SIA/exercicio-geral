package br.fiap.produto;

import java.text.DecimalFormat;

public class Produto {
    private int id;
    private String nome;
    private double valorUnitario;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double valorUnitario, int quantidadeEmEstoque) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String aux = "";
        aux += "Nome: " + nome + "\n";
        aux += "Valor: R$ " + df.format(valorUnitario) + "\n";
        aux += "Quantidade: " + quantidadeEmEstoque + "\n";
        return aux;
    }


    public void adicionarEstoque(int qtd) {
        quantidadeEmEstoque += qtd;
    }

    public void debitarEstoque(int qtd) {
        quantidadeEmEstoque -= qtd;
    }

    public String getNome() {
        return nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }
}
