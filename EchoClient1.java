import java.io.*;

public class EchoClient1 {
   static final String endMessage = ".";
   public static void main(String[] args) {
      InputStreamReader is = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(is);
      try {
         
         
         String hostName = "localhost";  //   use the default host name
        
        String  portNum = "7";          // default port number
         EchoClientHelper1 helper = 
            new EchoClientHelper1(hostName, portNum);
         boolean done = false;
         String message, echo;
         while (!done) {
            System.out.println("Vote (1) yes, (2) yo, or (3) don't care"
                            + "or a single peroid to quit.");
            message = br.readLine( );
            if ((message.trim()).equals (endMessage)){
               done = true;
               helper.done( );
            }
 
            else {
               echo = helper.getEcho( message);
               System.out.println(echo);
                 }
          } // end while
      } // end try  
      catch (Exception ex) {
         ex.printStackTrace( );
      } // end catch
   } //end main
} // end class      
