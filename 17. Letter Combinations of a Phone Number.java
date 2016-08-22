public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        char[] digitsArray = digits.toCharArray();
        Map<Character, char[]> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        StringBuilder tmpRes = new StringBuilder();
        
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});
        
        letterCombinationsHelper(digitsArray, map, 0, res, tmpRes);
        return res;
    }
    
    public void letterCombinationsHelper(char[] digitsArray, Map<Character, char[]> map, int pos,
            List<String> res, StringBuilder tmpRes) {
        if(pos == digitsArray.length) {
            res.add(tmpRes.toString());
            return;
        }

        for(char c: map.get(digitsArray[pos])) {
            tmpRes.append(c);
            letterCombinationsHelper(digitsArray, map, pos + 1, res, tmpRes);
            tmpRes.setLength(tmpRes.length() - 1);
        }
    }
}