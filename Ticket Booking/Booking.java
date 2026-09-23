import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import passenger.Passenger;

class Booking
{
  Scanner sc=new Scanner(System.in);
  HashMap<Integer,Passenger>seatMap=new HashMap<>();
  ArrayList<Passenger> currentBooking=new ArrayList<>();
  String seats[]=new String[21];

  void bookTicket()
  {
    System.out.print("[INFO] Enter Number Of Person -> : ");
    int n_person=sc.nextInt();
    sc.nextLine();

    for(int i=0;i<n_person;i++)
    {
      System.out.println("----------- PASSENGER "+(i+1)+" ----------------");
      System.out.print("Enter Name                        : ");
      String person_name=sc.nextLine();
      System.out.print("Enter Age                         : ");
      int Age=sc.nextInt();
      System.out.print("Gender (M / F)                    : ");
      char Gender=sc.next().charAt(0);
      System.out.print("Enter Phone Number                : ");
      long Phone_number=sc.nextLong();
      System.out.print("Physical Disabled (true / false)  : ");
      boolean Physical=sc.nextBoolean();
      System.out.print("Select Available Seat             : ");
      int seat=sc.nextInt();

      while(true)
      {
        if(seatMap.containsKey(seat))
        {
          System.out.print("This Seat is Booked, Try another Available Seat : ");
          seat=sc.nextInt();
        }
        else
        {
          break;
        }
      }

      sc.nextLine();

      Passenger Person=new Passenger(person_name,Age,Gender,Phone_number,Physical,seat);
      seatMap.put(seat,Person);
      currentBooking.add(Person);
    }
  }

  void showAvailableSeats()
  {
    for(int i=1;i<=20;i++)
    {
      if(seatMap.containsKey(i))
      {
        seats[i]="X";
      }
      else
      {
        seats[i]=String.valueOf(i);
      }
    }

    int seat_no=1;

    for(int i=0;i<5;i++)
    {
      for(int j=0;j<2;j++)
      {
        System.out.printf("[%-2s] ",seats[seat_no]);
        seat_no++;
      }

      System.out.print("     ");

      for(int j=0;j<2;j++)
      {
        System.out.printf("[%-2s] ",seats[seat_no]);
        seat_no++;
      }

      System.out.println();
    }
  }

  void saveData() throws IOException,ClassNotFoundException
  {
    File file=new File("book.dat");
    FileOutputStream file_out=new FileOutputStream(file);
    ObjectOutputStream file_write=new ObjectOutputStream(file_out);
    file_write.writeObject(seatMap);
    file_write.close();
  }

  void allPassengerDetail()
  {
    System.out.println();
    System.out.println("----------- ALL PASSENGER DETAILS -----------");

    for(Passenger passenger:seatMap.values())
    {
      System.out.println("--------------------------------------------------------------");
      System.out.println("Name              : "+passenger.Name);
      System.out.println("Age               : "+passenger.Age);
      System.out.println("Gender            : "+passenger.Gender);
      System.out.println("Phone Number      : "+passenger.Phone_number);
      System.out.println("Physical Disabled : "+passenger.Physical_disable);
      System.out.println("Allotted Seat     : "+passenger.Seat);
      System.out.println("Status            : Confirmed");
      System.out.println();
    }
  }

  void loadData() throws ClassNotFoundException,IOException
  {
    File file=new File("book.dat");

    if(file.exists())
    {
      FileInputStream file_inp=new FileInputStream(file);
      ObjectInputStream obj_inp=new ObjectInputStream(file_inp);
      seatMap=(HashMap<Integer,Passenger>)obj_inp.readObject();
      obj_inp.close();
    }
  }

  void cancelTicket(int cancel_seat)
  {
    seats[cancel_seat] = String.valueOf(cancel_seat);
    seatMap.remove(cancel_seat);
  }

  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    Booking book=new Booking();

    try{
      book.loadData();
    }
    catch(ClassNotFoundException | IOException e){
      System.out.print("Error ! ");
    }

    System.out.println("========================================");
    System.out.println("           TICKET BOOKING SYSTEM");
    System.out.println("========================================");
    System.out.println();
    System.out.println(" Welcome (^.^) ");
    System.out.println();
    System.out.println("1. Book Your Journey Ticket  ");
    System.out.println("2. Cancel Your Ticket  ");
	System.out.println("3. Passengers Details  ");
    System.out.print("|  Select               : ");
    int select=sc.nextInt();
    if(select==2){
      System.out.print(" Enter Your Seat  Number to Cancel   : ");
      int cancel_seat=sc.nextInt();
      book.cancelTicket(cancel_seat);
	  try{
		  book.saveData();
	  }
	  catch(ClassNotFoundException | IOException e){
        System.out.print("  error ! ");
    }
      System.out.println(" Your Ticket is Cancelled   ");
      return;
    }
	if(select==3)
	{
	 System.out.print("Enter Admin Password : ");
	 int admin_password=sc.nextInt();
	if(admin_password==5100)
	  {
		book.allPassengerDetail();
	  }
	 else
	 {
		System.out.println("Wrong Admin Password");
	 }
	  return;
	}
    System.out.println("----------- AVAILABLE SEATS ------------");
    System.out.println();
    book.showAvailableSeats();
    System.out.println();
    System.out.println("========================================");

    book.bookTicket();

    System.out.println();
    System.out.println("----------- UPDATED SEATS ---------------");
    System.out.println();
    book.showAvailableSeats();

    System.out.println();
    System.out.println("========================================");
    System.out.println("           BOOKING CONFIRMED");
    System.out.println("========================================");

    for(Passenger passenger:book.currentBooking)
    {
      System.out.println("Name          : "+passenger.Name);
      System.out.println("Age           : "+passenger.Age);
      System.out.println("Allotted Seat : "+passenger.Seat);
      System.out.println("Status        : Confirmed");
    }

    System.out.println();

    try{
      book.saveData();
    }
    catch(ClassNotFoundException | IOException e){
      System.out.print("Error !");
    }

    System.out.println("========================================");
  }
}