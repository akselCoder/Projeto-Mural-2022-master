/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.mural.core;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    
    private String userName;  // identificador
    private List<Post> postsSalvos;  //This is an array
    
    public Usuario(String userName) {
        this.userName = userName;
        this.postsSalvos = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    
    public List<Post> getPostsSalvos() {
		return postsSalvos;
	}
    
    public void salvarPost(Post post) {
    	this.postsSalvos.add(post);
    }
    
    //"salvarPost" é um método?
    
    //Não deve ser permitido a criação de usuários com o mesmo nome
  // if(usuario.equals(usuario)) {
    	
    }
    

    

    
    
    
    
    
    
}
