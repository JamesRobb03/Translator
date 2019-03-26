import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
public class Menu {
	/**
	 * 
	 * @param args
	 */
	Scanner s;
	Tree englishTree;
	Tree spanishTree;
	List listA, listB, listC, listD, listE, listF, listG, listH, listI, listJ, listK, listL, listM,listN,listO,listP,listQ,listR,listS,listT,listU,listV,listW,listX,listY,listZ;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Menu test = new Menu();
		test.init();
		test.englishToSpanish("jump");
		test.spanishToEnglish("fregona");
	}
	
	private void init(){
		englishTree=new Tree();
		spanishTree=new Tree();
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
	

	public void translateEnglish(String string) {
		String input;
		int id;
		String[] transInput_li;
		input = string;

		input = input.toLowerCase();
		transInput_li = input.split(" ");
		for(String transInput:transInput_li) {
			id = getID(transInput.substring(0, 1));
			try {

			System.out.print(englishTree.translateEng(id, transInput)+" ");
			output = output + " " +englishTree.translateEng(id, transInput);
        
			}catch(Exception e){
				System.out.print(transInput+" ");
			}
			return outpout;
		}

		System.out.println("");
		System.out.println("");
	}
	
	public void translateSpanish(String string) {
		String input;
		int id;
		String[] transInput_li;
		input = string;
		input = input.toLowerCase();
		transInput_li = input.split(" ");
		for(String transInput:transInput_li) {
			id = getID(transInput.substring(0, 1));
			try {
			System.out.print(spanishTree.translateSpa(id, transInput)+" ");
      output = output + " " +spanishTree.translateSpa(id, transInput);
			}catch(Exception e){
				System.out.print(transInput+" ");
			}
		}
		System.out.println("");
		System.out.println("");
		return output;

	}
  
	public static int getID(String letter) {
		int id = 0;
		switch(letter) {
			case "a":
			case "A":
				id = 1;
				break;
			case "b":
			case "B":
				id = 2;
				break;
			case "c":
			case "C":
				id = 3;
				break;		
			case "d":
			case "D":
				id = 4;
				break;
			case "e":
			case "E":
				id = 5;
				break;
			case "f":
			case "F":
				id = 6;
				break;
			case "g":
			case "G":
				id = 7;
				break;
			case "h":
			case "H":
				id = 8;
				break;
			case "i":
			case "I":
				id = 9;
				break;
			case "j":
			case "J":
				id = 10;
				break;
			case "k":
			case "K":
				id = 11;
				break;
			case "l":
			case "L":
				id = 12;
				break;		
			case "m":
			case "M":
				id = 13;
				break;
			case "n":
			case "N":
				id = 14;
				break;
			case "o":
			case "O":
				id = 15;
				break;
			case "p":
			case "P":
				id = 16;
				break;
			case "q":
			case "Q":
				id = 17;
				break;
			case "r":
			case "R":
				id = 18;
				break;
			case "s":
			case "S":
				id = 19;
				break;
			case "t":
			case "T":
				id = 20;
				break;
			case "u":
			case "U":
				id = 21;
				break;		
			case "v":
			case "V":
				id = 22;
				break;
			case "w":
			case "W":
				id = 23;
				break;
			case "x":
			case "X":
				id = 24;
				break;
			case "y":
			case "Y":
				id = 25;
				break;
			case "z":
			case "Z":
				id = 26;
				break;
		}
		return id;
	}

	private String englishToSpanish(String string) {

		
		englishTree.insert(13, "m",listM);
		englishTree.insert(6, "f",listF);
		englishTree.insert(3, "c",listC);
		englishTree.insert(1, "a",listA);
		englishTree.insert(2, "b",listB);
		englishTree.insert(4,"d", listD);
		englishTree.insert(5,"e", listE);
		englishTree.insert(9, "i",listI);
		englishTree.insert(7,"g", listG);
		englishTree.insert(8,"h", listH);
		englishTree.insert(11, "k",listK);
		englishTree.insert(10, "j",listJ);
		englishTree.insert(12, "l",listL);
		englishTree.insert(20, "t",listT);
		englishTree.insert(23, "w",listW);
		englishTree.insert(25, "y",listY);
		englishTree.insert(26, "z",listZ);
		englishTree.insert(24, "x",listX);
		englishTree.insert(21, "u",listU);
		englishTree.insert(22, "v",listV);
		englishTree.insert(17, "q",listQ);
		englishTree.insert(18,"r", listR);
		englishTree.insert(19,"s", listS);
		englishTree.insert(15, "o",listO);
		englishTree.insert(14, "n",listN);
		englishTree.insert(16, "p",listP);
		
		englishTree.showTree();
		//adds words from file into linked lists
		englishTree.openFile("english.txt", "spanish.txt");
		//runs the translate option that allows users to translate a word

		return translateEnglish(string);
	}

	
	private void spanishToEnglish(String string) {
		
		spanishTree.insert(13, "m",listM);
		spanishTree.insert(6, "f",listF);
		spanishTree.insert(3, "c",listC);
		spanishTree.insert(1, "a",listA);
		spanishTree.insert(2, "b",listB);
		spanishTree.insert(4,"d", listD);
		spanishTree.insert(5,"e", listE);
		spanishTree.insert(9, "i",listI);
		spanishTree.insert(7,"g", listG);
		spanishTree.insert(8,"h", listH);
		spanishTree.insert(11, "k",listK);
		spanishTree.insert(10, "j",listJ);
		spanishTree.insert(12, "l",listL);
		spanishTree.insert(20, "t",listT);
		spanishTree.insert(23, "w",listW);
		spanishTree.insert(25, "y",listY);
		spanishTree.insert(26, "z",listZ);
		spanishTree.insert(24, "x",listX);
		spanishTree.insert(21, "u",listU);
		spanishTree.insert(22, "v",listV);
		spanishTree.insert(17, "q",listQ);
		spanishTree.insert(18,"r", listR);
		spanishTree.insert(19,"s", listS);
		spanishTree.insert(15, "o",listO);
		spanishTree.insert(14, "n",listN);
		spanishTree.insert(16, "p",listP);
		
		//testTree.showTree();
		//adds words from file into linked lists
		spanishTree.openFile("spanish.txt", "english.txt");
		//runs the translate option that allows users to translate a word
		translateSpanish(string);
	}

	public String readFile(String inputFilePath) {

		FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String fileName;
        String input;
        //Line will be split by spaces into individual words.
        String nextLine;
        int wordNumber = 0;
        String word;
        int lineNumber = -1;
        //Asking user to input file name
        fileName = inputFilePath;
        String translatedFile = "";
        
        try {
        	System.out.println(fileName);
        	fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader); 
            nextLine = bufferedReader.readLine();
            while (nextLine != null)
            {
            	lineNumber++;
            	//Code to split and store into array
            	String[] words = nextLine.split("\\s+");
            	
            	//Removing punctuation from words
            	//Removing non lower case letters
            	for(int e = 0; e <= (words.length - 1); e++) {           		
            		words[e] = words[e].replaceAll("[^a-zA-Z0-9]", "");
            		words[e] = words[e].toLowerCase();
            	}
            	
            	String[] transWords = new String[words.length];
            	//int i = 0; i < words.length; i++
            	for(int i = 0; i < words.length; i++) {
            		int idOfWord;
            		//Set translation to word[i] after being put in translator
            		//Firstly get id for word which stands for its first letter
            		//Secondly give it the english word as a string
            		
                	if(isNumeric(words[i]) == false) {
                		 //Code must be located here which translate words[i] to spanish then places in transWords[i]:
                	    try {
                	    	idOfWord = getID(words[i].substring(0, 1));
                	    	System.out.print(idOfWord + " ");
                	    	transWords[i] = englishTree.translateEng(idOfWord, words[i]);
                		}catch(Exception e1){
                				transWords[i] = words[i];
                			} 
                	}
                	else {
                		transWords[i] = words[i];
                	}
            	}
            	
         
            	System.out.println();
            	System.out.println("length of line: " + transWords.length);
            	String fullLine = "";
            	for(int i = 0; i < transWords.length; i++) {
            		if(i == 0) {
            			fullLine = transWords[i];
            			translatedFile = translatedFile+transWords[i];
            		}
            		else {
            			fullLine = (fullLine + " " + transWords[i]);
            			translatedFile = translatedFile+" "+transWords[i];
            		}            	    
            		
            		if (i == 0) {
            			System.out.print(transWords[i]);
            		}
            		else {
            			System.out.print(" " + transWords[i]);
            		}
            	}
            	//Writing line to file
            	writeToFile(lineNumber, fullLine);
            	System.out.println();
                nextLine = bufferedReader.readLine();
                return translatedFile;
            }       
            bufferedReader.close();
            }
            catch (FileNotFoundException e)
            {
                return("File to be translated could not be found!");
            }
            catch (IOException e)
           {
                return("An error occured when opening and reading the file to be translated!");
           }
		return translatedFile;	
	    }
	
      public void writeToFile(int lineNumber, String text) {
        text = text + System.lineSeparator();
        if(lineNumber == 0) {
          try {
            PrintWriter writer = new PrintWriter("translation.txt", "UTF-8");
            try {
                Files.write(Paths.get("translation.txt"), text.getBytes(), StandardOpenOption.APPEND);
            }catch (IOException e) {
                System.out.println("Unable to add text to new translation text file!");
            }
          }
          catch (Exception e){
            System.out.println("File could not be created!");
          }
        }
        else {
          try {
              Files.write(Paths.get("translation.txt"), text.getBytes(), StandardOpenOption.APPEND);

          }catch (IOException e) {
            System.out.println("Unable to add text to translation text file!");
          }
        }		
      }

	
	public static boolean isNumeric(String str)
	{
	    for (char c : str.toCharArray())
	    {
	        if (!Character.isDigit(c)) return false;
	    }
	    return true;
	}
	
	

}

//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26