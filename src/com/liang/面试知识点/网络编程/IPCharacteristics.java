package com.liang.面试知识点.网络编程;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @Description: TODO
 * @Author: LiangYang
 * @Date: 2022/4/25 下午9:28
 **/
public class IPCharacteristics {
    public static void main(String[] args) {

        try {
            URL url = new URL("https://www.baidu.com");
            System.out.println(url.getProtocol());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

//        try {
//            InetAddress address = InetAddress.getByName("192.168.0.130");
//            System.out.println(address.isReachable(1000));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
