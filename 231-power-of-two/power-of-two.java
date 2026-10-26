class Solution {

    public boolean isPowerOfTwo(int n){
        if(n <= 0) return false;

        while(n % 2 == 0){
            n /= 2;
        }

        return n == 1;
    }
    // public boolean isPowerOfTwo(int n) {
    //     // edge case (if the num is negative)
    //     if(n <= 0){
    //         return false;
    //     }
    //     return helper(n);
    // }

    // private boolean helper(int n){
    //     // Base case 1
    //     if(n==1) return true;

    //     // Base case 2
    //     if(n%2 == 1) return false;
        

    //     // Recursive Step: Number ko 2 se divide karke aage bhej do
    //     return helper(n/2);
    // }
}