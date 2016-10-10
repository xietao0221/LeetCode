public class LRUCache {
    private int capacity;
    private Map<Integer, CacheNode> map;
    private CacheNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new CacheNode(0, 0);
        tail = new CacheNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    private void addToHead(CacheNode cacheNode) {
        cacheNode.next = head.next;
        cacheNode.prev = head;
        
        head.next.prev = cacheNode;
        head.next = cacheNode;
    }
    
    private CacheNode removeTail() {
        CacheNode temp = tail.prev;
        temp.prev.next = tail;
        tail.prev = temp.prev;
        return temp;
    }
    
    private void removeNode(CacheNode cacheNode) {
        cacheNode.prev.next = cacheNode.next;
        cacheNode.next.prev = cacheNode.prev;
    }
    
    private void moveToHead(CacheNode cacheNode) {
        removeNode(cacheNode);
        addToHead(cacheNode);
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            CacheNode temp = map.get(key);
            moveToHead(temp);
            return temp.value;
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)) {
            CacheNode temp = map.get(key);
            moveToHead(temp);
            temp.value = value;
        } else {
            if(map.size() == capacity) {
                CacheNode removed = removeTail();
                map.remove(removed.key);
            }
            CacheNode temp = new CacheNode(key, value);
            map.put(key, temp);
            addToHead(temp);
        }
    }
    
    class CacheNode {
        public int key, value;
        public CacheNode prev = null, next = null;
        
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}