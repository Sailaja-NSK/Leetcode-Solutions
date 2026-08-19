class Solution {
    public int firstPos(int[] nums,int target) {
        int first = -1;
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(nums[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return first;
    }

    public int secondPos(int[] nums,int target) {
        int last = -1;
        int low = 0;
        int high = nums.length-1;
        while(low <= high) {
            int mid = (low+high)/2;
            if(nums[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = firstPos(nums,target);
        res[1] = secondPos(nums,target);
        
        return res;
    }
}