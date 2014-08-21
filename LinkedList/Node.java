//Maggie Yu

public class Node<E>
{
    public E data;
    public Node<E> next;

	//Create a new node for a singly-linked list. 
    public Node (E element, Node<E> nextNode)
    {
        data = element;
        //Create a pointer that links the current node to the next node in the list.
        next = nextNode;
    }
}