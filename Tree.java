import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class Tree {
	 TreeNode root;
	 int indent;
	    /**
	     * Returns a node to be inserted into the tree
	     * @param current - current node
	     * @param id - user chosen id
	     * @param name- user chosen name
	     * @param cost- user chosen cost
	     * @return - node to be inserted
	     */
	    private TreeNode recursiveInsert(TreeNode current, int id, String letter, List name)
	    {  
	        if(current == null)
	        {
	            return new TreeNode(id,letter,name);
	        }
	       
	        if(id<current.id)
	        {
	            current.left = recursiveInsert(current.left, id,letter,name);
	        }
	        else if(id > current.id)
	        {
	            current.right = recursiveInsert(current.right,id,letter,name);
	        }
	        else
	        {
	            return current;
	        }
	       
	        return current;
	    }
	    /**
	     * Inserts the node into the tree
	     * @param id - user chosen id
	     * @param name - user chosen name
	     * @param cost - user chosen cost
	     */
	    public void insert(int id, String letter, List name)
	    {
	        root = recursiveInsert(root, id,letter,name);
	    }
	    /**
	     * Finds lowest number in tree
	     * @param root current node
	     * @return int minVal
	     */
	    int minValue(TreeNode root)
	    {
	        int minVal = root.id;
	        while (root.left != null)
	        {
	            minVal = root.left.id;
	            root = root.left;
	        }
	        return minVal;
	    }
	    /**
	     * Finds highest number in the tree.
	     * @param root -  the current node
	     * @return int maxVal
	     */
	    int maxValue(TreeNode root)
	    {
	        int maxVal = root.id;
	        while (root.right != null)
	        {
	            maxVal = root.right.id;
	            root = root.right;
	        }
	        return maxVal;
	    }
	   
	    /**
	     * Uses recursion to check if node with that id is in the BT
	     * @param current -  the current node
	     * @param id - unique ID of the node
	     * @return - True/False
	     */
	    private boolean findNodeRecursive(TreeNode current, int id)
	    {
	        if (current == null)
	        {
	            return false;
	        }
	        if (id == current.id)
	        {
	            return true;
	        }
	        return id < current.id
	                ? findNodeRecursive(current.left, id)
	                : findNodeRecursive(current.right, id);
	    }
	    /**
	     * Calls the recursive method - neater this way
	     * @param id - ID to be searched
	     * @return true/false
	     */
	    public boolean findNode(int id)
	    {
	        return findNodeRecursive(root, id);
	    }
	   
	    /**
	     * adds all the costs in the tree
	     * @param root current node
	     * @return the total cost (INT)
	     */
	    
	    /**
	     * boolean for whether or not the node exists in the tree
	     * @param node
	     * @param val
	     */
	    public void findNode(TreeNode node, int val)
	    {
	        boolean flag = false;
	       
	        while(flag == false)
	        {
	            if (node != null)
	            {
	                findNode(node.left,val);
	                if(node.id == val)
	                {
	                    System.out.println("Item found: "+node.id);
	                    flag = true;
	                }
	                findNode(node.right,val);
	            }
	        }
	       
	    }
	    /**
	     * Searches for a specific item in the tree
	     * @param current - current node
	     * @param id - id to be searched for
	     * @return the node
	     */
	    public TreeNode search(int id) {
	    	TreeNode current = search(root, id);
	    	return current;
	    }
	    public TreeNode search(TreeNode current, int id)
	    {
	        while(current != null) {
	        	if(current.id == id) {
	        		return current;
	        	}else if(current.id>id) {
	        		current = current.left;
	        	}else {
	        		current = current.right;
	        	}
	        }return null;
	    }
	    
	    /**
	     * ShowTree - print the tree on its side (provided by Ramanee)
	     *  
	     * @param       none
	     * @return      none
	     */
	    public void showTree()
	    {
	        indent = 0; // needs to be added as an instance variable
	        displayTree(root);

	   }


	  public void displayTree(TreeNode p)
	    {
	      int i;

	        if (p != null)
	        {
	           indent += 6;
	           displayTree(p.right);

	           for (i=6; i<indent; i=i+6)
	              System.out.print ("\t");
	              
	              
	            System.out.println("      " + p.data());

	            displayTree(p.left);

	            indent -= 6;
	         }
	     }
	  
	  /**
	   * 
	   * @param id the id of the first letter of the word
	   * @param english the English word to be translated
	   * @return returns the Spanish word that corresponds with the English word
	   */
	  public String translateEng(int id, String english) {
		  String spanish;
		  TreeNode current = search(id);
		  ListNode node = current.list.findEnglishInList(english);
		  spanish = current.list.spanishFromNode(node);
		  return spanish;
	  }
	  public String translateSpa(int id, String spanish) {
		  String english;
		  TreeNode current = search(id);
		  ListNode node = current.list.findSpanishInList(spanish);
		  english = current.list.englishFromNode(node);
		  return english;
	  }
	  
	  public void openFile(String lang1, String lang2) {
			
			String filename = lang1;
			String filename2 = lang2;
			FileReader fileReader = null;
			FileReader fileReader2 = null;
	        BufferedReader bufferedReader = null;
	        BufferedReader bufferedReader2 = null;
	        String nextLine;
	        String nextLine2;
	        int temp;
			
			try
	        {
	            fileReader = new FileReader(filename);
	            fileReader2 = new FileReader(filename2);

	            bufferedReader = new BufferedReader(fileReader);
	            bufferedReader2 = new BufferedReader(fileReader2);

	            nextLine = bufferedReader.readLine();
	            nextLine2 = bufferedReader2.readLine();
	            nextLine = StringUtils.stripAccents(nextLine);

	            while (nextLine != null)
	            {
	            	temp = Menu.getID(nextLine.substring(0, 1));
	            	TreeNode current = search(temp);
	            	current.list.addToList(nextLine, nextLine2);
	                nextLine = bufferedReader.readLine();
	                nextLine = StringUtils.stripAccents(nextLine);
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


	  
}
