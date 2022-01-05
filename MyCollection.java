import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyCollection {
	//ArrayList
	
   public static void main(String[] args) {

	MyHastSet();
	MyHashMap()	;
	MyLinkedlist();

    }
	
	private static void MyHashMap() {
		
		HashMap<Integer,String> myMap = new HashMap<Integer,String>();
		myMap.put(1,"Nav");
		myMap.put(2,"Rad");
		myMap.put(1,"Nav");
		myMap.put(null,null);
		System.out.println("My HashMap values are: "+ myMap);
		
		if(myMap.containsValue("Test"))
		{
			System.out.print("Test value found");
		}
		
		List<String> mapvalues = new ArrayList<String> (myMap.values());
		System.out.println("The Listmap values are:"+mapvalues);
		myMap.remove(1);
		System.out.println("After removal from HashMap: " + myMap);
		
	}


	private static void MyHastSet() {
		
		Set<String> mySet = new HashSet<String>();
		mySet.add("Nav");
		mySet.add("Sun");
		mySet.add("Mom");
		mySet.add("Nav");
		mySet.add(null);
		System.out.println("My HashSet values are: " + mySet);
       
	}	

    private static void MyLinkedlist() {
    	
		List<String> linkedls = new LinkedList<String>();
		linkedls.add("LSun");
		linkedls.add("LMon");
		linkedls.add("LTues");
		Iterator<String> itr = linkedls.iterator();
		System.out.print("My LinkedList values are: ");
		while(itr.hasNext()) {
			System.out.print(itr.next()+",");
	    }
   
    }

}



