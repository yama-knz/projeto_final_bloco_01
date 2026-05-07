package model;

public class Jogo extends Produto {

	private String plataforma;

	public Jogo(int id, String nome, int tipo, float preco, String plataforma) {
		super(id, nome, tipo, preco);
		this.plataforma = plataforma;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Plataforma: " + this.plataforma);
	}

}
