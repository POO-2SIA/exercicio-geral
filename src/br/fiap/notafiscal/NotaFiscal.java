package br.fiap.notafiscal;
import br.fiap.cliente.Cliente;
import br.fiap.item.ItemProduto;
import br.fiap.produto.Produto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    private List<ItemProduto> lista;
    private Cliente cliente;
    private boolean status; //True indica que a nota está em aberto

    public NotaFiscal(Cliente cliente) {
        this.lista = new ArrayList<>();
        this.cliente = cliente;
        this.status = true;
    }

    public void adicionarItem(ItemProduto item){
        lista.add(item);
    }

    public void removerProduto(Produto produto) {

    }

    public double calcularTotal() {
        double total = 0;
        for (ItemProduto item : lista) {
            total += item.calcularTotal();
        }
        return total;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String aux = "";
        aux += cliente.toString();
        for (ItemProduto item : lista) {
            aux += "Item: " + item.getProduto().getNome() + " x" + item.getQuantidadeComprada() + "\n";
        }
        aux += "\nTotal da compra: R$" + df.format(calcularTotal());
        return aux;
    }
}
