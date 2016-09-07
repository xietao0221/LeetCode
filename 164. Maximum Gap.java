// MaxGap >= (max - min) / (N - 1), if each bucket is smaller than this number, any InnerGap cannot be MaxGap
// we divide N numbers into (N - 1) buckets: [min, min + gap), [min + gap, min + 2 * gap)
public class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;

        // find the min and max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        // deal with all nums are the same, the gap is 0
        if(min == max) return 0;

        // build bucket
        int gap = (int)Math.ceil((double)(max - min) / (nums.length - 1));      // IMPORTANT
        int bucketNum = (int)Math.ceil((double)(max - min) / gap) + 1;          // IMPORTANT
        int[][] bucket = new int[bucketNum][2];
        for(int i = 0; i < bucket.length; i++) {
            bucket[i][0] = Integer.MAX_VALUE;
            bucket[i][1] = Integer.MIN_VALUE;
        }

        // put numbers into bucket
        for(int num: nums) {
            int index = (num - min) / gap;
            if(num < bucket[index][0]) bucket[index][0] = num;
            if(num > bucket[index][1]) bucket[index][1] = num;
        }

        // iterate the bucket array
        // the maxGap does not occur inside the bucket, but between buckets
        int prev = 0, curr = 1;
        gap = bucket[0][1] - bucket[0][0];
        while(curr < bucket.length) {
            while(curr < bucket.length && 
                bucket[curr][0] == Integer.MAX_VALUE && bucket[curr][1] == Integer.MIN_VALUE) {
                curr++;
            }
            
            // the gap is the value between the min of i+1 and max of i
            if(curr < bucket.length) {
                gap = Math.max(gap, bucket[curr][0] - bucket[prev][1]);
                prev = curr++;    
            }
        }
        return gap;
    }
}