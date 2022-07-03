package com.liang.面试知识点.网络编程;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/25 下午10:32
 **/
public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 10086);
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write("test \n");

    }
}
