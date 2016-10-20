/*
Given a stream of String, output top 10 frequency Strings
*/
public class TopKFreq {
    Map<String, Integer> map;
    PriorityQueue<NameFreq> queue;
    Set<String> set;
    int size;

    public TopKFreq(int size) {
        map = new HashMap<>();
        queue = new PriorityQueue<>(size, (a, b) -> a.freq - b.freq);
        set = new HashSet<>();
        this.size = size;
    }

    public List<NameFreq> add(String name) {
        if(!map.containsKey(name)) map.put(name, 1);
        else map.put(name, map.get(name) + 1);

        boolean isDup = set.contains(name);

        List<NameFreq> res = new ArrayList<>();
        NameFreq curr = new NameFreq(name, map.get(name));
        if(queue.size() < size) {
            if(!isDup) {
                queue.offer(curr);
                set.add(name);
            }
        } else {
            if(queue.peek().freq < map.get(name) && !isDup) {
                set.remove(queue.poll().name);
                queue.offer(curr);
                set.add(name);
            }
        }

        PriorityQueue<NameFreq> newQueue = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        if(isDup) queue.offer(curr);
        while(!queue.isEmpty()) {
            NameFreq tmp = queue.poll();
            if(isDup && tmp.name.equals(name)) {
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