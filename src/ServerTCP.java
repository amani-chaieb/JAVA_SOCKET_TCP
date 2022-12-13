


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerTCP {
	private static final int port = 6969;
	   
    public static void main(String[] args) {

    	 
        try  {
        	ServerSocket serverSocket = new ServerSocket(port);
            

            while (true) {
                Socket sc = serverSocket.accept();
                System.out.println("New client connected");

                Traitement th=new Traitement(sc);
                th.start();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
