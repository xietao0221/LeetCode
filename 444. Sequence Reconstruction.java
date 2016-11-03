public class Solution {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for(int[] seq: seqs) {
            if(seq.length == 1) {
                if(!map.containsKey(seq[0])) {
                    map.put(seq[0], new HashSet<>());
                    indegree.put(seq[0], 0);
                }
            } else {
                for(int i = 0; i < seq.length - 1; i++) {
                    if(!map.containsKey(seq[i])) {
                        map.put(seq[i], new HashSet<>());
                        indegree.put(seq[i], 0);
                    }

                    if(!map.containsKey(seq[i + 1])) {
                        map.put(seq[i + 1], new HashSet<>());
                        indegree.put(seq[i + 1], 0);
                    }

                    if(map.get(seq[i]).add(seq[i + 1])) {
                        indegree.put(seq[i + 1], indegree.get(seq[i + 1]) + 1);
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry: indegree.entrySet()) {
            if(entry.getValue() == 0) queue.offer(entry.getKey());
        }

        int index = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            if(size > 1) return false;
            int curr = queue.poll();
            if(index == org.length || curr != org[index++]) return false;
            for(int next: map.get(curr)) {
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) queue.offer(next);
            }
        }
        return index == org.length && index == map.size();
    }
}