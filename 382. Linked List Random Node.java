public class Solution {
    ListNode head;
    java.util.Random random;
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        this.random = new java.util.Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = null, curr = head;
        for(int i=1; curr != null; i++) {
            if(random.nextInt(i) == 0) res = curr;
            curr = curr.next;
        }
        return res.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */