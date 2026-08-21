class Solution {
    public void solve(int index,String digits,String current,String[] arr,List<String> ans) {
        if(index == digits.length()) {
            ans.add(current);
            return;
        }

        String s = arr[digits.charAt(index)-'0'];

        for(int i = 0;i < s.length();i++) {
            solve(index+1,digits,current+s.charAt(i),arr,ans);
        }
    }
    public List<String> letterCombinations(String digits) {
        String[] arr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<>();
        String current = "";
        solve(0,digits,current,arr,ans);
        return ans;
    }
}