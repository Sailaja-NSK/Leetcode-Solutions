class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        

        long max_product = Integer.MIN_VALUE;
        for(int i = 0;i < n;i++) {
            long product = 1;
            for(int j = i;j < n;j++) {
                product = product * nums[j];
                max_product = Math.max(product,max_product);
            }
        }

        return (int)max_product;
    }
}