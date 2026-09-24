import java.util.Scanner;
import java.util.Random;

abstract class Pay
{
	abstract double payMode(double bill,double balance);
}
class Upi extends Pay
{
	double payMode(double bill,double balance)
	{
		return balance-bill;
	}
}
class Credit extends Pay
{
	double payMode(double bill,double balance)
	{
		return balance-bill;
	}
}
class Payment
{
	public static void main(String arg[])
	{
		Scanner sc=new Scanner(System.in);
		Random rand  = new Random();
		Pay p;
		double bill = Math.round(rand.nextDouble()*10000*100.0)/100.0;
		System.out.println("-------------------------------------");
		System.out.println("| The Bill is         =  > "+bill);
		System.out.println("| Available Payment Mode  ");
		System.out.println("| 1.UPI   ");
		System.out.println("| 2.Credit Card ");
		System.out.println("-------------------------------------");
		System.out.print("| Choose Payment Mode   = >   ");
		int pay_mode = sc.nextInt();
		double balance = Math.round(rand.nextDouble()*30000*100.0)/100.0;
		while(true){
			if(pay_mode == 1){
				p = new Upi();
				System.out.println("| Accoutnt Balance  = > " +balance);
				System.out.print("| Enter Amount  = > ");
				double amount=sc.nextDouble();
				if(bill > balance){
					System.out.println("| Insufficient Balance  !! ");
				}else if (amount==bill){
				p.payMode(bill,balance);
				System.out.println("| Payment Successful  ");
				break;
				}
				else{
					System.out.println("| Error ! ");
				}
			}
			else if(pay_mode == 2){
				p = new Credit();
				System.out.println("| Account Balnace =  > "+balance);
				System.out.print ("| Enter Amount  = >  ");
				double amount=sc.nextDouble();
				if(bill > balance){
					System.out.println("| Insufficient Balance  !! ");
				}else if (amount==bill){
				p.payMode(bill,balance);
				System.out.println("| Payment Successful  ");
				break;
				}else{
					System.out.println("| Error ! ");
				}
			}
		}
	}
}