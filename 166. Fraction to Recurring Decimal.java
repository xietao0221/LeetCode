public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";

        long numeratorLong = Math.abs((long)numerator), denominatorLong = Math.abs((long)denominator);
        StringBuilder res = new StringBuilder();
        
        // deal with the sign
        res.append((numerator < 0) ^ (denominator < 0) ? "-" : "");
        
        // calculate the part1 which is before '.'
        res.append(numeratorLong / denominatorLong);
        numeratorLong %= denominatorLong;
        if(numeratorLong == 0) return res.toString();

        // calculate the part2 which is after '.'
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();       // numberator -> next position
        map.put(numeratorLong, res.length());
        while(numeratorLong != 0) {
            numeratorLong *= 10;
            res.append(numeratorLong / denominatorLong);
            numeratorLong %= denominatorLong;

            if(map.containsKey(numeratorLong)) {
                int delim = map.get(numeratorLong);
                res.insert(delim, "(");
                res.append(")");
                break;
            } else {
                map.put(numeratorLong, res.length());
            }
        }
        return res.toString();
    }
}