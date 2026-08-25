class Solution {
    public void reverseString(char[] s) {
        // RECURISON
        
        helper(s,0,s.length-1);



        // int start=0;
        // int end=s.length-1;
        // while(start<=end){
        //     char temp=s[start];
        //     s[start]=s[end];
        //     s[end]=temp;
        //     start++;
        //     end--;
        // }
    }

    private void helper(char[] s, int left,int right){
        if( left >= right) return;
      char temp=s[left];
      s[left]=s[right];
      s[right]=temp;
      helper(s, left+1, right-1);

    }
}