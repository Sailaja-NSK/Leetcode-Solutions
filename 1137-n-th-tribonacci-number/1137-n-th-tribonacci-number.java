class Solution {
    public int f(int n, int[] dp_arr) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        if(dp_arr[n] != -1) return dp_arr[n];
        return dp_arr[n] = f(n-1,dp_arr) + f(n-2,dp_arr) + f(n-3,dp_arr);
    }
    public int tribonacci(int n) {
        int[] dp_arr = new int[n+1];
        Arrays.fill(dp_arr,-1);
        return f(n,dp_arr);
        
    }
}