import java.io.*; 
import java.net.*;
import java.util.Random; 
class ClientHandler extends Thread  
{ 
    final Socket s = null; 
      
    private  Socket client;
    private  Random rand = new Random();
    private static int threadcount =0;
    private int threadid;
    // Constructor 
    public ClientHandler(Socket s)  
    { 
        this.client = s; 
        threadid  = threadcount;
        threadcount++;
    } 
  
    @Override
    public void run()
    { 
        
            try{
                    String message = recieveFromClient();
                    if(message.contains("city0")&& message.contains("s0")) {
                        System.out.println("state of city0, best route to reach s0 point");
                        sendToClient("recomindition sent about city0");
                    } else if(message.contains("city1")&& message.contains("s1")) {
                        System.out.println("state of city1, best route to reach s1 point");
                        sendToClient("recomindition sent about city1");
                    }else if(message.contains("city2")&& message.contains("s2")) {
                        System.out.println("state of city2, best route to reach s2 point");
                        sendToClient("recomindition sent about city2");
                    }else if(message.contains("city3")&& message.contains("s3")) {
                        System.out.println("state of city3, best route to reach s3 point");
                        sendToClient("recomindition sent about city3");
                    }
                    
            } catch(IOException e){
                System.out.println(e);
            }   //
        
    }
    private  String recieveFromClient() throws IOException{
        //Recieve message from Computing Node
      InputStreamReader inClient= new InputStreamReader(this.client.getInputStream());
      BufferedReader bfClient = new BufferedReader(inClient);
      return bfClient.readLine();
  }
  private  void sendToClient(String message) throws IOException {
    //Send message to Computing Node
    PrintWriter prClient = new PrintWriter(this.client.getOutputStream());
    prClient.println(message);
    prClient.flush();
}
} 