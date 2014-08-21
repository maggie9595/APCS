//Maggie Yu

public interface PriorityQueue<E extends Comparable<? super E>>
{
    public E min();
    public E deleteMin();
    public boolean insert(E data);
    public boolean isFull();
    public boolean isEmpty();
    public int size();
}
