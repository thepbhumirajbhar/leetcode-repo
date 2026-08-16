class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        int[] need = new int[128];       // frequency of each char needed from t
        int required = 0;               // total unique chars in t that need to be satisfied

        for( int i = 0; i < n; i++){
            need[t.charAt(i)]++;
            if(need[t.charAt(i)] == 1) required++;
        }

        int[] have = new int[128];        // frequency of each char in current window
        int formed = 0;                  // how many unique chars from t are fully satisfied
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        for(int right = 0; right < m; right++){
            char ch = s.charAt(right);
            have[ch]++;
            if(have[ch] == need[ch]) formed++;
            while(formed == required){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    ansLeft = left;
                    ansRight = right;
                }  
                char leftChar = s.charAt(left);
                have[leftChar]--;              
                if(have[leftChar] < need[leftChar]) formed--;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(ansLeft, ansRight + 1);
    }
}