public class RandomizedCollection {
    private List<Integer> nums;
    private Map<Integer, Set<Integer>> map;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean doesContain = map.containsKey(val);
        if(!doesContain) map.put(val, new HashSet<>());
        map.get(val).add(nums.size());
        nums.add(val);
        return !doesContain;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        // if val is not the last one
        if(!map.get(val).contains(nums.size() - 1)) {
            int currPos = map.get(val).iterator().next();
            int lastVal = nums.get(nums.size() - 1);
            
            // swap last one and 'val' in both map
            map.get(lastVal).remove(nums.size() - 1);
            map.get(lastVal).add(currPos);
            map.get(val).remove(currPos);
            map.get(val).add(nums.size() - 1);
            
            // setup nums, don't need to setup the last one, because it will be removed later
            nums.set(currPos, lastVal);
        }
        
        // remove the last value form both map and nums
        map.get(val).remove(nums.size() - 1);
        if(map.get(val).isEmpty()) map.remove(val);
        
        nums.remove(nums.size() - 1);
        
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */