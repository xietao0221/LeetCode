// https://segmentfault.com/a/1190000003817671
public class Solution {
    // binary search
    /*
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1, count = 0;
        while(low <= high) {
            count = 0;
            int mid = (low + high) / 2;
            for(int num: nums) {
                if(num <= mid) count++;
            }
            if(count <= mid) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    */
    
    // find cycle in the linked list, like Linked List Cycle II
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // because there is always one duplicated number at least
        // so we don't need to detect the cycle, there must have one cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}