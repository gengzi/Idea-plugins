package com.scoket.demo.basedemo.demo04;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端向服务端发送数据
 *
 * 并接收服务端传回来的数据
 *
 */
public class SocketClientDemo {
    String host = "127.0.0.1";
    int prot = 55533;
    private PrintWriter printWriter;
    private Scanner scan;
    OutputStream outputStream;

    public SocketClientDemo() {
        // 与服务器建立连接
        try {
            Socket socket = new Socket(host,prot);

            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(socket.getOutputStream());

            // 开启一个线程接收数据
            // 主线程发送消息

            Thread thread = new Thread(new ThreadClient(socket));
            thread.start();

            scan = new Scanner(System.in);
            while(true){
                String message = scan.nextLine();
//               String message =  "111";
//                printWriter.write(message);
//                printWriter.flush();
                printWriter.println(message);
                printWriter.flush();
                System.out.println(message);
//                printWriter.write(message);
//                printWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SocketClientDemo socketClientDemo = new SocketClientDemo();

    }

}
