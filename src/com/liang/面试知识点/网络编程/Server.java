package com.liang.面试知识点.网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/25 下午10:33
 **/
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        while (true){
            Socket acceptSocket = serverSocket.accept();
            InputStream inputStream = acceptSocket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
//            reader.

        }


    }
}
