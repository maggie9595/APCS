//Maggie Yu

public class CharArrayToWords
{
    private static char[][] convert(char[] charArray)
    {
    	int numberOfSpaces = 0;
    	int numberOfLetters = 0;
    	char[][] words;
		int outerArrayIndex = 0;
		int innerArrayIndex = 0;
    	
    	//March through the original array and count how many spaces there are.
    	for(int i = 0; i < charArray.length; i++)
    	{
    		if(charArray[i] == ' ')
				numberOfSpaces++;
    	}
		//Allocate enough space for the outer arrays of the new array of arrays to hold all of the words from the original array.
    	words = new char[numberOfSpaces][];
    	
    	//March through the original array again and count the number of letters in each word.
		//Then, allocate enough space for each inner array of the array of arrays to hold all of the letters from each word of the original array.
    	for(int i = 0; i < charArray.length; i++)
    	{
    		if(charArray[i] == ' ')
    		{
    			words[outerArrayIndex++] = new char[numberOfLetters];
    			numberOfLetters = 0;
    		}
    		else
				numberOfLetters++;
    	}
    	outerArrayIndex = 0;
		
    	//Split the original array into words by marching through the original array once again and transferring all of the letters 
		//one by one from the original array into the new array of arrays.
    	for(int i = 0; i < charArray.length; i++)
    	{
    		if(charArray[i] == ' ')
    		{
    		    outerArrayIndex++;
    			innerArrayIndex = 0;
    		}
    		else
    			words[outerArrayIndex][innerArrayIndex++] = charArray[i];
    	}
    	
    	return words;
    }
    ////////////////////////////////////////////////////////////	
    public static void main(String[] args)
    {
        //Create some Strings so that we can easily create some arrays of chars.
		String string1 = "Here is a string to be split into words. ";
        String string2 = "another test string ";
        String string3 = "oneWord ";
        String string4 = "";  //Don't crash with this!

        //Now establish the arrays of chars used for testing the convert() method.
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        char[] charArray3 = string3.toCharArray();
        char[] charArray4 = string4.toCharArray();

        //Call the convert() method on each char array, storing the result.
		char[][] answer1 = convert(charArray1);
		char[][] answer2 = convert(charArray2);
		char[][] answer3 = convert(charArray3);
		char[][] answer4 = convert(charArray4);
    		
        //Test print the answers to see if the arrays were converted correctly.
        //The output should be one word per line from each original String.
        System.out.println("First String:");
        for(int i = 0; i < answer1.length; i++)
		{
		    for(int j = 0; j < answer1[i].length; j++)
			    System.out.print(answer1[i][j]);
				
			System.out.println();
		}

        System.out.println("Second String:");
        for(int i = 0; i < answer2.length; i++)
		{
		    for(int j = 0; j < answer2[i].length; j++)
			    System.out.print(answer2[i][j]);
				
			System.out.println();
		}

        System.out.println("Third String:");
        for(int i = 0; i < answer3.length; i++)
		{
		    for(int j = 0; j < answer3[i].length; j++)
			    System.out.print(answer3[i][j]);
				
			System.out.println();
		}

        System.out.println("Fourth String:");
        for(int i = 0; i < answer4.length; i++)
		{
		    for(int j = 0; j < answer4[i].length; j++)
			    System.out.print(answer4[i][j]);
				
			System.out.println();
		}
	}
}