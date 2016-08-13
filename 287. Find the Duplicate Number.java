// find cycle in the linked list, like Linked List Cycle II
public class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        // because there is always one duplicated number at least
        // so we don't need to detect the cycle, there must have one cycle
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        slow = 0;
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}


// binary search
// https://discuss.leetcode.com/topic/25580/two-solutions-with-explanation-o-nlog-n-and-o-n-time-o-1-space-without-changing-the-input-array/2
/*
public class Solution {
    public int findDuplicate(int[] nums) {
        // the smallest number is 1, the largest number is nums.length - 1
        int left = 1, right = nums.length - 1, middle = 0, count = 0;
        while(left < right) {
            count = 0;
            middle = left + (right - left) / 2;     // round to left
            
            for(int num: nums) {
                if(num <= middle) count++;          // because 'middle' rounds to left, so need to <=
            }
            if(count <= middle) left = middle + 1;
            else right = middle;
        }
        return left;
    }
}
*/