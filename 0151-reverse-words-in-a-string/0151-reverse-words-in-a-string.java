class Solution {
    public String reverseWords(String s) {
        s = s.trim();

        Stack<String> st = new Stack<>();
        String word = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                word += ch;
            } else {
                if (!word.isEmpty()) {
                    st.push(word);
                    word = "";
                }
            }
        }

        // Push last word
        if (!word.isEmpty()) {
            st.push(word);
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());

            if (!st.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}