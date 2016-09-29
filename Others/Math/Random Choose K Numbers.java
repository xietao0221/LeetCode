public class Solution {
    Random random;
    int[] nums;

    public Solution(int[] nums) {
        random = new Random();
        this.nums = nums;
    }

    public List<Integer> getKRandom(int k) {
        List<Integer> res = new ArrayList<>();
        int count = 0;

        // run reservoir sampling k times, 
        // after each time, swap the choosen number with the last one, substract the length by one, and then run again.
        while(k-- > 0) {
            Integer tmpRes = null;
            for(int i = 0; i < nums.length - count; i++) {
                if(random.nextInt(i + 1) == 0) tmpRes = i;
            }

            if(tmpRes != null) {
                res.add(nums[tmpRes]);
                swap(nums, tmpRes, nums.length - 1 - count);
                count++;
            } else {
                break;
            }
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}