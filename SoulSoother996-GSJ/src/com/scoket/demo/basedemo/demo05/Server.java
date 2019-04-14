package com.scoket.demo.basedemo.demo05;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<ThreadServer> clients=new ArrayList<ThreadServer>();
    public void startup() throws IOException {
        System.out.println("监听5001端口");
        ServerSocket ss=new ServerSocket(5001);
        while(true){
            Socket socket=ss.accept();
            System.out.println("发现新用户");
            Thread st=new Thread(new ThreadServer(socket));
            st.start();
        }
    }
    
    public static void main(String []args) throws IOException {
        Server server=new Server();
        System.out.println("服务器开启");
        server.startup();
    }
    
}