import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server
{
    private ServerSocket serverSock;
    private Socket clientSock;
    private PrintWriter writer;
    private BufferedReader reader;
    private boolean isLogged;
    private String userName;
    private String userPass;
    private HashMap<String, String> userList;
    private ArrayList<String> mailsList;
    private File[] mailFiles;
    private ArrayList<Integer> mailsToDelete;


    public Server()
    {
        userListCreate();
        try
        {
            serverSock = new ServerSocket(110);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void connection()
    {
        refresh();
        try
        {
            clientSock = serverSock.accept();
            InputStreamReader isReader = new InputStreamReader(clientSock.getInputStream());
            reader = new BufferedReader(isReader);
            writer = new PrintWriter(clientSock.getOutputStream());
            response("+OK POP3 server ready");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void refresh()
    {
        isLogged = false;
        userName = null;
        userPass = null;
        mailsList.clear();
        mailsToDelete.clear();
        mailFiles = null;
    }

    private void response (String message)
    {
        try
        {
            writer.println(message);
            writer.flush();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void clientHandler()
    {
        String message;
        int number;

        try
        {
            while ((message = reader.readLine()) != null)
            {
                if (commandDef(message, "USER"))
                {
                    doUser(message.split(" ")[1]);
                }
                else if (commandDef(message, "PASS"))
                {
                    doPass(message.split(" ")[1]);
                }
                else if (commandDef(message, "RETR"))
                {
                    number = Integer.parseInt(message.split(" ")[1]);
                    doRetr(number);
                }
                else if (commandDef(message, "DELE"))
                {
                    number = Integer.parseInt(message.split(" ")[1]);
                    doDele(number);
                }
                else if (commandDef(message, "LIST"))
                {
                    doList();
                }
                else if (commandDef(message, "STAT"))
                {
                    doStat();
                }
                else if (commandDef(message, "TOP"))
                {
                    number = Integer.parseInt(message.split(" ")[1]);
                    doTop(number);
                }
                else if (commandDef(message, "QUIT"))
                {
                    doQuit();
                }
                else
                {
                    response("-ERR Command does not exist");
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void doUser(String message)
    {
        if (isLogged(true))
        {
            return;
        }

        if ((userPass = userList.get(message)) != null)
        {
            userName = message;
            response("-OK Name is a valid mailbox");
        }
        else
        {
            response("-ERR Never heard of mailbox name");
        }
    }

    private void doPass(String message)
    {
        if (isLogged(true))
        {
            return;
        }

        if (userName != null)
        {
            if (message.equals(userPass))
            {
                response("+OK Password accepted");
                isLogged = true;
                mailsListCreate();
            }
            else
            {
                response("-ERR Invalid password");
            }
        }
        else
        {
            response("-ERR Enter user first");
        }
    }

    private void doQuit()
    {
        int index;

        for (int i = 0; i < mailsToDelete.size(); i++)
        {
            index = mailsToDelete.get(i);
            mailFiles[index].delete();
        }

        response("+OK");

        try
        {
            reader.close();
            writer.close();
            clientSock.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void doTop(int number)
    {
        if (!validationCheck(number))
        {
            return;
        }

        int edge = mailsList.get(number).indexOf("\n\n");
        String head = mailsList.get(number).substring(0, edge);
        response("+OK\n" + head);
    }

    private void doStat()
    {
        int octetsCount = 0, msgCount = 0;
        for (int i = 0; i < mailsList.size(); i++)
        {
            if (!mailsToDelete.contains(i))
            {
                msgCount++;
                octetsCount += mailsList.get(i).length();
            }
        }
        response("+OK " + msgCount + " messages " + octetsCount + " octets");
    }

    private void doDele(int number)
    {
        if (!validationCheck(number))
        {
            return;
        }

        mailsToDelete.add(number);
        response("+OK Message deleted");
    }

    private void doRetr(int number)
    {
        if (!validationCheck(number))
        {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("+OK " + mailsList.get(number).length() + " octets\n");
        sb.append(mailsList.get(number));
        response(sb.toString());
    }

    private void doList()
    {
        if (!isLogged(false))
        {
            return;
        }

        StringBuilder sb = new StringBuilder();

        sb.append("+OK " + mailsList.size() + " messages\n");

        for (int i = 0; i < mailsList.size(); i++)
        {
            if (!mailsToDelete.contains(i))
            {
                sb.append((i + 1) + " " + mailsList.get(i).length() + "\n");
            }
        }

        response(sb.toString());
    }

    private boolean validationCheck(int number)
    {
        if (!isLogged(false))
        {
            return false;
        }

        if (number < 0 || number >= mailsList.size() || mailsToDelete.contains(number))
        {
            response("-ERR No such message");
            return false;
        }

        return true;
    }

    private boolean isLogged(boolean forLogin)
    {
        if (isLogged){
            if (forLogin)
            {
                response("-ERR You are already logged in");
            }
            return true;
        }
        else
        {
            if (!forLogin)
            {
                response("-ERR Please log in first");
            }
            return false;
        }
    }

    private boolean commandDef(String message, String command)
    {
        if (message.substring(0, command.length()).equalsIgnoreCase(command))
        {
            return true;
        }
        return false;
    }

    private void userListCreate()
    {
        userList = new HashMap<>();
        String line;
        try
        {
            BufferedReader rd = new BufferedReader(new FileReader("userDB.txt"));
            while ((line = rd.readLine()) != null)
            {
                String[] sp = line.split(";");
                userList.put(sp[0], sp[1]);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void mailsListCreate()
    {
        File folder = new File("mailbox/" + userName + "/");
        mailFiles = folder.listFiles();
        try
        {
            for (int i = 0; i < mailFiles.length; i++)
            {
                StringBuilder sb = new StringBuilder();
                String line;
                BufferedReader rd = new BufferedReader(new FileReader(mailFiles[i].getName()));
                while ((line = rd.readLine()) != null)
                {
                    sb.append(line);
                }
                mailsList.add(sb.toString());
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    private void go()
    {
        while (true)
        {
            connection();
            clientHandler();
        }
    }

    public static void main(String[] argv)
    {

        Server server = new Server();
        server.go();

    }
}
