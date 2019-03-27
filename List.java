import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
/**
 * Lab 1
 * 
 * @author James Robb
 * 
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
     * @param english english string stored in listnode 
     * @param spanish spanish string stored in listnode
     */
    public void addToList(String english, String spanish)
    {
        ListNode  newOne;
        
        newOne = new ListNode(english, spanish);        
        newOne.setNext(head);
        
        head = newOne;
    }
    /**
     * method which gets the spanish word form the found english words node
     * @param foundNode the node in which the word is stored
     * @return returns the Spanish word from the found node.
     */
     public String spanishFromNode(ListNode foundNode) {
    	 String spanish = foundNode.getSpanish();
    	 return spanish;
     }
     /**
      * method which gets the english word from the found spanish words node
      * @param foundNode the node in which the word is stored
      * @return returns the English word from the found node
      */
     public String englishFromNode(ListNode foundNode) {
    	 String english = foundNode.getSpanish();
    	 return english;
     }
     
   /**
     * Finds the node that has the string 
     * 
     * @param  english english word to be found.
     * @return foundNode returns the node in which the english word was found
     */
     public ListNode findEnglishInList(String english)
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
     
     /**
      * 
      * @param spanish the word in spanish to be found
      * @return foundNode returns the node in which the Spanish word was found
      */
     public ListNode findSpanishInList(String spanish)
     {
         ListNode marker, foundNode=null;

         
         for (marker = head; marker != null && foundNode == null; marker=marker.getNext())
         {
             if (spanish.equals(marker.getEnglish()))
             {
             	foundNode = marker;
       
             }
         }

          return foundNode;  
     }
}