package services;

import domain.Produto;

import java.util.ArrayList;
import java.util.Random;

public class ProdutosAleatorios {
    private  Produto[] produtosSelecionados = new Produto[3];
    private static ArrayList<Produto> produtos = new ArrayList<Produto>();

    public Produto[] getProdutosSelecionados() {
        return produtosSelecionados;
    }

    public void escolherProdutosDaLista() {
        ProdutosAleatorios.listaDeProdutos();
        int[] jaEscolhido = {0, 0, 0} ;
        int j = 0;
        while (j < 3) {
            boolean repetido = false;
            int random = new Random().nextInt(produtos.size());
            for (int i = 0; i < 3; i++) {
                if (jaEscolhido[i] == random) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                this.produtosSelecionados[j] = produtos.get(random);
                jaEscolhido[j] = random;
                j++;
            }
        }

    }

    private static void listaDeProdutos() {
        Produto produto1 = new Produto("Água", "Água Mineral", 1, 2.0);
        adicionarProdutosNaLista(produto1);
        Produto produto2 = new Produto("Sorvete", "Sorvete de morango", 1, 10.5);
        ProdutosAleatorios.adicionarProdutosNaLista(produto2);
        Produto produto3 = new Produto("Picolé", "Picolé de chocolate", 1, 5.85);
        ProdutosAleatorios.adicionarProdutosNaLista(produto3);
        Produto produto4 = new Produto("Biscoito", "Biscoito Recheado", 1, 2.28);
        ProdutosAleatorios.adicionarProdutosNaLista(produto4);
        Produto produto5 = new Produto("Panela", "Panela de pressão", 1, 120.49);
        ProdutosAleatorios.adicionarProdutosNaLista(produto5);

    }

    private static void adicionarProdutosNaLista(Produto produto) {
        ProdutosAleatorios.produtos.add(produto);
    }

}
