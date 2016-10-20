public class Solution {
    public List<String> topk(List<Tuple> inputs, int targetTime, int k) {
        // record all inputs into map
        Map<Integer, Map<String, Integer>> map = new HashMap<>();   // <timestamp, <name, freq>>
        for(Tuple input: inputs) {
            if(!map.containsKey(input.timeStamp)) map.put(input.timeStamp, new HashMap<>());
            map.get(input.timeStamp).put(input.name,
                    map.get(input.timeStamp).containsKey(input.name) ?
                            map.get(input.timeStamp).get(input.name) + 1 : 1);
        }

        // get global freq before target timestamp
        Map<String, Integer> freqs = new HashMap<>();
        for(Map.Entry<Integer, Map<String, Integer>> entry: map.entrySet()) {
            if(entry.getKey() > targetTime) continue;
            for(Map.Entry<String, Integer> e: entry.getValue().entrySet()) {
                freqs.put(e.getKey(), freqs.containsKey(e.getKey()) ? freqs.get(e.getKey()) + 1 : 1);
            }
        }

        // sort and output result
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqs.entrySet());
        Collections.sort(list, (a, b) -> b.getValue() - a.getValue());
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            res.add(list.get(i).getKey());
        }
        return res;
    }

    class Tuple {
        public int timeStamp;
        public String name;
    }
}