package com.scoket.demo.basedemo.demo04;


import java.io.*;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

/**
 *  服务端
 */
public class ThreadServer2 implements Runnable {
    private Set<ThreadServer2> clients ;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private String name;
    private Socket socket;
    OutputStream outputStream;


    public ThreadServer2(Socket socket) {
        try {
            this.socket = socket;
            clients = new HashSet<>(16);
            // 获取输入
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 获取输出
            outputStream = socket.getOutputStream();
            printWriter = new PrintWriter(socket.getOutputStream());
            bufferedReader.readLine();
            name = "[" + socket.getInetAddress().getHostAddress() + ":" + socket.getPort() + "]";
            System.out.println(name);
            clients.add(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将现有消息发送到所有客户端成员
     */
    public void send(String message) {

        for (ThreadServer2 client : clients) {
//            client.printWriter.write(message);
//            client.printWriter.flush();
            try {
                client.outputStream.write(message.getBytes("UTF-8"));
                client.outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 接收客户端发来的消息
     */
    public void receive() {
        System.out.println("接收数据");
        String message = null;
        boolean flag = true;
        while (flag) {
            System.out.println("执行");
            try {

                message = bufferedReader.readLine();
                if(message ==null){
                    continue;
                }
                System.out.println(name + ":" + message);
                send(name + ":" + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void run() {
        try {
            while (true) {
                receive();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
