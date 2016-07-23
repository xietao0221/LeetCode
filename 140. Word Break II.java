public class Solution {
    Map<String, List<String>> memo = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        
        // treat s as a single string
        if(wordDict.contains(s)) res.add(s);
        
        // treat s as a list of string
        for(int i=1; i<s.length(); i++) {
            String post = s.substring(i);
            if(wordDict.contains(post)) {
                List<String> preList = wordBreak(s.substring(0, i), wordDict);
                for(String pre: preList) res.add(pre + " " + post);
            }
        }
        memo.put(s, res);
        return res;
    }
}