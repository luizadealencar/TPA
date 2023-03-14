package parte2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import utils.Info;

public class ExcluirContato{
	private static void remover(ArrayList<Info> list, String nome){
		Iterator<Info> iterator=list.iterator();
		while (iterator.hasNext()){
			Info pessoa=iterator.next();
			if (pessoa.getNomeCompleto().contains(nome)){
				iterator.remove();
			}
		}
	}
	
	public static void excluir(ArrayList<Info> list) throws IOException{
		System.out.printf("\nDigite o nome para ser excluido: ");
		String nome=Input.hasNextLine() ? Input.nextLine() : null;
		remover(list, nome);
		System.out.printf("\nContato Excluido!\n");
  }
}