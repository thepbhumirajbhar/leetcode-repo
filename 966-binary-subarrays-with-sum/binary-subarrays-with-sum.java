class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int n = nums.length;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();

        int prefixSum = 0;
        int count = 0;

        // BaseCase : prefix sum 0 has occurred once
        prefixSumCount.put(0,1);

        // Traverse through array
        for(int i = 0; i < n; i++){
            prefixSum += nums[i];

            // Calculate the prefix sum that needs to be removed
            int toBeRemoved = prefixSum - goal;


            // If this prefix sum has been seen before,
            // add its count to the result
            if(prefixSumCount.containsKey(toBeRemoved)){
                count += prefixSumCount.get(toBeRemoved);
            }

            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) +1);

        }
        return count;
    }
}