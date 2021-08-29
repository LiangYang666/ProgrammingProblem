package com.liang.offer;

import java.util.*;

public class MOffer20表示数值的字符_状态机 {
    public static void main(String[] args) {
        System.out.println(isNumber("2e-"));
    }
    static
    public boolean isNumber(String s) {
        final String blank = " ",  sign = "sign", dot=".", number="number", e="e";
        Map[] states = {
                new HashMap<String, Integer>() {{ put(blank, 1);put(sign, 2); put(number,3); put(dot, 10);}},
                new HashMap<String, Integer>() {{put(dot, 10);put(number, 3); }},
                new HashMap<String, Integer>() {{put(number,3); put(dot, 4);put(e,6);put(blank, 9);}},
                new HashMap<String, Integer>() {{put(blank, 9); put(number,5);put(e, 6);}},
                new HashMap<String, Integer>() {{put(number, 5); put(blank,9);put(e, 6);}},
                new HashMap<String, Integer>() {{put(sign, 7); put(number,8);}},
                new HashMap<String, Integer>() {{put(number, 8);}},
                new HashMap<String, Integer>() {{put(number, 8); put(blank,9);}},
                new HashMap<String, Integer>() {{put(blank, 9);}},
                new HashMap<String, Integer>() {{put(number, 5);}}
        };
        int id = 1;
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            String get;
            switch (c){
                case ' ': get=blank;break;
                case '.': get=dot;break;
                case 'e':;
                case 'E':get=e;break;
                case '-':;
                case '+':get=sign;break;
                default:{
                    if('0'<=c && c<='9')
                        get=number;
                    else
                        return false;
                };break;
            }
            if(states[id-1].containsKey(get)){
                id = (int)(states[id-1].get(get));
            }else {
                return false;
            }
        }
        if ((new ArrayList<Integer>(Arrays.asList(3, 4, 5, 8, 9)).contains(id))) {
            return true;
        }
        return false;
    }
}
