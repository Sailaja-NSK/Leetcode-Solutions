class Solution {
    public int gcd(int a,int b) {
        while(b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num:nums) {
            max = Math.max(max,num);
            min = Math.min(min,num);
        }

        return gcd(max,min);
    }
}