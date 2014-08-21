//Paul Eppley   
//This is a test program for the HeapPriorityQueue class.

import java.util.*;

public class HeapTest
{
    public static void main(String[] args)
    {
        PriorityQueue<Integer> intQ = new HeapPriorityQueue<Integer>(10);
        intQ.insert(12);
        intQ.insert(4);
        intQ.insert(1);
        intQ.insert(19);
        intQ.insert(7);
        System.out.println("A 1 should print:  " + intQ.min());
        intQ.deleteMin();
        System.out.println("A 4 should print:  " + intQ.min());
        intQ.insert(11);
        intQ.insert(74);
        intQ.insert(5);
        intQ.insert(12);
        intQ.insert(18);
        System.out.print("Integers in order:  ");
        
        while(!intQ.isEmpty())
        {
            System.out.print(intQ.min() + " ");
            intQ.deleteMin();
        }

        System.out.println("\nShould be:          4 5 7 11 12 12 18 19 74");

		//Test the constructor that takes an array.
		Integer[] array = new Integer[12];
		array[0] = 9;
		array[1] = 12;
		array[2] = -3;
		array[3] = -9;
		array[4] = 6;
		array[5] = 7;
		array[6] = 8;
		array[7] = 1;
		array[8] = 13;
		array[9] = 9;
		array[10] = 0;
		array[11] = 2;
				
        PriorityQueue<Integer> q = new HeapPriorityQueue<Integer>(array);

        System.out.print("Integers in order:  ");
        
        while(!q.isEmpty())
        {
            System.out.print(q.min() + " ");
				q.deleteMin();
        }

        System.out.println("\nShould be:          -9 -3 0 1 2 6 7 8 9 9 12 13");
		
        PriorityQueue<String> stringQ = new HeapPriorityQueue<String>(20);
        
        stringQ.insert("First String");
        stringQ.insert("Second String");
        stringQ.insert("word");
        stringQ.insert("Never enter");
        stringQ.insert("Neverending");
        stringQ.insert("A long String");
        stringQ.insert("a short string");
        stringQ.insert("stringQ.insert");
        stringQ.insert("This is getting very boring.");
        stringQ.insert("No one claimed it would be interesting.");
        stringQ.insert("I know, but...");
        stringQ.insert("But what?");
        stringQ.insert("But nothing.");
        stringQ.insert("What do you mean?");
        
        int i = 1;
        
        System.out.println("Fourteen strings in alphabetical order, one per line:");
        while(!stringQ.isEmpty())
            System.out.println((i++) + ". " + stringQ.deleteMin());
        
        System.out.println("\nNow, throw an empty heap exception with informative message:");
        stringQ.min();
        
        //Test the constructors and exceptions.
        PriorityQueue<Integer> test1 = new HeapPriorityQueue<Integer>();
        
    }
}
