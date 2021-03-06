package com.scoket.demo.basedemo.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo01 {


    /**
     * socketServer demo 学习
     *
     * 开启socketserver 服务， 接收客户端的消息
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        int prot = 55533;

        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(prot);
        // 接收客户端的请求
        Socket socket = serverSocket.accept();
        // 获取客户端发送的数据（用流的方式接收）
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int len ;
        StringBuilder stringBuilder = new StringBuilder();
        while( (len = inputStream.read(buffer) ) != -1){
            stringBuilder.append(new String(buffer,0,len,"UTF-8"));
        }
        System.out.println(stringBuilder.toString());

        //响应消息

        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(new String("收到了您的消息").getBytes("UTF-8"));



        // 需要关闭流
        outputStream.close();
        inputStream.close();
        serverSocket.close();



    }


}
