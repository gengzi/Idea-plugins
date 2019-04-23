package com.nio.demo.mydemo;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) throws IOException {
        //使用nio读取文件内容，并复制内容到另一个文件中
        Scanner scanner = new Scanner(System.in);
        String inFilePath = scanner.next();
        File infile = new File(inFilePath);
        String outFilePath = scanner.next();
        File outfile = new File(outFilePath);

        // 通道
        FileInputStream infileInputStream = new FileInputStream(infile);
//        FileInputStream outfileInputStream = new FileInputStream(outfile);
        // 使用 FileInputStream 获取的文件只能是只读的，如果需要写入文件，需要使用FileOutputStream
        RandomAccessFile outfileInputStream = new RandomAccessFile(outfile,"rw");
        FileChannel infilechannel = infileInputStream.getChannel();
        FileChannel outfilechannel = outfileInputStream.getChannel();

        // 缓冲区
        byte[] bytes = new byte[1024];
        ByteBuffer buffer1 = ByteBuffer.wrap(bytes);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //将该文件的数据读取到 buffer
        while(true){
            buffer.clear();
            int read = infilechannel.read(buffer);

            if(read == -1){
                break;
            }

            //写数据之前，必须调用flip方法
            buffer.flip();
            int write = outfilechannel.write(buffer);
        }


    }


}
