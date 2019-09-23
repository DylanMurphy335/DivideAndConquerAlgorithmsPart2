package Part2;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {

	//----------------------------------------------
	// Class constructor
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		int scenario = 0; 
		
		if (m.length() == 0) 
			scenario = 1;
		else
			scenario = 2;

		switch(scenario){	
				
		case 1: 
			System.out.println("Empty MyList");
			
			break;
			
		case 2: 
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			break;
		}
	}

	//-------------------------------------------------------------------
	// 1. recursiveDisplayElements --> Displays all elements of a MyList  
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this recursive algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void recursiveDisplayElements(MyList<Integer> m){
		int scenario = 0; 
		if (m.length() == 0) { scenario = 1; }
		else { scenario = 2; }

		switch(scenario){	
		case 1: 
			System.out.println();
			break;
					
		case 2: 
			int e0 = m.getElement(0);
			m.removeElement(0);
			System.out.print(e0 + " ");
			recursiveDisplayElements(m);
			m.addElement(0, e0);
			break;
		}	
	}

	//-------------------------------------------------------------------
	// 2. smallerMyList --> Filters all elements in MyList smaller than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being smaller than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being smaller than 'e'  
	 */	
	public MyList<Integer> smallerMyList(MyList<Integer> m, int e){
	MyList<Integer> res = null;
		int scenario = 0;
		
		if (m.length() < 1) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		switch(scenario){	
		case 1:
			res = new MyDynamicList<Integer>();
			break;
			
		case 2:
			int e0 = m.getElement(0);
			m.removeElement(0);
			res = smallerMyList(m, e);
			if (e0 < e) {
				res.addElement(0, e0);; 
			}
			m.addElement(0, e0);
			break;
		}	
		return res;	
	}

	//-------------------------------------------------------------------
	// 3. biggerMyList --> Filters all elements in MyList bigger than e
	//-------------------------------------------------------------------	
	/**
	 * The function filters all elements of MyList being bigger than 'e'  
	 * @param m: The MyList we want to check.
	 * @param e: The number 'e' we want to compare each element of MyList to.
	 * @return: The new MyList containing just the elements being bigger or equal than 'e'  
	 */	
	public MyList<Integer> biggerEqualMyList(MyList<Integer> m, int e){
		MyList<Integer> res = null;
		int scenario = 0;
		
		if (m.length() < 1) {
			scenario = 1;
		}
		else {
			scenario = 2;
		}
		switch(scenario){	
		case 1:
			res = new MyDynamicList<Integer>();
			break;
			
		case 2:
			int e0 = m.getElement(0);
			m.removeElement(0);
			res = biggerEqualMyList(m, e);
			if (e0 >= e) {
				res.addElement(0, e0);
			}
			m.addElement(0, e0);
			
			break;
			
		}	
		return res;	
	}
		
	//-------------------------------------------------------------------
	// 3. concatenate --> It concatenates 2 MyList   
	//-------------------------------------------------------------------	
	/**
	 * The function concatenates the content of 2 MyList.   
	 * @param m1: The first MyList.
	 * @param m2: The second MyList.
	 * @return: The new MyList resulting of concatenate the other 2 MyList
	 */	
	public MyList<Integer> concatenate(MyList<Integer> m1, MyList<Integer> m2){
		MyList<Integer> res = null;
		int scenario = 0;
		if (m1.length() == 0 && m2.length() == 0) { scenario = 1; }
		else { scenario = 2; }
		
		switch(scenario){	
		case 1:
			res = new MyDynamicList<Integer>();
			break;
			
		case 2:
			res = new MyDynamicList<Integer>();
			if (m1.length() > res.length()) {
				int e0 = m1.getElement(0);
				m1.removeElement(0);
				res = concatenate(m1, m2);
				res.addElement(0, e0);
				m1.addElement(0, e0);
			} else {
				int e0 = m2.getElement(0);
				m2.removeElement(0);
				res = concatenate(m1, m2);
				res.addElement(0, e0);
				m2.addElement(0, e0);
			}
			break;
		}
		return res;	
	}
	
	//-------------------------------------------------------------------
	// 4. quickSort --> Sort a MyList using the method quick sort
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it computes a new sorted list using the method Quick Sort.
	 * @param m: The MyList we want to sort.
	 * @return: The new MyList being sorted.	  	  
	 */	  
	public MyList<Integer> quickSort(MyList<Integer> m){
		//recursiveDisplayElements(m);
		MyList<Integer> res = null;
		int scenario = 0; 
		if (m.length() <= 0) {
			scenario = 1;
		} else if (m.length() == 1) {
			scenario = 2;
		}else {
			scenario = 3;
		}
		
		switch(scenario){	
		case 1:
			res = new MyDynamicList<Integer>();
			break;
		
		case 2:
			res = new MyDynamicList<Integer>();
			res.addElement(0, m.getElement(0));
			break;
			
		case 3:
			res = new MyDynamicList<Integer>();
			int pivot = m.getElement(m.length()-1);
			m.removeElement(m.length()-1);
			MyList<Integer> m1 = smallerMyList(m, pivot);
			MyList<Integer> m2 = biggerEqualMyList(m, pivot);
			m.addElement(m.length(), pivot);
			m1 = quickSort(m1);
			m1.addElement(m1.length(), pivot);
			m2 = quickSort(m2);
			res = concatenate(m1, m2);
			//break;
		}
		return res;		
	}	
}