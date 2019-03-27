/**
 * 
 */

/**
 * @author James Robb
 *
 */
public class TreeNode {
	//Instance variables
    TreeNode left;
    TreeNode right;
   
    int id;
    String letter;
    List list;
    
    /**
     * 
     * @param id the id of the treenode
     * @param letter the letter in which the tree node contains
     * @param list the list which corresponds to the appropriate letters
     */
    TreeNode(int id,String letter ,List list)
    {
        this.id = id;
        this.list = list;
        this.letter = letter;
        left = null;
        right = null;
    }
    
    /**
     * contains data for the tree ID for the show tree method
     * @return returns the string containing the id of the tree.
     */
    public String data() {
    	String data = ""+id; 
    	return data;
    }
    
    
    
}
