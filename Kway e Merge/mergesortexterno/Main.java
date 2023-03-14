package mergesortexterno;
import java.util.ArrayList;

public class Main{
	public static void main(String [] args) throws Exception { 
		MergeSortExterno merge=new MergeSortExterno();
		ArrayList<Integer> list=merge.separa("utils/AgendaTeste1M.csv");
		while (list.size()>1){
			ArrayList<Integer> proxlist=new ArrayList<>(); 
			for (int i=0;i<list.size()-1;i+=2)
				proxlist.add(merge.merge(list.get(i), list.get(i+1))); 
			if (list.size()%2!=0) 
				proxlist.add(list.get(list.size()-1));
			list=proxlist;
		}
	}
}