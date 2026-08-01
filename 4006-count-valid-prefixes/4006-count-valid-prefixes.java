class Solution {
    public int countValidPrefixes(String s) {
        int len = s.length();
        int cntZeros = 0;
        int cntOnes = 0;
        int ans = 0;

        for(int i = 0;i < len;i++) {
            
            if (s.charAt(i) == '0') cntZeros++;
            else cntOnes++;

            if(Math.abs(cntZeros-cntOnes) < 2) ans++;
        }

        return ans;
    }
}