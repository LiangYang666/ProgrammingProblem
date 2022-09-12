package com.liang.leetcode.周赛;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Sep04_309_2402会议室III {
    public int mostBooked(int n, int[][] meetings) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        };
        int[][] rooms = new int[n][3];
        PriorityQueue<int[]> roomQ = new PriorityQueue<>(comparator);
        for (int i = 0; i < n; i++) {
            rooms[i][1] = i;
            roomQ.add(rooms[i]);
        }
        Arrays.sort(meetings, comparator);
        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            int[] room = null;
            for (int j = 0; j < n; j++) {
                if (rooms[j][0]<=meeting[0]){
                    roomQ.remove(rooms[j]);
                    room=rooms[j];
                    break;
                }
            }
            if (room==null){
                room = roomQ.poll();
            }
            room[0] = Math.max(meeting[1], meeting[1]-meeting[0]+room[0]);
            room[2]++;
            roomQ.add(room);
        }
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (rooms[i][2]>max){
                max = rooms[i][2];
                maxIndex = rooms[i][1];
            }
        }
        return maxIndex;
    }
}
