import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static List<Info> list = new ArrayList<Info>();

    private static void mergeCsvFiles(String[] idFile) throws IOException, InvalidParameterException {
        if(idFile.length == 0) throw new InvalidParameterException("Ao menos um arquivo deve ser passado");
        ArrayList<File> files = new ArrayList<File>();
        Iterator<File> iterFiles;
        BufferedReader fileReader;

        for (String string : idFile) {
            files.add(new File(string));
        }
        iterFiles = files.iterator();
        Scanner scanner = new Scanner(files.get(0));
        scanner.close();

        while (iterFiles.hasNext()) {
            String line;
            File nextFile = iterFiles.next();
            fileReader = new BufferedReader(new FileReader(nextFile));
            line = fileReader.readLine();
            while (line != null) {
                String[] vect = line.split(",");
                String name = vect[0];
                String surname = vect[1];
                String number = vect[2];
                String city = vect[3];
                Info prod = new Info(name, surname, number, city);
                list.add(prod);
                line = fileReader.readLine();
            }
            fileReader.close();
        }
    }

    private static void salvarArq(List<Info> list) throws IOException {
        File fileOutput;
        BufferedWriter fileWriter;
        String csvFinal = "saida.csv";

        fileOutput = new File(csvFinal);
        if (fileOutput.exists()) {
            fileOutput.delete();
        }
        try {
            fileOutput.createNewFile();
        } catch (IOException e) {
        }

        fileWriter = new BufferedWriter(new FileWriter(csvFinal, true));
        for (Info pessoa : list) {
            fileWriter.write(pessoa.getName() + ", " + pessoa.getSurname() + ", " + pessoa.getNumber() + ", "
                    + pessoa.getCity() + "\n");
        }
        fileWriter.close();
    }

    public static void main(String[] args) {
        try {
            mergeCsvFiles(args);
            ordenar(list);
            salvarArq(list);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidParameterException e) {
            e.printStackTrace();
        }
    }

    public static void ordenar(List<Info> list) {
        Collections.sort(list);
    }
}