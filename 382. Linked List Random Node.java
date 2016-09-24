/* http://blog.jobbole.com/42550/
1:          1 has possibility 1 to be choosen
1, 2:       2 has possibility 1/2 to be choosen
1, 2, 3:    3 has possibility 1/3 to be choosen
*/
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
        ListNode curr = head;
        int res = 0;
        
        // random choose a integer whose range is [0, i), so the starting value of i should be 1
        // curr is the head node, it has 1/range(0, curr) possibility to be choosen
        for(int i = 1; curr != null; i++) {
            if(random.nextInt(i) == 0) res = curr.val;
            curr = curr.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */