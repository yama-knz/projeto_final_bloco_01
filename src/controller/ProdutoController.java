package controller;

import java.util.ArrayList;

import model.Produto;
import repository.ProdutoRepository;

public class ProdutoController implements ProdutoRepository {

	private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
	int id = 0;

	@Override
	public void procurarPorId(int id) {

		var produto = buscarNaCollection(id);

		if (produto != null)
			produto.visualizar();
		else
			System.out.println("\nO Produto não foi encontrado!");

	}

	@Override
	public void listarTodos() {

		for (var produto : listaProdutos) {
			produto.visualizar();
		}

	}

	@Override
	public void cadastrar(Produto produto) {

		listaProdutos.add(produto);
		System.out.println("\nProduto cadastrado com sucesso!");

	}

	@Override
	public void atualizar(Produto produto) {

		var buscaProduto = buscarNaCollection(produto.getId());

		if (buscaProduto != null) {

			listaProdutos.set(listaProdutos.indexOf(buscaProduto), produto);
			System.out.println("\nProduto atualizado com sucesso!");

		} else
			System.out.println("\nO Produto não foi encontrado!");

	}

	@Override
	public void deletar(int id) {

		var produto = buscarNaCollection(id);

		if (produto != null) {

			listaProdutos.remove(produto);
			System.out.println("\nProduto apagado com sucesso!");

		} else
			System.out.println("\nO Produto não foi encontrado!");

	}

	public int gerarId() {
		return ++id;
	}

	public Produto buscarNaCollection(int id) {

		for (var produto : listaProdutos) {
			if (produto.getId() == id) {
				return produto;
			}
		}

		return null;
	}

}
