//Maggie Yu

public class QuickSort
{	
    public static void main(String[] args)
    {
		//Test to see if quick sort works correctly for a small array of random numbers.
		System.out.println("********************************* Test 1: *********************************");
		int[] testArray1 = new int[50];
		int[] copyOfArray1 = new int[testArray1.length];
		
		for(int i = 0; i < testArray1.length; i++)
		{
			testArray1[i] = randomInt(-20, 20);
			copyOfArray1[i] = testArray1[i];
		}
		
		test(testArray1, copyOfArray1);
    	
    	//Test to see if quick sort works correctly for an array that is already sorted from greatest to least (backwards).
		System.out.println("********************************* Test 2: *********************************");
		int[] testArray2 = new int[800];
		int[] copyOfArray2 = new int[testArray2.length];
		int number = testArray2.length - 1;
		
		for(int i = 0; i < testArray2.length; i++)
		{
			testArray2[i] = number;
			copyOfArray2[i] = testArray2[i];
			number--;
		}
		
		test(testArray2, copyOfArray2);
		
		//Test to see if quick sort works correctly for an array that is already sorted from least to greatest.
		System.out.println("********************************* Test 3: *********************************");
		int[] testArray3 = new int[5000];
		int[] copyOfArray3 = new int[testArray3.length];
		
		for(int i = 0; i < testArray3.length; i++)
		{
			testArray3[i] = i;
			copyOfArray3[i] = testArray3[i];
		}
		
		test(testArray3, copyOfArray3);

		//Test to see if quick sort works correctly for an empty array.
		System.out.println("********************************* Test 4: *********************************");
		int[] testArray4 = new int[0];
		int[] copyOfArray4 = new int[testArray4.length];
		
		test(testArray4, copyOfArray4);
		
		//Test to see if quick sort works correctly for a large array of random numbers.
		System.out.println("********************************* Test 5: *********************************");
		int[] testArray5 = new int[100000];
		int[] copyOfArray5 = new int[testArray5.length];
		
		for(int i = 0; i < testArray5.length; i++)
		{
			testArray5[i] = randomInt(-999, 999);
			copyOfArray5[i] = testArray5[i];
		}
		
		test(testArray5, copyOfArray5);
		
		//Test to see if quick sort works correctly for an array with duplicates.
		System.out.println("********************************* Test 6: *********************************");
		int[] testArray6 = new int[10000];
		int[] copyOfArray6 = new int[testArray6.length];
		
		for(int i = 0; i < testArray6.length; i++)
		{
			if(i % 2 == 0)
				testArray6[i] = randomInt(-9999, 9999);
			else 
				testArray6[i] = 6;
			
			copyOfArray6[i] = testArray6[i];
		}
		
		test(testArray6, copyOfArray6);
		
		//Test to see if quick sort works correctly for an array containing all duplicates.
		System.out.println("********************************* Test 7: *********************************");
		int[] testArray7 = new int[10000];
		int[] copyOfArray7 = new int[testArray7.length];
		
		for(int i = 0; i < testArray7.length; i++)
		{
			testArray7[i] = 0;
			copyOfArray7[i] = testArray7[i];
		}
		
		test(testArray7, copyOfArray7);
    }
    
	///////////////////////////////////////////////////
	
	public static void test(int[] testArray, int[] copyOfArray)
	{
		quickSort(testArray);
		
		//Check whether or not quick sort has worked properly by testing to see if the elements of the array are really in order from least to greatest 
		//as well as testing to see if the array still contains exactly the same elements as the original, unsorted array.
		System.out.println("Array is sorted: " + isSorted(testArray));
		System.out.println("Array contains the same elements: " + containsSameElements(testArray, copyOfArray));
    	System.out.println();
	}
	
	///////////////////////////////////////////////////
	
	//Generate a random integer from a certain minimum value to a certain maximum value.
	public static int randomInt(int min, int max)
	{
		int range = max - min + 1;
		return (min + (int)(range * Math.random()));
	}

	///////////////////////////////////////////////////		
	
