class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0,ele1 = Integer.MIN_VALUE;
        int cnt2 = 0,ele2 = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++) {
            if(cnt1 == 0 && nums[i] != ele2) {
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && nums[i] != ele1) {
                cnt2 = 1;
                ele2 = nums[i];
            }else if(ele1 == nums[i]) {
                cnt1++;
            }else if(ele2 == nums[i]) {
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }

        int temp1 = 0,temp2 = 0;
        for(int i = 0;i < n;i++) {
            if(nums[i] == ele1) temp1++;
            if(nums[i] == ele2) temp2++;
        }

        if(temp1 > (n/3)) {
            ans.add(ele1);
        }
        if(temp2 > (n/3)) {
            ans.add(ele2);
        }

        
        return ans;
    }
}