class Solution {
    public String reverseWords(String s) {
// APPROACH 2:
        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        while(i >= 0){
            while( i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            if(i < 0) break;
        

        int j = i;
        while( i >= 0 && s.charAt(i) != ' '){
            i--;
        }

        if(sb.length() > 0){
            sb.append(" ");
        }

        sb.append(s.substring(i+1,j+1));
        }

        return sb.toString();
         



// APPROACH 1: 
        // String[] words = s.trim().split("\\s+");
        // Collections.reverse(Arrays.asList(words));
        // return String.join(" ", words);
    }
}