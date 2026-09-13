import java.util.Scanner;

class BankAccount {

    private  int Account_Number;
    private  String Name;
    private int Balance;
    public int Accountnum(){
        return Account_Number;
    }
    public String getname(){
        return Name;
    } 
    public int getbalance(){
        return Balance;
    }
    void setacc(int n){
        Account_Number=n;
    }
    void setname(String n){
        Name=n;
    }
    void setbal(int n){
        Balance=n;
    }
}

class AccOpr extends BankAccount {

    void CreateAcc(int Accno, String Name, int Balance) {
       setacc(Accno);
       setname(Name);
       setbal(Balance);
    }

    int deposit(int n) {
        if (n <= 0) {
            System.out.println("Amount Must Be Greater Than 0");
            return -1;
        } else {
           int temp = getbalance()+n;
           setbal(temp);
        }
        return getbalance();
    }

    int withdraw(int n) {
         if(n<=0){
            System.out.println("Amount Must Be Greater Than 0");
            return -1;
        }
        else if (getbalance() >= n) {
            int temp=getbalance()-n;
            setbal(temp);
        }
        else{
            System.out.println("Insufficient Balance");
            return -1;
        }
        return getbalance();
    }

    int checkBal() {
       return getbalance();
    }

    void DisplayAcc() {
        System.out.println("===> ACCOUNT DETAILS <===");
        System.out.println("");
        System.out.println("=> Account Number : " + Accountnum());
        System.out.println("=> Account Holder Name : " + getname());
        System.out.println("=> Account Balance : " + getbalance());
        System.out.println("");
    }
}

class Bank {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccOpr user1 = new AccOpr();
        boolean bankrun = true;
		System.out.println("===> Welcome To Our Bank <===");
        System.out.println("Please Create An Account First");
		 System.out.print("=> Enter Account Number : ");
			int acc = sc.nextInt();
			sc.nextLine();
			System.out.print("=> Enter Holder Name : ");
			String name = sc.nextLine();
			System.out.print("=> Minimum ₹500 Deposit Required to Open an Account : ");
			boolean min_dep=true;
			int bal = sc.nextInt();
			while(min_dep){
				if(bal<500){
				System.out.println("=> Minimum ₹500 Deposit Required : ");
				bal=sc.nextInt();
				}else{
					min_dep=false;
                    System.out.println("=> "+bal+" Deposited Successfully");
				}
			}
			user1.CreateAcc(acc, name, bal);
			System.out.println();
        while (bankrun) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Account");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("=> Enter your choice: ");
            int n = sc.nextInt();
            switch (n) {
                case 1 -> {
                    System.out.print("=> Enter Deposit Money : ");
                    int money = sc.nextInt();
                    int result = user1.deposit(money);
                    if (result != -1) {
                        System.out.println("=> "+money+" Deposited Successfully");
                    }
                }
                case 2 -> {
                    System.out.print("=> Enter Withdraw Money : ");
                    int money = sc.nextInt();
                    int result = user1.withdraw(money);
                    if (result != -1) {
                        System.out.println("=> "+money+" Withdraw Successfully");
                    }
                }
                case  3-> {
                    System.out.println("Balance : " + user1.checkBal());
                }
                case 4 -> {
                    user1.DisplayAcc();
                }
                case 5 -> {
                    System.out.print("=> Thank You (^.^) Visit Again");
                    bankrun = false;
                }
                default ->
                    System.out.println("=> Invalid Choice ");
            }
        }
    }
}