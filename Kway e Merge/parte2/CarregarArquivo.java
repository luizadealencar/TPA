package parte2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
import java.util.Iterator;
import java.util.Scanner;
import utils.Info;

public class CarregarArquivo {
	public static void mergeCsvFiles(ArrayList<Info> list, String nome, TabelaHash tabela) throws IOException{
		ArrayList<File> files=new ArrayList<File>();
		Iterator<File> iterFiles;
		BufferedReader fileReader;
		files.add(new File(nome));
		iterFiles=files.iterator();
		Scanner scanner=new Scanner(files.get(0));
		scanner.close();
		while (iterFiles.hasNext()){
			String line;
			File nextFile=iterFiles.next();
			fileReader=new BufferedReader(new FileReader(nextFile));
			line=fileReader.readLine();
			while (line!=null){
				Info contato=new Info(line);
				list.add(contato);
				tabela.inserir(contato.getNomeCompleto(), contato);
				line=fileReader.readLine();
			}
			fileReader.close();
		}
		System.out.printf("\nArquivo Carregado!\n");
	}
}