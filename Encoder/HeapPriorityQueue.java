//Maggie Yu

public class HeapPriorityQueue<E extends Comparable<? super E>> implements PriorityQueue<E>
{
    //Use a one-based array to implement the heap.
    private E[] heap;
    //The number of elements the heap is currently holding.
    private int size;
    //The maximum number of elements the heap can hold.
    private int capacity;
    
    public HeapPriorityQueue()
    {
    	this(0);
    }
    
    //Create a heap of the desired capacity.
    public HeapPriorityQueue(int desiredCapacity)
    {
		this((E[])(new Comparable[0]), desiredCapacity);
    }    
    
    //Create a heap with all of the elements of the array.
    public HeapPriorityQueue(E[] array)
    {
    	this(array, array.length);
    }
    
    //Create a heap with all of the elements of the array and the desired capacity specified by the user.
    public HeapPriorityQueue(E[] array, int desiredCapacity)
    {
        if(desiredCapacity < 0)
            throw new IllegalCapacityException("Unable to create a heap with a capacity of " + desiredCapacity + " because it is less than zero.");
    	else if(desiredCapacity < array.length)
    	    throw new IllegalCapacityException("Unable to create a heap with a capacity of " + desiredCapacity + " because it is less than the length of your array.");
    	
    	//Copy the user input array over into a new array, leaving the first cell of the new array empty.
    	capacity = desiredCapacity;
    	heap = (E[])(new Comparable[capacity + 1]);
    	size = array.length;
    	
    	for(int i = 0; i < array.length; i++)
    	{
    		if(array[i] == null)
    			throw new NullElementException("Unable to insert a null element from your array into the heap.");
    		else
    			heap[i + 1] = array[i];
    	}
    	
    	//Sort the array to convert it into a heap.
    	buildHeap();
    }
    
    //Return the minimum element in the heap.
    public E min()
    {
        if(isEmpty())
        	throw new EmptyHeapException("Unable to return the minimum element because the heap is currently empty.");
        else
        	return heap[1];
    }
    
    //Return and delete the minimum element in the heap.
    public E deleteMin()
    {
        if(isEmpty())
            throw new EmptyHeapException("Unable to delete the minimum element because the heap is currently empty.");
        else
        {
            E minElement = heap[1];
			
			//Replace the first (minimum) element of the heap with the last element.
        	heap[1] = heap[size];
        	size--;
        	
        	//Percolate the current first element of the heap down to its correct position.
        	heapify(1);
        	
        	return minElement;
        }
    }
    
    //Insert a new element into the heap.
    public boolean insert(E data)
    {
    	if(data == null)
    		throw new NullElementException("Unable to insert a null element into the heap.");
    	else if(isFull())
    		throw new FullHeapException("Unable to insert another element into the heap because the heap is already at its maximum capacity.");
    		
        size++;
        int i = size;
        heap[i] = data;
        
        //Percolate the element that was just inserted up the heap in order to restore the heap property.
        while(i > 1 && heap[i].compareTo(heap[i / 2]) < 0)
        {
            E temp = heap[i];
            heap[i] = heap[i / 2];
            heap[i / 2] = temp;
          
            i = i / 2;
        }
        
        return true;
    }
	    
    public boolean isFull()
    {
        if(size == capacity)
            return true;
        else
            return false;
    }
    
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        else
            return false;
    }
    
    public int size()
    {
        return size;
    }

	//Percolate the contents of the specified cell down to its correct position in the heap.
    private void heapify(int i)
    {
        //Find the cell containing the smallest element between the specified cell and its two children.
        int indexOfSmallest;
        if(2 * i <= size && heap[2 * i].compareTo(heap[i]) < 0)
            indexOfSmallest = 2 * i;
        else
            indexOfSmallest = i;
            
        if((2 * i) + 1 <= size && heap[(2 * i) + 1].compareTo(heap[indexOfSmallest]) < 0)
            indexOfSmallest = (2 * i) + 1;
            
        //Swap the contents of the specified cell with the smallest element as found above and if necessary, recursively heapify
		//the cell that used to contain the smallest element.
        if(indexOfSmallest != i)
        {
            E temp = heap[i];
            heap[i] = heap[indexOfSmallest];
            heap[indexOfSmallest] = temp;  
            
            heapify(indexOfSmallest);          
        }    
    }
    
    //Build a heap by sorting the array so that it satisfies the heap property.
	private void buildHeap()
	{
	    for(int i = size / 2; i >= 1; i--)
	        heapify(i);
	}
}