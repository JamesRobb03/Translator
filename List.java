import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Lab 1
 * 
 * @author AC12001 Team
 * @version January 2018
 */
public class List 
{
    private ListNode head;
    
    /**
     * Constructor for objects of class List
     * Create a head
     */
    public List()
    {
        head = null;
    }

     /**
     * Add a new node at the start of a list
     * 
     * @param student Student name or ID
     * @param mark Student mark  
     */
    public void addToList(String english, String spanish)
    {
        ListNode  newOne;
        
        newOne = new ListNode(english, spanish);        
        newOne.setNext(head);
        
        head = newOne;
    }
    
public void openFile() {
		
		String filename = "english.txt";
		String filename2 = "spanish.txt";
		FileReader fileReader = null;
		FileReader fileReader2 = null;
        BufferedReader bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        String nextLine;
        String nextLine2;
        String temp;
		
		try
        {
            fileReader = new FileReader(filename);
            fileReader2 = new FileReader(filename2);

            bufferedReader = new BufferedReader(fileReader);
            bufferedReader2 = new BufferedReader(fileReader2);

            nextLine = bufferedReader.readLine();
            nextLine2 = bufferedReader2.readLine();

            while (nextLine != null)
            {
            	temp = nextLine+":"+nextLine2;
                System.out.println(temp);
                nextLine = bufferedReader.readLine();
                nextLine2 = bufferedReader2.readLine();
            }
            
            bufferedReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Sorry, your file was not found.");
        }
        catch (IOException e)
        {
            System.out.println("Sorry, there has been a problem opening or reading from the file");
        }
	}
 
    /**
     * Print the list, starting at head
     */
     public void printList()
     {
        ListNode marker;

        if (head == null)
        {
        	System.out.println("The list is empty.");  
        }
        else
        {
	        System.out.println("The list contains:");    
	        for (marker = head; marker != null; marker=marker.getNext())
	        {
	              System.out.println(marker.printInfo());  
	        }
        }
    }

     public String spanishFromNode(ListNode foundNode) {
    	 String spanish = foundNode.getSpanish();
    	 return spanish;
     }
   /**
     * Find a node
     * 
     * @param  student Student to find
     * @return node if found, else null
     */
     public ListNode findInList(String english)
    {
        ListNode marker, foundNode=null;

        
        for (marker = head; marker != null && foundNode == null; marker=marker.getNext())
        {
            if (english.equals(marker.getEnglish()))
            {
            	foundNode = marker;
      
            }
        }

         return foundNode;  
    }
}
