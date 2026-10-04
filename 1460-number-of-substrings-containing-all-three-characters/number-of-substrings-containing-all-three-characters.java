class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int left = 0;
        int totalCount = 0;
        int[] count = new int[3];  // to track frequency of a,b,c
        for(int right = 0; right < n; right++){
            count[s.charAt(right) - 'a']++;

            // while the window is valid, count and shrink from left
            while(count[0] > 0 && count[1] > 0 && count[2] > 0){
                totalCount += (n - right);
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return totalCount;
    }
}