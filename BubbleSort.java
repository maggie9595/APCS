//Maggie Yu

import java.util.*;
public class BubbleSort
{
    private static void bubbleSort(int[] listToBeSorted)
    {
        for(int passCounter = 1; passCounter <= listToBeSorted.length-1; passCounter++)
            //Make a pass through the list of numbers, but ignore the last number in the array.
            for(int bubblePlace = 0; bubblePlace < listToBeSorted.length-1; bubblePlace++)
                //
                if(listToBeSorted[bubblePlace] > listToBeSorted[bubblePlace+1])
                {
                    int numberStorage = listToBeSorted[bubblePlace];
                    listToBeSorted[bubblePlace] = listToBeSorted[bubblePlace+1];
                    listToBeSorted[bubblePlace+1] = numberStorage;
                }
    }
    ///////////////////////////////////////////////////
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many numbers would you like for me to list in order from least to greatest?");
        int quantityOfNumbers = userInput.nextInt();
        int[] unsortedList = new int[quantityOfNumbers];
        System.out.println("Please enter your numbers below:");
        for(int numberCounter = 0; numberCounter < quantityOfNumbers; numberCounter++)
        {
            System.out.print("==>");
            unsortedList[numberCounter] = userInput.nextInt();
        }

        //Sort the numbers that the user entered.
        bubbleSort(unsortedList);
        for(int numberCounter = 0; numberCounter < quantityOfNumbers; numberCounter++)
            System.out.print(unsortedList[numberCounter] + " ");
        System.out.println();
    }
}
