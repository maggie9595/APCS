//Maggie Yu

import java.util.*;

public class Encoder
{	       
    public static void main(String[] args) throws java.io.IOException
    {   		
        int[] frequencies = new int[256];	
        ArrayList<Character> input = new ArrayList<Character>();      
		int currentChar = System.in.read();
		
		//Create a frequency table to keep track of how many times each character appears in the input while storing all of the characters separately.
	    while(currentChar != -1)
		{
			frequencies[currentChar]++;
		    input.add((char)currentChar);
			currentChar = System.in.read();
        }
        
        //Build the Huffman code tree using the frequency table.
        ComparableBinaryTreeNode<CharFreq> node = buildTree(frequencies);
		    	
    	//Build the code table containing the path to every character in the tree.
    	String[] codeTable = new String[256];
    	buildCodeTable(node, codeTable, "");
    	
    	//Print the Huffman code tree.
    	outputTree(node);
    	
    	//Encode the message.
    	encode(input, codeTable);
    }
	
    //Build a Huffman code tree using a frequency table of the characters from the input.
    public static ComparableBinaryTreeNode<CharFreq> buildTree(int[] frequencies)
    {
        //Store the binary tree nodes in a priority queue.
	    HeapPriorityQueue<ComparableBinaryTreeNode<CharFreq>> heap = new HeapPriorityQueue<ComparableBinaryTreeNode<CharFreq>>(256);
    	
    	//Create binary tree nodes out of characters that appear at least once in the input. 
    	for(int i = 0; i < frequencies.length; i++)
    	{
    		if(frequencies[i] > 0)
    		{    
    			ComparableBinaryTreeNode<CharFreq> node = new ComparableBinaryTreeNode<CharFreq>(new CharFreq((char)(i), frequencies[i]));
    			heap.insert(node);
    	    } 
        }
        
	    ComparableBinaryTreeNode<CharFreq> newNode = new ComparableBinaryTreeNode<CharFreq>();
        
		//Combine the two nodes in the heap with the smallest frequencies until there is only one node left in the heap.
        while(heap.size() > 1)
        {
            ComparableBinaryTreeNode<CharFreq> leftChild = heap.deleteMin();
            ComparableBinaryTreeNode<CharFreq> rightChild = heap.deleteMin();
            newNode = new ComparableBinaryTreeNode<CharFreq>(new CharFreq(leftChild.getData().getFreq() + rightChild.getData().getFreq()), leftChild, rightChild);
            heap.insert(newNode);
        }
        
		//Return the root of the Huffman code tree.
        return newNode;        
    }
    
	//Build a code table that contains the path leading to every character in the tree.
   	public static void buildCodeTable(ComparableBinaryTreeNode<CharFreq> node, String[] codeTable, String path)
   	{
   		//When a leaf is reached, the current path leading to this leaf is added to the code table.
        if(node.getLeftChild() == null && node.getRightChild() == null)
            codeTable[(int)(node.getData().getChar())] = path;
        //If the current node is not a leaf, recursively build the code table with its left and right children, 
		//appending the appropriate character onto the end of their paths.  
		else
        {
            buildCodeTable(node.getLeftChild(), codeTable, path.concat("0"));
            buildCodeTable(node.getRightChild(), codeTable, path.concat("1"));        
        }       		
   	}
   	
   	//Print out the representation of the Huffman code tree.
   	public static void outputTree(ComparableBinaryTreeNode<CharFreq> node)
   	{
		//Print out a 1 if the current node is a leaf.
   	    if(node.getLeftChild() == null && node.getRightChild() == null)
   	        System.out.print("1" + node.getData().getChar());
   	    //Print out a 0 if the current node is not a leaf and recursively output the representations of the subtrees 
		//rooted at the children of the current node. 
		else 
   	    {
   	        System.out.print("0");
   	        outputTree(node.getLeftChild());
   	        outputTree(node.getRightChild());
   	    }    
   	}
   	
   	//Encode the input message by printing out the path from the code table that corresponds to every character from the input.
    public static void encode(ArrayList<Character> input, String[] codeTable)
    {
        for(int i = 0; i < input.size(); i++)
            System.out.print(codeTable[(int)input.get(i)]);
    }
}