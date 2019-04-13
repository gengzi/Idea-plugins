package com.scoket.demo.basedemo.demo02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerDemo02 {


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
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {

            String line = null;

            while ((line = bufferedReader.readLine()) != null && !line.equals("end")) {
                System.out.println(line);
                stringBuilder.append(line);

            }
            //响应消息

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(new String("收到了您的消息").getBytes("UTF-8"));
            outputStream.flush();

        }


    }


}
