package parte2;
import java.io.IOException;
import java.util.ArrayList;
import utils.Info;

public class Localizar{
	public static void busca(ArrayList<Info> list) throws IOException{
		System.out.printf("\nDigite o nome do contato a ser pesquisado: ");
		String nome=Input.hasNextLine() ? Input.nextLine() : null;
		for (Info pessoa : list){
			if(pessoa.getNomeCompleto().contains(nome)){
				System.out.printf("\nPessoa Encontrada:\n");
				System.out.println(pessoa.imprimir() + ",\n");
			}
		}
  }
}