class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, k, 1, result, new ArrayList<>());
        return result;
    }

    private void helper(int n, int k, int start, List<List<Integer>> result, List<Integer> current){

        // Base Case
        if(current.size() == k){
            result.add(new ArrayList<>(current));
            return;
        }

        // Recurse
        for(int i = start; i <= n - (k - current.size()) + 1; i++){
            current.add(i);
            helper(n, k, i+1, result, current);
            current.remove(current.size() - 1);
        }
    }
}