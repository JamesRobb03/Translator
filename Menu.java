import java.util.Scanner;

public class Menu {
	/**
	 * 
	 * @param args
	 */
	Scanner s;
	Tree testTree;
	List listA, listM, listZ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu test = new Menu();
		test.init();
		test.runTest();
	}
	
	private void init(){
		testTree=new Tree();
		listA = new List();
		listM = new List();
		listZ = new List();
		s = new Scanner(System.in);
	}
	
	public void translate() {
		String input;
		int id;
		String[] transInput_li;
		System.out.println("Please enter what you would like to translate");
		input = s.nextLine();
		transInput_li = input.split(" ");
		for(String transInput:transInput_li) {
			id = getID(transInput.substring(0, 1));
			System.out.print(testTree.translate(id, transInput)+" ");
		}
		
		
	}
	public int getID(String letter) {
		int id = 0;
		switch(letter) {
			case "a":
				id = 1;
				break;
			case "m":
				id = 13;
				break;
			case "z":
				id = 26;
				break;				
		}
		return id;
	}
	private void runTest() {
		listA.addToList("apples", "manzanas");
		listA.addToList("are","son");
		listA.addToList("autistic","autista");
		
		listM.addToList("money","dinero");
		
		listZ.addToList("zebra","cebra");
		
		testTree.insert(13, "m",listM);
		testTree.insert(1, "a",listA);
		testTree.insert(26, "z",listZ);
		
		testTree.showTree();
		
		translate();
	
	}
}

//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26