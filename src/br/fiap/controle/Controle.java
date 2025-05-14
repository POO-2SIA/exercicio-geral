package br.fiap.controle;
import br.fiap.cliente.Cliente;
import br.fiap.item.ItemProduto;
import br.fiap.notafiscal.NotaFiscal;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
import static javax.swing.JOptionPane.*;

public class Controle {

    private static List<Cliente> listaCliente = new ArrayList<>();
    private static List<Produto> listaProduto = new ArrayList<>();
    private NotaFiscal nf;

    static {
        //Usamos esse static para assim que instanciarmos um objeto dessa classe, esses
        // dados já serão subidos para a memória

        //Lista de clientes
        listaCliente.add(new Cliente(123, "Maria Ana"));
        listaCliente.add(new Cliente(456, "Joka Ferreira"));
        listaCliente.add(new Cliente(789, "Jhonny Boy"));

        //Lista de produtos
        listaProduto.add(new Produto(1, "Perfume", 800, 50));
        listaProduto.add(new Produto(2, "Tenis", 1100, 300));
        listaProduto.add(new Produto(3, "Jaqueta", 1500, 130));
    }

    public Controle() {
        Random rd = new Random();
        /*
        Cliente cliente = listaCliente.get(rd.nextInt(listaCliente.size()));
        nf = new NotaFiscal(cliente);
        */
        nf = new NotaFiscal(listaCliente.get(rd.nextInt(listaCliente.size())));
    }

    public void menu() {
        int opcao;
        while(true) {
            try {
                opcao = parseInt(showInputDialog(gerarMenu()));

                switch (opcao) {
                    case 1:
                        adicionarItem();
                        break;
                    case 2:
                        removerItem();
                        break;
                    case 3:
                        fecharCompra();
                        break;
                    case 4:
                        return;
                    default:
                        showMessageDialog(null, "Opção inválida, chefia!");
                        break;
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Digite um número");
            }
        }
    }

    private void adicionarItem() {
        if (nf.getStatus()) {
            String nomeProduto = showInputDialog("Insira o nome do item");
            for (Produto p : listaProduto) {
                if (p.getNome().equalsIgnoreCase(nomeProduto)) {
                    int quantidade = parseInt(showInputDialog("Insira a quantidade que deseja comprar"));
                    if (p.getQuantidadeEmEstoque() >= quantidade) {
                        //ItemProduto item = new ItemProduto(p, quantidade);
                        nf.adicionarItem(new ItemProduto(p, quantidade)); //Linha direta de código
                        p.debitarEstoque(quantidade);
                        showMessageDialog(null, "Item adicionado!");
                    }
                }
            }
        } else {
            showMessageDialog(null, "A nota já está fechada!");
        }
    }

    private void removerItem() {

    }

    private void fecharCompra() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        nf.setStatus(false);
        showMessageDialog(null, nf.toString());
    }




    private String gerarMenu() {
        String aux = "SISTEMA DE COMPRAS ONLINE\n";
        aux += "1. Adicionar item\n";
        aux += "2. Remover item\n";
        aux += "3. Fechar compra\n";
        aux += "4. Finalizar atendimento\n";
        return aux;
    }

}
