public class Solution {
    private String[] numbers = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private String[] tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", 
        "Seventy", "Eighty", "Ninety"};
    private String[] thunsands = new String[]{"Billion", "Million", "Thousand", ""};
    private int[] radix = new int[]{1000000000, 1000000, 1000, 1};
    
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < radix.length; i++) {
            if(num < radix[i]) continue;
            sb.append(numberToWrodsHelper(num/radix[i])).append(thunsands[i]).append(" ");
            num %= radix[i];
        }
        return sb.toString().trim();
    }
    
    private String numberToWrodsHelper(int num) {
        if(num == 0) {
            return "";
        } else if(num < 20) {
            return numbers[num] + " ";
        } else if(num < 100) {
            return tens[num / 10] + " " + numberToWrodsHelper(num % 10);
        } else {
            return numbers[num / 100] + " Hundred " + numberToWrodsHelper(num % 100);
        }
    }
}