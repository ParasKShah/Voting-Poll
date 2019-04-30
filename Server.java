/**
 * 
 * 
 *  A class of contains methods for counting votes
 * 
 * 
 * 
*/

import java.io.*;

public class Server 
{
   public static void main(String[] args) 
   {
      
      int yesCount=0;
      int noCount=0;
      int dontCareCount=0;
      int serverPort = 7;    // default port
      if (args.length == 1 )
         serverPort = Integer.parseInt(args[0]);       
      try 
      {

       MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort); 
         System.out.println("Echo server ready.");  
         while (true) 
         {  // forever loop
            DatagramMessage request = 
            mySocket.receiveMessageAndSender();
            System.out.println("I want to vote");
            String message = request.getMessage( ).trim();
            System.out.println("Vote received: "+ message);
            
           
             String yesCount1 = Integer.toString(yesCount);
             String noCount1 = Integer.toString(noCount);
             String dontCareCount1 = Integer.toString(dontCareCount);
             String Message = "You have voted";
            
          
            if ((message.trim()).equals ("1"))
            {
              yesCount = yesCount + 1;             
              mySocket.sendMessage(request.getAddress( ),
              request.getPort( ), Message);
              
            }
             else if ((message.trim()).equals ("2"))
             {            
               noCount = noCount + 1;
               mySocket.sendMessage(request.getAddress( ),
               request.getPort( ), Message);
             }
             else if ((message.trim()).equals ("3"))
             {
               dontCareCount = dontCareCount + 1;
               mySocket.sendMessage(request.getAddress( ),
               request.getPort( ), Message);
             }
             else if ((message.trim()).equals ("How many yes?"))
             {
              
               mySocket.sendMessage(request.getAddress( ),
               request.getPort( ), yesCount1);
             
             }
             else if ((message.trim()).equals ("How many no?"))
             {
             
               mySocket.sendMessage(request.getAddress( ),
               request.getPort( ), noCount1);
              
              }
             else if ((message.trim()).equals ("How many don't care?"))
             {
              
               mySocket.sendMessage(request.getAddress( ),
               request.getPort( ), dontCareCount1);
              
             }
             else
             {
                 String invalid = "Invalid input";
                 mySocket.sendMessage(request.getAddress( ),
                 request.getPort( ), invalid);
             }
     } //end while
    } // end try
     catch (Exception ex) 
     {
          ex.printStackTrace( );
     } // end catch
   } //end main
} // end class      
