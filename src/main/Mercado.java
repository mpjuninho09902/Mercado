package main;

import models.Produto;

import java.util.*;
import java.util.stream.Collectors;

public class Mercado {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static ArrayList<Produto> produtosComprados;

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        produtosComprados = new ArrayList<>();
        menu();
    }

    private static void menu(){

        System.out.println("--------------------------------------------------");
        System.out.println("-------------Welcome to the Market-------------");
        System.out.println("--------------------------------------------------");
        System.out.println("***** Selecione uma operacao que deseja realizar *****");
        System.out.println("--------------------------------------------------");
        System.out.println("|    Opcao 1 - Cadastrar      |");
        System.out.println("|    Opcao 2 - Listar produtos|");
        System.out.println("|    Opcao 3 - Comprar        |");
        System.out.println("|    Opcao 4 - Listar compras |");
        System.out.println("|    Opcao 5 - Sair           |");

        int opcao = input.nextInt();

        switch (opcao){
            case 1:
                cadastrarProdutos();
                break;
            case 2:
                listarProdutos();
                break;
            case 3:
                comprarProdutos();
                break;
            case 4:
                listarCompras();
                break;
            case 5:
                System.out.println("Obrigado por utilizar nosso mercado!");
                System.exit(0);
            default:
                System.out.println("Digite uma opcao valida!");
                menu();
                break;
        }
    }
    
    private static void cadastrarProdutos(){
        System.out.println("Nome do produto: ");
        String nome = input.next();

        System.out.println("Preco do produto: ");
        Double preco = input.nextDouble();

        Produto produto = new Produto(nome, preco);
        produtos.add(produto);

        System.out.println(produto.getNome() + " cadastrado com sucesso!");

        menu();
    }

    private static void listarProdutos(){
        if (produtos.size() > 0){
            System.out.println("Lista de produtos: \n");

            for (Produto p : produtos){
                System.out.println(p + "\n");
            }
        }else {
            System.out.println("Nenhum produto cadastrado!");
        }

        menu();
    }

    private static void comprarProdutos(){
        if (produtos.size() > 0){
            System.out.println("Produtos disponiveis para compra: ");

            for (Produto p : produtos){
                System.out.println(p + "\n");
            }

            System.out.println("Digite o id do produto que deseja comprar? ");
            int idProduto = input.nextInt();

            for (Produto p : produtos){
                if (p.getId() == idProduto){
                    System.out.println(p);
                    produtos.remove(p);
                    produtosComprados.add(p);
                    System.out.println("Produto comprado com sucesso!");
                }else {
                    System.out.println("Nao foi possivel comprar o produto!");
                }

                menu();
            }
        }
    }

    private static void listarCompras(){
        if (produtosComprados.size() > 0){
            System.out.println("Lista de produtos comprados: \n");

            for (Produto p : produtosComprados){
                System.out.println(p);
            }
        }else {
            System.out.println("Nenhum produto comprado!");
        }

        menu();
    }
}
