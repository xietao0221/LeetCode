// hash set
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>(), res = new HashSet<>();
        for(int i = 0; i + 9 < s.length(); i++) {
            String target = s.substring(i, i + 10);
            if(!seen.add(target)) res.add(target);
        }
        return new ArrayList<>(res);
    }
}

/*
Rolling-hash Solution
https://discuss.leetcode.com/topic/8539/short-java-rolling-hash-solution
r0 = 4*r + c0
r1 = 4*r0 + c1 = 4*(4*r + c0) + c1 = (4^2)*r + 4*c0 + c1
r2 = 4*r1 + c2 = 4*((4^2)*r + 4*c0 + c1) = (4^3)*r + (4^2)*c0 + 4*c1 + c2
......
r9 = (4^10)*r + (4^9)*c0 + ... + c9
*/
/*
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character, Integer> trans = new HashMap<>();
        Set<Integer> hashes = new HashSet<>();
        Set<String> res = new HashSet<>();
        int hashCode = 0, baseSub = (int)Math.pow(4, 9);
        
        trans.put('A', 0);
        trans.put('C', 1);
        trans.put('G', 2);
        trans.put('T', 3);
        
        for(int i = 0; i < s.length(); i++) {
            if(i > 9) hashCode -= baseSub * trans.get(s.charAt(i - 10));
            hashCode = 4 * hashCode + trans.get(s.charAt(i));
            if(i > 8 && !hashes.add(hashCode)) res.add(s.substring(i - 9, i + 1));
        }
        return new ArrayList<>(res);
    }
}
*/