package LetterCombinationsofaPhoneNumber;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]. Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you
 * want.
 */
class Solution {

    private static Map<Character, Character[]> NUMBER_MAP = new HashMap<>();

    static {
        NUMBER_MAP.put('0', new Character[]{' '});
        NUMBER_MAP.put('1', new Character[]{});
        NUMBER_MAP.put('2', new Character[]{'a', 'b', 'c'});
        NUMBER_MAP.put('3', new Character[]{'d', 'e', 'f'});
        NUMBER_MAP.put('4', new Character[]{'g', 'h', 'i'});
        NUMBER_MAP.put('5', new Character[]{'j', 'k', 'l'});
        NUMBER_MAP.put('6', new Character[]{'m', 'n', 'o'});
        NUMBER_MAP.put('7', new Character[]{'p', 'q', 'r', 's'});
        NUMBER_MAP.put('8', new Character[]{'t', 'u', 'v'});
        NUMBER_MAP.put('9', new Character[]{'w', 'x', 'y', 'z'});
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            Character[] chars = NUMBER_MAP.get(ch);

            if (i == 0) {
                for (Character character : chars) {
                    output.add("" + character);
                }
            } else {
                List<String> temp = new ArrayList<>();
                for (String s : output) {
                    for (Character character : chars) {
                        temp.add(s + character);
                    }
                }
                output = temp;
            }
        }

        return output;
    }
}