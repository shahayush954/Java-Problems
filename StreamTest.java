import java.util.*;
import java.util.stream.Collectors;

public class StreamTest{
	public static void main(String[]args){
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(0);
		l1.add(5); 
		l1.add(10);
		l1.add(15);
		l1.add(20);

		//List<Integer> l2 = l1.stream().filter(i->i%2==0).collect(Collectors.toList());
		List<Integer> l2 = l1.stream().map(i->i+5).collect(Collectors.toList());

		System.out.println(l2);
		
	}
}