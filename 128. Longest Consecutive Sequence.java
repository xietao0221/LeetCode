// hashset
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums) set.add(num);
        for(int num: nums) {
            int target = num, count = 1;
            while(set.contains(--target)) {
                count++;
                set.remove(target);
            }
            
            target = num;
            while(set.contains(++target)) {
                count++;
                set.remove(target);
            }
            res = Math.max(res, count);
        }
        return res;
    }
}

// union and find
/*
public class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind set = new UnionFind(nums.length);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) continue;
            if(map.containsKey(nums[i] + 1)) set.union(i, map.get(nums[i] + 1));
            if(map.containsKey(nums[i] - 1)) set.union(i, map.get(nums[i] - 1));
            map.put(nums[i], i);
        }
        return set.size();
    }
    
    class UnionFind {
        int[] id, size;
        int count;
        
        public UnionFind(int length) {
            id = new int[length];
            size = new int[length];
            for(int i = 0; i < length; i++) {
                id[i] = i;
                size[i] = 1;
            }
            count = 1;
        }
        
        public int size() {
            return count;
        }
        
        private int root(int i) {
            while(i != id[i]) {
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        public void union(int p, int q) {
            int pi = root(p), qi = root(q);
            if(pi == qi) return;
            
            int localCount = 0;
            if(size[pi] < size[qi]) {
                id[pi] = qi;
                size[qi] += size[pi];
                localCount = size[qi];
            } else {
                id[qi] = pi;
                size[pi] += size[qi];
                localCount = size[pi];
            }
            count = Math.max(count, localCount);
        }
    }
}
*/