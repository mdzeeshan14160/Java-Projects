
import java.util.*;

class Contact
{
  private String name;
  private String Phone_number;
  private String email;
  public String getname(){
    return name;
  }
  @Override
  public String toString() {
      return "[ Name: " + name +
            ", Phone: " + Phone_number +
            ", Email: " + email+" ]";
  }
  public String getphn(){
    return Phone_number;
  }
  public String getemail(){
    return email;
  }
  void setname(String person){
    name=person;
  }
  void setphn(String ph){
    Phone_number=ph;
  }
  void setemail(String mail){
    email=mail;
  }
}
class ContactException extends Exception{
  ContactException(String msg){
    super(msg);
  }
} 
class Crud 
{
  HashMap<String,Contact>map=new HashMap<>();
  void addcontact(String ph,String name,String email) throws ContactException{
      if(map.containsKey(ph)){
        throw new ContactException("-> Duplicate Phone Number ");
      }
      else if(ph.length()!=10 && !ph.matches("\\+d")){
        throw new ContactException("-> Enter Valid Phone Number");
      }
    Contact c=new Contact();
    c.setname(name);
    c.setphn(ph);
    c.setemail(email);
    map.put(ph,c);
  }
  void viewcont(){
    System.out.println(map.toString());
  }
  void searchcont(String ph){
    if(map.containsKey(ph)){
      System.out.println(map.get(ph).toString());
    }else{
      System.out.println("-> No Contact Found");
    }  
  }
  void deletecont(String ph){
    if(map.containsKey(ph)){
    map.remove(ph);
    }else{
      System.out.println("-> Contact Does Not Exist");
    }
  }
  void updatecont(String ph,String name,String email){
    Contact temp=map.get(ph);
    if(temp!=null){
      temp.setname(name);
      temp.setemail(email);
    }else{
        System.out.println("Contact Does Not Exist !");
    }
  }
}
class Main{
   public static void main (String[] args) {
   Scanner sc=new Scanner(System.in);
   Crud user=new Crud();
   System.out.println("| > Contact Manaager <-");
   while(true){
    System.out.println();
    System.out.println("| > 1. Add Contact");
    System.out.println("| > 2. View Contacts");
    System.out.println("| > 3. Search Contact");
    System.out.println("| > 4. Update Contact");
    System.out.println("| > 5. Delete Contact");
    System.out.println("| > 6. Exit");
    System.out.print("| > Select what you want to do: ");
    int opt=sc.nextInt();
    sc.nextLine();
    switch(opt){
      case 1 -> {
        System.out.print("| > Enter Phone Number : ");
        String ph = sc.nextLine();
        System.out.print("| > Enter Name : ");
        String name = sc.nextLine();
        System.out.print("| > Enter Email : ");
        String email = sc.nextLine();
        try {
          user.addcontact(ph,name,email);
        }
        catch(ContactException ce){
          System.out.println(ce);
        }
      }
      case 2 -> user.viewcont();
      case 3 -> {
        System.out.print("| > Search : ");
        String Search=sc.nextLine();
        user.searchcont(Search);
      }
      case 4 -> {
        System.out.print("| > Enter Phone Number : ");
        String ph = sc.nextLine();
        System.out.print("| > Enter New Name : ");
        String name = sc.nextLine();
        System.out.print("| > Enter New Email : ");
        String email = sc.nextLine();
        user.updatecont(ph, name, email);
      }
      case 5 -> {
        System.out.print("| > Enter Phone Number : ");
        String ph = sc.nextLine();
        user.deletecont(ph);
      }
      case 6 -> {
        return;
      }
    }
   }
  }
}
