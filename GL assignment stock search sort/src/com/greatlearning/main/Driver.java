package com.greatlearning.main;
import com.greatlearning.services.MergeSortAsc;
import com.greatlearning.services.MergeSortDesc;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int numCo;	
		int numStockRise=0;
		int numStockDecl=0;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("enter the no of companies");
		numCo=sc.nextInt();
		float[] stockPrices= new float[numCo];
		for(int i=0;i<numCo;i++)
	     {
	         System.out.println("Enter current stock price of the company "+(i+1));
	         stockPrices[i]=sc.nextFloat();
	         System.out.println("Whether company's stock price rose today compare to yesterday? enter true/false");
	         if (sc.nextBoolean()) {
	        	 numStockRise+=1;        	 
	         }else {numStockDecl+=1;
	         }
	         }
		int choice;
		//user is informed of choice 
		do {
			System.out.println("\n---------------------------------------------------------------------------------------\n");

		System.out.println("Enter the operation that you want to perform\n" + "1. Display the companies stock prices in ascending order\n"

		+ "2. Display the companies stock prices in descending order\n" + "3. Display the total no of companies for which stock prices rose today \n"

		+ "4. Display the total no of companies for which stock prices declined today\n" + "5. Search a specific stock price\n"+"6. press 0 to exit\n");

		System.out.println("---------------------------------------------------------------------------------------");



		choice = sc.nextInt();

		switch (choice) {

		case 0:

		choice = 0;

		break;

		case 1:
		{
			MergeSortAsc stockasc =new MergeSortAsc();
			stockasc.sort(stockPrices,0,stockPrices.length-1);
			System.out.println("Stock prices in ascending order are :");
			for(int i=0;i<stockPrices.length;i++) {
				System.out.print(stockPrices[i]+" ");
			}
		}
		break;
		
		case 2:{
			MergeSortDesc stockDesc =new MergeSortDesc();
			stockDesc.sort(stockPrices,0,stockPrices.length-1);
			System.out.println("Stock prices in descending order are :");
			for(int i=0;i<stockPrices.length;i++) {
				System.out.print(stockPrices[i]+" ");
			}
		}
		break;

		case 3: {

		System.out.println("Total no of companies whose stock price rose today : "+numStockRise);

		}

		break;

		case 4: {

			System.out.println("Total no of companies whose stock price declined today : "+numStockDecl);

		}

		break;

		case 5: {

			System.out.println("enter the key value :" );
			float keyVal=sc.nextFloat();
			boolean found=false;
			for(int i=0;i<stockPrices.length;i++) {
				if (stockPrices[i]==keyVal) {
					System.out.println("Stock of value "+keyVal+" is present");
					found=true;
					break;
				}
			}
			if (!found){
			System.out.println("Value not found");
			}
			}

		break;

		}

		} while (choice != 0);

		System.out.println("Exited Successfully");

		sc.close();

	}
}
