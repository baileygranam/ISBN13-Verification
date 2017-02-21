package verification;

import java.util.Scanner;

public class ISBNVerification {
	
	private static String ISBN;
	private static Scanner scanner;
	private static int total;
	private static int checkDigit;
	
	/**
	 * The purpose of the main is to ask the user for an ISBN in which
	 * the verifyISBN() method is called to get the result.  
	 * @param args
	 */

	public static void main(String[] args) {
				
		while(true)
		{
		getISBN();
		verifyISBN();
		}

	}
	
	/**
	 * The purpose of this method is to retrieve the ISBN number from the users.
	 * This utilizes the scanner utility and stores the user-entered value 
	 * in the variable ISBN.
	 * 
	 * @return ISBN (Value user entered). 
	 */
	
	public static String getISBN()
	{
		scanner = new Scanner(System.in);
		System.out.println("Enter your 13 digit ISBN number.");
		ISBN = scanner.nextLine();
		return ISBN;
	}
	
	/**
	 * The purpose of this method is to remove all non-numeric characters 
	 * from the ISBN entered and to check to see if the final ISBN result has
	 * a length of 13 digits. If the ISBN is invalid we ask the user to re-enter
	 * until the ISBN equals 13 digits.
	 * 
	 * @return true (If validation is a success)
	 */
	
	public static boolean validateISBN()
	{
		ISBN = ISBN.replaceAll( "[^\\d]", "" );
		
		while(ISBN.length() != 13) 
		{
			ISBN = getISBN();
			ISBN = ISBN.replaceAll( "[^\\d]", "" );
		}
		
		return true;
	}
	
	/**
	 * The purpose of this method is to verify the ISBN check digit. The method
	 * first checks to see that the ISBN is valid via the validateISBN() method. 
	 * 
	 * If the ISBN is valid then we will loop through the ISBN.
	 * 
	 * Each digit, from left to right, is alternately multiplied by 1 or 3.
	 * 
	 * Then those products are summed modulo 10 to give a value ranging from 0 to 9. 
	 * Subtracted from 10, that leaves a result from 1 to 10. A zero replaces 
	 * a ten, so, in all cases, a single check digit results.
	 * 
	 * The output of the method is either valid or invalid. 
	 * 
	 */
	
	public static void verifyISBN()
	{
		if(validateISBN())
		{
			total = 0;
			checkDigit = Character.getNumericValue(ISBN.charAt(12));
			
			for(int i=0; i<12; i++)
			{
				if(i%2 == 1)
				{
					total = total + (3 * Character.getNumericValue(ISBN.charAt(i)));
				}
				else
				{
					total = total + Character.getNumericValue(ISBN.charAt(i));
				}
			}
			
			if((10-total%10) == checkDigit)
			{
				System.out.println("ISBN " + ISBN + " is valid!");
			}
			else
			{
				System.out.println("ERROR: ISBN " + ISBN + " is INVALID!");
			}
		}
		else
		{
			System.out.println("Error can not verify an invalid ISBN");
		}
	}

}
