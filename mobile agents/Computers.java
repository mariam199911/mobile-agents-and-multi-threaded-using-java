import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Computers{
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
            //open a serversocket
            ServerSocket computer = new ServerSocket(1111);
            System.out.println("Computer is running......");
            delay(2000);
            //2. create socket and connect to the server
            Socket ServerSocket = new Socket("127.0.0.1", 5000);
            
            // Create I/O streams
            DataInputStream ServerSocketInput = new DataInputStream(ServerSocket.getInputStream());
            DataOutputStream ServerSocketOutput = new DataOutputStream(ServerSocket.getOutputStream());
            
            while (true)
            {
                System.out.println("Waiting for Client Connect......");
                delay(2000);
                Socket clientSocket = computer.accept();
                System.out.println("Connected to Client......");
                delay(2000);


                //3.create I/O streams
                DataInputStream clientSocketInput = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream clientSocketOutput = new DataOutputStream(clientSocket.getOutputStream());

                //5. perform IO with server 
                while (true)
                {
                    String clientData = clientSocketInput.readUTF();
                    System.out.println("Client says:" + clientData);
                    delay(2000);
                    System.out.println("Sending sensor readings,cameras and electronic traffic signs to server");
                    delay(2000);
                    
                    ServerSocketOutput.writeUTF("send data");
                    ServerSocketOutput.flush();
                    
                    String serverData = ServerSocketInput.readUTF();
                    System.out.println(serverData);
                    delay(2000);

                    if(serverData.equals("send recommendations")){
                        clientSocketOutput.writeUTF(serverData);
                        clientSocketOutput.flush();
                        ServerSocketInput.close();
                        ServerSocketOutput.close();
                        ServerSocket.close();
                        break;
                    }


                }
                clientSocketInput.close();
                clientSocketOutput.close();
                clientSocket.close();

                // //6. close connection
  
            }

            //7. close connections
        
            
        } 
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }    
}