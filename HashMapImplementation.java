import java.util.*;

public class HashMapImplementation{
	
	public static void main(String[]args){

		HashMap<Integer,String> mp = new HashMap<Integer,String>();

		mp.put(106,"Jimit");
		mp.put(107,"Meet");
		mp.put(108,"Bhavya");
		mp.put(109,"Ayush");
		mp.put(110,"Tanish");

		/*
		Set st = mp.entrySet();
		Iterator itr = st.iterator();

		while(itr.hasNext()){
			Map.Entry me = (Map.Entry)itr.next();
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}

		//System.out.println(mp); 
		*/

		if(mp.containsKey(106)){
			String obj = (String)mp.get(106);
			obj = obj + "Shah";
			mp.put(106,obj);
		}
		System.out.println(mp); 
	}
}