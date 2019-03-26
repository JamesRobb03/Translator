
/**
 * 

 * @author James Robb
 * 

 */
public class ListNode    
{
    // instance variables
    private String english;
    private String spanish;
    private ListNode next;

    /**
     * Constructor for objects of class List
     * @param  
     */
    public ListNode(String english, String spanish)
    {
        // initialise instance variables
        this.english = english;
        this.spanish = spanish;
        this.next = null;
    }
    

     /**
     * Set the next node
     * 
     * @param  the node to be added at this node's next
     */
    public void setNext(ListNode next)
    {
        this.next = next;
    }
    public ListNode getNext() {
    	return next;
    }
    
     /**
     * Return a string containing the data from this node, formatted
     */
    public String printInfo()
    {
        String info;
        
        info = "English "+ english+", Spanish "+spanish;
        
        return info;
    }


	/**
	 * @return the english
	 */
	public String getEnglish() {
		return english;
	}


	/**
	 * @param english the english to set
	 */
	public void setEnglish(String english) {
		this.english = english;
	}


	/**
	 * @return the spanish
	 */
	public String getSpanish() {
		return spanish;
	}


	/**
	 * @param spanish the spanish to set
	 */
	public void setSpanish(String spanish) {
		this.spanish = spanish;
	}
}
