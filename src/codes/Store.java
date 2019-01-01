package codes;

import java.util.Scanner;

public class Store {
	
	public static int mainMenuChoice = 0, storeChoice = 0, purchaseChoice = 0, number = 0, check = 0, response = 0;
	public static int canvas = 0, pencil = 0, paintTube = 0, brush = 0;
	public static double money = 100, canvasPrice = 23.00, pencilPrice = 0.25, paintTubePrice = 10.00, brushPrice = 8.00;
	
	public static int errorTrap()
	{
		Scanner input = new Scanner(System.in);
		
		do
		{
			check = 1;
			
			try
			{
				number = input.nextInt();
			}
			catch (Exception e)
			{
				input.next();
				
				System.out.println("Invalid input. Try again");
				check = 0;
			}
		} while (check == 0);
		
		return number;
	}
	
	public static int errorTrapRange(int min, int max)
	{
		Scanner input = new Scanner(System.in);
		
		do
		{
			check = 1;
			
			try
			{
				number = input.nextInt();
			}
			catch (Exception e)
			{
				input.next();
				
				
				check = 0;
			}
			
			if (number < min || number > max || check == 0)
			{
				System.out.println("Invalid input. Try again");
			}
			
		} while (number < min || number > max || check == 0);
		
		return number;
	}
	
	public static void inventory()
	{
		System.out.println("Inventory\n=========");
			System.out.println("Canvas:		" + canvas);
			System.out.println("Pencils:	" + pencil);
			System.out.println("Paint Tubes:	" + paintTube);
			System.out.println("Brushes:	" + brush);
			System.out.println("Money:		" + money);
		System.out.println("=========");
	}
	
	public static void mainMenu()
	{
		System.out.println("Main Menu\n=========");
		System.out.println("0. Exit");
		System.out.println("1. Go to Store");	
		
	}
	
	public static void store()
	{	
		System.out.println("Welcome to the Store!");
		
		do
		{
			System.out.println("What would you like to buy?");
			System.out.println("	0. Exit");
			System.out.println("	1. Canvas	$" + canvasPrice);
			System.out.println("	2. Pencil	$ " + pencilPrice);
			System.out.println("	3. Paint Tube	$" + paintTubePrice);
			System.out.println("	4. Brush	$ " + brushPrice);
			
			do
			{
				storeChoice = errorTrapRange(0,4);
				
			} while (storeChoice < 0 && storeChoice > 4);
			
			if(storeChoice == 1) // Canvas
			{
				purchase(1,canvasPrice);
			}
			if(storeChoice == 2) // Pencil
			{
				purchase(2,pencilPrice);
			}
			if(storeChoice == 3) // Paint Tube
			{
				purchase(3,paintTubePrice);
			}
			if(storeChoice == 4) // Brush
			{
				purchase(4,brushPrice);
			}
			
		} while(storeChoice != 0);
	}
	
	public static void purchase(int item,double price)
	{
		do
		{
			inventory();
			
			System.out.println("How many would you like to purchase?");
				purchaseChoice = errorTrap();
				
				if(purchaseChoice*price > money)
				{
					System.out.println("Insufficient funds.");
				}
				else
				{
					money -= purchaseChoice*price;
					
					if (item == 1)
					{
						canvas += purchaseChoice;
					}
					else if (item == 2)
					{
						pencil += purchaseChoice;
					}
					else if (item == 3)
					{
						paintTube += purchaseChoice;
					}
					else if (item == 4)
					{
						brush += purchaseChoice;
					}
					
				}
				
				System.out.println("Would you like to purchase more?");
					System.out.println("0. No");
					System.out.println("1. Yes");
				response = errorTrapRange(0,1);
				
		} while(response == 1);
	}
	
//************************************************************************************************************
	
	public static void main(String[] args) throws Exception{
		
		do
		{
			inventory();
			
			mainMenu();
			
			mainMenuChoice = errorTrapRange(0,1);
			
			if(mainMenuChoice == 1) // Go to Store
			{
				store();
			}
				
		} while (mainMenuChoice != 0);
		
		System.out.println("Thank you for playing");

	}

}