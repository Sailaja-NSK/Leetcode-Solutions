class Solution {
    public void func(int index,String s,List<List<String>> ans,List<String> temp) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i= index;i < s.length();i++) {
            if(isPalindrome(index,i,s)) {
                temp.add(s.substring(index,i+1));
                func(i+1,s,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    public boolean isPalindrome(int start,int end,String s) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        func(0,s,ans,temp);
        return ans;
    }
}