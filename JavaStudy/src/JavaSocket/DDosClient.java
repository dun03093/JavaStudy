package JavaSocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.SocketException;
import java.util.Random;

public class DDosClient {

	public static void main(String[] args) {

		try {
			Socket sock = new Socket(Inet4Address.getLocalHost().getHostAddress(), 23);
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			OutputStream out = sock.getOutputStream();
			InputStream in = sock.getInputStream();
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;
			int i = 0;
			while (true) {
				line += "[" + i++ + "]";
				pw.println(line);
				pw.flush();
				// String echo = br.readLine();
				System.out.println("return : " + line);

			}
			// pw.close();
			// br.close();
			// sock.close();
		} catch (ConnectException e) {
			// java.net.SocketException: Connection reset
			System.out.println("¼­¹ö ´ÝÈû");
		} catch (SocketException e) {
			// java.net.ConnectException: Connection refused: connect
			System.out.println("¿¬°á Áß ¼­¹ö°¡ ´ÝÇû½À´Ï´Ù.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String RandString() {
		Random rnd = new Random();
		StringBuffer temp = new StringBuffer();
		for (int i = 0; i < 30; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		return temp.toString();
	}
}