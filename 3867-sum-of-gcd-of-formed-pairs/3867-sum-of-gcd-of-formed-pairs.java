class Solution {
    public long gcd(long a, long b) {
        while(b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        long[] mx = new long[n];
        mx[0] = nums[0];
        for(int i = 1;i < n;i++) {
            mx[i] = Math.max(mx[i-1],nums[i]);
        }

        long[] prefixGCD = new long[n];
        for(int i = 0;i < n;i++) {
            prefixGCD[i] = gcd(nums[i],mx[i]);
        }

        Arrays.sort(prefixGCD);
        int i = 0;
        int j = n-1;
        long sum = 0;
        while(i < j) {
            sum += gcd(prefixGCD[i],prefixGCD[j]);
            i++;
            j--;
        }

        return sum;
    }
}