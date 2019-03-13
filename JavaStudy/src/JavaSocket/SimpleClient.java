package JavaSocket;

import java.net.*;
import java.io.*;

public class SimpleClient {
	public static void main(String[] ars) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds = new DatagramSocket();

		while (true) {
			System.out.print("Send Message : ");
			String msg = in.readLine();
			InetAddress ia = InetAddress.getByName(Inet4Address.getLocalHost().getHostAddress());
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ia, 4444);

			ds.send(dp);
			System.out.println("Send Complete.");
		}
	}
}