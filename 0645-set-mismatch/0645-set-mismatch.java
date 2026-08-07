class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for(int i = 0;i < n;i++) {
            xor = xor ^ nums[i];
            xor = xor ^ (i+1);
        }

        int bitNo = 0;
        while(true) {
            if((xor & (1 << bitNo)) != 0) {
                break;
            }
            bitNo++;
        }

        int zero = 0;
        int one = 0;

        for(int i = 0;i < n;i++) {
            //part of one club;
            if((nums[i] & (1 << bitNo)) != 0 ) {
                one = one ^ nums[i];
            } else {
                zero = zero ^ nums[i];
            }
        }

        for(int i = 1;i <= n;i++) {
            //part of one club;
            if((i & (1 << bitNo)) != 0 ) {
                one = one ^ i;
            } else {
                zero = zero ^ i;
            }
        }

        int cnt = 0;
        for(int i = 0;i < n;i++) {
            if(nums[i] == zero) cnt++;
        }
        if(cnt == 2) return new int[]{zero,one};

        return new int[]{one,zero};
    }
}