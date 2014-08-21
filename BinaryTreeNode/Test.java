//Maggie Yu

import java.util.*;

public class Test
{
    //make an array of nodes and connect all the child pointers
    //put Integers in the data of the nodes - same thing as the indices
    //send arraylist to print
    public static void main(String[] args)
    {
        //Create an array of binary tree nodes.
        ArrayList<BinaryTreeNode<Integer>> nodes = new ArrayList<BinaryTreeNode<Integer>>();
        
        //Initialize the binary tree nodes so that their data are the same as their indices.
        for(int i = 0; i <= 10; i++)
        {
            nodes.add(new BinaryTreeNode<Integer>(i));
        }
		
		//Set pointers to connect the binary tree nodes.
        nodes.get(1).setLeftChild(nodes.get(2));
        nodes.get(1).setRightChild(nodes.get(5));
        nodes.get(2).setLeftChild(nodes.get(4));
        nodes.get(2).setRightChild(nodes.get(3));
        nodes.get(3).setLeftChild(nodes.get(10));
        nodes.get(3).setRightChild(nodes.get(8));
        nodes.get(8).setLeftChild(nodes.get(9));
        nodes.get(5).setRightChild(nodes.get(6));
        nodes.get(6).setLeftChild(nodes.get(7));
       
	   //Test the preorder traversal method.
	    System.out.println("preorder:");
        ArrayList<BinaryTreeNode<Integer>> preorderTraversal = nodes.get(1).preorder();
        for(int i = 0; i < preorderTraversal.size(); i++)
        {
            System.out.println(preorderTraversal.get(i).getData());
        }
		System.out.println();
		
		System.out.println("preorder with a leaf:");
		ArrayList<BinaryTreeNode<Integer>> preorderTraversal2 = nodes.get(9).preorder();
        for(int i = 0; i < preorderTraversal2.size(); i++)
        {
            System.out.println(preorderTraversal2.get(i).getData());
        }
		System.out.println();
		
		System.out.println("preorder with a tree consisting of one node:");
		ArrayList<BinaryTreeNode<Integer>> preorderTraversal3 = new BinaryTreeNode<Integer>().preorder();
        for(int i = 0; i < preorderTraversal3.size(); i++)
        {
            System.out.println(preorderTraversal3.get(i));
        }
		System.out.println();
		
		//Test the postorder traversal method.
		System.out.println("postorder:");
        ArrayList<BinaryTreeNode<Integer>> postorderTraversal = nodes.get(1).postorder();
        for(int i = 0; i < 10; i++)
        {
            System.out.println(postorderTraversal.get(i).getData());
        }
		System.out.println();
		
		//Test the inorder traversal method.
	    System.out.println("inorder:");
        ArrayList<BinaryTreeNode<Integer>> inorderTraversal = nodes.get(1).inorder();
        for(int i = 0; i < 10; i++)
        {
            System.out.println(inorderTraversal.get(i).getData());
        }
		System.out.println();
		
		//Test the level order traversal method.
	    System.out.println("level order:");
        ArrayList<BinaryTreeNode<Integer>> levelOrderTraversal = nodes.get(1).levelOrder();
        for(int i = 0; i < 10; i++)
        {
            System.out.println(levelOrderTraversal.get(i).getData());
        }
		System.out.println();
		
		//Test the height method.
	    System.out.println("height of root:");
        int height = nodes.get(1).height();
        System.out.println(height);
		System.out.println();
		
	    System.out.println("height of a tree consisting of one node:");
        int height2 = new BinaryTreeNode<Integer>().height();
        System.out.println(height2);
		System.out.println();
    }
}
