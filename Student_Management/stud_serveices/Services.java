package stud_serveices;
import stud_manage_sys.Student;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import stud_exception.StdExc;
public class Services
{
  void check_Cls(int cls)throws StdExc{
    if(cls<=0 || cls>12){
      throw new StdExc("Invlaid Class ! <- ");
    }
  }
	 public Services(Scanner sc){
	  this.sc=sc;
	}
  ArrayList<Student>user=new ArrayList<>();
  Scanner sc=new Scanner(System.in);
   public void add_stud(){
    Student s=new Student();
    Random rand=new Random();
    int roll=rand.nextInt(9000)+1000;
      s.setroll(roll);
	  sc.nextLine();
      System.out.print("| Enter Student Name -> : ");
      String sn=sc.nextLine();
      s.setstdname(sn);
      System.out.print("| Enter Student Class -> : ");
      while(true){
        int cls;
       try{
        cls=sc.nextInt();
        check_Cls(cls);
		s.setyear(cls);
		break;
      }
      catch(StdExc e){
        System.out.println("| -> :"+e);
        } 
  }
      for(int i=0;i<3;i++){
      System.out.print("| Enter Student Subject "+(i+1)+" Marks  -> : ");
      while(true){
      try{
      int marks=sc.nextInt();
      if(marks<0 || marks>30)
      {
        throw new StdExc("Invlaid Marks !");
      }
      s.setmark(i,marks);
      break;
      }
      catch(StdExc e){
        System.out.print("| -> : "+e);
        }
      }
    }
    user.add(s);
  }
  public void view_stud(){
	for(Student s : user){
    System.out.println(s);
	System.out.println();
	}
  }
  public void Search(){
    System.out.print("| Search Student -> : ");
    int roll=sc.nextInt();
    boolean sear=false;
    for(Student S:user){
      if(S.get_rool()==roll){
        System.out.println(S);
        sear=true;
      }
    }
    if(!sear){
      System.out.println("| Student Not Found ! <- ");
    }
  }
  public void filter_stud(){
    for(int i=0;i<user.size();i++){
      int swap=0;
      for(int j=0;j<user.size()-i-1;j++){
        Student s1=user.get(j);
        Student s2=user.get(j+1);
        int[]  mark1=s1.get_mark();
        int[] mark2=s2.get_mark();
        int sum1=0,sum2=0;
        for(int k=0;k<3;k++){
          sum1 +=mark1[k];
          sum2 +=mark2[k];
          }
          if(sum2<sum1){
            user.set(j,s2);
            user.set(j+1,s1);
            swap++;
          }
        }
      if(swap==0){
        break;
      }
    }
    for(Student s : user){
    System.out.println(s);
    System.out.println();
    }
  }
  public void del_stud(){
    System.out.print("| Enter Student Roll Number To Delete -> : ");
    int roll=sc.nextInt();
    int del=0;
    for(int i=0;i<user.size();i++){
      Student s=user.get(i);
      if(s.get_rool()==roll){
        user.remove(s);
        del++;
        break;
      }
    }
    if(del==0)
    System.out.println("| Student  Not Found ! ");
  }
  public void upd_stud(){
    System.out.print("| Enter The Roll Number To Update -> : ");
    int rl=sc.nextInt();
    int upd=0;
    for(int i=0;i<user.size();i++){
      Student s=user.get(i);
      if(s.get_rool()==rl){
        while(true){
        int yr;
        try{
        System.out.print("| Enter The Class -> : ");
        yr=sc.nextInt();
        check_Cls(yr);
        s.setyear(yr);
        upd++;
        break;
        }
        catch(StdExc e){
          System.out.print("| -> "+e);
        }
      }
    }
	}
	if(upd==0){
    System.out.println("| No Student Found ! ");
  }
}
}