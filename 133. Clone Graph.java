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
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();    // <Raw, Cloned>
        Queue<UndirectedGraphNode> queue = new LinkedList<>();                  // <Raw>
        map.put(node, new UndirectedGraphNode(node.label));
        queue.offer(node);
        
        // BFS
        while(!queue.isEmpty()) {
            // raw and cloned parent
            UndirectedGraphNode rawParent = queue.poll();
            UndirectedGraphNode cloneParent = map.get(rawParent);
            
            // cloned parent's children
            List<UndirectedGraphNode> cloneChildren = cloneParent.neighbors;
            
            // raw parent's children
            for(UndirectedGraphNode rawChild : rawParent.neighbors) {
                if(!map.containsKey(rawChild)) {
                    // if map does not contain it, we need to 'new' it and put it into queue
                    map.put(rawChild, new UndirectedGraphNode(rawChild.label));
                    queue.offer(rawChild);
                }
                // no matter it is new or not, we need to put it into children
                cloneChildren.add(map.get(rawChild));
            }
        }
        return map.get(node);
    }
}