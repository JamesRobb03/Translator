/**
 * 
 */

/**
 * @author Harry Finch, James Robb
 *
 */
public class TreeNode {
	
    TreeNode left;
    TreeNode right;
   
    int id;
    String letter;
    List list;

    TreeNode(int id,String letter ,List list)
    {
        this.id = id;
        this.list = list;
        this.letter = letter;
        left = null;
        right = null;
    }
    
    public String data() {
    	String data = ""+id;
    	//String data = id +" "+ name+" "+ cost; 
    	return data;
    }
    
    public void printNode() 
    {
    	list.printList();
    }
    
}
