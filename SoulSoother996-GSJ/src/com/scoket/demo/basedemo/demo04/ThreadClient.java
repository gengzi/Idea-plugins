package com.scoket.demo.basedemo.demo04;


import java.io.IOException;
import java.net.Socket;

/**
 *  客户端
 */
public class ThreadClient implements  Runnable{

    private Socket socket;

    public ThreadClient(Socket socket) {
        this.socket = socket;

    }

    @Override
    public void run() {
        while(true){
            if(socket ==null){
                break;
            }
            byte ss[]=new byte[1024];
            try {
                socket.getInputStream().read(ss);
                System.out.println("接收消息"+new String(ss,0,ss.length));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
