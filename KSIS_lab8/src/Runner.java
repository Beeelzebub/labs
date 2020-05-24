import java.io.*;
import java.net.Socket;

public class Runner {
        public static void main(String[] args) throws IOException {//We don't handle Exceptions in this example
            //Open a socket to stackoverflow.com, port 80
            Socket socket = new Socket("vk.com/spontus",80);

            //Prepare input, output stream before sending request
            OutputStream outStream = socket.getOutputStream();
            InputStream inStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));

            //Send a basic HTTP header
            writer.print("GET / HTTP/1.1\nHost: vk.com/spontus\n\n");
            writer.flush();

            //Read the response
            System.out.println(readFully(reader));

            //Close the socket
            socket.close();
        }

        private static String readFully(Reader in) throws IOException {
            StringBuilder sb = new StringBuilder();
            int BUFFER_SIZE=1024;
            char[] buffer = new char[BUFFER_SIZE]; // or some other size,
            int charsRead = 0;
            while ((charsRead = in.read(buffer, 0, BUFFER_SIZE)) != -1) {
                sb.append(buffer, 0, charsRead);
                System.out.println("Получаем данные...");
            }
            return sb.toString();
        }
    }
