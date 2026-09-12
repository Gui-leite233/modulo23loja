package com.loja.produtos;


public abstract class Produto{
    private int preco;
    private String nome;

    public Produto(String nome, int preco){
        if (preco <= 0) {
		throw new IllegalArgumentException("O preço deve ser maior que zero");
        }
        this.nome = nome;
        this.preco = preco;
    }


    public int getPreco() {
		return preco;
	}


	public String getNome() {
		return nome;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + " | Preço: R$ " + preco;
	}


	public void exibirPreco(){
        System.out.println("Valor: " + preco);
    }
    public void exibirNome(){
        System.out.println("Nome: " + nome);
    }

    
    

    
}