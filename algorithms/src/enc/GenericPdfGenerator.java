package enc;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPCellEvent;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPTableEvent;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfShading;
import com.itextpdf.text.pdf.PdfShadingPattern;
import com.itextpdf.text.pdf.PdfWriter;




public class GenericPdfGenerator {
	
	private static Font smallBold = new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
	private static Font BigBold = new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
	 /** A table event. */
    public PdfPTableEvent tableBackground;
    /** A cell event. */
    public PdfPCellEvent cellBackground;
    /** A cell event. */
    public PdfPCellEvent roundRectangle;
    /** A cell event. */
    public PdfPCellEvent whiteRectangle;
    
	 
	
	
	public  void createPDF(String filename ,HashMap<String , List<MeterReads>>downloadMap,Date startDate,Date endDate, String summingOptions, int summingInterval) 
	
	{ 
		
		Document document = new Document();
		File _file = new File (filename) ;

        try {
        	
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream(_file));
            
            StringBuilder sb = new StringBuilder() ;
           /* sb.append("Meter ID :"+listofMeterReads.get(0).getMeterID() ) ;
            sb.append("\n") ;
            sb.append("Start Date :"+formatDate(startDate.toString()).substring(0, 8)+"   End Date:"+formatDate(endDate.toString()).substring(0, 8) ) ;
            sb.append("\n") ;
            sb.append("Summing Option :"+summingOptions+"   Summing Interval :"+summingInterval+ " mins" ) ;
            sb.append("\n") ;
            sb.append("Report generated on: " + formatDate(new Date().toString()) ) ;
            sb.append("\n") ;*/
            
            HeaderFooter event   = new HeaderFooter();
            tableBackground = new TableBackground();
            cellBackground = new CellBackground();
            roundRectangle = new RoundRectangle(new int[]{ 0,0,0,100});
            event.setHeader(sb.toString());
            writer.setBoxSize("art", new Rectangle(36, 54, 559, 788));
            writer.setPageEvent(event);
            
            document.open(); 
            
            List<MeterReads>listofMeterReads =  null ;
            
            Iterator iter1 = downloadMap.keySet().iterator();
            
            listofMeterReads = downloadMap.get((String)iter1.next()) ;
            
            Paragraph preface = new Paragraph () ;
            addEmptyLine(preface, 2);
            preface.add(new Paragraph("Meter ID :"+listofMeterReads.get(0).getMeterID(), BigBold));
            addEmptyLine(preface, 0);
            preface.add(new Paragraph("Start Date :"+formatDate(startDate.toString()).substring(0, 8)+"   End Date:"+formatDate(endDate.toString()).substring(0, 8), BigBold));
            addEmptyLine(preface, 0);
            preface.add(new Paragraph("Summing Option :"+summingOptions+"   Summing Interval :"+summingInterval+ " mins", BigBold));
            addEmptyLine(preface, 0);
            preface.add(new Paragraph("Report generated on: " + formatDate(new Date().toString()), BigBold));
            addEmptyLine(preface, 2);
            preface.setAlignment(Element.ALIGN_CENTER);
            
            document.add(preface) ;
    
           
            PdfPTable table = new PdfPTable(downloadMap.size()+1); 
            table.setTableEvent(tableBackground); 
            table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
            table.getDefaultCell().setCellEvent(cellBackground);
            
            System.out.println("No of Columns"+downloadMap.size()) ;
            
            PdfPCell cell2 = new PdfPCell(new Phrase("Date/Time",smallBold));
            cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            Style.headerCellStyle(cell2);
            cell2.setCellEvent(roundRectangle);
            table.addCell(cell2);
            
            Iterator iter2 = downloadMap.keySet().iterator();
            
            while(iter2.hasNext()) {
    		    String key = (String)iter2.next();
    		    PdfPCell cell3 = new PdfPCell(new Phrase(key,smallBold));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                Style.headerCellStyle(cell3);
                cell3.setCellEvent(roundRectangle);
                table.addCell(cell3);
            }
            
            
                table.setHeaderRows(1);
           
          
            
            
            for(int i=0;i<listofMeterReads.size() ;i++) 
          {      
            	 table.addCell(createValueCell(""+formatDate(listofMeterReads.get(i).getReadDate().toString()),i));
                
                Iterator iter3 = downloadMap.keySet().iterator();
                
                while(iter3.hasNext()) {
                	
            	 double readValue = downloadMap.get((String)iter3.next()).get(i).getReadValue() ;
            	 readValue = (double) Math.round(readValue*100)/100 ;
            	 table.addCell(createValueCell(""+readValue,i));
            	 
            	 }  

             
          }
           
            document.add(table);
            document.close();    
            
        } catch(Exception e){

        }
		
