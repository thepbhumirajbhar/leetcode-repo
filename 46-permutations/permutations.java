class Solution {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, result);
        return result;
    }

    private void helper(int[] nums, int index, List<List<Integer>> result){

        // Base case
        if(index == nums.length){
            List<Integer> current = new ArrayList<>();
            for(int num: nums) current.add(num);
            result.add(current);
            return;
        }


        for(int i = index; i < nums.length; i++){
            swap(nums, i , index);
            helper(nums, index+1,result);
            swap(nums, i, index);     // backtrack
        }
    }

     private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }








// Method 2    
    // public List<List<Integer>> permute(int[] nums){
    //     List<List<Integer>> result = new ArrayList<>();
    //     helper(nums, new boolean[nums.length], new ArrayList<>(nums.length), result);
    //     return result;
    // }

    // private void helper(int[] nums, boolean[] visited, List<Integer> current, List<List<Integer>> result){

    //     // Base Case
    //     if(current.size() == nums.length){
    //         result.add(new ArrayList<>(current));
    //         return;
    //     }

    //     // Recurse Case
    //     for(int i = 0; i< nums.length; i++){
    //         if (visited[i]) continue;

    //         visited[i] = true;
    //         current.add(nums[i]);

    //         helper(nums, visited, current, result);

    //         // Backtrack
    //         current.remove(current.size()-1);
    //         visited[i] = false;
    //     }
    // }


// Method 1
    // public List<List<Integer>> permute(int[] nums) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     helper(nums, new ArrayList<>(nums.length), result);
    //     return result;
    // }

    // private void helper(int[] nums, List<Integer> current, List<List<Integer>> result){

    //     // Base Case
    //     if(current.size() == nums.length ){
    //         result.add(new ArrayList<Integer> (current));
    //         return;
    //     }

    //     // Recurse case
    //     for(int i = 0; i < nums.length; i++){
    //         if(current.contains(nums[i])) continue;
    //         current.add(nums[i]);
    //         helper(nums, current, result);
    //         current.remove(current.size()-1);
    //     }
    // }
}