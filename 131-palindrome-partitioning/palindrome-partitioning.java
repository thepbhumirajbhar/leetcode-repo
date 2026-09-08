class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(s, 0, current, result);
        return result;
    }

    private void backtrack(String s, int startIndex, List<String> current, List<List<String>> result){

        // Base Case
        if(startIndex == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = startIndex; i < s.length(); i++){
            // check if s[startInedx...i] is a palindrome
            if(isPalindrome(s, startIndex, i)){
                // pick the substring
                current.add(s.substring(startIndex, i+1));

                // recurse of the remaining part of the string
                backtrack(s, i+1, current, result);

                // backtrack to try other cuts
                current.remove(current.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}