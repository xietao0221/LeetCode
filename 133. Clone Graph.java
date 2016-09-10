/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();        // represent which one is cloned
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        map.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        
        // BFS
        while(!queue.isEmpty()) {
            UndirectedGraphNode rawParent = queue.poll();
            UndirectedGraphNode cloneParent = map.get(rawParent);
            List<UndirectedGraphNode> cloneChildren = cloneParent.neighbors;
            for(UndirectedGraphNode child : rawParent.neighbors) {
                if(!map.containsKey(child)) {
                    map.put(child, new UndirectedGraphNode(child.label));
                    queue.offer(child);
                }
                cloneChildren.add(map.get(child));
            }
        }
        return map.get(node);
    }
}