import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("t", "t"));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();

        for (char sChar : s.toCharArray()) {
            if (sMap.get(sChar) == null) {
                sMap.put(sChar, 1);

            } else {
                sMap.put(sChar, sMap.get(sChar) + 1);
            }
        }

        for (char tChar : t.toCharArray()) {
            Integer value = sMap.get(tChar);

            if (value == null) {
                return false;
            }
            else if(value == 0){
                return false;
            }

            sMap.put(tChar, value - 1);
        }

        for (Integer sVal : sMap.values()) {
            if (sVal > 0) {
                return false;
            }
        }
        return true;
    }
}