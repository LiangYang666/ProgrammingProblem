package com.liang.面试知识点.网络编程;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/25 下午10:33
 **/
public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("127.0.0.1", 10086));
//        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("server start");
        while (true){
            Socket acceptSocket = serverSocket.accept();
            System.out.println("accept socket");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        InputStream inputStream = acceptSocket.getInputStream();
                        while (true){
                            byte[] buffer = new byte[1024];
                            int len = inputStream.read(buffer);
                            if (len == -1){
                                break;
                            }
                            String str = new String(buffer, 0, len, StandardCharsets.UTF_8);
                            System.out.println("received packet from " + acceptSocket.getInetAddress() + ":" + acceptSocket.getPort() + ": " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        acceptSocket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
}
