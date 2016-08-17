public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        
        int count = n - 2;      // 1 and 2 are not prime numbers
        boolean[] isPrime = new boolean[n];
        for(int i = 0; i < n; i++) isPrime[i] = true;
        
        for(int i = 2; i * i <= n; i++) {
            if(!isPrime[i]) continue;
            for(int j = i * i; j < n; j += i) {
                if(isPrime[j]) {
                    isPrime[j] = false;
                    count--;    
                }
            }
        }
        return count;
    }
}