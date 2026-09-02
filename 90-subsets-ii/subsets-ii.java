class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current, int index){

        // Base Case
        result.add(new ArrayList<>(current));


        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i-1]) continue;  // skip duplicates
            current.add(nums[i]);
            helper(nums, result, current, i+1);
            current.remove(current.size()-1);
        }
    }
}