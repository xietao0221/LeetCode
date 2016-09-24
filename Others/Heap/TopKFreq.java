/*
Given a stream of String, output top 10 frequency Strings
*/
public class TopKFreq {
    Map<String, Integer> map;
    PriorityQueue<NameFreq> queue;
    int size;

    public TopKFreq(int size) {
        map = new HashMap<>();
        queue = new PriorityQueue<>(size, (a, b) -> a.freq - b.freq);
        this.size = size;
    }

    public List<String> add(String name) {
        if(!map.containsKey(name)) map.put(name, 1);
        else map.put(name, map.get(name) + 1);

        NameFreq curr = new NameFreq(name, map.get(name));
        if(queue.size() < size) {
            queue.offer(curr);
        } else {
            if(queue.peek().freq < map.get(name)) {
                queue.poll();
                queue.offer(curr);
            }
        }

        List<String> res = new ArrayList<>();
        PriorityQueue<NameFreq> newQueue = new PriorityQueue<>(size, (a, b) -> a.freq - b.freq);
        while(!queue.isEmpty()) {
            NameFreq tmp = queue.poll();
            res.add(0, tmp.name);
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
    }
}