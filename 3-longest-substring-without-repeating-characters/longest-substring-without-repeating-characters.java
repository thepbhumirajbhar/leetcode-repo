class Solution {
    public int lengthOfLongestSubstring(String s) {
    // APPROACH 2
        int[] lastIndex = new int[128];

        for(int i = 0; i < 128; i++){
            lastIndex[i] = -1;
        }

        int maxLen = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);

            if(lastIndex[ch] >= left){
                left = lastIndex[ch] + 1;
            }
            lastIndex[ch] = right;

            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;


    // APPROACH 1    
        // Map<Character, Integer> indexMap = new HashMap<>();
        // int maxLen = 0;
        // int left = 0;
        // for(int i = 0; i < s.length(); i++){
        //     char ch = s.charAt(i);
        //     if(indexMap.containsKey(ch)){
        //         left = Math.max(left, indexMap.get(ch) + 1);
        //     }
        //     indexMap.put(ch,i);
        //     maxLen = Math.max(maxLen, i - left + 1);
        // }
        // return maxLen;
    }
}