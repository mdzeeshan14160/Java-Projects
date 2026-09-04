import java.util.*;
class Game
{
	public void GuessNum()
	{
		Random ran=new Random();
		int n=ran.nextInt(10);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.print("Guess Your Number : ");
			int guess=sc.nextInt();
			if(guess==n){
				System.out.println("You Guessed Right (^.^) !!!");
				break;
			}
			else if(guess < n){
				System.out.println("Hint --> High");
			}
			else{
				System.out.println("Hint --> Low");
			}
		}
	}
	public static void main(String args[])
	{
		Game user1=new Game();
		user1.GuessNum();
	}
}