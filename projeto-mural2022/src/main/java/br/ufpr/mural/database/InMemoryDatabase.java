/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.mural.database;


import java.util.HashMap;
import java.util.Map;

import br.ufpr.mural.core.Usuario;

/**
 *
 * @author helio
 */
public class InMemoryDatabase /*implements Database*/ {  // DAO = Data Access Object
        
   
	private Map<String, Usuario> usuarios;  // agregação 1 para muitos
//	private Map<String, Mural> murais;
	
	public InMemoryDatabase() {
		this.usuarios = new HashMap<>();
	}
	
    public void inserirUsuario(Usuario usuario){
        this.usuarios.put(usuario.getUserName(), usuario);
    }
    
    public Usuario getUsuario(String userName) {
    	return this.usuarios.get(userName);
//    	for (Usuario usuario: this.usuarios) { // para cada usuario em this.usuarios
//    		if (userNameNovo.equals(usuario.getUserName())) {
//    			return usuario;
//    		}
//    	}
//    	return null;
    }

	
    
    
    
}
