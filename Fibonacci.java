//Maggie Yu

public class Fibonacci
{
    public static void main(String[] args)
    {
        long[] FibonacciNumbers = new long[91];

        for(int i = 1; i < FibonacciNumbers.length; i++)
        {
            if(i == 1 || i == 2)
            {
                FibonacciNumbers[i] = 1;
                
                if(i == 2)
                    System.out.println(i + ".   " + FibonacciNumbers[i] + " " + ((double)FibonacciNumbers[i] / FibonacciNumbers[i-2]);
                else 
                    System.out.println(i + ".   " + FibonacciNumbers[i]);         
            }
            else
            {
                System.out.println(i + ".   " + FibonacciNumbers[i] + " " + ((double)FibonacciNumbers[i] / FibonacciNumbers[i-2]);
                System.out.println(i + ".   " + FibonacciNumbers[i]);
            }
        }
    }
}
