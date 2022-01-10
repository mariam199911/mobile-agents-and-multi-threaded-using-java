import java.io.*;
import java.net.*;
import java.util.*;

public class Client{
    public static void delay(int milli){
        try {
            Thread.sleep(milli);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        try
        {
            // Connect to the computer.
            Socket computerSocket = new Socket("127.0.0.1", 1111);
            
            DataInputStream computerSocketInput = new DataInputStream(computerSocket.getInputStream());
            DataOutputStream computerSocketOutput = new DataOutputStream(computerSocket.getOutputStream());

            System.out.println("Client is running.....");
            delay(2000);
            
            while (true)
            {
                String received =null;
                computerSocketOutput.writeUTF("get recommendations");
                delay(2000);
                computerSocketOutput.flush();
                
                System.out.println("Request of getting recommendations has been sent to the computer.");
                delay(2000);

                received = new String(computerSocketInput.readUTF());
               // System.out.println(received);
                if(received.equals("send recommendations")){
                    System.out.println("Recived my recommendations");
                    break;
                }
                //   // Close the connection with the computer.
              
            }
            computerSocketInput.close();
            computerSocketOutput.close();
            computerSocket.close();
           
        } 
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
       
    }
}