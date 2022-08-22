package com.liang.面试知识点.网络编程;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/25 下午10:32
 **/
public class TcpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("127.0.0.1", 10086);
        System.out.println("client start");
        OutputStream out = socket.getOutputStream();
        for (int i = 0; i < 50; i++) {
            Thread.sleep(2000);
            String msg = "hello, "+i;
            out.write(msg.getBytes());
            out.flush();
        }
        socket.close();
    }
}
