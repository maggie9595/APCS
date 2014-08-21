//Maggie Yu

public class ComparableBinaryTreeNode<E extends Comparable<E>> 
                                        extends BinaryTreeNode<E> 
                                        implements Comparable<ComparableBinaryTreeNode<E>>
{
    public ComparableBinaryTreeNode()
    {
        super();
    }    
    
    public ComparableBinaryTreeNode(E x)
    {
        super(x);
    }
    
    public ComparableBinaryTreeNode(E x, ComparableBinaryTreeNode<E> lc, ComparableBinaryTreeNode<E> rc)
    {
        super(x, lc, rc);
    }
    
    //Compare two comparable binary tree nodes by comparing the data stored in the nodes.
    public int compareTo(ComparableBinaryTreeNode<E> other)
    {
        return this.getData().compareTo(other.getData());
    }
    
    public ComparableBinaryTreeNode<E> getLeftChild()
    {
        return (ComparableBinaryTreeNode<E>)(super.getLeftChild());
    }
    
    public ComparableBinaryTreeNode<E> getRightChild()
    {
        return (ComparableBinaryTreeNode<E>)(super.getRightChild());
    }
}