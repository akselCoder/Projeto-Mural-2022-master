package br.ufpr.mural.core;

import java.time.LocalDateTime;

public class Post {
	private int id;
	private String texto;
	private Usuario usuarioCriador;
	private LocalDateTime dataCriação;
	//private List<Reacao> reacao;					     //List cannot be a resolved type
	//private List<Comentario> comentarios;
}
