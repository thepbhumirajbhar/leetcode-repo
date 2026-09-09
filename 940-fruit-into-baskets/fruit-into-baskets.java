class Solution {
    public int totalFruit(int[] fruits) {

        // BETTER 
        int start = 0, maxFruits = 0;
         Map<Integer, Integer> basket = new HashMap<>();
        
        for(int end = 0; end < fruits.length; end++){
           basket.put(fruits[end], basket.getOrDefault(fruits[end], 0) +1);

           while(basket.size() > 2){
            int leftFruit = fruits[start];
            basket.put(leftFruit, basket.get(leftFruit) - 1);

            if(basket.get(leftFruit) == 0) basket.remove(leftFruit);
            start++;
           }
           maxFruits = Math.max(maxFruits, end - start + 1);
        }
        return maxFruits;









        // // BRUTE FORCE

        // int maxFruits = 0;
       
        // for(int start = 0; start < fruits.length; start++){
        //     Map<Integer, Integer> basket = new HashMap<>();
        //     int currCount = 0; 
        //     for(int end = start; end < fruits.length; ++end){
        //         basket.put(fruits[end], basket.getOrDefault(fruits[end],0) +1);

        //         if (basket.size() > 2) break;
        //         currCount++;
        //     }

        //     maxFruits = Math.max(maxFruits, currCount);
        // }
        // return maxFruits;
    }
}