	//Check to see whether or not the array has been sorted correctly (from least to greatest).
	public static boolean isSorted(int[] array)
	{
		if(array != null)
		{
			for(int i = 0; i < array.length - 1; i++)
				if(array[i] > array[i + 1])
					return false;
		}
		
		return true;
	}
	
	///////////////////////////////////////////////////	
	
	public static boolean containsSameElements(int[] array1, int[] array2)
	{
		if(array1 == null && array2 == null)
			return true;
		else if((array1 == null && array2 != null) || (array2 == null && array1 != null))
			return false;
		else if(array1.length != array2.length)
			return false;
		//If neither of the arrays are null and both of them contain the same number of elements, continue to check 
		//whether or not they contain the same elements, but not necessarily in the same order.
		else
		{ 
			//Create an array of booleans to keep track of the identicalness of the elements in the two arrays.
			boolean[] sameElements = new boolean[array1.length];
			for(int i = 0; i < sameElements.length; i++)
				sameElements[i] = false;
			
			//March through the first array and try to find the same elements in the second array.
			for(int i = 0; i < array1.length; i++)
			{
				int counter = 0;
				boolean foundSameElement = false;
				
				//Keep checking the elements of both arrays until a match has been found for every element of the first array, meaning that
				//both arrays have to contain the exact same elements.
				while(foundSameElement == false && counter < array2.length)
				{
					if(array1[i] == array2[counter] && sameElements[counter] == false)
					{
						sameElements[counter] = true;
						foundSameElement = true;
					}
					else
						counter++;
				}
				
				//Stop marching through the arrays if an element in the first array was not found in the second array. 
				if(counter >= array2.length)
					return false;
			}				
			
			//March through the entire boolean array and make sure that every element was found in both arrays earlier.
			for(int i = 0; i < sameElements.length; i++)
				if(sameElements[i] == false)
					return false;
					
			return true;
		}				
	}	
	
	///////////////////////////////////////////////////
	
	public static void quickSort(int[] listToBeSorted)
	{
		//Call the recursive helper method and pass in the entire array to be sorted.
		quickSort(listToBeSorted, 0, listToBeSorted.length - 1);
	}
	
	///////////////////////////////////////////////////
	
	private static void quickSort(int[] array, int start, int end)
	{
		//If the unsorted array contains more than one element, partition the array and then recursively quick sort each part of the array.
		if(end > start)
		{
			int splitPoint = partition(array, start, end);
			quickSort(array, start, splitPoint);
			quickSort(array, splitPoint + 1, end);
		}
	}
	
	///////////////////////////////////////////////////	
	
	//Partition the array so that the elements in the left part of the array are less than all of the elements in the right part of the array.
	private static int partition(int[] array, int start, int end)
	{
		//Use the first element of the array as the pivot, which will be used to determine where to partition the array.
		int pivot = array[start];
		
		//Start the 2 fingers off the ends of the array.
		int leftFinger = start - 1;
		int rightFinger = end + 1;
		
		while(true)
		{
		    //Move the right finger along the array (to the left) until it reaches an element that is smaller than or equal to the pivot,
		    //which would mean that the element is in the wrong part of the array.
			do
				rightFinger--;
			while(array[rightFinger] > pivot);
			
			//Move the left finger along the array (to the right) until it reaches an element that is greater than or equal to the pivot,
			//which would mean that the element is in the wrong part of the array.
			do
				leftFinger++;
			while(array[leftFinger] < pivot);
			
			//If the left finger and the right finger have not crossed over in their paths, swap the elements that the fingers are pointing to.
			if(leftFinger < rightFinger)
			{
				int temp = array[leftFinger];
            	array[leftFinger] = array[rightFinger];
            	array[rightFinger] = temp;
			}
			//If the left and right fingers have crossed over, return the index of the split point, the point in the array that splits the array into 
			//two parts where all of the elements to the left of the split point are less than all of the elements to the right of the split point. 
			else
			{
				return rightFinger;
			}
		}								
	}	
}
