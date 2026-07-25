class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int endTime = intervals[0][1];
        int cnt = 0;
        for(int[] interval:intervals) {
            if(interval[0] >= endTime) {
                cnt++;
                endTime = interval[1];
            }
        }

        return intervals.length - cnt-1;
    }
}