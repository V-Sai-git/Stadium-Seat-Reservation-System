import java.util.List;
import java.util.Scanner;
import java.io.FileReader;
import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;
import java.lang.Math;   

 class Resv      				// NODE CLASS TO STORE DATA
{
	int rno,no_seats,age;
	String name,add,mail_id,bk_dt,res_dt,std_nm;
    Resv next;
    
    // reservation constructor
    Resv(int rn,String bkdt,String nm,String ad,int ag,String mailid,String stdnm,String resdt,int noseats)
    {
        rno     = rn;		// reservation number
        bk_dt   = bkdt;		// booked date
        name    = nm;		// name
        add     = ad;		// address
        age     = ag;		// age
        mail_id = mailid;	// mail
        std_nm  = stdnm;	// stadium name
        res_dt  = resdt;	// reservation data
        no_seats= noseats;	// number of seats
        next    = null;		// next node as null
    }
}

 class ResvLL // RESERVATION LINKED LIST CLASS
{
    Resv Head;
    ResvLL()
    {
        Head = null;
    }
    
    // method to insert data in the bottom of the stack
    public void insert(int rno,String bk_dt,String name,String add,int age,String mail_id,String std_nm,String res_dt,int no_seats)
    {
        Resv newNode = new Resv(rno,bk_dt,name,add,age,mail_id,std_nm,res_dt,no_seats);
        
        // puts data in new node if next node is empty (basically stack)
        if(Head==null)
        {
            Head = newNode;
        }
        else
        {
            Resv n = Head;
            while(n.next!=null)
            {
                n = n.next;
            }
            n.next = newNode;
        }
    }
    
    // DELETE DESIRED ENTRY BASED ON RESERVATION NUMBER 
    
    public void delete(int a,List<String[]> data) // data is array list which is the data being read from CSV
    {
    	int index=0; 
    	
        if(Head==null)
        {
            System.out.println("ResvLL is Empty");// because there is nothing to delete !!
        }
        else {
            Resv n = Head;
            if (n.rno == a) // checks registration number
            {
                Head = n.next;
                data.remove(index);
            }
            else {			// it keeps checking next nodes for the number given
                while (n.next != null) {
                	index++;
                    if (n.next.rno == a) {
                        break;
                    }
                    n = n.next;
                }
                if (n.next == null) { // if the given number isnt found
                    System.out.println("The Given Reservation Number Not present in the record.");
                } else {
                    n.next = n.next.next; // placing the next node in the present index which is given by user
                    data.remove(index);
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("The Given Entry is successfully removed");
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("         ");

                }
            }
        }
    }
    
    // TO SHOW THE DATA FROM LINKED LIST
    
