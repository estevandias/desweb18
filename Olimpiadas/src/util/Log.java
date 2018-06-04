package usjt.olimpiada.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Leonardo de Andrade
 * RA: 8162259292
 * Data de Criação: 25/05/2018
 */
public class Log {
	public static final String NOME = "logSistema.txt";
	private PrintWriter arquivo;
	
	public void abrir(String nome) throws IOException {
		File outFile = new File(nome);
		FileOutputStream outFileStream;
		
		System.out.println("Arquivo está em: " + nome);
		if(outFile.exists()) {
			outFileStream = new FileOutputStream(outFile, true);
		}else {
			System.out.println("Nao existe");
			outFileStream = new FileOutputStream(outFile);
		}
		
		arquivo = new PrintWriter(outFileStream);
	}
	
	public void escrever(String texto) throws IOException{
		arquivo.println(texto);
		arquivo.flush();
	}
	
	public void fechar() throws IOException {
		arquivo.close();
	}
}
