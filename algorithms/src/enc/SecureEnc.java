package enc;

import java.util.Scanner;
import org.apache.commons.codec.binary.Base64;



public class SecureEnc {
	
	  /**
	 * @param args
	 */
	public static void main(String[] args){
  	       
		String s = start() ; 
		if(s.equalsIgnoreCase("Y"))
			 main(args) ;
		else 
			System.exit(0) ;
        }
	
	  public static String start(){
		  String txt = "" ;
	  	  String key = "" ;
	  	  Scanner in = new Scanner(System.in);
	  	  System.out.println("Enter 1 to Encode and 2 to Decode");
	  	  String s = in.nextLine();
	        if(s.equalsIgnoreCase("1")){
	      	  System.out.println("Enter value to Encode");
	      	  txt = in.nextLine(); 
	      	  System.out.println("Enter key");
	      	  key = in.nextLine();  
	      	  txt=xorMessage( txt, key ) ; 
	      	  byte[] encoded = encode( txt );
	      	  System.out.println("Base64 Encoded String : " + new String(encoded));
	        }
	        else {
	        System.out.println("Enter value to Decode");
	  	  txt = in.nextLine(); 
	  	  System.out.println("Enter key");
	  	  key = in.nextLine();  
	  	  String decoded = decode(txt.getBytes()) ;
	  	  txt = xorMessage(decoded ,key ) ;
	  	  System.out.println("Base64 Encoded String : " + txt);
	       }
	        Scanner option = new Scanner(System.in);
			System.out.println("Continue ? (Y/N)");
			String response = in.nextLine();
			return response ;
	  }
	  
	  public static String xorMessage(String message, String key){
	       try {
	          if (message==null || key==null ) return null;

	         char[] keys=key.toCharArray();
	         char[] mesg=message.toCharArray();

	         int ml=mesg.length;
	         int kl=keys.length;
	         char[] newmsg=new char[ml];

	         for (int i=0; i<ml; i++){
	            newmsg[i]=(char)(mesg[i]^keys[i%kl]);
	         }//for i
	         mesg=null; keys=null;
	         return new String(newmsg);
	      }
	      catch ( Exception e ) {
	         return null;
	       }  
	      }//xorMessage
	     

	
	         //encoding  byte array into base 64 
	        public static byte[] encode (String orig){
	        byte[] encoded = Base64.encodeBase64(orig.getBytes());      
	        return encoded ;
	         }
	       
	         //decoding byte array into base64 
	         public static String decode(byte[] encoded){
	         byte[] decoded = Base64.decodeBase64(encoded);       
	         return new String (decoded) ;
	         }

          }
