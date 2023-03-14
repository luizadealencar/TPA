package parte2;
import java.util.Scanner;

public class Input{
	private static Scanner s=new Scanner(System.in);

	public static Boolean hasNextLine(){
		return s.hasNextLine();
	}

	public static String nextLine(){
		return s.nextLine();
	}
	
	public static Boolean hasNextInt(){
		return s.hasNextInt();
	}

	public static int nextInt(){
		return s.nextInt();
	}

	public static void close(){
		s.close();
	}
}
