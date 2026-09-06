
import java.util.Scanner;

class BankAccount {

    int Account_Number;
    String Name;
    int Balance;
}

class AccOpr extends BankAccount {

    void CreateAcc(int Accno, String Name, int Balance) {
        this.Account_Number = Accno;
        this.Name = Name;
        this.Balance = Balance;
    }

    int deposit(int n) {
        Balance += n;
        return Balance;
    }

    int withdraw(int n) {
        if (Balance >= n) {
            Balance -= n;
        }
        return Balance;
    }

    int checkBal() {
        return Balance;
    }

    void DisplayAcc() {
        System.out.println("===> Welcome To Our Bank <===");
        System.out.println("");
        System.out.println("=> Account Number : " + Account_Number);
        System.out.println("=> Account Holder Name : " + Name);
        System.out.println("=> Account Balance : " + Balance);
        System.out.println("");
    }
}

class Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccOpr user1 = new AccOpr();
        boolean bankrun = true;
        while (bankrun) {
            System.out.println("===> Welcome To Our Bank <===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("=> Enter your choice: ");
            int n = sc.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.print("=> Enter Account Number : ");
                    int acc = sc.nextInt();
                    sc.nextLine();
                    System.out.print("=> Enter Holder Name : ");
                    String name = sc.nextLine();
                    System.out.print("=> Enter Balance : ");
                    int bal = sc.nextInt();
                    user1.CreateAcc(acc, name, bal);
                }
                case 2 -> {
                    System.out.print("=> Enter Deposit Money : ");
                    int money = sc.nextInt();
                    user1.deposit(money);
                }
                case 3 -> {
                    System.out.print("=> Enter Withdraw Money : ");
                    int money = sc.nextInt();
                    user1.withdraw(money);
                }
                case 4 -> {
                    System.out.println("Balance : " + user1.checkBal());
                }
                case 5 -> {
                    user1.DisplayAcc();
                }
                case 6 -> {
                    System.out.print("=> Thank You (^.^)");
                    bankrun = false;
                }
                default ->
                    System.out.println("=> Invalid Choice ");
            }
        }
    }
}
