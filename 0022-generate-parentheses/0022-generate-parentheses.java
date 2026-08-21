class Solution {
    public void generate(int n,List<String> ans,String temp,int open,int close) {
        if(temp.length() == 2*n) {
            ans.add(temp);
            return;
        }

        if(open < n) {
            generate(n,ans,temp+"(",open+1,close);
        }

        if(close < open) {
            generate(n,ans,temp+")",open,close+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String temp = "";
        generate(n,ans,temp,0,0);
        return ans;
    }
}