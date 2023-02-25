package br.ufpr.mural.server;

public enum Resposta {
	
	//this is a list 
	OK("ok"),
	COMANDO_INVALIDO("comando-invalido"),
	USUARIO_JA_EXISTE("usuario-ja-existe"),
	NOME_INVALIDO("nome-invalido");

	private String nomeMensagem;
	
	Resposta(String nomeMensagem) {
		this.nomeMensagem = nomeMensagem;
	}
	
	@Override
	public String toString() {
		return nomeMensagem;
	}
	

}
