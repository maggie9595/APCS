//Maggie Yu

import java.util.*;

public class TreeReconstruct
{
    private static ArrayList<Integer> preorderArrayList = new ArrayList<Integer>();
    private static ArrayList<Integer> inorderArrayList = new ArrayList<Integer>();
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String preorderInput = input.nextLine();
        String inorderInput = input.nextLine();
        
		//Store the preorder traversal of the original binary tree into an arraylist.
        Scanner preorderScanner = new Scanner(preorderInput);
        while(preorderScanner.hasNextInt())
        {
            preorderArrayList.add(preorderScanner.nextInt());
        }
        
		//Store the inorder traversal of the original binary tree into an arraylist.
        Scanner inorderScanner = new Scanner(inorderInput);
        while(inorderScanner.hasNextInt())
        {
            inorderArrayList.add(inorderScanner.nextInt());
        }
        
		//Reconstruct the original binary tree using its preorder and inorder traversals if the inputted traversals are not empty.
        if(!preorderInput.isEmpty() && !inorderInput.isEmpty())
        {
            BinaryTreeNode<Integer> root = reconstruct(preorderArrayList, inorderArrayList);
	
			//Traverse the reconstructed tree in level order.
            ArrayList<BinaryTreeNode<Integer>> levelOrderTraversal = root.levelOrderTraversal();
	
			//Output the vertices of the original tree along with its left and right children, if they are not null. Null children will be output as -1.
            for(BinaryTreeNode<Integer> currentNode : levelOrderTraversal)
            {
                System.out.print(currentNode.getData() + " ");
                
                if(currentNode.getLeftChild() == null)
					System.out.print("-1 ");
				else
                    System.out.print(currentNode.getLeftChild().getData() + " ");
					
                if(currentNode.getRightChild() == null)
					System.out.print("-1");
				else
                    System.out.print(currentNode.getRightChild().getData());
                
                System.out.println();
            }
        }
    }
    
    public static BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> preorderTraversal, ArrayList<Integer> inorderTraversal)
	{
		//Call the recursive helper method and pass in the entire preorder and inorder traversals to reconstruct the original binary tree.
		return reconstruct(preorderTraversal, 0, preorderTraversal.size() - 1, inorderTraversal, 0, inorderTraversal.size() - 1);
	}
	
	//Reconstruct the original binary tree given its preorder and inorder traversals and return the root of the reconstructed tree.
	private static BinaryTreeNode<Integer> reconstruct(ArrayList<Integer> preorderTraversal, int preorderStart, int preorderEnd, ArrayList<Integer> inorderTraversal, int inorderStart, int inorderEnd)
	{
		//A tree cannot be reconstructed if the start and end indices are invalid so return null.
		if(preorderStart > preorderEnd)
			return null;
		else
		{
			//Reconstruct the root of the current tree, which is just the first node in the tree's preorder traversal.
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorderTraversal.get(preorderStart));
			
			//Return the root of the tree if the current tree only consists of one node.
			if(preorderStart == preorderEnd)
				return root;
			else	
			{
				//Find the position of the root in the inorder traversal of the tree and use it to calculate how many nodes the left subtree consists of.
				int inorderPosition = inorderTraversal.indexOf(root.getData());
				int leftSubtreeLength = inorderPosition - inorderStart;
				
				//Recursively reconstruct the left and right subtrees of the current tree.
				root.setLeftChild(reconstruct(preorderTraversal, preorderStart + 1, preorderStart + leftSubtreeLength, inorderTraversal, inorderStart, inorderStart + leftSubtreeLength - 1));
				root.setRightChild(reconstruct(preorderTraversal, preorderStart + leftSubtreeLength + 1, preorderEnd, inorderTraversal, inorderStart + leftSubtreeLength + 1, inorderEnd));      
				
				return root;
			}
		}
    }
}