class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        int x = 0;
        while(n != 0) {
            int digit = n % 10;
            if(digit != 0) {
                sum = sum + digit;
                x = x * 10 + digit;
            }
            n = n / 10;
        }

        long rev_x = 0;
        while(x != 0) {
            int temp = x % 10;
            rev_x = rev_x * 10 + (long)temp;
            x = x / 10;
        }

        return (long)(rev_x * sum);
    }
}