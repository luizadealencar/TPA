package parte2;
import java.util.ArrayList;
import utils.Info;

public class TabelaHash{
  public ArrayList<ArrayList<Info>> list;
  int tamanho=10000000;
  
	public TabelaHash(){
		list=new ArrayList<ArrayList<Info>>();
    for(int i=0;i<tamanho;i++){
      list.add(new ArrayList<Info>());
    }
  }
  
	public int hashVal(String chave){
    int hash=0;
    for(char c : chave.toCharArray())
      hash=Math.abs((hash + 37*(int)c) % this.tamanho);
    return hash;
  }

  public void inserir(String chave, Info valor){
    list.get(hashVal(chave)).add(valor);
  }
	
	public void atualizar(String chave, Info valor){   
    ArrayList<Info> informacoes=list.get(hashVal(chave));
		for(int i=0;i<informacoes.size();i++)
			if(informacoes.get(i).getNomeCompleto().equals(chave))
        informacoes.set(i, valor); 
  }
}