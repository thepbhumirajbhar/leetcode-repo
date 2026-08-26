class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), result);
        return result;
    }

    // start ensures you only look forward, never backward. That's what prevents duplicates

    private void helper(int start, int[] nums, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));

        for(int i = start; i<nums.length; i++){
            current.add(nums[i]);                   // include nums[i]
            helper(i+1, nums, current, result);     // explore
            current.remove(current.size()-1);       // exclude (backtrack!)
        }
    }
}