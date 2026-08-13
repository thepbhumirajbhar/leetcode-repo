// same as 205 (followup h uska)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<String, Character> m1 = new HashMap<>();
        Map<Character, String> m2 = new HashMap<>();

        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            char letter = pattern.charAt(i);

            if(m1.containsKey(word)){
                if(!m1.get(word).equals(letter)) return false;
            }

            else{
                m1.put(word,letter);
            }

            if(m2.containsKey(letter)){
                if(!m2.get(letter).equals(word)) return false;
            }
            else{
                m2.put(letter, word);
            }

        }
        return true;
    }
}