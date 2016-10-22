/*
Given a stream of String, output top 10 frequency Strings
*/
public class TopKFreq {
    private Map<String, Integer> map;           // global name freq map, <name, freq>
    private PriorityQueue<NameFreq> queue;      // PQ whose size is up to k <name, freq>
    private Set<String> set;                    // has same component as queue, used for O(1) find <name>
    private int size;

    public TopKFreq(int size) {
        map = new HashMap<>();
        queue = new PriorityQueue<>(size, (a, b) -> a.freq - b.freq);
        set = new HashSet<>();
        this.size = size;
    }

    public List<NameFreq> add(String name) {
        // update global hashmap
        if(!map.containsKey(name)) map.put(name, 1);
        else map.put(name, map.get(name) + 1);

        // update PQ
        boolean isDup = set.contains(name);
        NameFreq curr = new NameFreq(name, map.get(name));
        if(queue.size() < size) {
            // PQ is not full, directly add new element into it
            if(!isDup) {
                queue.offer(curr);
                set.add(name);
            }
        } else {
            // PQ is full, compare the first element with the new element
            if(queue.peek().freq < map.get(name) && !isDup) {
                set.remove(queue.poll().name);
                queue.offer(curr);
                set.add(name);
            }
        }
        // if the new element is duplicate, directly add it
        if(isDup) queue.offer(curr);

        List<NameFreq> res = new ArrayList<>();
        PriorityQueue<NameFreq> newQueue = new PriorityQueue<>((a, b) -> a.freq - b.freq);      // tmp PQ for the next round
        while(!queue.isEmpty()) {
            NameFreq tmp = queue.poll();
            if(isDup && tmp.name.equals(name)) {
                // this time, PQ has two elements whose name is the same, 
                // but the first one poped out has smaller freq, just skip it
                isDup = false;
                continue;
            }
            res.add(0, tmp);
            newQueue.offer(tmp);
        }
        queue = newQueue;
        return res;
    }

    class NameFreq {
        public String name;
        public int freq;

        public NameFreq(String name, int freq) {
            this.name = name;
            this.freq = freq;
        }

        public String toString() {
            return name + ":" + freq;
        }
    }
}