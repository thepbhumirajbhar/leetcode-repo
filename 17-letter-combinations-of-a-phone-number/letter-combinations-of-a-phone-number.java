class Solution{
    public List<String> letterCombinations(String digits){
        LinkedList<String> result = new LinkedList<>();

        if(digits == null || digits.length() == 0) return result;

        String[] map = {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};

        result.add("");

        for(int i = 0; i < digits.length(); i++){
            int digit = digits.charAt(i) - '0';
            String letters = map[digit];

            while(result.peek().length() == i){
                String removed = result.remove();

                for(char c: letters.toCharArray()){
                    result.add(removed + c);
                }
            }
        }
        return result;
    }
}



// class Solution {
//     public List<String> letterCombinations(String digits) {
//         // main function - call backtrack from here

//         List<String> result = new ArrayList<>();
//         if (digits.isEmpty())
//             return result;

//         String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
//         backtrack(digits, 0, new StringBuilder(), result, map);
//         return result;
//     }

//     // helper function - does the actual work
//     void backtrack(String digits, int index, StringBuilder current, List<String> result, String[] map) {

//         // String digits → the input like "23"
//         // int index → which digit are we processing right now? starts at 0
//         // StringBuilder current → combination built so far, like "a" or "ad"
//         // List<String> result → where we store complete combinations
//         // String[] map → the digit to letters mapping

//         if (current.length() == digits.length()) {
//             result.add(current.toString());
//             return;
//         }

//         String letters = map[digits.charAt(index) - '0'];
//         for (int i = 0; i < letters.length(); i++) {
//             current.append(letters.charAt(i)); // add
//             backtrack(digits, index + 1, current, result, map); // recurse
//             current.deleteCharAt(current.length() - 1); // backtrack
//         }

//     }
// }