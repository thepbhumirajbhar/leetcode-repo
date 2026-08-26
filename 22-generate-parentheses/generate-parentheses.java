class Solution {
    public List<String> generateParenthesis(int n){
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void helper(List<String> result, StringBuilder current,int open, int close, int n){
        //base case
        if(current.length() == 2*n){
            result.add(current.toString());
            return;
        }

        if(open < n){
            current.append('(');
            helper(result, current, open+1, close, n);
            current.deleteCharAt(current.length()-1);
        }

        if(close < open){
            current.append(')');
            helper(result, current, open, close+1, n);
            current.deleteCharAt(current.length()-1);
        }
    }





    // public List<String> generateParenthesis(int n) {
    //     List<String> result = new ArrayList<>();
    //     helper(n,0,0,"",result);
    //     return result;
    // }

    // private void helper(int n, int open, int close, String current, List<String> result){
    //     // base case
    //     if(open == n && close == n) {
    //         result.add(current);
    //         return;
    //     }
    //     if(open < n) {
    //         helper(n, open+1, close, current + "(", result);
    //     }
    //     if(close < open){
    //         helper(n, open, close+1, current + ")", result);
    //     }
    // }
}