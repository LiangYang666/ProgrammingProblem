package com.liang.面试知识点.网络编程.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.网络编程.udp
 * @ClassName: UdpServer
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/22 21:57
 * @Version: 1.0
 */
public class UdpUnicastServer {
    public static void main(String[] args) throws Exception {
        System.out.println("=====Server start======");
        String ip = "127.0.0.1";
        int port = 8888;
        InetAddress adds = InetAddress.getByName(ip);

        // 1、创建发送端socket，会使用随机端口
        DatagramSocket socket = new DatagramSocket();
        for (int i = 0; i < 50; i++) {
            Thread.sleep(1000);
            String msg = "hello, "+i;
            // 2、创建一个数据包对象封装数据
            byte[] buffer = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, adds, port);

            // 3、发送数据出去
            socket.send(packet);
        }

        socket.close();
    }
}
