package com.liang.面试知识点.计网;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
实现tcp服务端 监听8099端口 接收消息的小demo（与python编写的linux程序进行联系）
 */


public class CommunicateDemo01 {
    private static final Integer PORT = 8099;

    public static void main(String[] args) throws IOException {
        System.out.println("开始启动");
        ServerSocket serverSocket = new ServerSocket(PORT);
        int i =0;
        while (!serverSocket.isClosed()){
            Socket accept = serverSocket.accept();
            RequestHandler requestHandler = new RequestHandler(accept, Integer.toString(i++));
            Thread thread = new Thread(requestHandler);
            thread.start();
//            System.out.println(accept.getInetAddress().getHostAddress());
        }
    }
}
class RequestHandler implements Runnable{
    public Socket socket;
    public String name;

    public RequestHandler(Socket socket, String name) {
        this.name = Thread.currentThread().getName()+name;
        this.socket = socket;
        System.out.println("收到了一个连接："+ socket.getInetAddress().getHostAddress());
        System.out.println("创建了一个新的线程: "+this.name);
    }
    public void sleep(int millis){
        System.out.println();
        for (int i = 0; i < 10; i++) {
            String str = String.format("%1d", (9 - i));
            System.out.print(str);
            try {
                Thread.sleep(millis/10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("\b\b");
        }
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        byte[] bytes = new byte[1024];
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                int size = inputStream.read(bytes);
                System.out.println("size: "+size);
                if (size<0)    break;
            } catch (IOException e) {
                System.out.println("错误");
                e.printStackTrace();
            }
            System.out.println(name+" 收到消息"+ new String(bytes));
        }
        System.out.println("我知道你已经单向关闭了，我等一会也关闭");
        sleep(10000);
        try {
            System.out.println("关闭");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


//        try {
//            OutputStream outputStream = socket.getOutputStream();
//            String resp = "OK OK";
//
//            outputStream.write(resp.getBytes());
//            System.out.println(name+" 发送了："+resp);
//            outputStream.flush();
//            outputStream.close();
//            Thread.sleep(1000);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            if (socket!=null){
//                try {
//                    System.out.println(name+" 关闭连接"  );
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
}
