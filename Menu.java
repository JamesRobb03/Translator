import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Menu {
	/**
	 * 
	 * @param args
	 */
	Scanner s;
	Tree testTree;
	List listA, listB, listC, listD, listE, listF, listG, listH, listI, listJ, listK, listL, listM,listN,listO,listP,listQ,listR,listS,listT,listU,listV,listW,listX,listY,listZ;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu test = new Menu();
		test.init();
		test.runTest();
	}
	
	private void init(){
		testTree=new Tree();
		listA = new List();
		listB = new List();
		listC = new List();
		listD = new List();
		listE = new List();
		listF = new List();
		listG = new List();
		listH = new List();
		listI = new List();
		listJ = new List();
		listK = new List();
		listL = new List();
		listM = new List();
		listN = new List();
		listO = new List();
		listP = new List();
		listQ = new List();
		listR = new List();
		listS = new List();
		listT = new List();
		listU = new List();
		listV = new List();
		listW = new List();
		listX = new List();
		listY = new List();
		listZ = new List();
		
		s = new Scanner(System.in);
	}
	
	public void translate() {
		String input;
		int id;
		String[] transInput_li;
		do {
		System.out.println("Please enter what you would like to translate");
		input = s.nextLine();
		transInput_li = input.split(" ");
		for(String transInput:transInput_li) {
			id = getID(transInput.substring(0, 1));
			System.out.print(testTree.translate(id, transInput)+" ");
		}
		System.out.println("");
		System.out.println("");
		}while(input!="exit");
		
		
	}
	public int getID(String letter) {
		int id = 0;
		switch(letter) {
			case "a":
				id = 1;
				break;
			case "b":
				id = 2;
				break;
			case "c":
				id = 3;
				break;		
			case "d":
				id = 4;
				break;
			case "e":
				id = 5;
				break;
			case "f":
				id = 6;
				break;
			case "g":
				id = 7;
				break;
			case "h":
				id = 8;
				break;
			case "i":
				id = 9;
				break;
			case "j":
				id = 10;
				break;
			case "k":
				id = 11;
				break;
			case "l":
				id = 12;
				break;		
			case "m":
				id = 13;
				break;
			case "n":
				id = 14;
				break;
			case "o":
				id = 15;
				break;
			case "p":
				id = 16;
				break;
			case "q":
				id = 17;
				break;
			case "r":
				id = 18;
				break;
			case "s":
				id = 19;
				break;
			case "t":
				id = 20;
				break;
			case "u":
				id = 21;
				break;		
			case "v":
				id = 22;
				break;
			case "w":
				id = 23;
				break;
			case "x":
				id = 24;
				break;
			case "y":
				id = 25;
				break;
			case "z":
				id = 26;
				break;
		}
		return id;
	}
	private void runTest() {
		
		testTree.insert(13, "m",listM);
		testTree.insert(6, "f",listF);
		testTree.insert(3, "c",listC);
		testTree.insert(1, "a",listA);
		testTree.insert(2, "b",listB);
		testTree.insert(9, "i",listI);
		testTree.insert(11, "k",listK);
		testTree.insert(10, "j",listJ);
		testTree.insert(12, "l",listL);
		testTree.insert(20, "t",listT);
		testTree.insert(23, "w",listW);
		testTree.insert(25, "y",listY);
		testTree.insert(26, "z",listZ);
		testTree.insert(24, "x",listX);
		testTree.insert(21, "u",listU);
		testTree.insert(22, "v",listV);
		testTree.insert(17, "q",listQ);
		testTree.insert(15, "o",listO);
		testTree.insert(14, "n",listN);
		testTree.insert(16, "p",listP);
		
		testTree.showTree();
	
	}
	
	

}

//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26