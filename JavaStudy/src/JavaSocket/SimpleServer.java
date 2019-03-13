package JavaSocket;

import java.net.*;
import java.io.*;

public class SimpleServer {
	public static void main(String args[]) throws IOException {
		System.out.println("Server open.");
		DatagramSocket ds = new DatagramSocket(4444);
		while (true) {
			byte[] data = new byte[65508];
			DatagramPacket dp = new DatagramPacket(data, data.length);
			ds.receive(dp);
			System.out.println(dp.getAddress().getHostAddress() + ">> " + new String(dp.getData()).trim());
		}
	}
}