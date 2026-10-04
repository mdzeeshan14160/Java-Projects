import java.util.*;
import java.util.concurrent.*;

class Ticket 
{
  int ticId;
  String passName;
  String source;
  String dest;
  int amount;

  Ticket(int id,String name,String s,String d,int price){
    this.ticId=id;
    this.passName=name;
    this.source=s;
    this.dest=d;
    this.amount=price;
  }
}

class TicketProcess 
{
  Random rand = new Random();
  int seats=10;
  Object lock =new Object();
  Ticket obj;

  boolean processTicket(String s,String d){
    if(s.equals(d)){
      System.out.println("Invalid Route");
      return true;
    }

    synchronized(lock){
      if(seats<=0){
        System.out.println("Sorry, Tickets Full !!");
        return true;
      }else{
        seats--;
      }
    }

    return false;
  }
  
  synchronized int checkSeats(){
    return seats;
  }

  boolean payAmount(int amount,int ticketPrice){
    if(amount < ticketPrice || amount > ticketPrice){
      System.out.println("Invalid Amount !!");
      return true;
    }else{
      System.out.println("Payment Processing...");
    }

    return false;
  }
  
  Ticket bookTicket(){
    int amount,ticId;
    String src,des,name;

    String[] names={"Zishan","Rahul","Bhuvan","Jagan","Charan","Akash","Praneeth"};
    String[] places={"Hyderabad","Chennai","Bangalore","Mumbai","Howrah","Delhi","Patna","Vishakapatnam","Vijaywada"};
    
    synchronized(lock){

      if(seats<=0){
        System.out.println("Sorry, Tickets Full !!");
        return null;
      }

      name=names[rand.nextInt(names.length)];
      ticId=rand.nextInt(900)+100;

      while(true){
        src=places[rand.nextInt(places.length)];
        des=places[rand.nextInt(places.length)];

        if(!processTicket(src,des)){
          break;
        }
      }

      int bill=555+src.length()+des.length();

      System.out.println("\nTicket Booking Started");
      System.out.println("Route : "+src+" -> "+des);
      System.out.println("Price : "+bill);

      while(true){
        amount=bill;

        if(!payAmount(amount,bill)){
          break;
        }
      }
    }

    return new Ticket(ticId,name,src,des,amount);
  }

  void pasDetails(Ticket obj){
    System.out.println("\n----- Ticket Details -----");
    System.out.println("Ticket ID : "+obj.ticId);
    System.out.println("Name      : "+obj.passName);
    System.out.println("Route     : "+obj.source+" -> "+obj.dest);
    System.out.println("Amount    : "+obj.amount);
    System.out.println("Seat no   : "+seats);
  }
}

class TicketBookProcess implements Runnable
{
  TicketProcess pas;

  TicketBookProcess(TicketProcess pas){
    this.pas=pas;
  }

  public void run(){
    try {
      Ticket obj=pas.bookTicket();

      if(obj==null){
        return;
      }

      Thread.sleep(4000);

      System.out.println("Payment Successful");

      Thread.sleep(1500);

      pas.pasDetails(obj);
    }
    catch(InterruptedException e){
      System.out.println(e);
    }
  }
}

class MultiThreads
{
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);

    System.out.print("| How Many Tickets Want to Book : ");
    int n=sc.nextInt();

    TicketProcess pas=new TicketProcess();
    Runnable r=new TicketBookProcess(pas);
    ExecutorService ex=Executors.newFixedThreadPool(2);
    
    for(int i=0;i<n;i++){
      ex.submit(r);
    }

    ex.shutdown();
  }
}