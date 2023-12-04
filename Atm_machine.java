package Atm_interface;

import java.util.Scanner;

class BankAccount{
    private double Balance;
    
    public BankAccount(double Balance){
        this.Balance = Balance;
    }

    public double getBalance(){
        return Balance;
    }

    public void depositAmount(double depositAmount){
        Balance+=depositAmount;
    }
    public void withdrawAmount(double withdrawAmount){
        if(withdrawAmount<=Balance){
            Balance -= withdrawAmount;
        }else {
            System.out.println("Insufficient balance");
        }
        }
    }

    class ATM{
        private BankAccount account;

        public ATM(BankAccount account){
            this.account=account;
        }
        public void MenuOptions(){
            System.out.println("Welcome to Our Bank ATM");
            System.out.println("------------------------");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.println("-------------------------");
        }

        public void UserChoice(int choice){
            Scanner sc =new Scanner(System.in);
            switch (choice) {
                case 1: 
                    System.out.println("You chose to deposit money to your account.");
                    System.out.print("Enter the amount you want to deposit: ");
                    double depositAmount= sc.nextDouble();
                    account.depositAmount(depositAmount);
                    System.out.println("Deposit successful!\nMoney has been added to your account.");
                    System.out.println("Your new balance is :"+account.getBalance()+"\n");
                    System.out.println("-------------------------m");

                    break;
                case 2:
                    System.out.println("You chose to withdraw cash from your account.");
                    System.out.print("Enter the amount you want to withdraw: ");
                    double withdrawAmount=sc.nextDouble(); 
                    account.withdrawAmount(withdrawAmount);
                    System.out.println("Withdrawal Successful!");
                    System.out.println("Your new balance is :"+account.getBalance()+"\n");
                    System.out.println("-------------------------");                    
                    break;
                case 3:
                    System.out.println("You chose to check your current balance in your account.");
                    System.out.println("Current Balance is "+account.getBalance()+"\n");
                    System.out.println("-------------------------");
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!\n");
                    System.exit(0);
                    break;
                default:
                System.out.println("Invalid choice. Please choose a number from the menu.\n");
                System.out.println("-------------------------");
            }
    
        }
    }public class Atm_machine {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(14000.0);
        ATM atm = new ATM(userAccount);
        atm.MenuOptions();


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            atm.UserChoice(choice);
        }
    }
}
