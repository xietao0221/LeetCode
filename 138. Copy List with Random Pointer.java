/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();      // <raw, cloned>
        RandomListNode clonedHead = new RandomListNode(head.label), rawHead = head;
        map.put(rawHead, clonedHead);
        
        while(rawHead != null) {
            // deal with .next
            if(rawHead.next != null) {
                if(!map.containsKey(rawHead.next)) map.put(rawHead.next, new RandomListNode(rawHead.next.label));
                clonedHead.next = map.get(rawHead.next);
            }
            
            // deal with .random
            if(rawHead.random != null) {
                if(!map.containsKey(rawHead.random)) map.put(rawHead.random, new RandomListNode(rawHead.random.label));
                clonedHead.random = map.get(rawHead.random);
            }
            
            // move forward
            rawHead = rawHead.next;
            clonedHead = clonedHead.next;
        }
        return map.get(head);
    }
}