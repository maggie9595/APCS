//Maggie Yu

import java.util.*;

public class Decoder
{	
    public static void main(String[] args) throws java.io.IOException
    {	
        BinaryTreeNode<Character> node = buildTree();
		decode(node);
    }
    
    //Build and store the Huffman code tree from the code tree representation.
    public static BinaryTreeNode<Character> buildTree() throws java.io.IOException
    {
		char currentCharacter = (char)System.in.read();

	    //If the current character does not represent a leaf, create a binary tree node for it and build its left and right subtrees recursively.
	    if(currentCharacter == '0')
	    {
	        BinaryTreeNode<Character> node = new BinaryTreeNode<Character>();
	        node.setLeftChild(buildTree());
	        node.setRightChild(buildTree());	        
	        return node;
	    }  
	    //If the current character represents a leaf, create a binary tree node and store the appropriate character into the node.  
	    else
	        return new BinaryTreeNode<Character>((char)System.in.read());     
    }
    
    //Decode the message using a Huffman code tree.
    public static void decode(BinaryTreeNode<Character> root) throws java.io.IOException
    {
		int currentCharacter = System.in.read();
		BinaryTreeNode<Character> currentNode = root;
		
		while(currentCharacter != -1)
		{
		    if((char)currentCharacter == '0')
			    currentNode = currentNode.getLeftChild();
		    else if((char)currentCharacter == '1')
			    currentNode = currentNode.getRightChild();
		    
		    //If the current node has no left child, it can't have a right child either. Therefore, it is a leaf, so print out the character stored
		    //in that node and reset the current node pointer so the next character can be decoded from the root of the Huffman code tree.
		    if(currentNode.getLeftChild() == null)
		    {
			    System.out.print(currentNode.getData());
		        currentNode = root;
		    }    
		    
		    //Read in the next character from the input message.
		    currentCharacter = System.in.read();
		}
    }   
}
