import java.io.*;
import java.net.*;
import java.util.Random;

class ServerHandler extends Thread {
    //final Socket s = null;

    private Socket server;
    private static int threadcount = 0;
    private int threadid;
    private String message;

    // Constructor
    public ServerHandler(Socket s, String message) {
        this.server = s;
        this.message = message;
        threadid = threadcount;
        threadcount++;
    }

    @Override
    public void run() {

        try {
            messageToServer(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void messageToServer(String messageToServer) throws IOException {
        // Todo
        /**
         * Send message to computing node at port 5000 Recieve messafe from computing
         * node at port 5000 Compare the received water level with threshold value and
         * send decisison at port 5001
         */
        System.out.println("client no: " + (threadid+1) + " wants to know" + messageToServer);
        String msg = "";
        
            try {
                sendToServer(messageToServer);
                msg = recieveFromServer();
                System.out.println(msg);

            } catch (IOException e) {
                System.out.println(e);
            }
        
     
        

    }

    private String recieveFromServer() throws IOException{
        // Recieve message from Computing Node
        InputStreamReader inServer = new InputStreamReader(this.server.getInputStream());
        BufferedReader bfServer = new BufferedReader(inServer);
        return bfServer.readLine();
    }

    private void sendToServer(String message) throws IOException  {
        // Send message to Computing Node
        PrintWriter prServer = new PrintWriter(this.server.getOutputStream());
        prServer.println(message);
        prServer.flush();
    }
  
}