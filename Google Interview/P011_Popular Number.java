public class Solution {
    public List<Integer> findMajority(int[] nums) {
        int[] candidate = new int[]{nums[0], nums[0], nums[0]}, count = new int[3];
        for(int num: nums) {
            if(num == candidate[0]) {
                count[0]++;
            } else if(num == candidate[1]) {
                count[1]++;
            } else if(num == candidate[2]) {
                count[2]++;
            } else if(count[0] == 0) {
                count[0]++;
                candidate[0] = num;
            } else if(count[1] == 0) {
                count[1]++;
                candidate[1] = num;
            } else if(count[2] == 0) {
                count[2]++;
                candidate[2] = num;
            } else {
                for(int i = 0; i < count.length; i++) count[i]--;
            }
        }

        Arrays.fill(count, 0);
        for(int num: nums) {
            if(num == candidate[0]) count[0]++;
            else if(num == candidate[1]) count[1]++;
            else if(num == candidate[2]) count[2]++;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < candidate.length; i++) {
            if(count[i] > nums.length / 4) res.add(candidate[i]);
        }
        return res;
    }
}