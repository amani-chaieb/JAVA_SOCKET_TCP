
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientTCP {
	public static void main(String[] args) {

		try {
			Socket socket = new Socket("127.0.0.1", 6969);

			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			String command;

			while (true) {
				System.out.println("Enter Votre nom: ");
				BufferedReader inClavier = new BufferedReader(new InputStreamReader(System.in));

				command = inClavier.readLine();

				writer.println(command); // send command

				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

				String msgRCV = reader.readLine();

				System.out.println(msgRCV);
				
			}

		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
}
