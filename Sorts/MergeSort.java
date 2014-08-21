//Maggie Yu

import java.util.*;
public class MergeSort
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        
        //Ask the user for the amount of numbers that he or she wishes to sort.
        System.out.println("How many numbers do you wish to sort in order from least to greatest?");
        int quantityOfElements = userInput.nextInt();
        int[] unsortedList = new int[quantityOfElements];
        
        //Ask the user to enter the numbers that he or she wishes to sort.
        System.out.println("Please enter " + quantityOfElements + " numbers below:");
        for(int i = 0; i < quantityOfElements; i++)
        {
            System.out.print("==> ");
            unsortedList[i] = userInput.nextInt();
        }

        //Merge sort the numbers that the user has entered.
        mergeSort(unsortedList);
        
        //Display the user's numbers in order, from least to greatest.
        for(int i = 0; i < quantityOfElements; i++)
            System.out.print(unsortedList[i] + " ");
        System.out.println();
    }
    
    ///////////////////////////////////////////////////
	
	private static void mergeSort(int[] listToBeSorted)
	{
		//Call the recursive helper method and pass in the entire array to be sorted.
		mergeSort(listToBeSorted, 0, listToBeSorted.length - 1);
	}
	
	///////////////////////////////////////////////////
	
	private static void mergeSort(int[] listToBeSorted, int start, int end)
	{
		//If the array consists of two or more elements, split the array into two parts and recursively sort each part.
		if(end > start)
		{
			int middle = (start + end)/2;
			mergeSort(listToBeSorted, start, middle);
			mergeSort(listToBeSorted, middle + 1, end);
			//Merge the two sorted parts of the array.
			merge(listToBeSorted, start, middle, middle + 1, end);
		}
	}
	
	///////////////////////////////////////////////////
	
	private static void merge(int[] listToBeSorted, int start1, int end1, int start2, int end2)
	{
		int finger1 = start1;
		int finger2 = start2;
		int tempArrayIndex = 0;
		int[] tempArray = new int[(end2 - start2) + (end1 - start1) + 2];
		
		//Each time, compare two numbers from the two parts of the array and place the smaller one into a temporary array; keep comparing
		//and sorting the unsorted elements until one part of the array has no more unsorted elements left inside.
		while(end1 >= finger1 && end2 >= finger2)
		{
			if(listToBeSorted[finger1] <= listToBeSorted[finger2])
			{
				tempArray[tempArrayIndex] = listToBeSorted[finger1];
				finger1++;
				tempArrayIndex++;
			}
			else
			{
				tempArray[tempArrayIndex] = listToBeSorted[finger2];
				finger2++;
				tempArrayIndex++;
			}
		}
		
		//If one part of the array is already completely placed into the temporary array, place the rest of the elements from 
		//the other part into the temporary array as well.
		while(end1 <= finger1 && finger2 <= end2)
		{
			tempArray[tempArrayIndex] = listToBeSorted[finger2];
			finger2++;
			tempArrayIndex++;
		}
		while(end2 <= finger2 && finger1 <= end1)
		{
			tempArray[tempArrayIndex] = listToBeSorted[finger1];
			finger1++;
			tempArrayIndex++;
		}
		
		//Put the sorted numbers back into the original array.
		int indexCounter = 0;			
		for(int i = start1; i <= end1; i++)
		{
			listToBeSorted[i] = tempArray[indexCounter];
			indexCounter++;
		}				
		for(int i = start2; i <= end2; i++)
		{
			listToBeSorted[i] = tempArray[indexCounter];
			indexCounter++;
		}
	}
}