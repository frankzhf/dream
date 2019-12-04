package net.frank.demos.netty.action.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BlockingIoExample {

    public void serve(int portNumber) throws IOException {
        ServerSocket serverSocket =  new ServerSocket(portNumber);
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out =
                new PrintWriter(socket.getOutputStream(),true);
        String request, response;
        while((request= in.readLine())!=null){
            if("Done".equals(request)){
                break;
            }
            response = processRequest(request);
            out.println(response);
        }
    }

    private String processRequest(String request){
        return "Processed";
    }

}
