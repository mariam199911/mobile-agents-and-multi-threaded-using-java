import java.io.*;
import java.net.*;

public class Client {
    private static Socket computer0;
    private static Socket computer1;
    private static Socket computer2;
    private static Socket computer3;
    public static void main(String[] args) throws IOException {

        /** Connection Part */

        // Connect to Computing Node
        computer0 = new Socket("localhost", 5000);
        computer1 = new Socket("localhost", 5001);
        computer2 = new Socket("localhost", 5002);
        computer3 = new Socket("localhost", 5003);

        /** Connection Part */

        /** Client Threads */

        Thread client1 = new ServerHandler(computer0, "state of city0, best route to reach s0 point");
        Thread client2 = new ServerHandler(computer1, "state of city1, best route to reach s1 point");
        Thread client3 = new ServerHandler(computer2, "state of city2, best route to reach s2 point");
        Thread client4 = new ServerHandler(computer3, "state of city3, best route to reach s3 point");
        int i = 0;
        
        while (true) {

            client1.run();
            client2.run();
            client3.run();
            client4.run();
        }
        /** Client Threads */

    }
}