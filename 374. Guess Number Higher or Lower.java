/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int sol = guess(mid);
            if(sol == 0) {
                return mid;
            } else if(sol == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}