package com.liang.面试知识点.流;

import java.nio.charset.StandardCharsets;

/**
 * @ProjectName: ProgrammingProblem
 * @Package: com.liang.面试知识点.流
 * @ClassName: MyStream
 * @Description:
 * @Author: Yang Liang
 * @CreateDate: 2022/1/26 20:10
 * @Version: 1.0
 */
public class MyStream {
    public static void main(String[] args) {
        String s = "君山abc";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        for (Byte b :
                bytes) {
            System.out.println(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1));

        }
    }

}
