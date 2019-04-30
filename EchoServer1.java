/**
 * 
 * Using the three-tier software architecture Modifications were made in server in order to
 * design and implement a client-server suite for the protocol.
 * 
 * 
*/

import java.io.*;

/**
 * This module contains the application logic of an echo server
 * which uses a connectionless datagram socket for interprocess 
 * communication.
 * A command-line argument is required to specify the server port.
 * 
 * 
 * 
 * 
 */

public class EchoServer1 {
   public static void main(String[] args) {
      String names = "";
      int serverPort = 7;    // default port
      if (args.length == 1 )
         serverPort = Integer.parseInt(args[0]);       
      try {
         // instantiates a datagram socket for both sending
         // and receiving data
       MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort); 
         System.out.println("Echo server ready.");  
         while (true) {  // forever loop
            DatagramMessage request = 
               mySocket.receiveMessageAndSender();
            System.out.println("I want to vote");
            String message = request.getMessage( ).trim();
            System.out.println("Vote received: "+ message);
            // Now send the echo to the requestor
           int yesCount=0;
           int noCount=0;
           int dontCareCount=0;
            
            // Modifications were made here.
            while ((message.trim()).equals ("1")){
              yesCount = yesCount + 1;
              
            }
            System.out.println(yesCount);
            names += message + "\n" ;
            int length = names.length();
            String names1 = names.substring(0,length-1);
            mySocket.sendMessage(request.getAddress( ),
               request.getPort( ), names1);
            
     } //end while
       } // end try
     catch (Exception ex) {
          ex.printStackTrace( );
     } // end catch
   } //end main
} // end class      
