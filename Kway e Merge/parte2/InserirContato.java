package parte2;
import java.io.IOException;
import java.util.ArrayList;
import utils.Info;

public class InserirContato{
	public static void contatonovo(ArrayList<Info> list, TabelaHash tabela) throws IOException{
		System.out.printf("\nNome Completo: ");
		String nome=Input.hasNextLine() ? Input.nextLine() : null;
		System.out.printf("Telefone: ");
		String telefone=Input.hasNextLine() ? Input.nextLine() : null;
		System.out.printf("Cidade: ");
		String cidade=Input.hasNextLine() ? Input.nextLine() : null;
		System.out.printf("Pais: ");
		String pais=Input.hasNextLine() ? Input.nextLine() : null;
		Info prod=new Info(nome, telefone, cidade, pais);
		list.add(prod);
		tabela.inserir(nome, prod);
		System.out.printf("\nContato Inserido!\n");
	}
}