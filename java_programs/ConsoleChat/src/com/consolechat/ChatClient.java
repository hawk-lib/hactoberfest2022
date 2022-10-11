package com.consolechat;

import java.io.*;
import java.net.*;

public class ChatClient {
    private final String hostname;
    private final int port;
    private String userName;

    ChatClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    public void execute(){
        try{
            Socket socket = new Socket(hostname,port);
            System.out.println("connected to the cht server");
            new ReadThread(socket,this).run();
            new WriteThread(socket,this).run();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }

    public static void main(String[] args){
        if (args.length < 2){
            System.out.println("2 argument expected.");
        } else {
            String hostname = args[0];
            int port = Integer.parseInt(args[1]);

            ChatClient client = new ChatClient(hostname,port);
            client.execute();
        }
    }
}
