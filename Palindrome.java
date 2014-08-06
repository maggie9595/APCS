public class Palindrome
{
	public static void main(String[] args)
	{
		char[] array = new char[1];
		array[0] = 'a';
		
		boolean isPalindrome = isPalindrome(array);
		
		System.out.print(isPalindrome);
	}
	
	public static boolean isPalindrome(char[] array)
	{
		return isPalindrome(array, 0, array.length - 1);
	}
	
	private static boolean isPalindrome(char[] array, int start, int end)
	{
		if(end > start)
		{
			if(array[start] == array[end])
				return isPalindrome(array, start + 1, end - 1);
			else
				return false;
		}
		else if(end == start)
			return true;
		else
			return true;
	}
}