package com.liang.笔试真题.猿辅导;



import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {

            int maxT = 0;
            int n = sc.nextInt();
            HashMap<String, Integer> map = new HashMap<>();
            String[] words = new String[n];
            for (int j = 0; j < n; j++) {
                words[j] = sc.next().toLowerCase();
            }
            int k = sc.nextInt();
            String[] stopWords = new String[k];
            for (int j = 0; j < k; j++) {
                stopWords[j] = sc.next().toLowerCase();
            }
            for (int j = 0; j < n; j++) {
                boolean flag = false;
                String w = words[j];
                for (int l = 0; l < k; l++) {
                    String s = stopWords[l];
                    if (s.length()==w.length()){
                        int total = 0;
                        for (int m = 0; m < w.length(); m++) {
                            if (w.charAt(m)==s.charAt(m)||s.charAt(m)=='?'){
                                total++;
                            } else {
                                break;
                            }
                        }
                        if (total==w.length()){
                            flag=true;
                            break;
                        }

                    }
                }
                if (!flag){
                    if (!map.containsKey(w)){
                        map.put(w, 0);
                    }
                    map.put(w, map.get(w)+1);
                    maxT = Math.max(maxT, map.get(w));
                }
            }
            System.out.println(maxT);

//            System.out.println(Arrays.toString(words));
//            System.out.println(Arrays.toString(stopWords));
        }
    }
}
