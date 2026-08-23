class Solution {
    public String removeDuplicates(String s) {
    // METHOD 2: more optimisation
       StringBuilder sb = new StringBuilder();

       for(int i = 0; i < s.length(); i++){
            int len = sb.length();
            if(len > 0 && sb.charAt(len-1) == s.charAt(i)){
                sb.deleteCharAt(len-1);
            }
            else{
                sb.append(s.charAt(i));
            }
       }
       return sb.toString();

        // Stack<Character> st = new Stack<>();
        // for(int i = 0; i < s.length(); i++){
        //     if(!st.isEmpty() && s.charAt(i) == st.peek()) {
        //         st.pop();
        //     }
        //     else{
        //         st.push(s.charAt(i));
        //     }
        // }
        // StringBuilder sb = new StringBuilder();
        // while(!st.isEmpty()) {
        //     sb.append(st.pop());
        // }

        // return sb.reverse().toString();
    }
}