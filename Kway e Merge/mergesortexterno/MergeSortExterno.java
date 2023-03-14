package mergesortexterno;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.io.*;
import utils.Info;

public class MergeSortExterno{
	private int contarq=0;
	private static final int MAX = 1000000;

	public ArrayList<Integer> separa(String nome) throws Exception{
		ArrayList<Integer> lista_arq=new ArrayList<>(); 
		BufferedReader arq1=new BufferedReader(new FileReader(nome));
		String linha=arq1.readLine();
		ArrayList<Info> informacoes=new ArrayList<>();
		while (linha!=null){		
			Info contato=new Info(linha);
			informacoes.add(contato);
			linha=arq1.readLine();
			if (informacoes.size()>=MAX || linha==null){
				informacoes.sort((p1, p2) -> p1.getNomeCompleto().compareTo(p2.getNomeCompleto()));
				OutputStream os=new FileOutputStream("mergesortexterno/saida" + Integer.toString(contarq) + ".csv"); 
				Writer wr=new OutputStreamWriter(os); 
				BufferedWriter arq2=new BufferedWriter(wr);
				for (int k=0; k<informacoes.size(); k++){
					arq2.write(informacoes.get(k).imprimir() + ",\n");
				}
				lista_arq.add(contarq);     
				contarq++;
				arq2.close();
				informacoes.clear();
			}
		}
		arq1.close(); 	
		return lista_arq;
	}

	public int merge(Integer arquivo1, Integer arquivo2) throws Exception{
		BufferedReader arq1=new BufferedReader(new FileReader(Integer.toString(arquivo1) + ".csv"));
		BufferedReader arq2=new BufferedReader(new FileReader(Integer.toString(arquivo2) + ".csv"));			
		OutputStream os=new FileOutputStream("mergesortexterno/Saida" + Integer.toString(contarq) + ".csv"); 
		Writer wr=new OutputStreamWriter(os); 
		BufferedWriter arq3=new BufferedWriter(wr); 
		contarq++;
		String linha1=arq1.readLine(), linha2=arq2.readLine();
		String[] contato1=linha1.split(",");
		String[] contato2=linha2.split(",");
		while (linha1!=null && linha2!=null){
			if (contato1[0].compareTo(contato2[0]) < 0){ 
				arq3.write(linha1); 
				arq3.newLine();
				linha1=arq1.readLine(); 
				if (linha1!=null)
					contato1=linha1.split(","); 
			}else{ 
				arq3.write(linha2); 
				arq3.newLine();
				linha2=arq2.readLine(); 
				if (linha2!=null)
					contato2=linha2.split(",");
			}
		}
		while (linha1!=null){
			arq3.write(linha1);
			arq3.newLine();
			linha1=arq1.readLine();
		}
		while (linha2!=null){
			arq3.write(linha2);
			arq3.newLine();
			linha2=arq2.readLine();
		}
		arq1.close();
		arq2.close();
		arq3.close();
		return contarq-1;
	}
}