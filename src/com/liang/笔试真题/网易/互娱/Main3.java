package com.liang.笔试真题.网易.互娱;

import java.util.*;

public class Main3 {
    static HashMap<String, Integer> edgeNumber = new HashMap<>();
    static  int allNumber = 0;
    static HashSet<String> edgesExit;

    static ArrayList<int[]> points;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            edgesExit = new HashSet<>();
            edgeNumber = new HashMap<>();
            allNumber = 0;
            boolean[][] canTrack = new boolean[3][3];
            points = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                String next = sc.next();
                for (int k = 0; k < 3; k++) {
                    if (next.charAt(k)=='.'){
                        canTrack[j][k] = true;
                        points.add(new int[]{k, j});
                    }
                }
            }
            boolean[][] visit = new boolean[3][3];
            for (int j = 0; j < points.size(); j++) {
                dfs(points.get(j)[0], points.get(j)[1], visit, new ArrayList<>());
            }
//            for (int[] point : points) {
//                System.out.println(Arrays.toString(point));
//            }
//            System.out.println("all n "+allNumber);
//            System.out.println("edgeNumber map "+edgeNumber);
            System.out.println(edgesExit.size());
            System.out.println(edgesExit);
        }
    }
    static
    void dfs(int x, int y, boolean[][] visit, ArrayList<Integer> have){
        visit[x][y] = true;
        for (int i = 0; i < points.size() ; i++) {
            int xt = points.get(i)[0];
            int yt = points.get(i)[1];
            if (xt==x && y==yt) continue;
            ArrayList<Integer> allBian = getAllBian(x, y, xt, yt);
            if (visit[xt][yt]){
                HashSet<Integer> sets = new HashSet<>(have);
//                sets.addAll(allBian);
                Integer[] integers = sets.toArray(new Integer[0]);
                int[] ints = new int[integers.length];
                for (int j = 0; j < integers.length; j++) {
                    ints[j] = integers[j];
                }
                Arrays.sort(ints);
//                System.out.println(Arrays.toString(ints));
                edgesExit.add(Arrays.toString(ints));
            } else {
                have.addAll(allBian);
                dfs(xt, yt, visit, have);
                for (int j = 0; j < allBian.size(); j++) {
                    have.remove(have.size()-1);
                }
            }
        }
        visit[x][y] = false;
    }
    static ArrayList<Integer> getAllBian(int x0, int y0, int x1, int y1){
        ArrayList<Integer> rs = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        if (Math.abs(x0-x1)==1 || Math.abs(y0-y1)==1){
            strings.add(getBianString(x0, y0, x1, y1));
        } else {
            int xm = Math.abs(x0+x1)/2;
            int ym = Math.abs(y0+y1)/2;
            strings.add(getBianString(x0, y0, xm, ym));
            strings.add(getBianString(x1, y1, xm, ym));
        }
        for (String string : strings) {
            if (!edgeNumber.containsKey(string)){
                edgeNumber.put(string, allNumber++);
            }
            rs.add(edgeNumber.get(string));
        }
        return rs;
    }
    static String getBianString(int x0, int y0, int x1, int y1){
        int[][] temp = {{x0, y0}, {x1, y1}};
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        return Arrays.deepToString(temp);
    }
}


/*
3
...
XXX
XXX
...
XXX
X.X
.X.
X.X
.X.
 */

/*
3
22
111
 */
