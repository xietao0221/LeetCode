/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// BFS, no multiplication
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweighted = 0, res = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        for(NestedInteger item: nestedList) queue.offer(item);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                NestedInteger curr = queue.poll();
                if(curr.isInteger()) {
                    unweighted += curr.getInteger();
                } else {
                    for(NestedInteger item: curr.getList()) queue.offer(item);
                }
            }
            res += unweighted;
        }
        return res;
    }
}

// DFS
/*
public class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null) return 0;
        
        int level = getLevel(nestedList);
        int res = getSum(nestedList, level);
        return res;
    }
    
    private int getLevel(List<NestedInteger> nestedList) {
        int level = 0;
        for(NestedInteger item: nestedList) {
            if(item.isInteger()) level = Math.max(level, 1);
            else level = Math.max(level, getLevel(item.getList()) + 1);
        }
        return level;
    }
    
    private int getSum(List<NestedInteger> nestedList, int level) {
        int res = 0;
        for(NestedInteger item: nestedList) {
            if(item.isInteger()) res += level * item.getInteger();
            else res += getSum(item.getList(), level - 1);
        }
        return res;
    }
}
*/