class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // 1. Store value, indices pair
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // 2. Sort them by value
        // tell Java explicitly how to compare two rows (a and b) against each other.
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0], b[0]));


        // 3. Get connected components
        int[] res = new int[n];
        int i = 0;
        while(i < n){
            int j = i;
            List<Integer> vals = new ArrayList<>();
            List<Integer> indices = new ArrayList<>();
            
            // Add the first element of the new group
            vals.add(arr[i][0]);
            indices.add(arr[i][1]);

            // Keep expanding the group as long as the difference is <= limit
            while(j+1 < n && arr[j + 1][0] - arr[j][0] <= limit){
                j++;
                vals.add(arr[j][0]);
                indices.add(arr[j][1]);
            }

            // Sort indices so we assign smaller values to earlier positions
            Collections.sort(indices);
            for(int k = 0; k < indices.size(); k++){
                res[indices.get(k)] = vals.get(k);
            }
            i = j+1;
        }
        return res;

    }
}