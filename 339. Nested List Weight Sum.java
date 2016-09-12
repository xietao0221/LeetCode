/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// BFS
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        int level = 0, res = 0;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while(size-- > 0) {
                NestedInteger curr = queue.poll();
                if(curr.isInteger()) {
                    res += curr.getInteger() * level;
                } else {
                    for(NestedInteger item: curr.getList()) {
                        queue.offer(item);
                    }
                }
            }
        }
        return res;
    }
}

// DFS
/*
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        int[] result = new int[]{0};
        for(NestedInteger item: nestedList) {
            depthSumHelper(item, 1, result);
        }
        return result[0];
    }
    
    public void depthSumHelper(NestedInteger nestedList, int depth, int[] result) {
        if(nestedList.isInteger()) {
            result[0] += nestedList.getInteger() * depth;
            return;
        }
        
        for(NestedInteger item: nestedList.getList()) {
            depthSumHelper(item, depth + 1, result);
        }   
    }
}
*/