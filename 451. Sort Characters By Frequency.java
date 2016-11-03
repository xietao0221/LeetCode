public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()) map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        
        PriorityQueue<Map.Entry<Character, Integer>> queue = 
                new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Character, Integer> entry: map.entrySet()) queue.offer(entry);

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            Map.Entry<Character, Integer> curr = queue.poll();
            for(int i = 0; i < curr.getValue(); i++) sb.append(curr.getKey());
        }
        return sb.toString();
    }
}