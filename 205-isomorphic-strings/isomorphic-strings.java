class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();

        if(s.length() != t.length()) return false;

        for(int i = 0; i < s.length(); i++){
            if(m1.containsKey(s.charAt(i))){
                if(m1.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else{
                m1.put(s.charAt(i), t.charAt(i));
            } 


            if(m2.containsKey(t.charAt(i))){
                if(m2.get(t.charAt(i)) != s.charAt(i)) return false;
            }
            else{
                m2.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}