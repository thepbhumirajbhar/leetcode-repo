class Solution {
    // APPROACH 2

    public List<String> letterCasePermutation(String s){
        List<String> result = new ArrayList<>();
        helper(s.toCharArray(), 0, result);
        return result;
    }

    private void helper(char[] chars, int index, List<String> result){

        // BASE CASE
        if(index == chars.length){
            result.add(new String(chars));
            return;
        }

        if(Character.isDigit(chars[index])){
            helper(chars, index+1, result);
        }
        else{
            // try lowercase
            chars[index] = Character.toLowerCase(chars[index]);
            helper(chars, index+1, result);

            // try uppercase
            chars[index] = Character.toUpperCase(chars[index]);
            helper(chars, index+1, result);
        }
    }




    // public List<String> letterCasePermutation(String s) {
    //     List<String> result = new ArrayList<>();
    //     helper(s, result,"", 0);
    //     return result;
    // }

    // private void helper(String s, List<String> result, String current, int index){

    //     // Base Case
    //     if(index == s.length()){
    //         result.add(current);
    //         return;
    //     }

       
    //     char ch = s.charAt(index);
    //     if(Character.isDigit(ch)){
    //         helper(s, result, current+ch, index+1);
    //     }

    //     else{
    //         helper(s, result, current + Character.toUpperCase(ch), index+1);
    //         helper(s, result, current + Character.toLowerCase(ch), index+1);
    //     }
    // }    
}