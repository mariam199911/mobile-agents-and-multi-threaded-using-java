import java.io.*; 
import java.net.*;
import java.util.Random; 
public class Server {
    private static Socket intermediate0;
    private static Socket intermediate1;
    private static Socket intermediate2;
    private static Socket intermediate3;


    public static void main(String[] args) throws IOException{
        /**Connection Part */
        
        //Conncect to Computing and Accept
        ServerSocket server0 = new ServerSocket(4000);
        ServerSocket server1 = new ServerSocket(4001);
        ServerSocket server2 = new ServerSocket(4002);
        ServerSocket server3 = new ServerSocket(4003);
        
        
        intermediate0 = server0.accept();
        System.out.println("compute0 connected");
        intermediate1 = server1.accept();
        System.out.println("compute1 connected");
        intermediate2 = server2.accept();
        System.out.println("compute2 connected");
        intermediate3 = server3.accept();
        System.out.println("compute3 connected");


        // /**Connection Part */
        Thread t0 = new ClientHandler(intermediate0);
        Thread t1 = new ClientHandler(intermediate1);
        Thread t2 = new ClientHandler(intermediate2);
        Thread t3 = new ClientHandler(intermediate3);


        while(true){
        try{
        /**Protocol */
            t0.run();
            t1.run();
            t2.run();
            t3.run();
           
         /**Protocol */
       

            
       } catch(Exception e) {
        intermediate0.close();
        intermediate1.close();
        intermediate2.close();
        intermediate3.close();
       
           e.printStackTrace();
       }
    }
    
    }
}
