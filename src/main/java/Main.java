import java.util.Scanner;
import java.util.Vector;

import com.loja.produtos.Celular;
import com.loja.produtos.Produto;
import com.loja.produtos.Radio;
import com.loja.produtos.Tablet;
import com.loja.produtos.Televisao;
import com.loja.produtos.Videogame;

public class Main {
    Vector<Produto> produtos = new Vector<>();

    public void mostrarProdutos(){
    	for (Produto p : produtos){
    		System.out.println("Nome: " + p.getNome() + " | Preço: R$ " + p.getPreco());
    	}
    }

    public void addProdutos(int quantidade, String tipo){
    	for (int i = 0; i < quantidade; i++) {
    		switch (tipo) {
    			case "Videogame" -> produtos.add(new Videogame());
    			case "Radio" -> produtos.add(new Radio());
    			case "Tablet" -> produtos.add(new Tablet());
    			case "Televisao" -> produtos.add(new Televisao());
    			case "Celular" -> produtos.add(new Celular());
    			default -> System.out.println("Tipo inválido!");
    		}
    	}
    }
    
    public int somaPreco(){
    	int total = 0;
    	for (Produto p : produtos){
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
            p.mostrarProdutos();
        }
    }

}
