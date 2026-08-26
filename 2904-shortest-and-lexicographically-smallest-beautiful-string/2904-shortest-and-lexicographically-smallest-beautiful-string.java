class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();
        ArrayList<String> list = new ArrayList<>();
        
        for(int i = 0;i < n;i++) {
            String substrings = "";
            int cnt = 0;
            for(int j = i;j < n;j++) {
                if(s.charAt(j) == '1') cnt++;
                substrings = substrings + s.charAt(j);
                if(cnt == k) {
                    list.add(substrings);
                }
            }
        }
        if(list.isEmpty()) return "";
        Collections.sort(list,(a,b)->{
            if(a.length() != b.length()) return a.length() - b.length();
            return a.compareTo(b);
        });
        return list.get(0);
    }
}