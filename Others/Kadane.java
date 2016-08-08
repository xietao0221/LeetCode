public class Kadane {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,-3,4,-1,-2,1,5,-3};
        kadaneAlgorithm(nums);
    }

    public static void kadaneAlgorithm(int[] nums) {
        int[] result = new int[3];       // start, end, sum
        int tmpStart = 0, tmpSum = 0;
        for(int i=0; i<nums.length; i++) {
            tmpSum += nums[i];
            if(tmpSum < 0) {
                tmpSum = 0;
                tmpStart = i + 1;
            }
            if(tmpSum > result[2]) {
                result[0] = tmpStart;
                result[1] = i;
                result[2] = tmpSum;
            }
        }
        System.out.println("Start: " + result[0] + ", End: " + result[1] + ", Sum: " + result[2]);
    }
}