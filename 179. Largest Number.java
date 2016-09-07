public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        String[] array = new String[nums.length];
        for(int i = 0; i < nums.length; i++) array[i] = Integer.toString(nums[i]);
        Arrays.sort(array, new StringComparator());
        
        if(array[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s: array) sb.append(s);
        return sb.toString();
    }
    
    // sort in decreasing order
    class StringComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
}