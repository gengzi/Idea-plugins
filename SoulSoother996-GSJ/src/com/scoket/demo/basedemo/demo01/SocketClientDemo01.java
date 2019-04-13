package com.scoket.demo.basedemo.demo01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端向服务端发送数据
 */
public class SocketClientDemo01 {


    public static void main(String[] args) throws IOException {

        String host = "127.0.0.1";
        int prot = 55533;
        // 与服务器建立连接
        Socket socket = new Socket(host,prot);
        // 获取输出流，向服务端写数据
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(new String("你好").getBytes("UTF-8"));
        //通过shutdownOutput 已经发送完数据，后续只能接受数据
        socket.shutdownOutput();



        // 获取客户端发送的数据（用流的方式接收）
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1024];
        int len ;
        StringBuilder stringBuilder = new StringBuilder();
        while( (len = inputStream.read(buffer) ) != -1){
            stringBuilder.append(new String(buffer,0,len,"UTF-8"));
        }
        System.out.println(stringBuilder.toString());



        // 关闭资源
        outputStream.close();
        socket.close();




    }
}
