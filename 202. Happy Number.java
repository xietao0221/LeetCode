public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        return isHappyHelper(n, set);
    }
    
    public boolean isHappyHelper(int n, Set<Integer> set) {
        if(n == 1) return true;
        
        if(!set.add(n)) return false;
        int sum = 0;
        while(n > 0) {
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return isHappyHelper(sum, set);
    }
}