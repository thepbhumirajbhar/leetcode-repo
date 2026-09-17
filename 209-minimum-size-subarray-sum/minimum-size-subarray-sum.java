class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];  // expand
            while(sum >= target){
                minLen = Math.min(minLen, right - left + 1);  // update
                sum -= nums[left++];  // shrink
            }
        }        
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}