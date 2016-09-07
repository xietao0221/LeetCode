public class Solution {
    public void bucketSort(int[] nums) {
        // find the max and min value
        int maxValue = Integer.MIN_VALUE, minValue = Integer.MAX_VALUE;
        for(int num: nums) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
        }

        // create buckets
        int gap = (int)Math.ceil((double)(maxValue - minValue) / (nums.length - 1));
        int bucketCount = (int)Math.ceil((double)(maxValue - minValue) / gap) + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i = 0; i < bucketCount; i++) buckets.add(new ArrayList<>());

        // distribute buckets
        for(int num: nums) {
            int index = (num - minValue) / gap;
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