    //    return _file ;
	}
	
	private static void addEmptyLine(Paragraph paragraph, int number) {
	    for (int i = 0; i < number; i++) {
	      paragraph.add(new Paragraph(" "));
	    }
	  }
	
	private  String formatDate (String date)
	
	{
	
		   String temp = date.substring(8,10)+"-"+date.substring(4,7)+"-"+date.substring(26) ;
		   SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yy");
		   SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yy");
		   Date newdate = new Date();
		   
		try {
			    newdate = format1.parse(temp);
			    
		    } catch (ParseException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		
		   String result = format2.format(newdate)+" "+date.substring(11, 16);
		   
		   return result ;
		
	}
	
	 // create cells
    private  PdfPCell createValueCell(String text,int i){
        // font
        Font font = new Font(FontFamily.HELVETICA, 8, Font.BOLD, BaseColor.BLACK);
 
        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));
        cell.setCellEvent(roundRectangle);
 
        // set style
        Style.valueCellStyle(cell,i);
        return cell;
    }
	
	 class HeaderFooter extends PdfPageEventHelper {
      
		Phrase[] header = new Phrase[1];
		String headercontent = "" ;
        int pagenumber;
        
        public void setHeader (String header)
        {
        	headercontent = header ;
        }

		public void onOpenDocument(PdfWriter writer, Document document) 
        {
			header[0] = new Phrase(headercontent);
        }
        

        public void onStartPage(PdfWriter writer, Document document) {
        	Image watermark_image = null  ;
			try {
				watermark_image = Image.getInstance("C:/Users/SUBHODEEP/Desktop/logo.png");
				watermark_image.setAbsolutePosition(50,790);
				watermark_image.scaleToFit(45,45);
			} catch (BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				writer.getDirectContent().addImage(watermark_image);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
              pagenumber ++ ;
        }
        
  
        public void onEndPage(PdfWriter writer, Document document)
        
        {  
            Rectangle rect = writer.getBoxSize("art"); 
            ColumnText.showTextAligned(writer.getDirectContent(),
                    Element.ALIGN_RIGHT, new Phrase(String.format("Page %d", pagenumber),smallBold),
                    (rect.getLeft() + rect.getRight()) / 2, rect.getBottom() - 26 , 0);
        }
    }
	 
	 
	 /**
	     * Inner class with a table event that draws a background with rounded corners.
	     */
	    class TableBackground implements PdfPTableEvent {
	        
	        public void tableLayout(PdfPTable table, float[][] width, float[] height,
	                int headerRows, int rowStart, PdfContentByte[] canvas) {
	            PdfContentByte background = canvas[PdfPTable.BASECANVAS];
	            background.saveState();
	            background.setCMYKColorFill(0x00, 0x00, 0xFF, 0x0F);
	            background.roundRectangle(
	                width[0][0], height[height.length - 1] - 2,
	                width[0][1] - width[0][0] + 6, height[0] - height[height.length - 1] - 4, 4);
	            background.fill();
	            background.restoreState();
	        }

	    }
	    
	    
	    /**
	     * Inner class with a cell event that draws a background with rounded corners.
	     */
	    class CellBackground implements PdfPCellEvent {
	        
	        public void cellLayout(PdfPCell cell, Rectangle rect,
	                PdfContentByte[] canvas) {
	            PdfContentByte cb = canvas[PdfPTable.BACKGROUNDCANVAS];
	            cb.roundRectangle(
	                rect.getLeft() + 1.5f, rect.getBottom() + 1.5f, rect.getWidth() - 3,
	                rect.getHeight() - 3, 4);
	            cb.setCMYKColorFill(0x00, 0x00, 0x00, 0x00);
	            cb.fill();
	        }
	    }
	    
	    /**
	     * Inner class with a cell event that draws a border with rounded corners.
	     */
	    class RoundRectangle implements PdfPCellEvent {
	        /** the border color described as CMYK values. */
	        protected int[] color ;
	        /** Constructs the event using a certain color. */
	        public RoundRectangle(int[] color) {
	            this.color = color;
	        }
	        
	        public void cellLayout(PdfPCell cell, Rectangle rect,
	                PdfContentByte[] canvas) {
	            PdfContentByte cb = canvas[PdfPTable.LINECANVAS];
	            cb.roundRectangle(
	                rect.getLeft() + 1.5f, rect.getBottom() + 1.5f, rect.getWidth() - 3,
	                rect.getHeight() - 3, 4);
	            cb.setLineWidth(1.5f);
	            cb.setCMYKColorStrokeF(color[0], color[1], color[2], color[3]);
	            cb.stroke();
	        }
	    }
	  }