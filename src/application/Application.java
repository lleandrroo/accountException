package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.entities.BusinessAccount;
import model.entities.SavingsAccount;
import model.entities.enums.Person;
import model.exception.DomainException;

public class Application {

	public static void main(String[] args) {
		
		/*
		 * 	Fazer um programa para ler os dados de uma conta bancária e depois 
		 * 	realizar um saque nesta conta bancária, mostrando o novo saldo. Um
		 * 	saque não pode ocorrer ou se não houver saldo na conta, ou se o valor
		 * 	do saque for superior ao limite de saque da conta. 
		 * 	
		 * 	Account
		 * 	-number: Integer
		 * 	-holder: String
		 * 	-balance: Double
		 * 	-withdrawLimit: Double
		 * 	+deposit(amount: Double): void
		 * 	+withdraw(amount: Double): void
		 * 
		 * */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Account> acc = new ArrayList<>();
		
		char continuar;
		do {
			System.out.println("Enter data of accounts");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Balance: ");
			double balance = sc.nextDouble();
			System.out.print("Person PP(1), PL(2): ");
			Person person = Person.valueOf(sc.next().toUpperCase());
			
			switch (person.getValue()) {
				case 1:
					acc.add(new SavingsAccount(number, holder, balance));
					break;
				case 2 :
					acc.add(new BusinessAccount(number, holder, balance));
					break;
				default:
					System.out.println("Choose the value option:");
			}
			
			System.out.print("Do you want type new account (Y/N)?: ");
			continuar = sc.next().toUpperCase().charAt(0);
		}while (continuar != 'N');

		// Move that account			
		System.out.print("Do you want move some account (Y or N) ? ");
		continuar = sc.next().toUpperCase().charAt(0);
		if (continuar != 'N') {
			while (continuar != 'N') {
				System.out.print("Type the number of account: ");
				int accountNumber = sc.nextInt();		
				System.out.print("Do you want to deposit (d) or withdraw (w)?");
				char dW = sc.next().toUpperCase().charAt(0);
						
				for(Account ac : acc) {
					if (ac.getNumber().equals(accountNumber)) {
						switch (dW) {
							case 'D':
							System.out.print("Type the quantity that you want to deposit: ");
							double deposit = sc.nextDouble();
							ac.deposit(deposit);
								break;
							case 'W':
								System.out.print("Type the quantity that you want to withdraw: ");
								double withdraw = sc.nextDouble();
								/*String error = ac.validateWithdraw(withdraw);
								if(error != null) {
									System.out.println(error);
								} else { */
								
								try {
									ac.withdraw(withdraw);
									System.out.printf("New balance: %.2f%n", ac.getBalance());
								}
								catch (DomainException e) {
									System.out.println(e.getMessage());
								}
								
								break;
						}
					}
				}
				System.out.print("\nDo you want move that account? ");
				continuar = sc.next().toUpperCase().charAt(0);
			}	
		}				
		sc.close();
	}

}
