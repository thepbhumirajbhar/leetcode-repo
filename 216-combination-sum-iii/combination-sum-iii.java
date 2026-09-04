class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(k, n, new ArrayList<>(), result, 1);
        return result;
    }

    private void helper(int k, int n, List<Integer> current, List<List<Integer>> result, int index){

        // Base Case
        if(current.size() == k){
            if(n == 0){
                result.add(new ArrayList<>(current));
                return;
            }
        }

        for(int i = index; i <= 9; i++){
            // Pruning: if the current number is greater than the remaining sum
            if(i > n){
                break;
            }
            current.add(i);
            helper(k, n-i, current, result,i+1);
            current.remove(current.size()-1);    // Backtrack
        }
    }
}