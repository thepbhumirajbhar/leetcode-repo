class Solution {
    public String minRemoveToMakeValid(String s) {
    // METHOD 2: (more optimised)
    char[] arr = s.toCharArray();
    int open = 0;

    // Pass 1: Remove invalid ')' from left to right
    for(int i = 0; i<arr.length; i++){
        if(arr[i] == '('){
            open++;
        }
        else if( arr[i] == ')'){
            if(open == 0) arr[i] = '*';
            else{
                open--;
            }
        }
    }

    // Pass 2: Remove excess '(' from right to left: after full string is processed, open > 0 means that many ( were never matched → remove them!
    for(int i = arr.length-1; i >= 0; i--){
        if(open > 0 && arr[i] == '('){
            arr[i] = '*';
            open--;
        }
    }

    // Pass 3: Build cleaned string
    StringBuilder sb = new StringBuilder();
    for(char c: arr){
        if(c != '*') sb.append(c);
    }

    return sb.toString();







    // METHOD 1: uses a stack to track open parentheses, marks all unmatched ( and ) with *, and then strips out those placeholders to produce a valid string.


        // StringBuilder sb = new StringBuilder(s);
        // Deque<Integer> stack = new ArrayDeque<>();

        // for(int i = 0; i<s.length(); i++){
        //     if(s.charAt(i) == '(') stack.push(i);
        //     else if(s.charAt(i) == ')'){
        //         if(!stack.isEmpty()) stack.pop();
        //         else{
        //             sb.setCharAt(i,'*');
        //         }
        //     }
        // }
        // while(!stack.isEmpty()){
        //     sb.setCharAt(stack.pop(), '*');
        // }
        // return sb.toString().replace("*","");
    }
}