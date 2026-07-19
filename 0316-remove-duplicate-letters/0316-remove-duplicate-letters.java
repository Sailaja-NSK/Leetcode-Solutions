class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for(int i = 0;i < s.length();i++) {
            freq[s.charAt(i)-'a']++;
        }
        boolean[] visited = new boolean[26];

        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < s.length();i++) {
            char ch = s.charAt(i);
            if(!visited[ch-'a']) {
                while(sb.length() > 0 && sb.charAt(sb.length()-1) > ch) {
                    if(freq[sb.charAt(sb.length()-1) - 'a'] > 0) {
                        visited[sb.charAt(sb.length()-1) - 'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                    } else {
                        break;
                    }
                }
                visited[ch-'a'] = true;
                sb.append(ch);
            }
            freq[ch-'a'] -= 1;

        }

        return sb.toString();
    }
}