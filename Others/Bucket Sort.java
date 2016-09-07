public class Solution {
    private final int maxBucketNum = 5;          // based on space limitations

    public void bucketSort(int[] nums) {
        // create buckets
        int bucketCount = Math.min(maxBucketNum, nums.length);
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        // find the max and min value
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for(int num: nums) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        // distribute buckets
        double bucketRange = (double)(maxValue - minValue + 1) / bucketCount;
        for(int num: nums) {
            int index = (int)((num - minValue) / bucketRange);
            buckets.get(index).add(num);
        }

        // sort each bucket and merge together
        int index = 0;
        for(List<Integer> bucket: buckets) {
            Collections.sort(bucket);
            for(int ele: bucket) nums[index++] = ele;
        }

    }
}

public class Solution {
    public void bucketSort(int[] nums) {
        // find max and min value
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for(int num: nums) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        // create buckets
        int[] buckets = new int[maxValue - minValue + 1];

        // distribute buckets
        for(int num: nums) buckets[num - minValue]++;

        // put back result
        int index = 0;
        for(int i = 0; i < buckets.length; i++) {
            for(int j = 0; j < buckets[i]; j++) {
                nums[index++] = i + minValue;
            }
        }
    }
}