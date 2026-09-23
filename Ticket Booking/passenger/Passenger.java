package passenger;
import java.io.*;
public class Passenger implements Serializable
{
  public String Name;
  public int Age;
  public char Gender;
  public long Phone_number;
  public boolean Physical_disable;
  public int Seat;
  
    public Passenger(String name,int age,char gender,long phone,boolean Physical_disable,int seat){
    this.Name=name;
    this.Age=age;
    this.Gender=gender;
    this.Phone_number=phone;
    this.Physical_disable=Physical_disable;
    this.Seat=seat;
  }
}