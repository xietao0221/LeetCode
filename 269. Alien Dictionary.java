public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) return "";
        Map<Character, Set<Character>> dependency = new HashMap<>();
        int[] degree = new int[26];
        Set<Character> dict = new HashSet<>(); 
        StringBuilder sb = new StringBuilder();


        // save all characters which is used in the hash set
        for(String word: words) {
            for(char c: word.toCharArray()) {
                dict.add(c);
            }
        }

        // build dependency graph
        for(int i=0; i<words.length-1; i++) {
            char[] w1 = words[i].toCharArray(), w2 = words[i+1].toCharArray();
            int len = Math.min(w1.length, w2.length);
            for(int j=0; j<len; j++) {
                char c1 = w1[j], c2 = w2[j];
                if(c1 == c2) continue;

                Set<Character> c2Set = dependency.containsKey(c1) ? dependency.get(c1) : new HashSet<>();
                if(!c2Set.contains(c2)) {       // avoid duplicates
                    c2Set.add(c2);
                    dependency.put(c1, c2Set);
                    degree[c2 - 'a']++;
                    break;
                }
            }
        }

        // insert the nodes which have no parents
        Queue<Character> queue = new LinkedList<>();
        for(char c: dict) {
            if(degree[c - 'a'] == 0) queue.add(c);
        }
        
        // BFS search
        while(!queue.isEmpty()) {
            char c1 = queue.poll();
            sb.append(c1);
            if(!dependency.containsKey(c1)) continue;
            for(char c2: dependency.get(c1)) {
                // decrease the degree, and insert the new nodes which have no parents now
                if(--degree[c2 - 'a'] == 0) queue.add(c2);
            }
        }

        // avoid the loop
        if(sb.length() != dict.size()) return "";
        return sb.toString();
    }
}