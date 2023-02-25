package br.ufpr.mural.core;
import java.util.*;
import java.time.LocalDateTime;

//extends post
	public class Evento {
		private LocalDateTime dataHora;
		private String local;
		private List<Usuario> usuariosConfirmados; 					//criação do atributo de "usuáriosConfirmados"
	
	public Evento(LocalDateTime dataHora, String local) {
			this.dataHora = dataHora;
			this.local = local;
	}
	
	//Because it is private 
	public String getLocal() {
		return local;
	}

	//Dúvida aqui --> "Create method getUsuario(String)
	//Maybe the parameters are wrong --> criar um List ou ArrayList como parâmetro
	public confirmarPresença(Usuario usuario) {
		return this.getUsuario(local);
		//usuario.addEventoConfirmando(this);
		
	
	}
	
//void confirmarPresença(Usuario usuario)--> usuario.addEventoConfirmado(this)
//void desconfirmarPresença(Usuario usuario) --> usuario.removeEvento(this)
	
//List <Usuario)getUsuariosConfirmados --> ToString 

}
