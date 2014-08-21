//Maggie Yu

import java.util.*;
public class SelectionSort
{
    private static void selectionSort(int[] listToBeSorted)
    {
		//Sort the list of numbers, beginning with the first unsorted cell every time, finding the appropriate number to put into that cell.
        for(int firstUnsortedCell = 0; firstUnsortedCell < listToBeSorted.length; firstUnsortedCell++)
        {
            int minElementIndex = firstUnsortedCell;
            
            //Select the element in the first unsorted cell and compare it to the rest of the unsorted elements.
            for(int i = firstUnsortedCell+1; i < listToBeSorted.length; i++)
            	//Update the position of the minimum element if a new, lower element is found.
                if(listToBeSorted[i] < listToBeSorted[minElementIndex])
                    minElementIndex = i;
            
            //Swap the element of the first unsorted cell with the lowest element found.
            int temp = listToBeSorted[firstUnsortedCell];
            listToBeSorted[firstUnsortedCell] = listToBeSorted[minElementIndex];
            listToBeSorted[minElementIndex] = temp;
        }
    }
    ///////////////////////////////////////////////////
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        
        //Ask the user for the amount of numbers that he or she wishes to sort.
        System.out.println("How many numbers do you want to sort in order from least to greatest?");
        int quantityOfElements = userInput.nextInt();
        int[] unsortedList = new int[quantityOfElements];
        
        //Ask the user to enter the numbers that he or she wishes to sort.
        System.out.println("Please enter " + quantityOfElements + " numbers below:");
        for(int i = 0; i < quantityOfElements; i++)
        {
            System.out.print("==> ");
            unsortedList[i] = userInput.nextInt();
        }

        //Selection sort the numbers that the user has entered.
        selectionSort(unsortedList);
        
        //Display the user's numbers in order from least to greatest.
        for(int i = 0; i < quantityOfElements; i++)
            System.out.print(unsortedList[i] + " ");
        System.out.println();
    }
}