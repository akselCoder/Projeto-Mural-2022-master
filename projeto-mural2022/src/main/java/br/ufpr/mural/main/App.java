package br.ufpr.mural.main;

import java.io.IOException;

import br.ufpr.mural.server.Servidor;


public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Iniciando servidor");
        Servidor servidor = new Servidor();
        servidor.iniciar();        
    }
}
