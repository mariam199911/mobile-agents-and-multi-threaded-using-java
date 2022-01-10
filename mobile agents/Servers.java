import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servers{
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
            //1.open server socket
            ServerSocket server = new ServerSocket(5000);
            System.out.println("Server is running...");
            delay(2000);
            while (true)
            {
                //2.accept connection
                
                System.out.println("Waiting for Computer Connect......");
                delay(2000);
                Socket computerSocket = server.accept();
                delay(5000);
                System.out.println("Connected to Computer......");

                //3.create I/O streams
                DataInputStream computerSocketInput = new DataInputStream(computerSocket.getInputStream());
                DataOutputStream computerSocketOutput = new DataOutputStream(computerSocket.getOutputStream());

                //4.perform IO with client
                while (true)
                {
                    String data = computerSocketInput.readUTF();
                    if(data.equals("send data")){
                        System.out.println("Resived data from computers");
                        delay(2000);
                        System.out.println("process the data ");
                        delay(2000);
                    }
                    computerSocketOutput.writeUTF("send recommendations");
                    computerSocketOutput.flush();
                    break;
                // //5.close connection

                }
                computerSocketInput.close();
                computerSocketOutput.close();
                computerSocket.close();
    
            }

        } 
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
