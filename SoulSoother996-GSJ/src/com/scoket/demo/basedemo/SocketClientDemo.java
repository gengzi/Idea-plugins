package com.scoket.demo.basedemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端向服务端发送数据
 */
public class SocketClientDemo {


    public static void main(String[] args) throws IOException {

        String host = "127.0.0.1";
        int prot = 55533;
        // 与服务器建立连接
        Socket socket = new Socket(host,prot);
        // 获取输出流，向服务端写数据
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(new String("你好").getBytes("UTF-8"));

        // 关闭资源
        outputStream.close();
        socket.close();




    }
}
