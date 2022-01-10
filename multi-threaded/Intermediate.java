import java.io.*; 
import java.net.*;
import java.util.Random;

public class Intermediate {
    private static Socket client0;
    private static Socket client1;
    private static Socket client2;
    private static Socket client3;

    public static void main(String[] args) throws IOException{
        /**Connection Part */
        
        //Conncect to Computing and Accept
        ServerSocket serverClient0 = new ServerSocket(5000);
        ServerSocket serverClient1 = new ServerSocket(5001);
        ServerSocket serverClient2 = new ServerSocket(5002);
        ServerSocket serverClient3 = new ServerSocket(5003);


        Socket server0 =  new Socket("localhost",4000);
        Socket server1 =  new Socket("localhost",4001);
        Socket server2 =  new Socket("localhost",4002);
        Socket server3 =  new Socket("localhost",4003);
       
        
            // /**Connection Part */
        client0 = serverClient0.accept();
        System.out.println("decision connected");
        client1 = serverClient1.accept();
        System.out.println("decision connected");
        client2 = serverClient2.accept();
        System.out.println("decision connected");
        client3 = serverClient3.accept();
        System.out.println("decision connected");

        Thread t0 = new IntermediateHandler(client0,server0);
        Thread t1 = new IntermediateHandler(client1,server1);
        Thread t2 = new IntermediateHandler(client2,server2);
        Thread t3 = new IntermediateHandler(client3,server3);

        while(true){
        try{
        /**Protocol */
            t0.run();
            t1.run();
            t2.run();
            t3.run();
         /**Protocol */
       

            
       } catch(Exception e) {
        client0.close();
        client1.close();
        client2.close();
        client3.close();
       
           e.printStackTrace();
       }
    }
    
    }
}
