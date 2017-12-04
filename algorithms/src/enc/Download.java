package enc;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import com.itextpdf.text.pdf.PdfReader;

public class Download {
	
	 public static void main(String[] args) {
		 
		/* String arr[] = {"C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Data Interpretation and Logical Reasoning",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Data Interpretation and Logical Reasoning/LR and DI  FB",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/GDPI and Articles",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Verbal and Reading Comprehension",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Verbal and Reading Comprehension/Verbal and RC FB",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Verbal and Reading Comprehension/Verbal",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Quant" ,
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Quant/Fundas",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Quant/Quant FB",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Quant/Question Set FB",
				         "C:/Users/SUBHODEEP/Desktop/Ebooks/Cat/Imp" } ;
		 
		 for (int i =0;i<1;i++){
			 
			 getFileNameinLocal(arr[i]) ;
		 }*/
		 
			BufferedReader br = null;
			FileWriter fileWriter = null;
			 
			try {
	            int i = 1 ;
				String sCurrentLine;
	            br = new BufferedReader(new FileReader("C:/Users/SUBHODEEP/Desktop/Links.txt"));
	            while ((sCurrentLine = br.readLine()) != null) {
					System.out.println(sCurrentLine);
					String content = getHtmlCode(sCurrentLine);
		            File newTextFile = new File("C:/Users/SUBHODEEP/Desktop/New folder/Test-"+i+".html");
		            fileWriter = new FileWriter(newTextFile);
		            fileWriter.write(content);
		            fileWriter.close();
		            i++ ;
				}
	 
			} catch (IOException e) {
				e.printStackTrace();
			}
			finally {
	            try {
	                fileWriter.close();
	            } catch (IOException ex) {
	                
	            }
	        }
		 
		/*for(int j = 1; j <= 15 ; j++){
		    
			Scanner in = new Scanner(System.in);
		  	System.out.println("Enter URL");
		  	String completeurl = in.nextLine();
	        FileWriter fileWriter = null;
	        try {
	        	
	            String content = getHtmlCode(completeurl);
	            File newTextFile = new File("C:/Users/SUBHODEEP/Desktop/New folder/16.html");
	            fileWriter = new FileWriter(newTextFile);
	            fileWriter.write(content);
	            fileWriter.close();
	        } catch (IOException ex) {
	           
	        } finally {
	            try {
	                fileWriter.close();
	            } catch (IOException ex) {
	                
	            }
	        }
	 
		 }
	    */
	 }
	
	
	
	
	 public static String getHtmlCode(String completeurl){
			String html = "" ;
			try{
				  
				  URL u = new URL("http://www.careerlauncher.biz/sis/ValidateProduct.jsp") ;
				  HttpURLConnection uc = (HttpURLConnection) u.openConnection();
				  uc.addRequestProperty("userName", "subhodeep.sn@gmail.com");
				  uc.addRequestProperty("password", "Singularity");
				  int code = uc.getResponseCode();
				  String response = uc.getResponseMessage();
				  //System.out.println("HTTP/1.x " + code + " " + response);
				  for(int j = 1; ; j++){
				  String header = uc.getHeaderField(j);
				  String key = uc.getHeaderFieldKey(j);
				  if(header == null || key == null)
				  break;
				 // System.out.println(uc.getHeaderFieldKey(j) + ": " + header);
				  }
				  InputStream in = new BufferedInputStream(uc.getInputStream());
				  Reader r = new InputStreamReader(in);
				  int c;
				  while((c = r.read()) != -1){
					  html = html+(char)c ;
				  }
				  }
				  catch(MalformedURLException ex){
				  System.err.println(completeurl + " is not a valid URL.");
				  }
				  catch(IOException ie){
				  System.out.println("Input/Output Error: " + ie.getMessage());
				  }
                    return html ;
}
	 
	 public static void getFileNameinLocal(String path) {
		 
		      String files = "" ;
		//    String temp = path.substring(path.indexOf("Cat")) ;
		 //   temp.replaceAll("/", " > ") ;
		    
			  File folder = new File(path);
			  File[] listOfFiles = folder.listFiles();
		//	  System.out.println("Folder :"+temp.replaceAll("/", " > ") ) ;
			  System.out.println("----------------------------------------------------------------") ;
			  for (int i = 0; i < listOfFiles.length; i++) 
			  {     if (listOfFiles[i].isFile()) 
			       {   
				      files = listOfFiles[i].getName();
				      if(files.endsWith(".pdf")){
				         PdfReader reader;       
					try {
						reader = new PdfReader(listOfFiles[i].getAbsolutePath());
						int pages = reader.getNumberOfPages(); 
						System.out.println(files+"  Pages : "+pages) ;
					} catch (IOException e) {
						// TODO Auto-generated catch block
						 
					}
					catch (NoClassDefFoundError e) { 
						
						System.out.println(files+" is Encrypted") ;  
					}  
				      }
			  }
			      
			  }
			  System.out.println("---------------------------------------------------------") ;
	       }
          }
