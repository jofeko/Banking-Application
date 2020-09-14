package bank;

import java.util.Scanner;

class BankAccount{
	private int balance;
	private int previousTransaction;
	private String customerName;
	private String customerID;
	
	public BankAccount(String cName, String cId) {
		this.customerName = cName;
		this.customerID = cId;
	}
		
	public void deposit(int amount) {
		if(amount > 0) {
			balance += amount;
			previousTransaction = amount;
		}
	}
	
	public void withdraw(int amount) {
		if(amount > 0) {
			balance -= amount;
			previousTransaction = -amount;
		}
	}
	
	public void previousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Last deposit: "+previousTransaction);
		} 
		else if (previousTransaction < 0){
			System.out.println("Last withdraw: "+previousTransaction);
		}
		else {
			System.out.println("No transactions detected");
		}
	}
	
	public void printMenu() {
		char option ='0';
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome "+customerName);
		System.out.println("Bank account related to ID: "+customerID);
		System.out.print("\n");
		System.out.println("A - Check Balance");
		System.out.println("B - Deposit");
		System.out.println("C - Withdraw");
		System.out.println("D - Previous transaction");
		System.out.println("E - Exit");
		
		
		do {			
			System.out.print("\n");
			System.out.println("*** Enter an option ***");
			option = scan.next().toUpperCase().charAt(0);
			
			switch(option) {
			
			case 'A':
				System.out.println("Balance = "+balance);
				break;
				
			case 'B':
				System.out.println("Enter a deposit amount");
				if (scan.hasNextInt()) {
					int amountIn = scan.nextInt();
					deposit(amountIn);	
				}	else {
					System.out.println("Wrong format. Only integer allowed");	
				}		
				break;
				
			case 'C':
				System.out.println("Enter a withdrawal amount");
				if (scan.hasNextInt()) {
					int amountOut = scan.nextInt();
						if (balance >= amountOut) {
							withdraw(amountOut);
						} else {
							System.out.println("Withdrawal amount exceeds current balance. No overdraft possible");	
						}
				}	else {
					System.out.println("Wrong format. Only integer allowed");
				}
				break;
				
			case 'D':
				previousTransaction();
				break;
				
			case 'E':
				System.out.println("*** Thank you for banking with us ***");
				break;
			
			default: 
				System.out.println("Invalid entry. Please enter again");
				break;
			}
			
		} while (option != 'E');	
		
	}		
	
}