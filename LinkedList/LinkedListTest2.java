//Paul Eppley
//This class is a driver that tests the LinkedList class.

public class LinkedListTest2
{
    public static void main(String[] args)
    {   
        LinkedList<Integer> list = new LinkedList<Integer>();

        //Let's make sure a single append works.
        list.append(13);

        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     13");

        //Let's try a prepend.
        list.prepend(77);

        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     77 13");

        //Now let's test a removeFirst.
        list.removeFirst();
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     13");

        //Now we'll start over and test a single prepend.
        list = new LinkedList<Integer>();
        list.prepend(11);
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     11");

        //Next, let's try a removeLast.
        list.removeLast();
        System.out.print("List contains: ");
        list.output();
        System.out.println("Should be:     ");

        //Finally, we'll throw an exception.
        System.out.println("We're about to getFirst from an empty list.");
        list.getFirst();
    }
}