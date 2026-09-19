package stud_manage_sys;
public class Student
{
  private int roll_no;
  private String stud_name;
  private int year;
  private int[] marks;
  public Student(){
    marks=new int[3];
  }
  public String toString(){
  return "Roll Number : "+roll_no+
         "\nName : "+stud_name+
         "\nClass : "+year+
         "\nMarks : "+marks[0]+" "+marks[1]+" "+marks[2];
	}
  public void setroll(int n){
    roll_no=n;
  }
  public void setstdname(String s){
    stud_name=s;
  }
  public void setyear(int n){
    year=n;
  }
  public void setmark(int i,int mark){
    marks[i]=mark;
  }
  public int get_rool(){
    return roll_no;
  }
  public int[] get_mark(){
    return marks;
  }
}