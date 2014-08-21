//Maggie Yu

public class LinkedList<E>
{
    private int length;
    private Node<E> first;
    private Node<E> last;

	//Create an empty linked list with a header that stores the length of the list and pointers to the first node and the last node in the list.
    public LinkedList()
    {
        length = 0;
        first = null;
        last = null;        
    }

    //Return the first element of the list or throw an exception if the list is empty.
    public E getFirst()
    {
        if(length == 0)
            throw new EmptyListException("Unable retrieve the first element because the list is currently empty.");
        else
            return first.data;
    }

    //Return the last element of the list or throw an exception if the list is empty.
    public E getLast()
    {
        if(length == 0)
            throw new EmptyListException("Unable to retrieve the last element because the list is currently empty.");
        else
            return last.data;
    }

    //Return the element at the specified position in the list or throw an exception if the position is invalid.
    public E get(int position)
    {
    	if(position > length || position < 1)
    		throw new IllegalPositionException("Unable to retrieve the element because the specified position is out of the range of 1-" + length + ".");
    	else
    	{ 
    		Node<E> tempNode = first;
    		
    		//March through the list until the node at the specified position is reached.
    		for(int i = 1; i <= position - 1; i++)
    			tempNode = tempNode.next;
    		
    		return tempNode.data;
        }
    }
    
    //Return the length of the list.
    public int getLength()
    {
    	return length;
    }
    
    //Remove the first element from the list or throw an exception if the list is empty.
    public void removeFirst()
    {
    	if(length == 0)
    		throw new IllegalRemoveException("Unable to remove the first element because the list is currently empty.");
    	else
    	{
    		length--;
    		
    		//Set the first node pointer in the header to the current second node of the list so that the first node can no longer be accessed.
    		first = first.next;
    		
    		//If the list becomes empty after removing its only element, there is no longer a last node, 
    		//so set the last node pointer in the header to null.
    		if(length == 0)
    			last = null;
    	}
    }
    
    //Remove the last element from the list or throw an exception if the list is empty.
    public void removeLast()
    {
   		if(length == 0)
    		throw new IllegalRemoveException("Unable to remove the last element because the list is currently empty.");
    	else
    	{
    		//If the list becomes empty after removing its only element, set the pointers to the first and the last node in the header to null.
    		if(length == 1)
    		{
    			first = null;
    			last = null;
    		}
    		else
    		{
    			Node<E> tempNode = first;
    			
    			//March through the list until the second to last node is reached.
    			while(tempNode.next != last)
    				tempNode = tempNode.next;
    			
    			//Set the last node pointer in the header to the current second to last node so that the current last node can no longer be accessed.
    			last = tempNode;
    			tempNode.next = null;
    		}
    		
    		length--;
        }
    }
    
    //Append an element to the list.
    public void append(E element)
    {
    	Node<E> newNode = new Node<E> (element, null);
    	length++;
    	if(length == 1)
    		first = newNode;
    	else
    		last.next = newNode;
    	last = newNode;
    }

	//Prepend an element to the list.
	public void prepend(E element)
	{
		Node<E> newNode = new Node<E> (element, first);
		first = newNode;
		length++;
		
		if(length == 1)
			last = newNode;
	}
	    
	//Insert an element at the specified position in the list or throw an exception if the position is invalid.
	public void insert(E element, int position)
	{
		if(position > length + 1 || position < 1)
		{
			throw new IllegalPositionException("Unable to insert the element into the list because the specified position is out of the range of 1- " 
			+ (length + 1) + ".");
		}
		else if(position == 1)
			prepend(element);
		else if(position == length + 1)
			append(element);
		else
		{		
			Node<E> tempNode = first;	
			
			//March through the list until the node at the position just before the specified position is reached.
			for(int i = 1; i <= position - 2; i++)
				tempNode = tempNode.next;
			
			Node<E> newNode = new Node<E> (element, tempNode.next);
			tempNode.next = newNode;
			
			length++;
		}
	}
	
	//Output all of the elements in the list separated by spaces.
    public void output()
    {    
    	Node<E> node = this.first;
    	while(node != null)
    	{
    		System.out.print(node.data + " ");
    		node = node.next;
    	}
    	
    	System.out.println();
	}	
}
