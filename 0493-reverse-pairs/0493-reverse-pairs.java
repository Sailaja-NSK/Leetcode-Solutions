class Solution {
    void merge(int[] nums,int low,int mid,int high) {
        List<Integer> ans = new ArrayList<>();
        int left = low;
        int right = mid+1;

        while(left <= mid && right <= high) {
            if(nums[left] <= nums[right]) {
                ans.add(nums[left]);
                left++;
            } else {
                ans.add(nums[right]);
                right++;
            }
        }

        while(left <= mid) {
            ans.add(nums[left]);
            left++;
        }

        while(right <= high) {
            ans.add(nums[right]);
            right++;
        }

        for(int i = low;i <= high;i++) {
            nums[i] = ans.get(i-low);
        }

    }

    public static int countPairs(int[] arr,int low,int mid,int high) {
        int cnt = 0;
        int right = mid+1;
        for(int i = low ;i <= mid;i++) {
            while(right <= high && (long)arr[i] > (long)2 * arr[right]) {
                right++;
            }
            cnt += (right - (mid+1));
        }
        return cnt;
    }
    int mergeSort(int[] nums,int low,int high) {
        int cnt = 0;
        if(low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(nums,low,mid);
        cnt += mergeSort(nums,mid+1,high);
        cnt += countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return cnt;
    }
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int low = 0,high = n-1;
        return mergeSort(nums,low,high);
    }
}