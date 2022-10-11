package com.consolechat;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    private int port;
    private HashSet<String> userNames = new HashSet<>();
    private HashSet<UserThread> userThreads = new HashSet<>();

    ChatServer(int port){
        this.port = port;
    }

    public void execute(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Chat server is listening on port " + port);
            while(true){
                Socket socket = serverSocket.accept();
                System.out.println("New user connected.");

                UserThread newUser = new UserThread(socket,this);
                userThreads.add(newUser);
                newUser.start();
            }
        } catch (IOException e) {
            System.out.println("Error in server " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Syntax: java ChatServer <port-number>");
            System.exit(0);
        }
        int port = Integer.parseInt(args[0]);

        ChatServer server = new ChatServer(port);
        server.execute();
    }

    public void broadcast(String message, UserThread excludeUser){
        for (UserThread user : userThreads){
            if (user != excludeUser){
                user.sendMessage(message);
            }
        }
    }

    public void addUserName(String userName){
        userNames.add(userName);
    }

    public void removeUser(String userName, UserThread user){
        boolean removed = userNames.remove(userName);
        if (removed){
            userThreads.remove(user);
            System.out.println("User " + userName + " left the chat.");
        }
    }

    Set<String> getUserNames(){
        return this.userNames;
    }

    public boolean hasUsers(){
        return !this.userNames.isEmpty();
    }
}
