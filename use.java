import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.*;

class use {

 
	 static void Welcome() {
		 System.out.println("###################################################################################################");
		 System.out.println("#################                                                  	          #################");
		 System.out.println("#################   WELCOME TO SEAT RESERVATION AND  ALLOTMENT SYSTEM             #################");
		 System.out.println("#################                                                                 #################");
		 System.out.println("#################   Created By :                                                  #################");
		 System.out.println("#################                GROUP E7, Sem-2,AIE                              #################");
		 System.out.println("#################                                                                 #################");
		 System.out.println("#################                AMRITA SCHOOL OF ENGINEERING,BANGALORE           #################");
		 System.out.println("#################                                                                 #################");
		 System.out.println("###################################################################################################");
	 }
	 

static List<String[]> ReadData(String file, ResvLL newLL) {
	List<String[]> data = new ArrayList<String[]>(); // declaring array list
	String[] data1 = new String[9];   ////  String Array
	int i=0;
	try {
        FileReader filereader = new FileReader(file);
  
        // create csvReader object and skip first Line
        CSVReaderBuilder csvBuild = new CSVReaderBuilder(filereader);
        CSVReader csvReader = csvBuild.build();
        System.out.println("            ");
        System.out.println("            ");
        System.out.print("Loading your program");
        use.loading();
        System.out.println("                                   ");
        Thread.sleep(850);

        List<String[]> allData = csvReader.readAll();  //// Reading all data frm CSV
  
        // print Data by simplifying row to cell
        for (String[] row : allData) {
        	i=0;
            for (String cell : row) {
            	data1[i]=cell;
            	i++;
            }
            data.add(new String[] { data1[0],data1[1],data1[2],data1[3],data1[4],data1[5],data1[6],data1[7],data1[8] });
            
            ////////***** Each row  LL insert
            newLL.insert(Integer.parseInt(data1[0]),data1[1],data1[2],data1[3],Integer.parseInt(data1[4]),data1[5],data1[6],data1[7],Integer.parseInt(data1[8]));
        }
        System.out.println("Data has been successfully loaded and inserted into the linked list")  ;     // newLL.display();
        System.out.println("                                   ");

        Thread.sleep(350);

	}
    catch (Exception e) {
        e.printStackTrace();
    }
	return data;
}

static void WriteData(String fname, List<String[]> data) {
    File file = new File(fname);
    
    try {
        // create FileWriter object with file as parameter
        FileWriter outputfile = new FileWriter(file);
  
        // create CSVWriter object filewriter object as parameter
        CSVWriter writer = new CSVWriter(outputfile);
  
        // create a List which contains String array
        //List<String[]> data = new ArrayList<String[]>();
//        data.add(new String[] { "Name", "Class", "Marks" });
        writer.writeAll(data);
  
        // closing writer connection
        writer.close();
    }
    catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public static void sleep(int someDelay) {
	   try {
	      Thread.sleep(someDelay);
	   } 
	   catch (InterruptedException e) {
	      Thread.currentThread().interrupt();
	   }
	}
public static void loading() {
    use.sleep(350);  System.out.print(".");
    use.sleep(350);  System.out.print(".");                
    use.sleep(350);  System.out.print(".");
    use.sleep(350);  System.out.print(".");
    use.sleep(350);  System.out.println(".");
}
public static void loading1() {
	int i=0;
	while(i<=5)
	{i++;
    use.sleep(350);  System.out.print("-");
    use.sleep(350);  System.out.printf("%c",8);                
    use.sleep(350);  System.out.print(".");
    use.sleep(350);  System.out.print(".");
    use.sleep(350);  System.out.println(".");
	}
}
}