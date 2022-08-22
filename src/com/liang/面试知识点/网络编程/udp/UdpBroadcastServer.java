package com.liang.面试知识点.网络编程.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.网络编程.udp
 * @ClassName: UdpBroadcastServer
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/8/22 21:22
 * @Version: 1.0
 */
public class UdpBroadcastServer {
    public boolean closed = false;
//    public String ip = "255.255.255.255"; //受限广播地址 一般用于不知道本机地址时希望从DHCP服务器获取地址
    public String ip = "192.168.0.255"; //直接广播地址 局域网 指定子网ip+全1主机号
    public int port = 6787;//指定广播接收数据端口
    public int MessageIndex = 0;//数据发送次数

    public void start(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("UdpBroadcastServer start ");
                runServer();
            }
        }).start();
    }

    private void runServer(){
        try {
            while(!closed){
                Thread.sleep(2000);
                send();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("UdpTestServer run Exception: "+e.toString());
        }
    }

    public void send(){
        try{
            String sendMessage="hello ,message from server,"+MessageIndex++;
            InetAddress adds = InetAddress.getByName(ip);
            DatagramSocket ds = new DatagramSocket();
            DatagramPacket dp = new DatagramPacket(sendMessage.getBytes(),sendMessage.length(), adds, port);
            ds.send(dp);
            ds.close();
        }catch (Exception e) {
            System.out.println("UdpTestServer send Exception: "+e.toString());
        }

        if(MessageIndex>=50){
            closed = true;
            System.out.println("closed  ");
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        UdpBroadcastServer server = new UdpBroadcastServer();
        server.start();
    }

}