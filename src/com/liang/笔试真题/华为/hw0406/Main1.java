package com.liang.笔试真题.华为.hw0406;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int topN = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<String[]> headers = new ArrayList<>();
        ArrayList<String[]> text = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] t1 = sc.nextLine().split(" ");
            headers.add(t1);
            String[] t2 = sc.nextLine().split(" ");
            text.add(t2);
        }
        HashMap<String, int[]> recordMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < headers.get(i).length; j++) {
                String s = headers.get(i)[j];
                if (!recordMap.containsKey(s)){
                    recordMap.put(s, new int[6]);
                }
                int[] info = recordMap.get(s);
                info[1] = info[1]+1;
                info[3] = Math.max(info[3], Integer.MIN_VALUE-j);
            }

            for (int j = 0; j < text.get(i).length; j++) {   //复制上段 改text
                String s = text.get(i)[j];  //改text
                if (!recordMap.containsKey(s)){
                    recordMap.put(s, new int[6]);
                }
                int[] info = recordMap.get(s);
                info[2] = info[2]+1;       //改2 2
                info[4] = Math.max(info[4], Integer.MIN_VALUE-j);//改 4 4
            }
        }
        int n = recordMap.size();
        int[][] records = new int[n][6];
        String[] keys = recordMap.keySet().toArray(new String[0]);
        for (int i = 0; i < n; i++) {
            String s = keys[i];
            records[i] = recordMap.get(s);
            records[i][0] = records[i][1]*3+records[i][2];
            records[i][5] = i;
        }
        Arrays.sort(records, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < 6; i++) {
                    if (o1[i]-o2[i]!=0){
                        return o2[i]-o1[i];
                    }
                }
                return 0;
            }
        });
        for (int i = 0; i < topN; i++) {
            System.out.print(keys[records[i][5]]+" ");
//            System.out.println(Arrays.toString(records[i]));
        }
    }
}
