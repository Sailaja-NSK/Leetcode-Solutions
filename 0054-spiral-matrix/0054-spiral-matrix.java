class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();

        int top = 0,bottom = n-1;
        int left = 0,right = m-1;

        while(left <= right && top <= bottom) {
            
            for(int i = left;i <= right;i++) {
                ans.add(matrix[top][i]);
            }
            top += 1;

            for(int i = top;i <= bottom;i++) {
                ans.add(matrix[i][right]);
            }
            right -= 1;

            if(top <= bottom) {
                for(int i = right;i >= left;i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom -= 1;
            }
            

            if(left <= right) {
                for(int i = bottom;i >= top;i--) {
                    ans.add(matrix[i][left]);
                }
                left += 1;
            }
            
            
        }

        return ans;
    }
}