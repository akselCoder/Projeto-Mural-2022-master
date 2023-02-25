package br.ufpr.mural.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufpr.mural.core.Usuario;
import br.ufpr.mural.database.DatabaseDao;
import br.ufpr.mural.database.InMemoryDatabase;

public class Servidor {
   
	
    private static final int PORTA = 1234; // atributo de classe

    private InMemoryDatabase database; // atributo do objeto
    
    public void iniciar() throws IOException {

        ServerSocket socket = new ServerSocket(PORTA);
        database = new InMemoryDatabase();

        System.out.println("Servidor iniciado.");
        
        try {
            while (true) {
                atenderCliente(socket.accept());
            }
        } finally {
            socket.close();
        }
    }
    
    private void atenderCliente(final Socket cliente) {        
        // A ideia basica para atender um cliente é
        //   - ler comando
        //   - processar comando  (feito por meio do método tratarComando)
        //   - escrever resposta
    	    	
        new Thread() {

            @Override
            public void run() {
                
                ArrayList<String> listaDeResultado; //Lista de retorno
        
                String command = null;
                
                try {
                    command = readLine(cliente.getInputStream());
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }

                listaDeResultado = tratarComando(command); 
                
                try {
                    for (String line: listaDeResultado){
                        writeLine(cliente.getOutputStream(), line);
                    }
                    
                    cliente.close();
                } catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }.start(); 
    }
    
    private static String readLine(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader.readLine();
    }
    
    private static void writeLine(OutputStream out, String linhas) throws IOException {
        out.write(linhas.getBytes());
        out.write('\n');
    }

 private ArrayList<String> tratarComando(String comando){
        
        ArrayList<String> listaDeResultado = new ArrayList<String>();

        if (comando == null){
            listaDeResultado.add(Resposta.COMANDO_INVALIDO.toString());
            return listaDeResultado;
        }
        
        String[] comandoDividido = comando.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1); //"criar-usuario joao" --> ["criar-usuario", "joao"]
        String tipoComando = comandoDividido[0]; 
 
        
        if (tipoComando.equals(Comando.LIMPAR_BASE.toString())) {  //limpeza do banco para testes
        	this.database.limparBase(); // CHAMA MÉTODO QUE LIMPA BASE NO PRÓPRIO OBJETO database
        	listaDeResultado.add(Resposta.OK.toString());
        	return listaDeResultado;
        }
        
        if (tipoComando.equals("criar-usuario")){
            //System.out.println(command.split(" ").length);
            if (comandoDividido.length != 2){
                listaDeResultado.add(Resposta.COMANDO_INVALIDO.toString());
                return listaDeResultado;
            }
            //else:
            String userName = comandoDividido[1];
            
            // TODO: testar se tamanho de userName é menor que 3 ou maior que 20
            
            
            // LÓGICA DE NEGÓCIO
            
            //   VERIFICAR SE USUARIO EXISTE:
            if (database.getUsuario(userName) != null) {
            	listaDeResultado.add(Resposta.USUARIO_JA_EXISTE.toString());
                return listaDeResultado;
            }
            
            
            Usuario user = new Usuario(userName);
            
            database.inserirUsuario(user);
            
            // RETORNAR SAÍDA1.7
            listaDeResultado.add("ok");
            

     
        } else if (tipoComando.equals(Comando.CRIAR_MURAL.toString())){
            // TODO
        	// COMANDO PARA DAR SPLIT IGNORANDO AS ASPAS
//        	String comando = "postar-evento \"Encontro dos Estudantes de Jandaia\" 08/11/2017 17:00 \"Bloco I\"";
//        	
        	// String mensagem = comandoDividido[1];
        	// String data = comandoDividido[2];
        	// String hora = comandoDividido[3];
        	// String local = comandoDividido[4];
        	
        	// String dataHoraStr = data   " "   hora;
        	
        	//Datetime..comando;.
        	
        	//this.usuarioLogadnull;
        	
        }

//        else if (tipoComando.equals(Comando.CRIAR_POST.toString()) {
//            //Mural...
//
//
//            mural.addPost(anuncio);
//            database.inserirPost(anuncio, mural); // para quem está fazendo BD
//        }
        //TODO...
        
        return listaDeResultado;

    }

//    private ArrayList<String> tratarComando(String comando){
//        
//        ArrayList<String> listaDeResultado = new ArrayList<String>();
//
//        if (comando == null){
//            listaDeResultado.add(Resposta.COMANDO_INVALIDO.toString());
//            return listaDeResultado;
//        }
//        
//        
//        String[] comandoDividido = comando.split(" (?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//        String tipoComando = comandoDividido[0];
//        //"criar-usuario joao" --> ["criar-usuario", "joao"]
//         
//        
//        if (tipoComando.equals(Comando.LIMPAR_BASE.toString())) {  //limpeza do banco para testes
//        	this.database = new InMemoryDatabase();
//        	listaDeResultado.add(Resposta.OK.toString());
//        	return listaDeResultado;
//        }
//        
//        //Verifica se na criação do usuário: comandoDividido != 2
//        //Caso for diferente de 2 ==> "Comando inválido"
//        if (tipoComando.equals(Comando.CRIAR_USUARIO.toString())){
//            //System.out.println(command.split(" ").length);
//            if (comandoDividido.length != 2){
//                listaDeResultado.add(Resposta.COMANDO_INVALIDO.toString());
//                return listaDeResultado;
//            }
//            //else:
//            //Pega o segundo elemento de "comandoDividido"
//            String userName = comandoDividido[1];
//            
//                        
//            // TODO: testar se tamanho de userName é menor que 3 ou maior que 20
//            if (userName.length() >= 20 ||  userName.length() <= 3) {
//            	listaDeResultado.add(Resposta.NOME_INVALIDO.toString());
//            	return listaDeResultado;
//            	
//            }            
//            
//            // LÓGICA DE NEGÓCIO  
//            
//            //   VERIFICAR SE USUARIO EXISTE:
//            if (database.getUsuario(userName) != null) {
//            	listaDeResultado.add(Resposta.USUARIO_JA_EXISTE.toString());
//                return listaDeResultado;
//            }
//            
//            //Por que "new Usuario" está depois da verificação do "userName.lenght()"
//            //Cria novo usuario
//            Usuario user = new Usuario(userName);   
//            
//            //if (tipoComando.equals(CRIAR_USUARIO)) {
//            //	return user.getUserName("")
//            //	user.getUserName("Maria");
//           
//
//  //          }
//            //user.getUserName("Maria");
//            //"criar-usuario joao" --> ["criar-usuario", "joao"]
//            //tipoComando = (Comando.CRIAR_USUARIO("Maria"));
//            //tipoComando(CRIAR_USUARIO("MARIA");
//            
//  //          Usuario user; 
//   			database.inserirUsuario(user);
//            
//            // RETORNAR SAÍDA
//            listaDeResultado.add("ok");
//            
//           //Criar um if-else para login
//     
//        
//    	//else (tipoComando.equals(Comando.CRIAR_MURAL.toString())){
//            // TODO
//        	//Comando para dar "split" ignorando as aspas 
////			String comando = "postar-evento" \ "Encontro dos Estudantes de Jandaia"\ "08/11"
//       // }
//        //TODO...
//        
//        return listaDeResultado;
//        }
//        
		
    
   
 
    