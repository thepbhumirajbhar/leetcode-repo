class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n) return "";

        int[] arr = new int[128];
        for(char c: t.toCharArray()){
            arr[c]++;
        }

        int count = n;       // Characters remaining to match
        int left = 0, minLen = Integer.MAX_VALUE, start = 0;

        for(int right = 0; right < m; right++){
            char rightChar = s.charAt(right);
            if(arr[rightChar] > 0){
                count--;
            }
            arr[rightChar]--;

            while(count == 0){
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }
            
            char leftChar = s.charAt(left);
            arr[leftChar]++;
            if (arr[leftChar] > 0) count++;
            left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}