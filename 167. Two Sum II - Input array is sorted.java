public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        int[] res = new int[2];
        while(left < right) {
            int tmp = numbers[left] + numbers[right];
            if(tmp == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            } else if(tmp > target) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}