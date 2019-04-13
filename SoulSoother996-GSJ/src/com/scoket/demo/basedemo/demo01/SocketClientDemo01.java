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
        /**
         * 调用Socket的shutdownOutput()方法，底层会告知服务端我这边已经写完了，那么服务端收到消息后，就能知道已经读取完消息，
         * 如果服务端有要返回给客户的消息那么就可以通过服务端的输出流发送给客户端，如果没有，直接关闭Socket。
         * 缺点：
         * 不能再次发送消息给服务端，如果再次发送，需要重新建立Socket连接
         * 　　这个缺点，在访问频率比较高的情况下将是一个需要优化的地方。
         */
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
