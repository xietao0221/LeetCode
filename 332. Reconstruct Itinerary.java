// Recursive Solution
public class Solution {
    private Map<String, PriorityQueue<String>> map = new HashMap<>();
    private List<String> res = new LinkedList<>();

    public List<String> findItinerary(String[][] tickets) {
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        dfs("JFK");
        return res;
    }

    public void dfs(String departure) {
        PriorityQueue<String> arrivals = map.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll());
        }
        res.add(0, departure);
    }
}


// Iterative Solution
/*
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        Stack<String> stack = new Stack<>();
        
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).offer(ticket[1]);
        }
        
        stack.push("JFK");
        while(!stack.isEmpty()) {
            String departure = stack.peek();
            if(map.containsKey(departure) && !map.get(departure).isEmpty()) {
                stack.push(map.get(departure).poll());
            } else {
                res.add(departure);
                stack.pop();
            }
        }
        Collections.reverse(res);
        return res;
    }
}
*/