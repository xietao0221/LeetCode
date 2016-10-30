public class AllOne {
    Map<String, Integer> mapStr;
    Map<Integer, Set<String>> mapInt;
    LinkedList<Integer> minMax;               // first <----> last, max <---> min

    /** Initialize your data structure here. */
    public AllOne() {
        mapStr = new HashMap<>();
        mapInt = new HashMap<>();
        minMax = new LinkedList<>();
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!mapStr.containsKey(key)) {
            mapStr.put(key, 1);
            putMapInt(1, key);
        } else {
            int num = mapStr.get(key);
            removeFromMapInt(num, key);
            mapStr.put(key, num + 1);
            putMapInt(num + 1, key);
        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!mapStr.containsKey(key)) return;

        int num = mapStr.get(key);
        if(num == 1) {
            mapStr.remove(key);
            removeFromMapInt(1, key);
        } else {
            removeFromMapInt(num, key);
            mapStr.put(key, num - 1);
            putMapInt(num - 1, key);
        }
    }

    private void putMapInt(int num, String str) {
        if(!mapInt.containsKey(num)) mapInt.put(num, new HashSet<>());
        mapInt.get(num).add(str);

        if(minMax.isEmpty() || minMax.getLast() > num) minMax.offerLast(num);
        if(!minMax.isEmpty() && minMax.getFirst() < num) minMax.offerFirst(num);
    }

    private void removeFromMapInt(int num, String str) {
        mapInt.get(num).remove(str);
        if(mapInt.get(num).isEmpty()) {
            mapInt.remove(num);

            if(!minMax.isEmpty() && minMax.getFirst() == num) minMax.pollFirst();
            if(!minMax.isEmpty() && minMax.getLast() == num) minMax.pollLast();
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(minMax.isEmpty()) return "";
        return mapInt.get(minMax.getFirst()).iterator().next();
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(minMax.isEmpty()) return "";
        return mapInt.get(minMax.getLast()).iterator().next();
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */