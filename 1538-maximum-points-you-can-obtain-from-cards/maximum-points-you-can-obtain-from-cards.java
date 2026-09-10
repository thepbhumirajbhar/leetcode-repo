class Solution {
    public int maxScore(int[] cardPoints, int k) {

        // Optimal
        int n = cardPoints.length;

        int total = 0;
        for (int i = 0; i < k; i++) {
            total += cardPoints[i];
        }
        int maxPoints = total;

        // Slide the window: remove from front and add from back
        for (int i = 0; i < k; i++) {
            // Subtract card from front
            total -= cardPoints[k - 1 - i];

            // Add card from back
            total += cardPoints[n - 1 - i];

            // Update the max score
            maxPoints = Math.max(maxPoints, total);
        }
        return maxPoints;




        // int n = cardPoints.length;
        // int maxSum = 0;

        // for(int i = 0; i <= k; i++){
        //     int tempSum = 0;

        //     for (int j = 0; j < i; j++) {
        //         tempSum += cardPoints[j];
        //     }

        //     for (int j = 0; j < k - i; j++) {
        //         tempSum += cardPoints[n - 1 - j];
        //     }

        //     maxSum = Math.max(maxSum, tempSum);
        // }
        // return maxSum;
    }
}