public class Solution {
    private ListNode head;
    private Random random;
    
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode res = null, curr = head;
        for(int i = 1; curr != null; i++) {
            // random choose a integer whose range is [0, i), so the starting value of i should be 1
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