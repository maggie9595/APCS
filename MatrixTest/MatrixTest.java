//Maggie Yu

import java.util.*;
public class MatrixTest
{
	public static int[][] calculateProduct(int[][] matrix1, int[][] matrix2)
	{
		if(matrix1.length == 0 || matrix1[0].length == 0 || matrix2.length == 0 || matrix2[0].length == 0)
			return new int[0][0];
		//Display an error if the dimensions of the user's matrices are incompatible to be multiplied.
		else if(matrix1[0].length != matrix2.length)
			throw new BadDimException("Your first matrix has " + matrix1[0].length + " column(s) and your second matrix has " + matrix2.length + " row(s). Therefore, your matrices cannot be multiplied together because their dimensions are incompatible!");
		
		//Create a new matrix with the appropriate dimensions to hold the product.
		int[][] product = new int[matrix1.length][matrix2[0].length];
		
		//Multiply the two matrices together.
		for(int row = 0; row < matrix1.length; row++)
			for(int col = 0; col < matrix2[0].length; col++)
				for(int i = 0; i < matrix1[0].length; i++)
					product[row][col] += matrix1[row][i] * matrix2[i][col];
		
		return product;
	}
	
	//Allocate space for, fill, and return a two dimensional array of
	//integers having the specified number of rows and columns.
	//Precondition: rows and columns are positive.
	public static int[][] getUserMatrix(int rows, int columns)
	{
		Scanner userInput = new Scanner(System.in);
		int[][] sum = new int[rows][columns];
		
		for(int row = 0; row < rows; row++)
			for(int col = 0; col < columns; col++)
			{
				System.out.print("Enter an integer for row " + (row + 1) + " column " + (col + 1) + " ==> ");
				sum[row][col] = userInput.nextInt();				
			}
		
		return sum;
	}
	
	//Return a new matrix that is the sum of the input matrices.
	//Precondition: both input matrices are non-null and have the same dimensions.
	public static int[][] calculateSum(int[][] matrix1, int[][] matrix2)
	{
		if(matrix1.length == 0)
			return new int[0][0];
		
		int[][] sum = new int[matrix1.length][matrix1[0].length];
		
		for(int row = 0; row < sum.length; row++)
			for(int col = 0; col < sum[0].length; col++)
				sum[row][col] = matrix1[row][col] + matrix2[row][col];
		
		return sum;
	}
	
	public static void main(String[] args)
	{
		Scanner userInput = new Scanner(System.in);
		
		//Prompt user for dimensions.
		System.out.print("How many rows in the first matrix? ");
		int rows1 = userInput.nextInt();
		
		System.out.print("How many columns in the first matrix? ");
		int columns1 = userInput.nextInt();
		
		System.out.print("How many rows in the second matrix? ");
		int rows2 = userInput.nextInt();
		
		System.out.print("How many columns in the second matrix? ");
		int columns2 = userInput.nextInt();
		
		//Call the method to fill the matrices.
		int[][] matrixA = getUserMatrix(rows1, columns1);
		int[][] matrixB = getUserMatrix(rows2, columns2);
		
		//int[][] sum = calculateSum(matrixA, matrixB);
		
		//Output sum to screen to check correctness.
		//for(int i = 0; i < rows; i++)
		//{
			//System.out.print("Row " + i + ": ");
			
			//for(int j = 0; j < columns; j++)
				//System.out.print("Entry " + j + ": " + sum[i][j] + " ");
				
			//System.out.println();
		//}
					
		int[][] product = calculateProduct(matrixA, matrixB);
		
		//Output product to screen to check correctness.
		for(int i = 0; i < rows1; i++)
		{
			System.out.print("Row " + i + ": ");
			
			for(int j = 0; j < columns2; j++)
				System.out.print("Entry " + j + ": " + product[i][j] + " ");
			
			System.out.println();
		}
	}
}	
