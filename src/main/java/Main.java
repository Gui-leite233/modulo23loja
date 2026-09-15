import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;
import java.util.Map;

import com.loja.produtos.Celular;
import com.loja.produtos.Produto;
import com.loja.produtos.Radio;
import com.loja.produtos.Tablet;
import com.loja.produtos.Televisao;
import com.loja.produtos.Videogame;

public class Main {
    Vector<Produto> produtos = new Vector<>();
    Vector<Produto> carrinho = new Vector<>();

    public void mostrarProdutos(){
        int i = 0;
        for (Produto p : produtos){
            i++;
            System.out.println("[" + i + "] Nome: " + p.getNome() + " | Preço: R$ " + p.getPreco());
        }
    }

    public void mostrarCarrinho(){
        HashMap<String, Integer> contagem = new HashMap<>();
        HashMap<String, Integer> subtotal = new HashMap<>();
    
        for (Produto p : carrinho){
            String nome = p.getNome();
            contagem.put(nome, contagem.getOrDefault(nome, 0) + 1);
            subtotal.put(nome, subtotal.getOrDefault(nome, 0) + p.getPreco());
        }
    
        for (Map.Entry<String, Integer> entry : contagem.entrySet()){
            String nome = entry.getKey();
            int qtd = entry.getValue();
            int total = subtotal.get(nome);
            System.out.printf("%d %s que resulta em R$%d%n", qtd, nome, total);
        }
    }

    public void addProdutos(int quantidade, String tipo){
        for (int i = 0; i < quantidade; i++) {
            switch (tipo) {
                case "Videogame" -> carrinho.add(new Videogame());
                case "Radio" -> carrinho.add(new Radio());
                case "Tablet" -> carrinho.add(new Tablet());
                case "Televisao" -> carrinho.add(new Televisao());
                case "Celular" -> carrinho.add(new Celular());
                default -> System.out.println("Tipo inválido!");
            }
        }
    }

    public void comprarProdutos(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        Vector<Integer> escolha = new Vector<>();
        Vector<Integer> quantidade = new Vector<>();
        String tipo;
    
        System.out.println();
        System.out.println("Aqui estão os produtos disponíveis:\n");
        System.out.println();
    
        while (true) {
            mostrarProdutos();
            System.out.println("Qual produto te interessou mais? Digite o número correspondente:");
            int escolhaAtual = scanner.nextInt();
            escolha.add(escolhaAtual);
    
            System.out.println("Digite a quantidade do produto que escolheu agora:");
            int quantidadeAtual = scanner.nextInt();
            quantidade.add(quantidadeAtual);
    
            String rto = switch (escolhaAtual) {
                case 1 -> tipo = "Videogame";
                case 2 -> tipo = "Radio";
                case 3 -> tipo = "Tablet";
                case 4 -> tipo = "Televisao";
                case 5 -> tipo = "Celular";
                default -> throw new IllegalArgumentException("caso inválido");
            };
    
            addProdutos(quantidadeAtual, rto);
    
            System.out.println("Terminar compra? Digita [1] para não e [0] para sim");
            choice = scanner.nextInt();
    
            if (choice == 1){
                continue;
            } else {
                break;
            }
        }
    
        System.out.println("\nSeu carrinho:");
        mostrarCarrinho();
        System.out.println("Total a pagar: R$ " + somaPreco());
    }

    public int somaPreco(){
        int total = 0;
        for (Produto p : carrinho){
            total += p.getPreco();
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main p = new Main();
        int escolha;

        p.produtos.add(new Videogame());
        p.produtos.add(new Radio());
        p.produtos.add(new Tablet());
        p.produtos.add(new Televisao());
        p.produtos.add(new Celular());

        System.out.println("Seja bem vindo à loja!");
        System.out.println("Comprar produtos? Digite [1]");
        System.out.println("Sair [0]");
        escolha = scanner.nextInt();

        if(escolha==0){
            String tchau = "Até mais!";
            System.out.println(tchau);
            return;
        } else {
            p.comprarProdutos();
        }
    }
}