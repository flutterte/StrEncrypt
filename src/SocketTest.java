import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SocketTest {

	public static void main(String[] args) throws IOException {

		Socket socket = new Socket("www.qssq666.cn", 80);// ip��ַ��������
															// �˿ںţ������https����443

		// �������ݵ�������
		final BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		// �������� �����
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		bw.write("GET /about/ HTTP/1.1");
		bw.write("\n");
		bw.write("Host: qssq666.cn");
		bw.write("\n");
		bw.write("Connection: Keep-Alive");
		bw.write("\n");
//		bw.write("\n");
		bw.flush();
		System.out.println("execute....");
		while (true) {
			String line = null;
			try {
				// System.out.println("========readLineStart=======");
				while ((line = br.readLine()) != null) {
					System.out.println("" + line);
				}
				// System.out.println("========readLineEnd=======");
			} catch (IOException e) {
				System.err.println("�����쳣:" + e.toString());
				e.printStackTrace();
			}

			// System.out.println("========================");
		}

	}
}
