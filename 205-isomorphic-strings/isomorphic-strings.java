class Solution {
    public boolean isIsomorphic(String s, String t) {
        // APPROACH 2

        if(s.length() != t.length()) return false;

        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Agar last seen positions match nahi karti, toh mapping breakdown ho chuki hai
            if(m1[c1] != m2[c2]) return false;

            m1[c1] = i+1;
            m2[c2] = i+1;
        }
        return true;




    // APPROACH 1    
        // Map<Character, Character> m1 = new HashMap<>();
        // Map<Character, Character> m2 = new HashMap<>();

        // if(s.length() != t.length()) return false;

        // for(int i = 0; i < s.length(); i++){
        //     if(m1.containsKey(s.charAt(i))){
        //         if(m1.get(s.charAt(i)) != t.charAt(i)) return false;
        //     }
        //     else{
        //         m1.put(s.charAt(i), t.charAt(i));
        //     } 


        //     if(m2.containsKey(t.charAt(i))){
        //         if(m2.get(t.charAt(i)) != s.charAt(i)) return false;
        //     }
        //     else{
        //         m2.put(t.charAt(i), s.charAt(i));
        //     }
        // }
        // return true;
    }
}