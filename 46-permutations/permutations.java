class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, new ArrayList<>(nums.length), result);
        return result;
    }

    private void helper(int[] nums, List<Integer> current, List<List<Integer>> result){

        // Base Case
        if(current.size() == nums.length ){
            result.add(new ArrayList<Integer> (current));
            return;
        }

        // Recurse case
        for(int i = 0; i < nums.length; i++){
            if(current.contains(nums[i])) continue;
            current.add(nums[i]);
            helper(nums, current, result);
            current.remove(current.size()-1);
        }
    }
}