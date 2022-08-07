package com.liang.笔试真题.科大讯飞;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(";");
//        ArrayList<ArrayList<String>> hashSets = new ArrayList<>();
        ArrayList<Object[]> objects = new ArrayList<>();

        HashSet<String> haveGet = new HashSet<>();
        ArrayList<String[]> data = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            String[] tempSplit = split[i].split("\\|");
            data.add(tempSplit);
        }
        data.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (!o1[1].equals(o2[1])){
                    return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
                }
                return o2.length- o1.length;
            }
        });
//        for (int i = 0; i < data.size(); i++) {
//            System.out.println(Arrays.toString(data.get(i)));
//        }
        long rs = 0;
        while (true){
            int avgMinIndex = -1;
            double avgMin = Double.MAX_VALUE;
            for (int i = 0; i < data.size(); i++) {
                String[] temp = data.get(i);
                int tempTotal = 0;
                for (int j = 2; j < temp.length; j++) {
                    if (!haveGet.contains(temp[j])){
                        tempTotal ++;
                    }
                }
                if (tempTotal!=0){
                    double avg = (Integer.parseInt(temp[1]))*1.0/tempTotal;
                    if (avg<avgMin){
                        avgMin = avg;
                        avgMinIndex = i;
                    }
                }
            }
            if (avgMinIndex==-1)   break;
            String[] get = data.remove(avgMinIndex);
            for (int i = 0; i < get.length; i++) {
                haveGet.add(get[i]);
            }
            rs += Integer.parseInt(get[1]);
        }
        System.out.println(rs);
    }
}
