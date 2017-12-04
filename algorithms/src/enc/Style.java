package enc;

	
	import com.itextpdf.text.BaseColor;
	import com.itextpdf.text.Element;
	import com.itextpdf.text.pdf.PdfPCell;
	 
	public class Style {
	 
	    public static void headerCellStyle(PdfPCell cell){
	 
	    // alignment
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	 
	    // padding
	       cell.setPaddingTop(0f);
	       cell.setPaddingBottom(7f);
	 
	        // background color
	        cell.setBackgroundColor(new BaseColor(135,206,250));
	 
	        // border
	        cell.setBorder(0);
	        cell.setBorderWidthBottom(2f);
	 
	    }
	    
	    public static void valueCellStyle(PdfPCell cell,int i){
	    // alignment
	    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	    cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	 
	        // padding
	     cell.setPaddingTop(0f);
	     cell.setPaddingBottom(5f);
	 
	        // border
	        cell.setBorder(0);
	        cell.setBorderWidthBottom(0.5f);
	        
	     // background color
	        if(i%2==0)
	        {
	        cell.setBackgroundColor(BaseColor.WHITE);
	        }
	        else 
	        {
	        	cell.setBackgroundColor(new BaseColor(135,206,250));
	        }
	        // height
	        cell.setMinimumHeight(18f);
	    }
	}


