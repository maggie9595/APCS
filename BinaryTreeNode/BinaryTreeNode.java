import java.util.*;

public class BinaryTreeNode<E>
{
    private E data;
    private BinaryTreeNode<E> leftChild;
    private BinaryTreeNode<E> rightChild;
    
    public BinaryTreeNode()
    {
        data = null;
        leftChild = null;
        rightChild = null;
    }
    
    public BinaryTreeNode(E x)
    {
        this();
        data = x;
    }
    
    public BinaryTreeNode(E x, BinaryTreeNode<E> lc, BinaryTreeNode<E> rc)
    {
        this(x);
        leftChild = lc;
        rightChild = rc;
    }
     
    public String toString()
    {
        return data.toString();
    }
 
    public E getData()
    {
        return data;
    }
    
    public void setData(E x)
    {
        data = x;
    }
    
    public BinaryTreeNode<E> getLeftChild()
    {
        return leftChild;
    }
    
    public void setLeftChild(BinaryTreeNode<E> lc)
    {
        leftChild = lc;
    }
    
    public BinaryTreeNode<E> getRightChild()
    {
        return rightChild;
    }
    
    public void setRightChild(BinaryTreeNode<E> rc)
    {
        rightChild = rc;
    }    
 
    public ArrayList<BinaryTreeNode<E>> levelOrderTraversal()
    {
        ArrayList<BinaryTreeNode<E>> traversal = new ArrayList<BinaryTreeNode<E>>(1);
        Queue<BinaryTreeNode<E>> q = new LinkedList<BinaryTreeNode<E>>();

        //Initialize the queue with the current tree node.
        q.add(this);
        
        //While the queue is not empty, visit the tree node at the front of the queue, then enqueue its
        //children, and dequeue.
        while(!q.isEmpty())
        {
            traversal.add(q.peek());
            
            if(q.peek().leftChild != null)
                q.add(q.peek().leftChild);
                
            if(q.peek().rightChild != null)
                q.add(q.peek().rightChild);
                
            q.remove();
        }
        
        return traversal;
    }
}