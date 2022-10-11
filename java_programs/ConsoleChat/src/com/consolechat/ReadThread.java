package com.consolechat;

import java.io.*;
import java.net.*;

public class ReadThread {
    private BufferedReader reader;
    private Socket socket;
    private ChatClient client;

    ReadThread(Socket socket,ChatClient client){
        this.socket = socket;
        this.client = client;

        try{
            InputStream input = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));
        } catch (IOException e) {
            System.out.println("Error getting input stream: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void run(){
        while(true){
           try{
               String response = reader.readLine();
               System.out.println("\n" + response);

               if(client.getUserName() != null){
                   System.out.println("[" + client.getUserName() + "]: ");
               }
           } catch (IOException e) {
               System.out.println("Error reading from server: " + e.getMessage());
               e.printStackTrace();
               break;
           }
        }
    }
}
