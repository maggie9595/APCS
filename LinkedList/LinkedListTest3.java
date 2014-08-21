//Paul Eppley
//This class is a driver that tests the LinkedList class.

public class LinkedListTest3
{
    public static void main(String[] args)
    {   
        LinkedList<Integer> list = new LinkedList<Integer>();

        //Let's append some integers.  Note that we're using autoboxing.
        list.append(8);
        list.append(12);
        list.append(0);
        list.append(6);
        list.append(1);

        //Now we'll test the get() method.
        System.out.print("The 4th element is        ");
        System.out.print(list.get(4));
        System.out.println(".");
        System.out.println("The 4th element should be 6.");
    }
}