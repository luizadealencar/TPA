package parte2;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import utils.Info;

public class SalvarDados{
	public static void salvarArq(ArrayList<Info> list) throws IOException {
		File fileOutput;
		BufferedWriter fileWriter;
		String csvFinal="parte2/saida.csv";

		fileOutput=new File(csvFinal);
		if(fileOutput.exists()){
			fileOutput.delete();
		}
		try{
			fileOutput.createNewFile();
		}catch (IOException e){}

		fileWriter=new BufferedWriter(new FileWriter(csvFinal, true));
		for (Info pessoa : list){
			fileWriter.write(pessoa.imprimir() + ",\n");
		}
		fileWriter.close();
		System.out.printf("Arquivo salvo!\n");
	}
}