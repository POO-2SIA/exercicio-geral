package br.fiap.cliente;

public class Cliente {
    private long cpf;
    private String nome;

    public Cliente(long cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String aux = "";
       aux += "CPF: " + cpf + "\n";
       aux += "Nome: " + nome + "\n";
       return aux;
    }
}
