package enc;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;



public class TestPdfGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GenericPdfGenerator gen = new GenericPdfGenerator() ;
		String path = "C:/Users/SUBHODEEP/Desktop/Pdf.pdf" ;
		HashMap<String , List<MeterReads>>downloadMap = new HashMap<String , List<MeterReads>>() ;
		ArrayList<MeterReads> list = new ArrayList<MeterReads>() ;
		for(int i =0;i<100;i++)
        { 
        	MeterReads mtr = new MeterReads() ;
        	mtr.setMeterID("110098765") ;
        	mtr.setReadDate(new Date()) ;
        	mtr.setReadValue((double)i) ;
        	list.add(mtr) ;
        }
		downloadMap.put("KWH", list) ;
		gen.createPDF(path, downloadMap, new Date(), new Date(),"ROLL", 5) ;
	

}  
} 
	
