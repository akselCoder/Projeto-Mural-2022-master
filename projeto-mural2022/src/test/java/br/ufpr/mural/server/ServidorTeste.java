package br.ufpr.mural.server;
import org.junit.Test;

public class ServidorTeste {
	private DatabaseDao databaseDao = new InMemoryDatabase();
	private Servidor servidor = new Servidor(); 
	
	@Test
	public void tesCriarUsuario() {
		//cenario 
		String comando = "criar-usuario joao";
		String respostaEsperada = "ok";
		
		//execução 
		//servidor.
	}
	
}
