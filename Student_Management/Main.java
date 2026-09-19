import stud_serveices.Services;
import java.util.Scanner;
class Main
{
  public static void main (String[] args) {
    Scanner sc=new Scanner(System.in);
    Services stud=new Services(sc);
    System.out.println("[ | Welcome To Our College | ]");
    while(true){
	  System.out.println();
      System.out.println("| 1. Add Student -> : ");
      System.out.println("| 2. View Students -> : ");
      System.out.println("| 3. Search Student -> : ");
      System.out.println("| 4. Sort Students -> : ");
      System.out.println("| 5. Delete Student -> : ");
      System.out.println("| 6. Update Student -> : ");
      System.out.println("| 7. Exit -> : ");
	  System.out.println();
      System.out.print("| Perform An Operation -> : ");
      int opt=sc.nextInt();
      switch(opt){
        case 1 -> {
          stud.add_stud();
        }
        case 2 ->{
          stud.view_stud();
        }
        case 3 ->{
          stud.Search();
        }
        case 4 ->{
          stud.filter_stud();
        }
        case 5 -> {
          stud.del_stud();
        }
        case 6 ->{
          stud.upd_stud();
        }
        case 7 -> { 
          return;
        }
      }
    }
  }
}