package br.ufpr.mural.server;

public enum Comando {
	
	CRIAR_USUARIO("criar-usuario"),
	LIMPAR_BASE("limpar-banco"),
	CRIAR_MURAL("criar-mural"),
	LOGIN("login");

	private String nomeComando;
	
	//Construtor
	Comando(String nomeComando) {
		this.nomeComando = nomeComando;
	}
	
		
	@Override
	public String toString() {
		return this.nomeComando;
	}

}
