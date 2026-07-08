class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();


        final long MOD = 1000000007L;

        int[] prefix_sum = new int[n+1];
        long[] prefix_concat = new long[n+1];
        int[] count = new int[n+1]; //count of non-zero digits
        long[] pow10 = new long[n+1];

        pow10[0] = 1;

        for(int i = 1; i < n+1;i++) {
            pow10[i] = ( pow10[i-1] * 10 ) % MOD;
        }


        for(int i = 1;i < n+1;i++) {
            int temp = s.charAt(i-1) - '0';
            prefix_sum[i] = prefix_sum[i-1] + temp;

            if(temp != 0) {
                prefix_concat[i] = ( prefix_concat[i-1] * 10 + temp ) % MOD;
                count[i] = count[i-1] + 1;
            } else {
                prefix_concat[i] = prefix_concat[i-1]; 
                count[i] = count[i-1];
            }
        }


        int[] ans = new int[queries.length];
        for(int i = 0;i < queries.length;i++) {
            int starting = queries[i][0];
            int ending = queries[i][1];
            long x = 0;
            long sum = 0;

            sum = prefix_sum[ending+1] - prefix_sum[starting];

            int digits = count[ending+1] - count[starting];
            x = (prefix_concat[ending+1] - (prefix_concat[starting] * pow10[digits]) % MOD + MOD) % MOD;

            int res = (int)(( x * sum ) % MOD ) ;
            ans[i] = res;
        }

        return ans;  
    }
}