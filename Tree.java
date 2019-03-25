import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	     * Deletes a node from the tree
	     * @param root - current node
	     * @param id - id to be deleted
	     * @return - new node in place of deleted one
	     */
	    private TreeNode deleteRecursive(TreeNode root,int id)
	    {
	        //If tree is empty - do nothing
	        if(root==null) return root;
	       
	        //If not, go through tree
	        if(id<root.id)
	        {
	            root.left = deleteRecursive(root.left, id);
	        }
	        else if(id>root.id)
	        {
	            root.right = deleteRecursive(root.right,id);
	        }
	        //if id is same as roots id then that is the one to be deleted
	        else
	        {
	            //node with one or no leaf
	            if(root.left == null)
	            {
	                return root.right;
	            }
	            else if(root.right == null)
	            {
	                return root.left;
	            }
	            //node with 2 leaves
	            root.id = minValue(root.right);
	           
	            root.right = deleteRecursive(root.right,root.id);
	        }
	        return root;
	    }
	    /**
	     * calls the recursive method
	     * @param id - id to be deleted
	     */
	    public void delete(int id)
	    {
	        root = deleteRecursive(root,id);
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
	  
	  
	  public String translate(int id, String english) {
		  String spanish;
		  TreeNode current = search(id);
		  ListNode node = current.list.findInList(english);
		  spanish = current.list.spanishFromNode(node);
		  return spanish;
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
	        int temp;
			
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
	            	temp = Menu.getID(nextLine.substring(0, 1));
	            	TreeNode current = search(temp);
	            	current.list.addToList(nextLine, nextLine2);
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
	 

	  
}
