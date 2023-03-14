package parte2;
import utils.Info;
import java.io.IOException;
import java.util.ArrayList;

public class Main{
	private static ArrayList<Info> list=new ArrayList<Info>();

	public static void main(String[] args){
		TabelaHash tabela=new TabelaHash();
		int escolha=Menu();
		try{
			while (escolha<=6){
				if(escolha==1){
					String nome="utils/AgendaTeste1M.csv";
					CarregarArquivo.mergeCsvFiles(list, nome, tabela);
				}else if(escolha==2){
					Localizar.busca(list);
				}else if(escolha==3){
					InserirContato.contatonovo(list, tabela);
				}else if(escolha==4){
					AtualizarContato.atualizar(list, tabela);
				}else if(escolha==5){
					ExcluirContato.excluir(list);
				}else if(escolha==6){
					SalvarDados.salvarArq(list);
				}
				escolha=Menu();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		Input.close();
	}

	public static int Menu(){
		System.out.printf("\nBem-vindo!\n");
		System.out.printf("==========\n");
		System.out.printf("1 - Carregar Arquivo\n");
		System.out.printf("2 - Localizar contato\n");
		System.out.printf("3 - Inserir contato\n");
		System.out.printf("4 - Atualizar contato\n");
		System.out.printf("5 - Excluir contato\n");
		System.out.printf("6 - Salvar dados\n");
		System.out.printf("Escolha um Numero (fora destes saira do programa): ");
		int opcao = Input.hasNextInt() ? Input.nextInt() : 0;
    	Input.nextLine();
		return opcao;
	}
}