package oct27;
//
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Student {
	
	String  firstname;
	String lastname;
	int birthday;
	
	Student(){};
	Student(String fn, String ln, String items, int b){
		firstname = fn;
		lastname = ln; //convert item into date
		birthday = b; 
	}
	
	private static ArrayList<Student> getFromFile(String inputFile)throws Exception {
		ArrayList<Student> myarraylist = new ArrayList<>();
		 File f = new File(inputFile);
		 Scanner input = new Scanner(f);
		 String cls = input.nextLine();
		 int classcount = Integer.parseInt(cls);
		 for (int i = 0; i<classcount; i++) {
			 int studentcount = Integer.parseInt(input.nextLine());
			 for (int j = 0; j < studentcount; j++) {
				 String line = input.nextLine();
				 String[] items = line.split("\\s+");
				 Student s = new Student(items[0], items[1], items[2], Integer.parseInt(items[3]));
				 myarraylist.add(s);
			 }
		 }
		 
		return myarraylist;
	}
	
	public String toString(){
		return this.firstname+"\t"+this.lastname+"\t"+this.birthday;
	}
	
	
	public static void main (String[] args){
		try {
			ArrayList<Student> myarraylist = getFromFile("birthday.txt");
			System.out.println(myarraylist);
		} catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
		}
		
		
	}
	
}
