class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int m = 0;
        for(int num:nums) {
            m = Math.max(num,m);
        }

        int u = 1;
        while(u <= m) {
            u <<= 1;
        }

        boolean[] one = new boolean[u];
        boolean[] two = new boolean[u];
        boolean[] three = new boolean[u];

        for(int num:nums) {
            one[num] = true;
            for(int i = 0;i < u;i++) {
                if(one[i]) {
                    two[i ^ num] = true;
                }
            }
        }

        for(int num:nums) {
            for(int i = 0;i < u;i++) {
                if(two[i]) {
                    three[i ^ num] = true;
                }
            }
        }

        int ans = 0;
        for(boolean b : three) {
            if(b) {
                ans++;
            }
        }
        return ans;
    }
}