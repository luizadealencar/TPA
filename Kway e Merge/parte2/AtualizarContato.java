package parte2;
import java.io.IOException;
import java.util.ArrayList;
import utils.Info;

public class AtualizarContato{
	public static void atualizar(ArrayList<Info> list, TabelaHash tabela) throws IOException{
		System.out.printf("\nDigite o nome do contato a ser atualizado: ");
		String nome=Input.hasNextLine() ? Input.nextLine() : null;
		for (Info pessoa : list) {
			if(pessoa.getNomeCompleto().contains(nome)){
				System.out.println(pessoa.getNomeCompleto() + ", " + pessoa.getTelefone() + ", " + pessoa.getCidade() + ", " + pessoa.getPais());
				System.out.printf("\nO que vai ser atualizado?\n1 - Telefone\t\n2 - Cidade\t\n3 - Pais\nNumero:");
    		int opcao=Input.hasNextInt() ? Input.nextInt() : 0;
				if (opcao==1){
					Input.nextLine();
					System.out.printf("\nDigite o telefone para trocar: ");
					String tel=Input.hasNextLine() ? Input.nextLine() : null;
					pessoa.setTelefone(tel);
					System.out.println(pessoa.imprimir() + "\n");
					tabela.atualizar(nome, pessoa);
				}else if (opcao==2){
					Input.nextLine();
					System.out.printf("\nDigite a cidade para trocar: ");
					String cid=Input.hasNextLine() ? Input.nextLine() : null;
					pessoa.setCidade(cid);
					System.out.println(pessoa.imprimir() + "\n");
					tabela.atualizar(nome, pessoa);
				}else{
					Input.nextLine();
					System.out.printf("\nDigite o pais para trocar: ");
					String pais=Input.hasNextLine() ? Input.nextLine() : null;
					pessoa.setPais(pais);
					System.out.println(pessoa.imprimir() + "\n");
					tabela.atualizar(nome, pessoa);
				}
			}
		}
	}
}