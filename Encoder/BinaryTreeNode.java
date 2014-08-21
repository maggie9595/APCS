//Maggie Yu

import java.util.*;

public class BinaryTreeNode<E>
{
    private E data;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;

    //Create a new binary tree node and initialize all of its fields to null.
    public BinaryTreeNode()
    {
        this(null);
    }
 
    //Create a new binary tree node and assign an element to its data field.
    public BinaryTreeNode(E element)
    {
        this(element, null, null);
    }
   
	//Create a new binary tree node and initialize its fields accordingly. 
    public BinaryTreeNode(E element, BinaryTreeNode<E> leftNode, BinaryTreeNode<E> rightNode)
    {
        data = element;
        //Create pointers that link the current node to its children nodes. 
        leftChild = leftNode;
        rightChild = rightNode;
    }
    
    public E getData()
    {
        return data;
    }
    
    public void setData(E element)
    {
        data = element;
    }
    
    public BinaryTreeNode<E> getLeftChild()
    {
        return leftChild;
    }
    
    public void setLeftChild(BinaryTreeNode<E> leftNode)
    {
        leftChild = leftNode;
    }
    
    public BinaryTreeNode<E> getRightChild()
    {
        return rightChild;
    }
    
    public void setRightChild(BinaryTreeNode<E> rightNode)
    {
        rightChild = rightNode;
    }
    
    //Recursively calculate and return the height of this binary tree node, which is the length of the longest path from the node to a leaf.
    public int height()
    {
        //The height of a leaf is zero.
        if(leftChild == null && rightChild == null)
            return 0;
		//If this node has no left child, its height is equal to the height of its right child plus one.
        else if(leftChild == null)
            return rightChild.height() + 1;
		//If this node has no right child, its height is equal to the height of its left child plus one.
        else if(rightChild == null)
            return leftChild.height() + 1;
		//If this node has two children, recursively calculate both of its children's heights and return the greater of the two height values plus one.
        else
        {
            int leftChildHeight = leftChild.height();
            int rightChildHeight = rightChild.height();
            
            if(leftChildHeight > rightChildHeight)
                return leftChildHeight + 1;
            else
                return rightChildHeight + 1;
        }   
    }
   
   //Return the String representation of the data stored in this binary tree node.
    public String toString()
    {
        if(data == null)
            return "null";
        else
            return data.toString();          
    }
    
    //Recursively traverse the subtree rooted at this binary tree node and return a list of binary tree nodes in preorder.
    public ArrayList<BinaryTreeNode<E>> preorder()
    {       
        ArrayList<BinaryTreeNode<E>> preorderTraversal = new ArrayList<BinaryTreeNode<E>>();
        
		//Store the root of the current subtree in the list.
		preorderTraversal.add(this);
        
        if(leftChild == null && rightChild == null)
            return preorderTraversal;
        
		//If a left child exists for the current node, recursively preorder traverse the subtree rooted at this node and store the results of
		//the preorder traversal in the list.
        if(leftChild != null)
            preorderTraversal.addAll(leftChild.preorder());
        
		//If a right child exists for the current node, recursively preorder traverse the subtree rooted at this node and store the results of
		//the preorder traversal in the list.
		if(rightChild != null)
            preorderTraversal.addAll(rightChild.preorder());            
    
        return preorderTraversal;
    }
    
	//Recursively traverse the subtree rooted at this binary tree node and return a list of binary tree nodes in postorder.
    public ArrayList<BinaryTreeNode<E>> postorder()
    {
        ArrayList<BinaryTreeNode<E>> postorderTraversal = new ArrayList<BinaryTreeNode<E>>();
        
        if(leftChild == null && rightChild == null)
        {
            postorderTraversal.add(this);
            return postorderTraversal;
        }
		
        //If a left child exists for the current node, recursively postorder traverse the subtree rooted at this node and store the results of
		//the postorder traversal in the list.
		if(leftChild != null)
            postorderTraversal.addAll(leftChild.postorder());
        
		//If a right child exists for the current node, recursively postorder traverse the subtree rooted at this node and store the results of
		//the postorder traversal in the list.
		if(rightChild != null)
            postorderTraversal.addAll(rightChild.postorder());
        
		//Store the root of the current subtree in the list.
        postorderTraversal.add(this);
		
        return postorderTraversal;            
    }
    
	//Recursively traverse the subtree rooted at this binary tree node and return a list of binary tree nodes in inorder.
    public ArrayList<BinaryTreeNode<E>> inorder()
    {
        ArrayList<BinaryTreeNode<E>> inorderTraversal = new ArrayList<BinaryTreeNode<E>>();
        
        if(leftChild == null && rightChild == null)
        {
            inorderTraversal.add(this);
            return inorderTraversal;    
        }
        
		//If a left child exists for the current node, recursively inorder traverse the subtree rooted at this node and store the results of
		//the inorder traversal in the list.
		if(leftChild != null)
            inorderTraversal.addAll(leftChild.inorder());
        
		//Store the root of the current subtree in the list.
        inorderTraversal.add(this);
        
		//If a right child exists for the current node, recursively inorder traverse the subtree rooted at this node and store the results of
		//the inorder traversal in the list.
		if(rightChild != null)
            inorderTraversal.addAll(rightChild.inorder());
        
        return inorderTraversal;
    }
    
	//Traverse the subtree rooted at this binary tree node and return a list of binary tree nodes in level order.
    public ArrayList<BinaryTreeNode<E>> levelOrder()
    {
        ArrayList<BinaryTreeNode<E>> levelOrderTraversal = new ArrayList<BinaryTreeNode<E>>();    
        Queue<BinaryTreeNode<E>> queue = new LinkedList<BinaryTreeNode<E>>();
		
		//Store the root of the current subtree in the queue.
		queue.add(this);
       
        //Using a queue, store all of the nodes in the subtree rooted at this node first into the queue and then into a list in level order.
        while(!queue.isEmpty())
        {
			//Dequeue the first node in the queue and store it in the list of binary tree nodes.
            BinaryTreeNode<E> vertex = queue.peek();
            queue.remove();
			levelOrderTraversal.add(vertex);
            
			//If the current vertex has a left child, add its left child to the end of the queue.
			if(vertex.leftChild != null)
				queue.add(vertex.leftChild);
			
			//If the current vertex has a right child, add its right child to the end of the queue.
            if(vertex.rightChild != null)
				queue.add(vertex.rightChild);
        }
        
        return levelOrderTraversal;
    }
}