import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	List listA, listB, listC, listD, listE, 
	listF, listG, listH, listI, listJ, listK, listL, listM,listN,
	listO,listP,listQ,listR,listS,listT,listU,listV,listW,listX,listY,listZ;
	public void init(){
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
	

	public String translateEnglish(String string) {
		String input;
		int id;
		String[] transInput_li;
		input = string;
		input = input.toLowerCase();
		transInput_li = input.split(" ");
		String output = " ";
		for(String transInput:transInput_li) {
			id = getID(transInput.substring(0, 1));
			try {

			System.out.print(englishTree.translateEng(id, transInput)+" ");
			output = output + " " +englishTree.translateEng(id, transInput);
        
			}catch(Exception e){
				System.out.print(transInput+" ");
			}
		
		}
		return output;
	}
	
	public String translateSpanish(String string) {
		String input;
		int id;
		String[] transInput_li;
		input = string;
		input = input.toLowerCase();
		transInput_li = input.split(" ");
		String output = " ";
		for(String transInput:transInput_li) {
			id = getID(transInput.substring(0, 1));
			try {
			System.out.print(spanishTree.translateSpa(id, transInput)+" ");
      output = output + " " +spanishTree.translateSpa(id, transInput);
			}catch(Exception e){
				System.out.print(transInput+" ");
			}
		}
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
	public String readFile(String inputFilePath, String originLang) {
		FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String fileName;
        String input;
        String nextLine;
        int wordNumber = 0;
        String word;
        int lineNumber = -1;
        fileName = inputFilePath;
        String translatedFile = "";
        
        try {
        	fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader); 
            nextLine = bufferedReader.readLine();
            
            //While there is a next line read current line
            while (nextLine != null)
            {
            	lineNumber++;
            	//Code to split line and store into array of strings
            	String[] words = nextLine.split("\\s+");
            	
            	//Removing punctuation from words
            	//Removing non lower case letters
            	for(int e = 0; e <= (words.length - 1); e++) {           		
            		words[e] = words[e].replaceAll("[^a-zA-Z0-9]", "");
            		words[e] = words[e].toLowerCase();
            	}
            	
            	//Creating new array to store translated words from current line
            	String[] transWords = new String[words.length];
            	
            	//For each word in the array translate and store into new array
            	for(int i = 0; i < words.length; i++) {
            		int idOfWord;
            		
            		//If the string is a number it will be ignored if not it is translated here
                	if(isNumeric(words[i]) == false) {
                		//A translation of the word is attempted, if failed it is left not translated
                	    try {
                	    	//Obtains ID of word for binary tree which is dictated by words first letter
                	    	idOfWord = getID(words[i].substring(0, 1));
                	    	//If the origin language is English a Spanish translation is attempted
                	    	if(originLang == "english") {
                	    		transWords[i] = englishTree.translateEng(idOfWord, words[i]);
                	    	}
                	    	//If the origin language is Spanish a English translation is attempted
                	    	else if(originLang == "spanish") {
                	    		transWords[i] = spanishTree.translateEng(idOfWord, words[i]);
                	    	}
                		}catch(Exception e1){
                				transWords[i] = words[i];
                			} 
                	}
                	else {
                		transWords[i] = words[i];
                	}
            	}
            	
            	//The array of now translated strings is recombined into a single string
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
            	translatedFile = translatedFile + fullLine;
                nextLine = bufferedReader.readLine();
            }       
            bufferedReader.close();
            return translatedFile;
            }
            catch (FileNotFoundException e)
            {
                return("File to be translated could not be found!");
            }
            catch (IOException e)
           {
                return("An error occured when opening and reading the file to be translated!");
           }
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
 public String englishToSpanish(String string) {
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
		
		//englishTree.showTree();
		//adds words from file into linked lists
		englishTree.openFile("C:\\Users\\Harrys-Laptop\\eclipse-workspace\\Translator\\src\\english.txt", "C:\\Users\\Harrys-Laptop\\eclipse-workspace\\Translator\\src\\spanish.txt");
		//runs the translate option that allows users to translate a word

		return translateEnglish(string);
	}

	
	public String spanishToEnglish(String string) {
		
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
		spanishTree.openFile("C:\\Users\\Harrys-Laptop\\eclipse-workspace\\Translator\\src\\spanish.txt", "C:\\Users\\Harrys-Laptop\\eclipse-workspace\\Translator\\src\\english.txt");
		//runs the translate option that allows users to translate a word
		return translateSpanish(string);
		
	}
	public void addToFile(String eng, String esp) 
	{
		FileOutputStream outputStream1 = null;
		FileOutputStream outputStream2 = null;
        PrintWriter printWriter1 = null;
        PrintWriter printWriter2 = null;
        String fileName1 = "C:\\Users\\Harrys-Laptop\\eclipse-workspace\\Translator\\src\\english.txt";
        String fileName2 = "C:\\Users\\Harrys-Laptop\\eclipse-workspace\\Translator\\src\\spanish.txt";
        boolean flag = false;
        String temp = null;
        Scanner s1 = new Scanner(System.in);
        try
        {
            outputStream1 = new FileOutputStream(fileName1, true);
            outputStream2 = new FileOutputStream(fileName2, true);
            printWriter1 = new PrintWriter(outputStream1);
            printWriter2 = new PrintWriter(outputStream2);
            printWriter1.println(eng);
            printWriter2.println(esp);
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or writing to the file");
            System.out.println("/t" + e);
        }
        finally
        {
        	printWriter1.close();
        	printWriter2.close();
        }
	}
	
	

}
	
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26