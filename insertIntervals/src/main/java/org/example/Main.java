package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        insert(new int[][]{
                {2,3},
                {4,5},
                {6,7},
        }, new int[]{0, 1});
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{
                    newInterval
            };
        }

        int start = newInterval[0];
        int end = newInterval[1];

        boolean startInArray = false;
        boolean endInArray = false;

        int[] startInterval = new int[2];
        int[] endInterval = new int[2];

        int startIndex = -2;
        int endIndex = -2;

        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0]<=start && start<=intervals[i][1]) {
                startInterval = intervals[i];
                startIndex=i;
                startInArray = true;
                break;
            } else if (start<intervals[i][0]) {
                startIndex = i-1;
                break;
            }
        }

        for(int i=0; i<intervals.length; i++) {
            if(intervals[i][0]<=end && end<=intervals[i][1]) {
                endInterval = intervals[i];
                endIndex=i;
                endInArray = true;
                break;
            } else if (intervals[i][1]<end) {
                endIndex = i+1;
                break;
            }
        }

        if(startInArray && !endInArray) {
            startInterval[1] = Math.max(startInterval[1], end);
            return intervals;
        }

        if(startInArray) {
            int[][] ans = new int[startIndex+intervals.length-endIndex][2];
            for(int i=0; i<startIndex; i++) {
                ans[i] = intervals[i];
            }

            ans[startIndex][0] = Math.min(startInterval[0], start);
            ans[startIndex][1] = Math.max(endInterval[1], end);

            int j=endIndex;

            for(int i=startIndex+1; i<ans.length ; i++) {
                ans[i] = intervals[++j];
            }

            return ans;
        }

        if(!endInArray) {
            int[][]  ans = new int[intervals.length+1][2];
            if(endIndex == intervals.length && startIndex == -2) {
                for(int i=0;i< intervals.length; i++) {
                    ans[i] = intervals[i];
                }
                ans[intervals.length] = newInterval;
                return ans;
            }

            if(endIndex==-2 && startIndex==-1) {
                ans[0] = newInterval;
                for(int i=1; i<ans.length; i++){
                    ans[i] = intervals[i-1];
                }
                return ans;
            }

//            int[][] ans2 = new int[][2];

        }



        return intervals;
    }
}