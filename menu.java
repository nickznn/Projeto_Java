package construtor;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private double valorTotal;
    private List<Produto> produtos;

    public Pedido(int numero) {
        this.numero = numero;
        this.valorTotal = 0.0;
        this.produtos = new ArrayList<>();
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getNumero() {
        return numero;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    // Método para adicionar produto genérico
    public void addProduto(Produto produto) {
        produtos.add(produto);
        valorTotal += produto.getPreco();
    }

    // Método para remover produto genérico
    public void removerProduto(Produto produto) {
        if (produtos.remove(produto)) {
            valorTotal -= produto.getPreco();
            System.out.println("Produto removido: " + produto.getNome());
        } else {
            System.out.println("Produto não encontrado: " + produto.getNome());
        }
    }

    // Aplicar desconto, se aplicável
    public void aplicarDesconto() {
        if (valorTotal > 100) {
            valorTotal *= 0.9;
            System.out.println("PARABÉNS! VOCÊ GANHOU UM DESCONTO DE 10%\nNOVO VALOR DO PEDIDO: " + valorTotal);
        }
    }

    // Exibir resumo do pedido
    public void exibirPedido() {
        System.out.println("Produtos no pedido #" + numero + ":");
        for (Produto p : produtos) {
            System.out.println("- " + p.getNome() + ": R$ " + p.getPreco());
        }
        System.out.println("VALOR TOTAL DO PEDIDO: " + valorTotal);
        aplicarDesconto();
    }
}
