package com.scoket.demo.basedemo.demo04;

import com.scoket.demo.basedemo.demo05.ThreadServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;


/**
 * serverscoket 服务端
 * <p>
 * 接收用户发来的请求
 * 并将消息分发给所有链接的客户端
 */
public class SocketServerDemo {

    private Set<Socket> clients;
    int prot = 55533;


    public SocketServerDemo() {
        clients = new HashSet<>(16);
        try {
            // 创建ServerSocket
            ServerSocket serverSocket = new ServerSocket(prot);
            System.out.println("聊天室开启");
            while (true) {
                // 接收客户端的请求,阻塞方法

                Socket socket = serverSocket.accept();
                System.out.println("新用户");
                ThreadServer2 threadServer = new ThreadServer2(socket);
                Thread thread = new Thread(threadServer);
                thread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("聊天室异常关闭");
        }
    }



    public static void main(String[] args) throws IOException {
        SocketServerDemo socketServerDemo = new SocketServerDemo();


    }

}

