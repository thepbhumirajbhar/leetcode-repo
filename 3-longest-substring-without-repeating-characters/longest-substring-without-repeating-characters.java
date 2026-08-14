class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(indexMap.containsKey(ch)){
                left = Math.max(left, indexMap.get(ch) + 1);
            }
            indexMap.put(ch,i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}