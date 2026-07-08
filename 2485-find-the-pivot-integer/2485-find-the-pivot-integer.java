class Solution {
    public int pivotInteger(int n) {
        int totalsum =  ( n * (n + 1) ) / 2;

        int[] leftsum = new int[n+1];
        for(int i = 1;i <= n;i++) {
            leftsum[i] = leftsum[i-1] + i;

            int rightsum = totalsum - leftsum[i] + i;

            if(leftsum[i] == rightsum) {
                return i;
            }
        }
        return -1;      
    }
}