    public void display() {
    	
        if (Head == null)
        {
            System.out.println("Resservation list is Empty !!! 1");
        }
        else
        {
            Resv n = Head; // to print entries from head i.e, from index 0
			System.out.println("|-------|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
            System.out.println("| Res.No| Booking Date\t| Customer Name\t| Address Name\t| Age\t| E-mail Id               \t| Stadium Name           \t| Reserv.Date\t| Seats Resvd |");
			System.out.println("|-------|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
            while(n!=null)
            {
                //System.out.print(n.rno+"\t"+n.bk_dt+"\t"+n.name+"\t"+n.add+"\t"+n.age+"\t"+n.mail_id+"\t"+n.std_nm+"\t"+n.res_dt+"\t"+n.no_seats);
            	System.out.printf("| %-5s\t| %-13s\t| %-12s\t| %-13s\t| %3s\t| %-25s\t| %-25s\t| %-13s\t|    %-3s      |\n",n.rno,n.bk_dt,n.name,n.add,n.age,n.mail_id,n.std_nm,n.res_dt,n.no_seats);
                n = n.next;
                //System.out.println();
            }
			System.out.println("|-------|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
        }
    }
}



                          /////   CITY CLASSS  /////////
class City {
      int city_id[] = {1,2,3,4,5};
	  String city_nm[] = { "BANGALORE","CHENNAI","HYDERABAD","MUMBAI", "DELHI" };
	  int count=5;
	  
	  void show()           /// show method to display all 5 cities
	  {
		  for(int i=0;i<count;i++) 
			  System.out.println(city_id[i]+" -> "+city_nm[i]);
	  }
	  
	  //void add()        
	  //{
		// System.out.println("Enter City :");
		// System.out.println("Enter Stadium : ");
		// count++;
	  //}
	  
	  void line(int x)
	  {
		  if(x==1)
			  System.out.println("-------------------------------------------------------------------------------------");
		  else 
			  System.out.println("=====================================================================================");
	  }
}

                  /////   STADIUM CLASSS  /////////
 
 class Stdm extends City {              ////////// inheritance DONE
	  int c_id[] = { 1,1,1,2,2,2,3,5,5,4,4 };
	  int stdm_id[] = { 1,2,3,4,5,6,7,8,9,10,11 };
	  String stdm_nm[]= {"Sree Kanteerava ","Chinnaswamy","Bangalore Football","M.A. Chidambaram Stadium","Mac B Stadium","MMC Cricket Ground","Rajiv Gandhi","Arun Jaitley Stadium","Shaheed Veer Narayan Singh","Wankhede Stadium","Brabourne Stadium"};
	  int stdm_cap[]= { 4000,6000,5000,8000,2000,700,8000,7500,5000,6000,7000 };
	  int count=11;
  

	  void show()
	  {
		  System.out.println("ID  ->     Stadium Name       Capacity");
		  for(int i=0;i<count;i++)
		  {
			  System.out.println(stdm_id[i]+"  -> "+stdm_nm[i]+ " "+ stdm_cap[i]);
	     }
	  }	  
	  
	  void show(int cid)          ///// Method Overloading/Polymorphism is DONE 
	  {
		  System.out.println("ID  ->  Stadium Name        Total Capacity");
		  line(2);
		  for(int i=0;i<count;i++)
		  {
			  if(c_id[i]==cid)   /////  Only display stadiums with given city code...
				  System.out.println(stdm_id[i]+" -> "+stdm_nm[i]+ " \t"+ stdm_cap[i]);
	     }
	  }	  
}
 

                     /////   STADIUM RESERVATION CLASSS  /////////
 
class Stdm_Res extends Stdm {
	int stdm_res[]= { 0,0,0,0,0,0,0,0,0,0,0 };
	int max,min; 
	
    void get_res_data() {               //// For Stadium Reserved seat count (random from capacity) 
    	for(int i=0;i<count;i++)
    	{
    		max=stdm_cap[i];
    		min=stdm_res[i];
    		stdm_res[i]=(int)(Math.random()*(max-min+1)+min);    
      	}	    	
    }
    
    void res_status() {
    	int bal,c;
    	
    	line(1);
    	System.out.println("ID  ->  Stadium Name      || City         || Total Capacity || Reserved || Vacant |");
    	line(1); 
    	for(int i=0;i<count;i++)
    	 {
    		 bal=stdm_cap[i]-stdm_res[i];
    		 c=c_id[i]-1;
    		 //System.out.println("c valuee.."+c);
    		 System.out.println(stdm_id[i]+"  -> "+stdm_nm[i]+ " || "+ city_nm[c] + " || "+ stdm_cap[i]+" || "+stdm_res[i]+" || "+bal);
    	 }
    	line(2);
    }
    
    void res_status(int s) {      /////  Polymorphism is Done 
    	int bal,c;
    	
    	 line(1);
     	System.out.println("ID  ->  Stadium Name  \t|| City         || Total Capacity || Reserved || Vacant |");
    	 line(1);
    	 for(int i=0;i<count;i++)
    	    if(s==stdm_id[i])          ////  To filter given s (stadium id) only 
    	    {
    		 bal=stdm_cap[i]-stdm_res[i];
    		 c=c_id[i]-1;
    		 //System.out.println("c valuee.."+c);
    		 System.out.println(stdm_id[i]+"  -> "+stdm_nm[i]+ "\t|| "+ city_nm[c] + " || "+ stdm_cap[i]+" || "+stdm_res[i]+" || "+bal);
    	    } 
    	 line(2);
    }
    
    
    void reservation(int r,List<String[]> data,ResvLL newLL)  {
    	int no_seats,age,bal,opt,res_no;
    	String name,add,mail_id,bk_dt="13-07-2022",res_dt="25-07-2022";   /////////////////////Date hardcoded
    	Scanner inp = new Scanner(System.in);
        //List<String[]> data = new ArrayList<String[]>();
        //data.add(new String[] { "Name", "Class", "Marks" });

    	System.out.print("Enter Number of Seats you need to Book : ");
    	no_seats = Integer.parseInt(inp.nextLine());
    	bal=stdm_cap[r]-stdm_res[r];
    	
    	if(no_seats>bal)                        //// Checking No.of seats (input) with Balance seats 
    	{
    		System.out.println("The Number of Seats available in "+ stdm_nm[r] +" are "+bal+" Out of "+stdm_cap[r]+"seats");
    	    System.out.println("But your requirement is : "+ no_seats);
    	    System.out.println("Sorry for the inconvenience!!!  Seats are not AVAILABLE!!!");
    	}
    	else 
    	{
    		System.out.println("The Number of Seats available in "+ stdm_nm[r] +" are "+bal+" Out of "+stdm_cap[r]+" seats");
    		System.out.println("        ");
    		System.out.println("Are you sure? Payments should be done in the Stadium only");
    		System.out.println("        ");
        	System.out.println("1 -> Yes\n2 -> No");
        	opt = Integer.parseInt(inp.nextLine());
            use.sleep(850);
        	line(2);
        	if(opt==2)
        	{
        		System.out.println("Oops!  Your Booking is Cancelled... Good byeee....");
        		line(2);
                use.sleep(3000);

        	}
        	else if(opt==1)
        	{
        		System.out.print("Loading");
        		use.loading();
                use.sleep(850);
        		line(1);
        		System.out.println("But first, we need your details to complete the following Reservation :-)");
        		line(2);
                use.sleep(250);
        		System.out.println("Enter your details ");
        		System.out.print("Name     :  ");
        		name=inp.nextLine();
        		System.out.print("Address  :  ");
        		add=inp.nextLine();
        		System.out.print("Age      :  ");
        		age=Integer.parseInt(inp.nextLine());
        		System.out.print("Email Id :  ");
        		mail_id=inp.nextLine();
        		System.out.println("        ");
                use.sleep(1000);
        		System.out.print("Loading please wait");
        		use.loading();
        		System.out.println("\n");
	
        		System.out.println("Your Reservation is done!\nAllotted Seat Nos : ");
        		for(int x=1;x<=no_seats;x++)
        			System.out.println(stdm_res[r]+x);
                use.sleep(250);
           		line(1);
        		System.out.print("Printing receipt");
        		use.loading();
        		line(2);
                use.sleep(1000);
        		System.out.println("           R E C E I P T");
        		line(1);
        		res_no=(int)(Math.random()*(2000));;
        		System.out.println("Reservation No.	: "+res_no);
        		System.out.println("Date           	: "+bk_dt);
        		System.out.println("Name           	: "+name);
        		System.out.println("Address        	: "+add);
        		System.out.println("Age            	: "+age);
        		System.out.println("Email Id       	: "+mail_id);
        		System.out.println("Stadium Name   	: "+stdm_nm[r]);
        		int frm=stdm_res[r]+1;
        		int to=stdm_res[r]+no_seats;
        		System.out.println("Seats allotted  : From "+frm+" To "+to);
        		line(2);
        		
        		///// Insert row to LL
        		data.add(new String[] { String.valueOf(res_no),bk_dt,name,add,String.valueOf(age),mail_id,stdm_nm[r],res_dt,String.valueOf(no_seats) });
                newLL.insert(res_no,bk_dt,name,add,age,mail_id,stdm_nm[r],res_dt,no_seats);
        		///// Write to CSV
                use.WriteData("data.csv", data);

        		System.out.println("THANK YOU! HAVE A GREAT DAY!!");
        		line(2);
        		System.out.println("        ");
                use.sleep(4500);


        	}
        	else 
        	{
                use.sleep(250);
        		System.out.println("Wrong option is picked !!!!");
        	}
    	}
    }
}


//// ****   MAIN STADIUM CLASS BEGINS FROM HERE  ******///

public class stadium {
	
  public static void main(String[] args) {
    City city = new City();                       // instance variables // default constructors
    Stdm stdm = new Stdm();                       
    Stdm_Res stdm_res = new Stdm_Res();           
    int opt1,opt2,opt3,opt,no;
    Scanner myObj = new Scanner(System.in);
    List<String[]> data = new ArrayList<String[]>();
    //data.add(new String[] { "Name", "Class", "Marks" });
    
    
 // Create a new LL object which calls methods from ResvLL class
    ResvLL newLL = new ResvLL(); 
    
    // city.line(2);
    use.Welcome();            //// Calling  Welcome method from use.java  - Inheritance 
    // city.line(2);
    File f = new File("./data.csv");
    System.out.println("check1");
    if(f.exists())
    	data=use.ReadData("./data.csv", newLL);
    else
    	use.WriteData("./data.csv", data);
    //use.WriteData("data.csv");
while(true) {
	System.out.println("\nPlease select your option to continue : ");
    System.out.println("-----------------------------------------------");
    System.out.println("1 --> Display Reservations List    ");
    System.out.println("2 --> Book New Reservation         ");
    System.out.println("3 --> Cancel Reservation           ");
    System.out.println("4 --> Exit                         ");
    System.out.println("                                   ");
    opt = Integer.parseInt(myObj.nextLine());
    if(opt==1)
    {
    	newLL.display();
    }
    	
    else if (opt==2)
    {
    				////// Booking Reservation //
		System.out.println("List of Cities available:");
		city.line(1);    
		city.show();
		city.line(1);    
		System.out.print("Enter Your Preferred City id : ");
		opt1 = Integer.parseInt(myObj.nextLine());
		System.out.println("        ");

		city.line(2);
		System.out.println("City selected is: "+ " -> " + city.city_nm[opt1-1]);
		city.line(1);
		System.out.println("1 -> Select this to see the full list of Stadiums available ");  
		System.out.println("2 -> Select this to see the list of the Stadiums of the Selected city : " + city.city_nm[opt1-1]);
		
		System.out.print("\nEnter Your Option : ");    
		opt2 = Integer.parseInt(myObj.nextLine());
		city.line(2);    
		if (opt2==1)
		stdm.show();
		else if (opt2==2)
		stdm.show(opt1);    ///// Method Overloading is DONE
		else 
		System.out.println("Wrong option is picked !!!!");  
		
		System.out.print("\nSelect the Stadium for Reservation : ");    
		opt3 = Integer.parseInt(myObj.nextLine());
		
		stdm_res.get_res_data();
		stdm_res.res_status(opt3);
		
		//System.out.println("1 -> To Confirm "+stdm.stdm_nm[opt3-1]);
		//System.out.println("2 -> To see the full list of Stadiums ");
		//opt = Integer.parseInt(myObj.nextLine());
		opt=1;
		if(opt==1)
		stdm_res.reservation(opt3-1, data, newLL);
		else if(opt==2)
		{
		stdm_res.res_status();         ///// To display all Stadiums reservation 
		do {
		System.out.println("Enter Stadium ID");
		System.out.println("0 -> Refresh");
		opt = Integer.parseInt(myObj.nextLine());
		if(opt==0)
		{
		stdm_res.get_res_data();
		stdm_res.res_status();
		}
		else if(opt<stdm_res.count)
		stdm_res.reservation(opt-1, data, newLL);
		else
		System.out.println("Wrong option is picked !!!!");  
		} while(opt==0); 
		}
		else
		System.out.println("Wrong option is picked !!!!");  
		
		
    }
    else if(opt==3)
    {
    	System.out.println("Enter Reservation Number to Cancel: ");
    	no = Integer.parseInt(myObj.nextLine());
    	newLL.delete(no,data);
    	use.WriteData("./data.csv", data);
    	use.sleep(3000);
    }
    else if(opt==4)
    {	System.out.println("-----------------------------------------------------------------");
		System.out.println("Thanks for using....");  
    	break;
    }
    else 
    {
    	System.out.println("Wrong option, Please enter correct option...");
    }

		}
  }
}