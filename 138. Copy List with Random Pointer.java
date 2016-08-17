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
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode headOriginal = head, headNew = new RandomListNode(head.label), res = headNew;
        
        while(headNew != null) {
            // deal with the .next
            if(headOriginal.next != null) {
                if(!map.containsKey(headOriginal.next)) {
                    headNew.next = new RandomListNode(headOriginal.next.label);
                    map.put(headOriginal.next, headNew.next);    
                } else {
                    headNew.next = map.get(headOriginal.next);
                }
            }
            
            // deal with the .random
            if(headOriginal.random != null) {
                if(!map.containsKey(headOriginal.random)) {
                    headNew.random = new RandomListNode(headOriginal.random.label);   
                    map.put(headOriginal.random, headNew.random);
                } else {
                    headNew.random = map.get(headOriginal.random);
                }
            }
            
            headNew = headNew.next;
            headOriginal = headOriginal.next;
        }
        return res;
    }
}