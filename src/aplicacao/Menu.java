package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Jogo;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcao;
		
		// Testando o objeto
		Jogo jogo1 = new Jogo(1, "God of War Ragnarok", 2, 299.90f, "PlayStation 5");
		jogo1.visualizar();

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
					System.out.println("\nCadastrar Produto\n");
					keyPress();
					break;

				case 2:
					System.out.println("\nListar Produtos\n");
					keyPress();
					break;

				case 3:
					System.out.println("\nBuscar Produto por ID\n");
					keyPress();
					break;

				case 4:
					System.out.println("\nAtualizar Produto\n");
					keyPress();
					break;

				case 5:
					System.out.println("\nApagar Produto\n");
					keyPress();
					break;

				case 6:
					sobre();
					System.out.println("\nLoja de Games - O seu universo gamer começa aqui!");
					sc.close();
					System.exit(0);
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

}
