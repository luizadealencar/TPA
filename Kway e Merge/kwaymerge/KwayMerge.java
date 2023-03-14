package kwaymerge;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import utils.Info;

public class KwayMerge{
	private int bufferSize=1000000;
	public int gerar(String arquivo) throws IOException{
		try{
			FileReader fr=new FileReader(arquivo);
			BufferedReader br=new BufferedReader(fr);
			ArrayList<Info> list=new ArrayList<>();
			int i=1;
			String linha=br.readLine();
			while (linha!=null){
				Info contato=new Info(linha);
				list.add(contato);
				if (list.size()>=bufferSize){
					list.sort(Info::compareTo);
					FileWriter fw=new FileWriter("kwaymerge/memoria" + i++ + ".csv");
					BufferedWriter bw=new BufferedWriter(fw);
					for (Info c : list){
						bw.write(c.imprimir() + "\n");
					}
					bw.close();
					fw.close();
					list.clear();
				}
				linha=br.readLine();
			}
			if (list.size()>0){
				list.sort(Info::compareTo);
				FileWriter fw=new FileWriter("kwaymerge/memoria" + i++ + ".csv");
				BufferedWriter bw=new BufferedWriter(fw);
				for (Info c : list){
					bw.write(c.imprimir() + ",\n");
				}
				bw.close();
				fw.close();
				list.clear();
				br.close();
			}
			return i-1;
		}catch (IOException e){
			throw e;
		}
	}

	public void ordenar(String arquivo) throws IOException{
		try{
			int qtdArquivos=gerar(arquivo);
			ArrayList<FileReader> listfr=new ArrayList<>();
			ArrayList<BufferedReader> listbr=new ArrayList<>();
			for (int i=1;i<=qtdArquivos;i++){
				FileReader fr=new FileReader("kwaymerge/memoria" + i + ".csv");
				BufferedReader br=new BufferedReader(fr);
				listfr.add(fr);
				listbr.add(br);
			}
			ArrayList<String> linhas=new ArrayList<>();
			for (BufferedReader br : listbr) linhas.add(br.readLine());
				FileWriter fw=new FileWriter("kwaymerge/saida.csv");
				BufferedWriter bw=new BufferedWriter(fw);
				boolean flag=true;
				while (flag){
					flag=false;
					int indexmenorAlfabeto=-1;
					Info menorAlfabeto=null;
					for (String linha : linhas){
						if (linha!=null){
							flag=true;
							Info contato=new Info(linha);
							if (menorAlfabeto==null || menorAlfabeto.compareTo(contato)>0){
								indexmenorAlfabeto=linhas.indexOf(linha);
								menorAlfabeto=contato;
							}
						}
					}
					if (flag){
						bw.write(menorAlfabeto.imprimir() + ",\n");
						ArrayList<String> listLinhas=new ArrayList<>();
						for (BufferedReader br : listbr){
							int indexBuffer=listbr.indexOf(br);
							if (indexmenorAlfabeto==indexBuffer) listLinhas.add(br.readLine());
							else listLinhas.add(linhas.get(indexBuffer));
						}
						linhas=listLinhas;
					}
				}
			bw.close();
		}catch(IOException e){
			throw e;
		}
	}
}