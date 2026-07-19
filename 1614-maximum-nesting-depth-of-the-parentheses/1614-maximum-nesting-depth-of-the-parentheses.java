class Solution {
    public int maxDepth(String s) {
        int level = 0;
        int max = 0;
        for(char ch:s.toCharArray()) {
            if(ch == '(') {
                level++;
                max = Math.max(max,level);
            } else if(ch == ')') {
                level --;
            }
        }
        return max;
    }
}