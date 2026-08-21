class Solution {
    public boolean isValid(String s) {
    // Method 2: 
       if(s.length() % 2 != 0) return false;
       
       // Since valid matching requires pairs, a valid string can never have more than s.length() / 2 opening brackets.
       char[] stack  = new char[s.length()/2];
       int head = 0;

       for(int i = 0; i< s.length(); i++){
        char ch = s.charAt(i);
        if(ch == '('){
            if(head == stack.length) return false;
            stack[head++] = ')';
        }
        else if(ch == '{'){
            if(head == stack.length) return false;
            stack[head++] = '}';
        }
        else if(ch == '['){
            if(head == stack.length) return false;
            stack[head++] = ']';
        }
        else if(head == 0 || stack[--head] != ch){
            return false;
        }
       }  
    return head == 0; 






    // Method 1:     
        // Stack<Character> st = new Stack<>();
        // for(int i = 0; i<s.length(); i++){
        //     char ch = s.charAt(i);
        //     if (ch == '(' || ch == '[' || ch == '{') st.push(ch);

        //     else if(ch == ')') {
        //         if(st.isEmpty() || st.peek() != '(') return false;
        //         else st.pop();
        //     }
        //     else if(ch == ']') {
        //         if(st.isEmpty() || st.peek() != '[') return false;
        //         else st.pop();
        //     }
        //     else if(ch == '}') {
        //         if(st.isEmpty() || st.peek() != '{') return false;
        //         else st.pop();
        //     }
        // }
        // return st.isEmpty();
    }
}