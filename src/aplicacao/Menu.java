package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ProdutoController;
import model.Jogo;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;

		ProdutoController produtos = new ProdutoController();

		while (true) {

			limparTela();

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                LOJA DE GAMES                        ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar Produtos                      ");
			System.out.println("            3 - Buscar Produto por ID                ");
			System.out.println("            4 - Atualizar Produto                    ");
			System.out.println("            5 - Apagar Produto                       ");
			System.out.println("            6 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.print("Entre com a opção desejada: ");

			try {

				opcao = sc.nextInt();
				sc.nextLine();

				switch (opcao) {

				case 1:
					cadastrarProduto(produtos);
					keyPress();
					break;

				case 2:
					listarProdutos(produtos);
					keyPress();
					break;

				case 3:
					buscarProdutoPorId(produtos);
					keyPress();
					break;

				case 4:
					atualizarProduto(produtos);
					keyPress();
					break;

				case 5:
					apagarProduto(produtos);
					keyPress();
					break;

				case 6:
					sobre();
					System.out.println("\nLoja de Games - O seu universo gamer começa aqui!");
					sc.close();
					return;

				default:
					System.out.println("\nOpção Inválida!");
					keyPress();

				}

			} catch (InputMismatchException e) {

				System.out.println("\nDigite apenas números inteiros!");
				sc.nextLine();
				keyPress();

			}

		}

	}

	public static void sobre() {

		limparTela();

		System.out.println("*********************************************************");
		System.out.println("Projeto Desenvolvido por: Igor Kenzo Yamamoto");
		System.out.println("Generation Brasil - Java Full Stack");
		System.out.println("github.com/yama-knz");
		System.out.println("*********************************************************");

	}

	public static void keyPress() {

		System.out.println("\nPressione Enter para Continuar...");
		sc.nextLine();

	}

	public static void limparTela() {

		for (int i = 0; i < 50; i++) {
			System.out.println();
		}

	}

	public static void cadastrarProduto(ProdutoController produtos) {

		String nome, plataforma;
		int tipo;
		float preco;

		System.out.println("\nCadastrar Produto\n");

		System.out.print("Nome do Produto: ");
		nome = sc.nextLine();

		System.out.print("Tipo do Produto (1-Console | 2-Jogo): ");
		tipo = sc.nextInt();
		sc.nextLine();

		System.out.print("Preço do Produto: ");
		preco = sc.nextFloat();
		sc.nextLine();

		System.out.print("Plataforma: ");
		plataforma = sc.nextLine();

		produtos.cadastrar(
				new Jogo(produtos.gerarId(), nome, tipo, preco, plataforma));

	}

	public static void listarProdutos(ProdutoController produtos) {

		System.out.println("\nListar Produtos\n");

		produtos.listarTodos();

	}

	public static void buscarProdutoPorId(ProdutoController produtos) {

		int id;

		System.out.println("\nBuscar Produto por ID\n");

		System.out.print("Digite o ID do Produto: ");
		id = sc.nextInt();
		sc.nextLine();

		produtos.procurarPorId(id);

	}

	public static void atualizarProduto(ProdutoController produtos) {

		String nome, plataforma;
		int id, tipo;
		float preco;

		System.out.println("\nAtualizar Produto\n");

		System.out.print("Digite o ID do Produto: ");
		id = sc.nextInt();
		sc.nextLine();

		var buscaProduto = produtos.buscarNaCollection(id);

		if (buscaProduto != null) {

			System.out.print("Novo Nome do Produto: ");
			nome = sc.nextLine();

			System.out.print("Novo Tipo do Produto (1-Console | 2-Jogo): ");
			tipo = sc.nextInt();
			sc.nextLine();

			System.out.print("Novo Preço do Produto: ");
			preco = sc.nextFloat();
			sc.nextLine();

			System.out.print("Nova Plataforma: ");
			plataforma = sc.nextLine();

			produtos.atualizar(
					new Jogo(id, nome, tipo, preco, plataforma));

		} else {
			System.out.println("\nProduto não encontrado!");
		}

	}

	public static void apagarProduto(ProdutoController produtos) {

		int id;

		System.out.println("\nApagar Produto\n");

		System.out.print("Digite o ID do Produto: ");
		id = sc.nextInt();
		sc.nextLine();

		produtos.deletar(id);

	}

}
