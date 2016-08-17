public class RandomizedSet {
    List<Integer> nums;
    Map<Integer, Integer> map;      // value -> position
    java.util.Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.nums = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new java.util.Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int currPos = map.get(val);
        // if 'val' is not the last one, swap it with the last one
        // because we want to truncate the map and nums by one
        // to meet the requirement of O(1), we cannot remove the element in the middle(that will be O(n))
        if(currPos != nums.size() - 1) {
            int lastVal = nums.get(nums.size() - 1);
            nums.set(currPos, lastVal);
            map.put(lastVal, currPos);
        }
        map.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */