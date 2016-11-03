// Bit Manipulation Solution
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        
        int count = n & 1;
        while(n != 0) {
            n >>>= 1;
            count += n & 1;
        }
        return count == 1;
    }
}

// Iterative Solution
/*
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        
        while(n % 2 == 0) n /= 2;
        return n == 1;
    }
}
*/