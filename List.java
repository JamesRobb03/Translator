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
