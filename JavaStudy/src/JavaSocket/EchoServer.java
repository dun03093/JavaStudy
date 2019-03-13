package JavaSocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	final static int MAXSOCKET = 100;
	final static int socketNum = 23;

	public static void main(String[] args) {
		System.out.println("Server Open.");
		try {

			// 1. make ServerSockets number of MAXSOCKET

			ServerSocket[] server = new ServerSocket[MAXSOCKET];
			Socket[] sock = new Socket[MAXSOCKET];
			for (int socketIndex = 0; socketIndex < MAXSOCKET; socketIndex++)
				server[socketIndex] = new ServerSocket(socketIndex);

			System.out.println("Wating Connect ..");

			// 2. ServerSocket.accept() = wait Client
			// When Client join -> return Socket object.
			sock[socketNum] = server[socketNum].accept();
			InetAddress inetaddr = sock[socketNum].getInetAddress();
			System.out.println(inetaddr.getHostAddress() + " 로부터 접속했습니다.");

			// 3. Make InputStream& OutputStream from returned socket.
			OutputStream out = sock[socketNum].getOutputStream();
			InputStream in = sock[socketNum].getInputStream();

			// 4. InputStream transfer to BufferedReader type.

			// OutputStream transfer to PrintWriter

			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = null;

			// 5. Read Client's Message 1 line.
			while ((line = br.readLine()) != null) {
				System.out.print(inetaddr.getHostAddress());
				System.out.printf("[%4d]", socketNum);
				System.out.println(inetaddr.getHostAddress() + " : " + line);

				// 6. pw.println() -> return to Client.
				pw.println(line);
				pw.flush();

			}

			// 6. IO Objects & socket close()
			pw.close();
			br.close();
			sock[socketNum].close();
			for (int socketIndex = 0; socketIndex < MAXSOCKET; socketIndex++)
				server[socketIndex].close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}